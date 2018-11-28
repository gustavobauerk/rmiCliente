/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import principal.Hotel;
import principal.Trip;
import rmi.Cliente;

/**
 * Managedbean para pagina de pacote
 */
@ManagedBean
@SessionScoped
public class pacoteBean {
    /**
     * Dados do pacote
     */
    private List<Pacote> pack = new ArrayList<>();
    /**
     * Filtro de pesquisa de ida e volta de passagem
     */
    private boolean ida;
    /**
     * Origem da passagem
     */
    private String source;
    /**
     * Destino da passagem
     */
    private String destination;
    /**
     * Data de ida da passagem
     */
    private String flightdate;
    /**
     * Data de volta da passagem
     */
    private String flightdateVolta;
    /**
     * Numero de passagens
     */
    private int numberOfAirfares;
    /**
     * Numero de quartos
     */
    private int numberOfRooms;
    /**
     *
     */
    private final Cliente cliente;

    /**
     * Construtor para instanciar cliente
     */
    public pacoteBean() {
        cliente = new Cliente();
    }

    /**
     * Pesquisa pacote
     */
    public void search() {
        //nova lista para exibição
        pack = new ArrayList<>();
        //pesquisa viagem
        Trip trip = cliente.consultaPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        //pesquisa hotel
        Hotel hotel = cliente.consultaHotel(destination, flightdate, flightdateVolta, numberOfRooms, numberOfAirfares);
        //Seta as informações obtidas no pacote
        Pacote pacote = new Pacote();
        pacote.setSource(trip.getSource());
        pacote.setDestination(trip.getDestination());
        pacote.setBegin(trip.getBegin());
        pacote.setEnd(trip.getEnd());
        pacote.setCity(hotel.getCity());
        pacote.setPrice(hotel.getPrice());
        //adiciona a lista
        pack.add(pacote);
    }

    /**
     * Compra o pacote
     */
    public void comprar() {
        //compra a passagem
        boolean a = cliente.compraPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        //compra o hotel
        boolean b = cliente.compraHotel(destination, flightdate, flightdateVolta, numberOfRooms, numberOfAirfares);
        //se ambos deram certo, mensagem de confirmação
        if (a && b) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Compra concluida com sucesso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Erro na compra."));
        }
    }

    /**
     * Retorna origem
     * @return origem
     */
    public String getSource() {
        return source;
    }

    /**
     * Define origem
     * @param source origem
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Retorna destino
     * @return destino
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Define destino
     * @param destination destino
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Retorna data de entrada no hotel
     * @return data de entrada no hotel
     */
    public String getFlightdate() {
        return flightdate;
    }

    /**
     * Define data de entrada no hotel
     * @param flightdate data de entrada no hotel
     */
    public void setFlightdate(String flightdate) {
        this.flightdate = flightdate;
    }

    /**
     * Retorna data de saida do hotel
     * @return data de saida do hotel
     */
    public String getFlightdateVolta() {
        return flightdateVolta;
    }

    /**
     * Define data de saida do hotel
     * @param flightdateVolta data de saida do hotel
     */
    public void setFlightdateVolta(String flightdateVolta) {
        this.flightdateVolta = flightdateVolta;
    }

    /**
     * Retorna numero de passagens
     * @return numero de passagens
     */
    public int getNumberOfAirfares() {
        return numberOfAirfares;
    }

    /**
     * Define numero de passagens
     * @param numberOfAirfares numero de passagens
     */
    public void setNumberOfAirfares(int numberOfAirfares) {
        this.numberOfAirfares = numberOfAirfares;
    }

    /**
     * Retorna numeros de quartos desejados
     * @return numeros de quartos desejados
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Define numeros de quartos desejados
     * @param numberOfRooms numeros de quartos desejados
     */
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    /**
     * Retorna se é ida ou ida e volta
     * @return se é ida ou ida e volta
     */
    public boolean isIda() {
        return ida;
    }

    /**
     * Define se é ida ou ida e volta
     * @param ida se é ida ou ida e volta
     */
    public void setIda(boolean ida) {
        this.ida = ida;
    }

    /**
     * Retorna lista de pacotes
     * @return lista de pacotes
     */
    public List<Pacote> getPack() {
        return pack;
    }

    /**
     * Define lista de pacotes
     * @param pack lista de pacotes
     */
    public void setPack(List<Pacote> pack) {
        this.pack = pack;
    }

}
