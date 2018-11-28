/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import rmi.Cliente;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class registroBean {
    private String source;
    private String destination;
    private Integer price;
    private final Cliente cliente;
    private InterfaceClienteImpl interfaceCliente;
    public registroBean() {
        cliente = new Cliente();
        try {
            interfaceCliente = new InterfaceClienteImpl();
        } catch (RemoteException ex) {
            Logger.getLogger(registroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registry(){
        cliente.registrarInteresse(source, this.interfaceCliente, destination, price);
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
