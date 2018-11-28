/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.time.LocalDate;

/**
 * Junção do hotel e passagem para exibição na tabela
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
     * Retorna Data de ida
     * @return data de ida
     */
    public LocalDate getBegin() {
        return begin;
    }

    /**
     * Define Data de ida
     * @param begin Data de ida
     */
    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    /**
     * Retorna Data de volta
     * @return Data de volta
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * Define Data de volta
     * @param end Data de volta
     */
    public void setEnd(LocalDate end) {
        this.end = end;
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
     * Retorna nome do hotel
     * @return nome do hotel
     */
    public String getCity() {
        return city;
    }

    /**
     * Define nome do hotel
     * @param city nome do hotel
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retorna preço do hotel
     * @return preço do hotel
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Define preço do hotel
     * @param price preço do hotel
     */
    public void setPrice(Integer price) {
        this.price = price;
    }
}
