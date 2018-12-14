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
 * @author alcre
 */
public interface ControlFiles {
    
    /**
     * Lee en la carpeta los archivos y los devuelve en una lista de tipo Fichero
     * @return Lista de Ficheros en la carpeta
     */
    public List<String> obtenerListaDeFicheros();
    
    /**
     * Guarda en la carpeta el Fichero pasado
     * @param nombre Nombre del fichero
     * @param datos Contenido del fichero
     * @return Retorna true si ha sido correcto o false en caso de que falle.
     */
    public Boolean guardarFichero(String nombre, String datos);
    
    /**
     * Obtiene el fichero solicitado en base64
     * @param fichero Fichero solicitado
     * @return Fichero solicitado
     */
    public String obtenerFichero(String fichero);
}
