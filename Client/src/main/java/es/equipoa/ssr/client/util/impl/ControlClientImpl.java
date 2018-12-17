/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.impl;

import es.equipoa.ssr.client.dao.Comunication;
import es.equipoa.ssr.client.dao.Fichero;
import es.equipoa.ssr.client.util.ControlClient;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * Esta clase tiene los atributos necesarios para que el servidor funcione y los
 * metodos necesarios
 *
 * @author alcreta
 */
public class ControlClientImpl implements ControlClient {

    private List<Fichero> ficherosCompartidos = new ArrayList<>();
    String ipLocal = "";

    private JList<String> listaFicherosCompartidos;
    private JList<String> listaFicherosBuscados;

    /**
     * El constructor necesita que se pasen las dos JList de la interfaz para
     * poder actualizarla
     *
     * @param ipLocal Ip local del cliente
     * @param listaFicherosCompartidos JList que muestra los ficheros
     * compartidos con el servidor
     * @param listaFicherosBuscados JList que muestra los ficheros que ha
     * recibido del servidor
     */
    public ControlClientImpl(String ipLocal, JList<String> listaFicherosCompartidos, JList<String> listaFicherosBuscados) {
        this.ipLocal = ipLocal;
        this.listaFicherosCompartidos = listaFicherosCompartidos;
        this.listaFicherosBuscados = listaFicherosBuscados;
    }

    @Override
    public void buscarFicheros(List<Fichero> ficheros) {
        listaFicherosBuscados.removeAll();
        DefaultListModel model = new DefaultListModel();
        for (Fichero fichero : ficheros) {
            model.addElement(fichero.getNombre() + " ~ " + fichero.getId());
        }
        listaFicherosBuscados.setModel(model);
    }

    public Comunication actualizarFicherosCompartidos(List<String> ficheros) {
        Comunication c = new Comunication(1);
        c.setList(ficheros);
        return c;
    }

    public Comunication responderPeticionFichero(String nombreFichero, String idFichero, Integer idCliente) {
        Comunication c = new Comunication(4);
        c.setMessage(nombreFichero);
        c.setBase64File(idFichero);
        c.setIdCliente(idCliente);
        //hay que obtener la direccion ip pero to much complicado asi que bester ponerla a mano
        c.setIp(ipLocal);
        c.setPort(9638);

        return c;
    }
    
    public Comunication enviarFichero(String nombre, String datos) {
        Comunication c = new Comunication(4);
        c.setMessage(nombre);
        c.setBase64File(datos);
        return c;
    }

}
