package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface cliente
 */
public interface InterfaceCliente extends Remote {
    /**
     * Notifica o usuário que o evento que ele registrou interesse está disponivel
     * @param evento qual evento está disponivel
     * @throws RemoteException
     */
    public void notificar(String evento) throws RemoteException;

}
