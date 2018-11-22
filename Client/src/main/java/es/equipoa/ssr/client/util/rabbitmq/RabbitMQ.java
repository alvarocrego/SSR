/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;

/**
 *
 * @author alcreta
 */
public interface RabbitMQ {

    	public void conectar() throws Exception;

	public void enviar(String nombre, Object objeto) throws Exception;

	public String getCola();

	public void encolar(String nombre);

	public Channel getChannel();

	public void añadirConsumidor(Consumer consumidor);

	public void cerrar() throws Exception;

}
