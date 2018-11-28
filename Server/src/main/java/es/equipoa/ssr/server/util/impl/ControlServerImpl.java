/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.impl;

import es.equipoa.ssr.server.dao.Cliente;
import es.equipoa.ssr.server.util.ControlServer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcre
 */
public class ControlServerImpl extends Thread implements ControlServer {

    Map<Integer, Cliente> clientes = new HashMap<>();
    Map<String, Cliente> ficheros = new HashMap<>();

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Ah, ha, ha, ha, stayin' alive, stayin' alive");
                clientes.entrySet().forEach((entry) -> {
                    ServerConnectionImpl.keepAlive(entry.getValue().getSocket());
                });
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Map<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Map<String, Cliente> getFicheros() {
        return ficheros;
    }

    public void setFicheros(Map<String, Cliente> ficheros) {
        this.ficheros = ficheros;
    }

    public void añadirCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

}
