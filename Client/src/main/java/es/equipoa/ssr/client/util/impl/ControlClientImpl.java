/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.impl;

import es.equipoa.ssr.client.dao.Fichero;
import es.equipoa.ssr.client.util.ControlClient;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author alcreta
 */
public class ControlClientImpl implements ControlClient{

    private List<Fichero> ficherosCompartidos = new ArrayList<>();

    
    private JList<String> listaFicherosCompartidos;
    private JList<String> listaFicherosBuscados;

    public ControlClientImpl(JList<String> listaFicherosCompartidos, JList<String> listaFicherosBuscados) {
        this.listaFicherosCompartidos = listaFicherosCompartidos;
        this.listaFicherosBuscados = listaFicherosBuscados;
    }
    
    @Override
    public void buscarFicheros(List<Fichero> ficheros) {
        listaFicherosBuscados.removeAll();
        DefaultListModel model = new DefaultListModel();
        for(Fichero fichero:ficheros){
            model.addElement(fichero.getNombre() + " - " + fichero.getId());
        }
        listaFicherosBuscados.setModel(model);
    }
    
    
}