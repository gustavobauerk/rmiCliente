package principal;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que simboliza a passagem aérea
 */
public class Trip implements Serializable {
    /**
     * Váriavel para viagem ser de ida(false), ida e volta(true)
     */
    private boolean roundTrip;
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
     * Retorna true caso a viagem seja de ida e volta, false caso só ida
     * @return true caso a viagem seja de ida e volta, false caso só ida
     */
    public boolean isRoundTrip() {
        return roundTrip;
    }

    /**
     * Define se a viagem é só de ida ou de ida e volta
     * @param roundTrip true caso a viagem seja de ida e volta, false caso só ida
     */
    public void setRoundTrip(boolean roundTrip) {
        this.roundTrip = roundTrip;
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

}
