package rmi;

import beans.InterfaceClienteImpl;
import interfaces.InterfaceServ;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import principal.Hotel;
import principal.Trip;

/**
 * Classe que instancia a interface do server e se conecta ao servidor
 */
public class Cliente {
    private InterfaceServ server;
    /**
     * Conecta ao server
     */
    public Cliente() {
        try {
            System.setProperty("java.security.policy", "file:java.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            // procuro o servico de nomes
            Registry locate = LocateRegistry.getRegistry("localhost", 10000);
            // procuro a interface do servidor
            server = (InterfaceServ) locate.lookup("Server");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma passagem
     * @param ida false só ida, true ida e volta
     * @param source da onde está viajanto
     * @param destination para onde está viajando
     * @param dateIda data de ida do voo
     * @param passagens numero de passagenes desejadas
     * @param dateVolta data do voo de volta
     * @return a passagem caso encontrada
     */
    public Trip consultaPassagem(boolean ida, String source, String destination, String dateIda,
        String dateVolta, int passagens) {
        Trip result = new Trip();
        try {
            result = server.searchAirfare(ida, source, destination, dateIda, dateVolta, passagens);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Retorna o resultado da compra de uma passagem
     * @param ida false só ida, true ida e volta
     * @param source da onde está viajanto
     * @param destination para onde está viajando
     * @param flightdate data de ida do voo
     * @param numberOfAirfares numero de passagenes desejadas
     * @param flightdateVolta data do voo de volta
     * @return true caso a compre de certo, false no contrário
     */
    public boolean compraPassagem(boolean ida, String source, String destination, String flightdate, String flightdateVolta, int numberOfAirfares) {
        boolean result = false;
        try {
            result = server.buyAirfare(ida, source, destination, flightdate, flightdateVolta, numberOfAirfares);
        } catch (RemoteException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * Retorna o resultado da compra de um hotel
     * @param name nome do hotel
     * @param flightdate data de entrada no hotel
     * @param flightdateVolta data de volta no hotel
     * @param numberOfRooms numero de quartos desejados
     * @param numberOfPeople numero de pessoas viajando
     * @return true caso a compre de certo, false no contrário
     */
    public Hotel consultaHotel(String name, String flightdate, String flightdateVolta, int numberOfRooms, int numberOfPeople) {
        Hotel result = new Hotel();
        try {
            result = server.searchHotel(name, flightdate, flightdateVolta, numberOfRooms, numberOfPeople);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Retorna um hotel baseado nos filtros de pesquisa
     * @param name nome do hotel
     * @param flightdate data de entrada no hotel
     * @param flightdateVolta data de volta no hotel
     * @param numberOfRooms numero de quartos desejados
     * @param numberOfPeople numero de pessoas viajando
     * @return um hotel
     */
    public boolean compraHotel(String name, String flightdate, String flightdateVolta, int numberOfRooms, int numberOfPeople) {
        boolean result = false;
        try {
            result = server.buyHotel(name, flightdate, flightdateVolta, numberOfRooms, numberOfPeople);
        } catch (RemoteException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * Registra o interesse em um evento
     * @param source nome do evento(viagem, hotel, pacote)
     * @param a o cliente
     * @param destination destino do evento
     * @param price preço máximo a ser pago pelo cliente
     */
    public void registrarInteresse(String source,InterfaceClienteImpl a, String destination, Integer price) {
        try {
            server.registerInterest(source, a, destination, price);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
