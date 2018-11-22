/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.rabbitmq.impl;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import es.equipoa.ssr.client.util.rabbitmq.RabbitMQ;

/**
 *
 * @author alcreta
 */
public class RabbitMQImpl implements RabbitMQ {

    private String EX;
    private Channel channel;
    private Connection connection;
    private String queue;

    public RabbitMQImpl(String exchange) {
        this.EX = exchange;
    }

    @Override
    public void conectar() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EX, BuiltinExchangeType.TOPIC);
            queue = channel.queueDeclare().getQueue();
        } catch (Exception e) {
            System.out.println("Error al Conectar");
            e.printStackTrace();
        }
    }

    @Override
    public void enviar(String nombre, Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCola() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void encolar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Channel getChannel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void añadirConsumidor(Consumer consumidor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
