/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.connection.impl;

import es.equipoa.ssr.server.util.connection.Connection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcreta
 */
public class ConnectionImpl implements Connection {

    Socket sc;
    String HOST;
    int PUERTO;

    public ConnectionImpl(String server, int port) {
        this.HOST = server;
        this.PUERTO = port;
    }

    @Override
    public boolean conectar() {
        try {
            System.err.println(HOST);
            System.err.println(PUERTO);
            sc = new Socket(HOST, PUERTO);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void enviar(String texto) {
        try {
            DataOutputStream salida = new DataOutputStream(sc.getOutputStream());
            salida.writeUTF(texto);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public String recibir() {
        BufferedReader entrada = null;
        String res = null;
        try {
            entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            res = entrada.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }

    @Override
    public void cerrar() {
        try {
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
