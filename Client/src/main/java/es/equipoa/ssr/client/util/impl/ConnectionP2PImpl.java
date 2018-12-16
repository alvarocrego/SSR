/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.impl;

import com.google.gson.Gson;
import es.equipoa.ssr.client.dao.Comunication;
import es.equipoa.ssr.client.util.ConnectionP2P;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcre
 */
public class ConnectionP2PImpl implements ConnectionP2P {

    ServerSocket sc;
    Socket so;
    Integer PUERTO;

    public ConnectionP2PImpl(Integer puerto) {
        try {
            this.PUERTO = puerto;
            sc = new ServerSocket(PUERTO);
            esperarConexion();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionP2PImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void esperarConexion() {
        try {
            this.so = sc.accept();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionP2PImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviar(Comunication mensaje) {
        Gson gson = new Gson();
        try {
            DataOutputStream salida = new DataOutputStream(this.so.getOutputStream());
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
            entrada = new DataInputStream((this.so.getInputStream()));
            res = entrada.readUTF();

        } catch (IOException ex) {
            Logger.getLogger(ConnectionP2PImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gson.fromJson(res, Comunication.class);
    }

    @Override
    public void cerrar() {
        try {
            this.so.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionP2PImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
