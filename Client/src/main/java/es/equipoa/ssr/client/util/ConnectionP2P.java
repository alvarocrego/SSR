/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util;

import es.equipoa.ssr.client.dao.Comunication;
import java.net.Socket;

/**
 *
 * @author alcre
 */
public interface ConnectionP2P {

    /**
     * Recibir un mensaje
     *
     * @return Retorna el mensaje recibido de tipo Comunication
     */
    public Comunication recibir();

    /**
     * Cierra el socket
     *
     */
    public void cerrar();
}
