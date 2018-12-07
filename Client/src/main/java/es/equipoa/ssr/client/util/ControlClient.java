/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util;

import es.equipoa.ssr.client.dao.Fichero;
import java.util.List;

/**
 *
 * @author alcreta
 */
public interface ControlClient {
    
    public void buscarFicheros(List<Fichero> ficheros);
    
}
