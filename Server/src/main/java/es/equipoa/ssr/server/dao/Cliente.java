/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.dao;

import java.net.Socket;

/**
 *
 * @author alcre
 */
public class Cliente {

    Integer id;

    Socket so;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Socket getSocket() {
        return so;
    }

    public void setSocket(Socket so) {
        this.so = so;
    }

}
