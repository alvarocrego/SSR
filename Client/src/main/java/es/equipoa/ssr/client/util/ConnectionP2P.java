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
     * Recibir un mensaje proveniente del socket
     *
     * @param so Socket por el que se recibirá un mensaje
     * @return Retorna el mensaje recibido de tipo Comunication
     */
    public Comunication recibir(Socket so);

    /**
     * Cierra el socket proporcionado
     *
     * @param so Socket a cerrar
     */
    public void cerrar(Socket so);
}
