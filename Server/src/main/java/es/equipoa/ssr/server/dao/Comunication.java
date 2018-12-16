/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alcreta
 */
public class Comunication {

    private Integer typeMessage;
    private String message;
    private Integer idCliente;
    private String base64File;
    private List<String> list = new ArrayList<>();
    private List<Fichero> ficheros = new ArrayList<>();
    private String ip;
    private Integer port;
    private Boolean ack;

    public Comunication(Integer typeMessage) {
        this.typeMessage = typeMessage;
    }

    public Integer getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(Integer typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getBase64File() {
        return base64File;
    }

    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Fichero> getFicheros() {
        return ficheros;
    }

    public void setFicheros(List<Fichero> ficheros) {
        this.ficheros = ficheros;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getAck() {
        return ack;
    }

    public void setAck(Boolean ack) {
        this.ack = ack;
    }

}
