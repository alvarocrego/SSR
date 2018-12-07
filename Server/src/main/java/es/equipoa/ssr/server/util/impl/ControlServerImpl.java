/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.impl;

import es.equipoa.ssr.server.dao.Cliente;
import es.equipoa.ssr.server.dao.Comunication;
import es.equipoa.ssr.server.dao.Fichero;
import es.equipoa.ssr.server.util.ControlServer;
import java.awt.Color;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author alcre
 */
public class ControlServerImpl extends Thread implements ControlServer {

    Map<Integer, Cliente> clientes = new HashMap<>();
    Map<String, Fichero> ficheros = new HashMap<>();
    
    JList<String> cli;
    JList<String> fi;
    public ControlServerImpl(JList<String> cliente, JList<String> ficheros) {
        cli = cliente;
        fi = ficheros;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Ah, ha, ha, ha, stayin' alive, stayin' alive");
                DefaultListModel<String> modelCliente = new DefaultListModel<>();
                DefaultListModel<String> modelFichero = new DefaultListModel<>();
                clientes.entrySet().forEach((entry) -> {
                    Socket s = entry.getValue().getSocket();
                    Integer id = entry.getValue().getId();
                    if (s.isClosed()) {
                        clientes.remove(id);
                        ficheros.entrySet().forEach((entry2) -> {
                            Integer aux = entry2.getValue().getIdCliente();
                            if(aux == id){
                                ficheros.remove(entry2.getKey());
                            }
                        });
                    } else {
                        modelCliente.addElement(Integer.toString(id));
                    }
                });
                cli.setModel(modelCliente);
                ficheros.entrySet().forEach((entry) -> {
                    modelFichero.addElement(entry.getValue().getNombre());
                });
                fi.setModel(modelFichero);
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

    public Map<String, Fichero> getFicheros() {
        return ficheros;
    }

    public void setFicheros(Map<String, Fichero> ficheros) {
        this.ficheros = ficheros;
    }

    @Override
    public void añadirCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
    
    private void añadirFichero(String nombre, Integer idCliente) {
        Fichero fichero = new Fichero();
        fichero.setId(crearIdFichero(nombre, idCliente));
        fichero.setNombre(nombre);
        fichero.setIdCliente(idCliente);
        System.err.println("He pasado por aqui");
        ficheros.put(fichero.getId(), fichero);
    }
    
    private String crearIdFichero (String fichero, Integer idCliente) {
        return (Integer.toString(idCliente) + Integer.toString(fichero.hashCode()));
    }

    public void borrarFicherosPorCliente(Cliente cli) {
        ficheros.entrySet().forEach((entry) -> {
            Integer aux = entry.getValue().getIdCliente();
            if(aux == cli.getId()){
                ficheros.remove(entry.getKey());
            }
        });
    }
    
    @Override
    public void actualizarFicheros(List<String> newFicheros, Cliente cli) {
//        ficheros.entrySet().forEach((entry) -> {
//            Integer aux = entry.getValue().getIdCliente();
//            if(aux == cli.getId()){
//                ficheros.remove(entry.getKey());
//            }
//        });
        
        borrarFicherosPorCliente(cli);

        for(String fichero : newFicheros){
            añadirFichero(fichero, cli.getId());
        }
    }
    
    @Override
    public List<Fichero> buscarFicheros(Socket so, String busqueda) {
        List<Fichero> res = new ArrayList<>();
        ficheros.entrySet().forEach((entry) -> {
            if(entry.getValue().getNombre().contains(busqueda)){
                res.add(entry.getValue());
            }
        });
        Comunication comu = new Comunication(2);
        ServerConnectionImpl.enviar(so, busqueda);
        return res;
    }
    
    private Socket getSocketByIdFichero(String idFichero){
        return clientes.get(ficheros.get(idFichero).getIdCliente()).getSocket();
    }

    @Override
    public void enviarPeticionFichero(String idFichero) {
        Socket so = getSocketByIdFichero(idFichero);
        //Comunication comu = new Comunication();
        //ServerConnectionImpl.enviar(so, );
    }

    @Override
    public void enviarSolicitanteIpPuerto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
