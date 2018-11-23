/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util.connection;

/**
 *
 * @author alcreta
 */
public interface Connection {
    
	public void enviar(String nombre);

	public void cerrar();
}
