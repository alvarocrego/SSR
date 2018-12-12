/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util;

import es.equipoa.ssr.client.dao.Fichero;
import java.io.File;
import java.util.List;

/**
 *
 * @author alcre
 */
public interface ControlFiles {
    
    public void ControlFiles(String prueba);
    
    /**
     * Lee en la carpeta los archivos y los devuelve en una lista de tipo Fichero
     * @return Lista de Ficheros en la carpeta
     */
    public List<Fichero> obtenerListaDeFicheros();
    
    /**
     * Guarda en la carpeta el Fichero pasado
     * @param fichero Fichero a guardar
     * @return Retorna true si ha sido correcto o false en caso de que falle.
     */
    public Boolean guardarFichero(File fichero);
    
    /**
     * Obtiene el fichero solicitado
     * @param fichero Fichero solicitado
     * @return Fichero solicitado
     */
    public File obtenerFichero(Fichero fichero);
}
