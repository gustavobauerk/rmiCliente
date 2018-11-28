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
    private List<Trip> trip = new ArrayList<>();
    private boolean ida;
    private String source;
    private String destination;
    private String flightdate;
    private String flightdateVolta;
    private int numberOfAirfares;
    private final Cliente cliente;
    private boolean deuBoa;

    public passagemBean() {
        cliente = new Cliente();
    }

    /**
     * Consulta passagem
     */
    public void search() {
        trip = new ArrayList<>();
        Trip trips = cliente.consultaPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        if (trips != null) {
            trip.add(trips);
        }
    }

    public void comprar() {
        deuBoa = cliente.compraPassagem(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        if (deuBoa) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Compra concluida com sucesso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Erro na compra."));
        }
    }

    public List<Trip> getTrip() {
        return trip;
    }

    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }

    public boolean isIda() {
        return ida;
    }

    public void setIda(boolean ida) {
        this.ida = ida;
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

}
