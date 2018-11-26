/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.impl;

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

    public static void keepAlive(Socket s) {
        DataOutputStream salida = null;
        try {
            salida = new DataOutputStream(s.getOutputStream());
            salida.writeUTF("ping");
        } catch (IOException ex) {
            Logger.getLogger(ServerConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                salida.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
