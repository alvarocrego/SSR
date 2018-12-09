/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util;

import es.equipoa.ssr.server.dao.Cliente;
import es.equipoa.ssr.server.dao.Fichero;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author alcre
 */
public interface ControlServer {

    public void actualizarFicheros(List<String> newFicheros, Cliente cli);

    public void añadirCliente(Cliente cliente);

    public void buscarFicheros(Socket so, String busqueda, Cliente cli);

    public void enviarPeticionFichero(String idFichero);

    public void enviarSolicitanteIpPuerto();
}
