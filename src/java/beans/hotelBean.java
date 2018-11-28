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
import rmi.Cliente;

/**
 * ManagedBean da página de pesquisa e compra de hoteis
 */
@ManagedBean
@SessionScoped
public class hotelBean {
    /**
     * Lista de hoteis para exibição ao usuário
     */
    private List<Hotel> hotel = new ArrayList<>();
    /**
     * Filtro de pesquisa do nome do hotel
     */
    private String name;
    /**
     * Filtro de pesquisa da data de entrada no hotel
     */
    private String flightdate;
    /**
     * Filtro de pesquisa da data de saida no hotel
     */
    private String flightdateVolta;
    /**
     * Filtro de pesquisa do numero de quartos desejados
     */
    private int numberOfRooms;
    /**
     * Filtro de pesquisa do numero de pessoas indo ao hotel
     */
    private int numberOfPeople;
    /**
     * Cliente para acesso
     */
    private final Cliente cliente;

    /**
     * Controi o cliente para uso dos métodos do server
     */
    public hotelBean() {
        cliente = new Cliente();
    }

    /**
     * Consulta passagem
     */
    public void search() {
        //instancia nova lista
        hotel = new ArrayList<>();
        //consulta a passagem
        Hotel hotels = cliente.consultaHotel(name, flightdate, flightdateVolta, numberOfRooms, numberOfPeople);
        //se teve retorno válido anexa a lista
        if (hotels != null) {
            hotel.add(hotels);
        }
    }

    /**
     * Compra passagem
     */
    public void comprar() {
        //compra apassagem
        boolean a = cliente.compraHotel(name, flightdate, flightdateVolta, numberOfRooms, numberOfPeople);
        if (a) {
            //se deu certo, mensagem de sucesso
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Compra concluida com sucesso."));
        } else {
            //se deu errado, mensagem de erro
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Erro na compra."));
        }
    }

    /**
     * Retorna lista de hoteis
     * @return lista de hoteis
     */
    public List<Hotel> getHotel() {
        return hotel;
    }

    /**
     * Define lista de hoteis
     * @param hotel lista de hoteis
     */
    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    /**
     * Retorna nome do hotel
     * @return nome do hotel
     */
    public String getName() {
        return name;
    }

    /**
     * Define nome do hotel
     * @param name nome do hotel
     */
    public void setName(String name) {
        this.name = name;
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
     * Retorna numero de pessoas
     * @return numero de pessoas
     */
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    /**
     * Define numero de pessoas
     * @param numberOfPeople numero de pessoas
     */
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

}
