/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.impl;

import com.google.gson.Gson;
import es.equipoa.ssr.client.dao.Comunication;
import es.equipoa.ssr.client.util.Connection;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que sirve para controlar la comunicación con el servidor o con Cliente
 * @author alcreta
 */
public class ConnectionImpl implements Connection {

    Socket sc;
    String HOST;
    int PUERTO;

    /**
     * Inicializa los atributos de la clase necesarios para poder conectarse
     * @param server IP del servidor al que se va a realizar la conexión
     * @param port Puerto del servidor al que se va a realizar la conexion
     */
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
    public void enviar(Comunication mensaje) {
        Gson gson = new Gson();
        try {
            DataOutputStream salida = new DataOutputStream(sc.getOutputStream());
            salida.writeUTF(gson.toJson(mensaje));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public Comunication recibir() {
        DataInputStream entrada = null;
        String res = null;
        Gson gson = new Gson();
        try {
            entrada = new DataInputStream((sc.getInputStream()));
            res = entrada.readUTF();
            
        } catch (IOException ex) {
            Logger.getLogger(ConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gson.fromJson(res, Comunication.class);
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
