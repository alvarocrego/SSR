/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util;

import es.equipoa.ssr.client.dao.Comunication;

/**
 *
 * @author alcreta
 */
public interface Connection {

    /**
     * Este metodo realiza la conexion con el servidor
     *
     * @return Devuelve true si se ha realizado la conexión y false si no se ha
     * realizado
     */
    public boolean conectar();

    /**
     * Envia un objeto de tipo Comunication por el socket
     *
     * @param mensaje Mensaje a enviar
     */
    public void enviar(Comunication mensaje);

    /**
     * Recibir un mensaje proveniente del socket
     *
     * @return Devuelve un objeto de tipo Comunication recibido por el socket
     */
    public Comunication recibir();

    /**
     * Metodo que cierra el socket
     */
    public void cerrar();
}
