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
import principal.Trip;
import rmi.Cliente;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class pacoteBean {
    private List<Pacote> pack = new ArrayList<>();
    private boolean ida;
    private String source;
    private String destination;
    private String flightdate;
    private String flightdateVolta;
    private int numberOfAirfares;
    private int numberOfRooms;
    private final Cliente cliente;

    public pacoteBean() {
        cliente = new Cliente();
    }

    public void search() {
        pack = new ArrayList<>();
        Trip trip = cliente.consultaPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        Hotel hotel = cliente.consultaHotel(destination, flightdate, flightdateVolta, numberOfRooms, numberOfAirfares);
        Pacote pacote = new Pacote();
        pacote.setSource(trip.getSource());
        pacote.setDestination(trip.getDestination());
        pacote.setBegin(trip.getBegin());
        pacote.setEnd(trip.getEnd());
        pacote.setCity(hotel.getCity());
        pacote.setPrice(hotel.getPrice());
        pack.add(pacote);
    }

    public void comprar() {
        boolean a = cliente.compraPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        boolean b = cliente.compraHotel(destination, flightdate, flightdateVolta, numberOfRooms, numberOfAirfares);
        if (a && b) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Compra concluida com sucesso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Erro na compra."));
        }
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public int getNumberOfAirfares() {
        return numberOfAirfares;
    }

    public void setNumberOfAirfares(int numberOfAirfares) {
        this.numberOfAirfares = numberOfAirfares;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isIda() {
        return ida;
    }

    public void setIda(boolean ida) {
        this.ida = ida;
    }

    public List<Pacote> getPack() {
        return pack;
    }

    public void setPack(List<Pacote> pack) {
        this.pack = pack;
    }

}
