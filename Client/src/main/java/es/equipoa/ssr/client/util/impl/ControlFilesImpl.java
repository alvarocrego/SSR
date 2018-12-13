/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.impl;

import es.equipoa.ssr.client.dao.Fichero;
import es.equipoa.ssr.client.gui.Application;
import es.equipoa.ssr.client.util.ControlFiles;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcre
 */
public class ControlFilesImpl implements ControlFiles {

    private File carpeta;
    private Map<String, File> archivos;

    public ControlFilesImpl(String ruta) {
        inicializar(ruta);
    }

    @Override
    public void ControlFiles(String prueba) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> obtenerListaDeFicheros() {
        Map<String, File> list = new HashMap<>();
        File[] files = carpeta.listFiles();
        for (File file : files) {
            if(file.isFile())
                list.put(file.getName(), file);
        }
        archivos = list;
        return new ArrayList<>(list.keySet());
    }

    @Override
    public Boolean guardarFichero(File fichero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File obtenerFichero(Fichero fichero) {
        return archivos.get(fichero.getNombre());
    }

    /**
     * Comprueba y crea la carpeta en caso de no existir
     */
    private void inicializar(String ruta) {
//        File f = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
//        System.out.println(f.getAbsolutePath() + "\\" + ruta);
        carpeta = new File(ruta);
        if (!existeLaCarpeta(ruta)) {
            crearCarpeta(ruta);
        }
    }

    /**
     * Comprueba si la carpeta existe
     *
     * @return
     */
    private Boolean existeLaCarpeta(String ruta) {
        File tmp = new File(ruta);
        if (tmp.exists()) {
            return tmp.isDirectory();
        } else {
            return false;
        }
    }

    /**
     * Crea una carpeta
     */
    private void crearCarpeta(String ruta) {
        carpeta = new File(ruta);
        carpeta.mkdirs();
    }

}
