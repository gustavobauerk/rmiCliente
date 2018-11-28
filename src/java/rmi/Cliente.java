package rmi;

import beans.InterfaceClienteImpl;
import interfaces.InterfaceServ;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import principal.Hotel;
import principal.Trip;

public class Cliente {
    private InterfaceServ server;
    private InterfaceClienteImpl interfaceCliente;

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

    public Hotel consultaHotel(String name, String flightdate, String flightdateVolta, int numberOfRooms, int numberOfPeople) {
        Hotel result = new Hotel();
        try {
            result = server.searchHotel(name, flightdate, flightdateVolta, numberOfRooms, numberOfPeople);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }

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

    public void registrarInteresse(String source,InterfaceClienteImpl a, String destination, Integer price) {
        try {
            server.registerInterest(source, a, destination, price);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
