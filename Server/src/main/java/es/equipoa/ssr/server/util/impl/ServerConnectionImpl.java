/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.impl;

import com.google.gson.Gson;
import es.equipoa.ssr.server.dao.Comunication;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcreta
 */
public class ServerConnectionImpl {

    ServerSocket sc;
    int PUERTO;

    public ServerConnectionImpl(int port) {
        try {
            this.PUERTO = port;
            sc = new ServerSocket(PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ServerConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket esperarConexion() {
        try {
            Socket so = new Socket();
            so = sc.accept();
            System.err.println(so.getRemoteSocketAddress().hashCode());
            System.err.println(so.getPort());
            return so;
        } catch (IOException ex) {
            Logger.getLogger(ServerConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Comunication recibir(Socket so) {
        Gson gson = new Gson();
        
        return gson.fromJson(message, Comunication.class);
    }

}
