/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.client.util.impl;

import es.equipoa.ssr.client.dao.Fichero;
import es.equipoa.ssr.client.util.ControlFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
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
    private String ruta;
    private Map<String, File> archivos;

    public ControlFilesImpl(String ruta) {
        inicializar(ruta);
    }

    @Override
    public List<String> obtenerListaDeFicheros() {
        Map<String, File> list = new HashMap<>();
        File[] files = carpeta.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                list.put(file.getName(), file);
            }
        }
        archivos = list;
        return new ArrayList<>(list.keySet());
    }

    @Override
    public Boolean guardarFichero(String nombre, String datos) {
        File file = new File(this.ruta + "\\" + nombre);
        try {
            OutputStream stream = new FileOutputStream(file);
            stream.write(decodeBase64BinaryToFile(datos));
            stream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public String obtenerFichero(String fichero) {
        return encodeFileToBase64Binary(archivos.get(fichero));
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

    private static byte[] leerFichero(File file) {
        try {
            InputStream is = new FileInputStream(file);

            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                // File is too large
            }
            byte[] bytes = new byte[(int) length];

            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }

            is.close();
            return bytes;
        } catch (IOException ex) {
            Logger.getLogger(ControlFilesImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private String encodeFileToBase64Binary(File file) {
        byte[] bytes = leerFichero(file);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encodedString = new String(encoded);

        return encodedString;
    }

    private byte[] decodeBase64BinaryToFile(String base64) {
        return Base64.getDecoder().decode(base64);
    }

}
