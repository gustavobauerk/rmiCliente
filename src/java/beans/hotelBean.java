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
import principal.Hotel;
import rmi.Cliente;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class hotelBean {
    private List<Hotel> hotel = new ArrayList<>();
    private String name;
    private String flightdate;
    private String flightdateVolta;
    private int numberOfRooms;
    private int numberOfPeople;
    private final Cliente cliente;

    public hotelBean() {
        cliente = new Cliente();
    }

    /**
     * Consulta passagem
     */
    public void search() {
        hotel = new ArrayList<>();
        Hotel hotels = cliente.consultaHotel(name, flightdate, flightdateVolta, numberOfRooms, numberOfPeople);
        if (hotels != null) {
            hotel.add(hotels);
        }
    }

    public void comprar() {
        boolean a = cliente.compraHotel(name, flightdate, flightdateVolta, numberOfRooms, numberOfPeople);
        if (a) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Compra concluida com sucesso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Erro na compra."));
        }
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightdate() {
        return flightdate;
    }

    public void setFlightdate(String flightdate) {
        this.flightdate = flightdate;
    }

    public String getFlightdateVolta() {
        return flightdateVolta;
    }

    public void setFlightdateVolta(String flightdateVolta) {
        this.flightdateVolta = flightdateVolta;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

}
