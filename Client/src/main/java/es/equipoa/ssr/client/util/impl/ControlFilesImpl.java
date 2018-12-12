/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.impl;

import es.equipoa.ssr.client.dao.Fichero;
import es.equipoa.ssr.client.util.ControlFiles;
import java.io.File;
import java.util.List;

/**
 *
 * @author alcre
 */
public class ControlFilesImpl implements ControlFiles {

    private String ruta;

    public ControlFilesImpl(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void ControlFiles(String prueba) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fichero> obtenerListaDeFicheros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean guardarFichero(File fichero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File obtenerFichero(Fichero fichero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
