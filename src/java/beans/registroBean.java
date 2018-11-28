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
 * Managedbean para registro de interesse
 */
@ManagedBean
@ViewScoped
public class registroBean {
    /**
     * Evento
     */
    private String source;
    /**
     * Destino
     */
    private String destination;
    /**
     * Preço
     */
    private Integer price;
    /**
     * Cliente para acesso ao server
     */
    private final Cliente cliente;
    /**
     * Implementação para interface do cliente
     */
    private InterfaceClienteImpl interfaceCliente;
    /**
     * Instancia cliente e interface
     */
    public registroBean() {
        cliente = new Cliente();
        try {
            interfaceCliente = new InterfaceClienteImpl();
        } catch (RemoteException ex) {
            Logger.getLogger(registroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Registra interesse
     */
    public void registry(){
        cliente.registrarInteresse(source, this.interfaceCliente, destination, price);
    }
    /**
     * Retorna evento
     * @return evento
     */
    public String getSource() {
        return source;
    }

    /**
     * Define evento
     * @param source evento
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
     * Retorna preço
     * @return preço
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Define preço
     * @param price preço
     */
    public void setPrice(Integer price) {
        this.price = price;
    }
}
