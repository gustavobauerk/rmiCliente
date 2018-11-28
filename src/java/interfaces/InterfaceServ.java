package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import principal.Hotel;
import principal.Trip;

public interface InterfaceServ extends Remote {
    /**
     * Retorna uma passagem
     * @param ida false só ida, true ida e volta
     * @param source da onde está viajanto
     * @param destination para onde está viajando
     * @param dateIda data de ida do voo
     * @param passagens numero de passagenes desejadas
     * @param dateVolta data do voo de volta
     * @return a passagem caso encontrada
     * @throws RemoteException
     */
    public Trip searchAirfare(boolean ida, String source, String destination, String dateIda, String dateVolta, int passagens) throws RemoteException;

    /**
     * Retorna o resultado da compra de uma passagem
     * @param ida false só ida, true ida e volta
     * @param source da onde está viajanto
     * @param destination para onde está viajando
     * @param dateIda data de ida do voo
     * @param passagens numero de passagenes desejadas
     * @param dateVolta data do voo de volta
     * @return true caso a compre de certo, false no contrário
     * @throws RemoteException
     */
    public boolean buyAirfare(boolean ida, String source, String destination, String dateIda, String dateVolta, int passagens) throws RemoteException;

    /**
     * Retorna o resultado da compra de um hotel
     * @param name nome do hotel
     * @param flightdate data de entrada no hotel
     * @param flightdateVolta data de volta no hotel
     * @param numberOfRooms numero de quartos desejados
     * @param numberOfPeople numero de pessoas viajando
     * @return true caso a compre de certo, false no contrário
     * @throws RemoteException
     */
    public Hotel searchHotel(String name, String flightdate, String flightdateVolta, int numberOfRooms, int numberOfPeople) throws RemoteException;

    /**
     * Retorna um hotel baseado nos filtros de pesquisa
     * @param name nome do hotel
     * @param flightdate data de entrada no hotel
     * @param flightdateVolta data de volta no hotel
     * @param numberOfRooms numero de quartos desejados
     * @param numberOfPeople numero de pessoas viajando
     * @return um hotel
     * @throws RemoteException
     */
    public boolean buyHotel(String name, String flightdate, String flightdateVolta, int numberOfRooms, int numberOfPeople) throws RemoteException;

    /**
     * Registra o interesse em um evento
     * @param event nome do evento(viagem, hotel, pacote)
     * @param client o cliente
     * @param destination destino do evento
     * @param price preço máximo a ser pago pelo cliente
     * @throws RemoteException
     */
    public void registerInterest(String event, InterfaceCliente client, String destination, Integer price) throws RemoteException;

    /**
     * Cancela um registro em um evento
     * @param event nome do evento(viagem, hotel, pacote)
     * @param client o cliente
     * @param destination destino do evento
     * @param price preço máximo a ser pago pelo cliente
     * @throws RemoteException
     */
    public void cancelRegister(String event, InterfaceCliente client, String destination, Integer price) throws RemoteException;

}
