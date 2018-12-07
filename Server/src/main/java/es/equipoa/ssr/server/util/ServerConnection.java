/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util;

import es.equipoa.ssr.server.dao.Comunication;
import java.net.Socket;

/**
 *
 * @author alcreta
 */
public interface ServerConnection {

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
