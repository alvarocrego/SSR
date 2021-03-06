/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.impl;

import com.google.gson.Gson;
import es.equipoa.ssr.server.dao.Comunication;
import es.equipoa.ssr.server.util.ServerConnection;
import java.io.DataInputStream;
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
public class ServerConnectionImpl implements ServerConnection {

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

    @Override
    public Comunication recibir(Socket so) {
        DataInputStream entrada = null;
        String res = null;
        Gson gson = new Gson();
        try {
            entrada = new DataInputStream((so.getInputStream()));
            res = entrada.readUTF();

        } catch (IOException ex) {
            Logger.getLogger(ServerConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gson.fromJson(res, Comunication.class);
    }

    /**
     * Envia un objeto de tipo Comunication por el socket
     *
     * @param so Socket por donde se enviará el mensaje
     * @param mensaje Objeto de tiempo Comunication que se enviará por el socket
     */
    public static void enviar(Socket so, Comunication mensaje) {
        Gson gson = new Gson();
        try {
            DataOutputStream salida = new DataOutputStream(so.getOutputStream());
            salida.writeUTF(gson.toJson(mensaje));
        } catch (IOException ex) {
            Logger.getLogger(ServerConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cerrar(Socket so) {
        try {
            so.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
