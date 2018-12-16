/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.util;

import es.equipoa.ssr.server.dao.Cliente;
import es.equipoa.ssr.server.util.impl.ControlServerImpl;
import javax.swing.JList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alcreta
 */
public class ControlServerImplTest {
    
    JList<String> clientes;
    JList<String> ficheros;
    ControlServerImpl cs;
    
    public ControlServerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         
         
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        clientes = new JList<>();
        ficheros = new JList<>();
        cs = new ControlServerImpl(clientes, ficheros);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void test(){
        Cliente c = new Cliente();
//        c.setId();
        cs.añadirCliente(c);
    }
}
