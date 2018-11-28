package beans;

import interfaces.InterfaceCliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Interface para os métodos disponiveis no cliente
 */
public class InterfaceClienteImpl extends UnicastRemoteObject implements InterfaceCliente {
    protected InterfaceClienteImpl() throws RemoteException {
        super();
    }

    /**
     * Notifica o usuário que a viagem interessada está disponivel
     * @param evento quak eventi está disponivel
     */
    @Override
    public void notificar(String evento) {
        System.out.println(evento + " disponivel");
    }

}
