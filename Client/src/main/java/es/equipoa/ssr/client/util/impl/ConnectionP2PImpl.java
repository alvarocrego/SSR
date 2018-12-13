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
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcre
 */
public class ConnectionP2PImpl implements ConnectionP2P {

    @Override
    public Comunication recibir(Socket so) {
        DataInputStream entrada = null;
        String res = null;
        Gson gson = new Gson();
        try {
            entrada = new DataInputStream((so.getInputStream()));
            res = entrada.readUTF();

        } catch (IOException ex) {
            Logger.getLogger(ConnectionP2PImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gson.fromJson(res, Comunication.class);
    }

    @Override
    public void cerrar(Socket so) {
        try {
            so.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionP2PImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
