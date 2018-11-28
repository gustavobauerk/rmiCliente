/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.time.LocalDate;

/**
 *
 * @author Gustavo
 */
public class Pacote {
    /**
     * Origem da passagem
     */
    private String source;
    /**
     * Destino da passagem
     */
    private String destination;
    /**
     * Data de ida da viagem
     */
    private LocalDate begin;
    /**
     * Data de volta da viagem
     */
    private LocalDate end;
    /**
     * Numero de passagens
     */
    private Integer numberOfAirfares;
    /**
     * Cidade do hotel
     */
    private String city;
    /**
     * Tamanho do quarto, numero de quartos daquele tamanho
     */
    private Integer price;

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

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Integer getNumberOfAirfares() {
        return numberOfAirfares;
    }

    public void setNumberOfAirfares(Integer numberOfAirfares) {
        this.numberOfAirfares = numberOfAirfares;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
