/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.connection.impl;

import es.equipoa.ssr.server.util.connection.Connection;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alcreta
 */
public class ConnectionImpl implements Connection {

    ServerSocket sc;
    Socket so;

    public ConnectionImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
