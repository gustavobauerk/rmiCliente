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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import principal.Trip;
import rmi.Cliente;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class passagemBean {
    /**
     * Lista de passagens
     */
    private List<Trip> trip = new ArrayList<>();
    /**
     * Ida ou ida e volta
     */
    private boolean ida;
    /**
     * origem
     */
    private String source;
    /**
     * Destino
     */
    private String destination;
    /**
     * Data de ida
     */
    private String flightdate;
    /**
     * Data de volta
     */
    private String flightdateVolta;
    /**
     * Numero de passagens
     */
    private int numberOfAirfares;
    /**
     * Contém os métodos do server
     */
    private final Cliente cliente;
    /**
     * Resultado da compra
     */
    private boolean deuBoa;

    /**
     * Instancia um cliente para acesso ao método do servidor
     */
    public passagemBean() {
        cliente = new Cliente();
    }

    /**
     * Consulta passagem
     */
    public void search() {
        //nova lista
        trip = new ArrayList<>();
        //consulta
        Trip trips = cliente.consultaPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        if (trips != null) {
            //adiciona a lista
            trip.add(trips);
        }
    }

    /**
     * Compra passagem
     */
    public void comprar() {
        //compra
        deuBoa = cliente.compraPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        //se deu certo, mensagem de sucesso, se não, de erro
        if (deuBoa) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Compra concluida com sucesso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Erro na compra."));
        }
    }

    /**
     * Retorna lista de passagens
     * @return lista de passagens
     */
    public List<Trip> getTrip() {
        return trip;
    }

    /**
     * Define lista de passagens
     * @param trip lista de passagens
     */
    public void setTrip(List<Trip> trip) {
        this.trip = trip;
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

}
