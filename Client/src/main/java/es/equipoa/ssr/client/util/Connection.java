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

    public boolean conectar();

    public void enviar(String nombre);

    public Comunication recibir();

    public void cerrar();
}
