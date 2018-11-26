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
            clientes.entrySet().forEach((entry) -> {
                ServerConnectionImpl.keepAlive(entry.getValue().getSocket());
            });
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
