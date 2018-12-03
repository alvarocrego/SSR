/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alcreta
 */
public class Comunication {

    private Integer typeMessage;
    private String message;
    private List<String> list = new ArrayList<>();
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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Boolean getAck() {
        return ack;
    }

    public void setAck(Boolean ack) {
        this.ack = ack;
    }

}
