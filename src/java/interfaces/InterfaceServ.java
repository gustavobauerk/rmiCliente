package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import principal.Hotel;
import principal.Trip;

public interface InterfaceServ extends Remote {
    /**
     * Retorna uma lista de passagens
     * @param ida
     * @param source
     * @param destination
     * @param dateIda
     * @param passagens
     * @param dateVolta
     * @return lista de passagens
     * @throws RemoteException
     */
    public Trip searchAirfare(boolean ida, String source, String destination, String dateIda, String dateVolta, int passagens) throws RemoteException;

    /**
     * Retorna uma lista de passagens
     * @param ida
     * @param source
     * @param destination
     * @param dateIda
     * @param passagens
     * @param dateVolta
     * @return estado da compra
     * @throws RemoteException
     */
    public boolean buyAirfare(boolean ida, String source, String destination, String dateIda, String dateVolta, int passagens) throws RemoteException;

    public Hotel searchHotel(String name, String flightdate, String flightdateVolta, int numberOfRooms, int numberOfPeople) throws RemoteException;

    public boolean buyHotel(String name, String flightdate, String flightdateVolta, int numberOfRooms, int numberOfPeople) throws RemoteException;

    public void registerInterest(String event, InterfaceCliente client, String destination, Integer price) throws RemoteException;

    public void cancelRegister(String event, InterfaceCliente client, String destination, Integer price) throws RemoteException;

}
