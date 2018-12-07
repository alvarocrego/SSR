/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.equipoa.ssr.server.gui;

import es.equipoa.ssr.server.dao.Cliente;
import es.equipoa.ssr.server.dao.Comunication;
import es.equipoa.ssr.server.dao.Fichero;
import es.equipoa.ssr.server.util.impl.ControlServerImpl;
import es.equipoa.ssr.server.util.impl.ServerConnectionImpl;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcreta
 */
public class Application extends javax.swing.JFrame {

    /**
     * Creates new form Application
     */
    public Application() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        informacionPanel = new javax.swing.JPanel();
        ipLabel1 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        ficherosPanel = new javax.swing.JPanel();
        totalFicherosLabel = new javax.swing.JLabel();
        ficherosField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ficherosList = new javax.swing.JList<>();
        clientesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesList = new javax.swing.JList<>();
        totalClientesLabel = new javax.swing.JLabel();
        totalClientesField = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Servidor");

        informacionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Información"));

        ipLabel1.setText("IP:");

        ipField.setText("localhost");
        ipField.setEnabled(false);
        ipField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipFieldActionPerformed(evt);
            }
        });

        portLabel.setText("Port:");

        portField.setText("8182");

        javax.swing.GroupLayout informacionPanelLayout = new javax.swing.GroupLayout(informacionPanel);
        informacionPanel.setLayout(informacionPanelLayout);
        informacionPanelLayout.setHorizontalGroup(
            informacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ipLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        informacionPanelLayout.setVerticalGroup(
            informacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(informacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel1)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLabel)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        ficherosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ficheros Compartidos:"));
        ficherosPanel.setPreferredSize(new java.awt.Dimension(254, 328));

        totalFicherosLabel.setText("Total ficheros:");

        ficherosField.setText("0");

        jScrollPane2.setViewportView(ficherosList);

        javax.swing.GroupLayout ficherosPanelLayout = new javax.swing.GroupLayout(ficherosPanel);
        ficherosPanel.setLayout(ficherosPanelLayout);
        ficherosPanelLayout.setHorizontalGroup(
            ficherosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ficherosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ficherosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(ficherosPanelLayout.createSequentialGroup()
                        .addComponent(totalFicherosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ficherosField, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ficherosPanelLayout.setVerticalGroup(
            ficherosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ficherosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ficherosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalFicherosLabel)
                    .addComponent(ficherosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        clientesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jScrollPane1.setViewportView(clientesList);

        totalClientesLabel.setText("Clientes Conectados:");

        totalClientesField.setText("0");
        totalClientesField.setEnabled(false);

        javax.swing.GroupLayout clientesPanelLayout = new javax.swing.GroupLayout(clientesPanel);
        clientesPanel.setLayout(clientesPanelLayout);
        clientesPanelLayout.setHorizontalGroup(
            clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(clientesPanelLayout.createSequentialGroup()
                        .addComponent(totalClientesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalClientesField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        clientesPanelLayout.setVerticalGroup(
            clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalClientesLabel)
                    .addComponent(totalClientesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        startButton.setText("Iniciar Servidor");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(informacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ficherosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(informacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(startButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ficherosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipFieldActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        startButton.setEnabled(false);
        startButton.setText("Iniciado");
        int puerto = Integer.parseInt(portField.getText());
        ControlServerImpl cs = new ControlServerImpl(clientesList, ficherosList);
        ServerConnectionImpl sc = new ServerConnectionImpl(puerto);
        cs.start();
        System.out.println("arrancado");
        Thread t1 = new Thread(() -> {
            AtomicInteger a = new AtomicInteger(0);
            while (true) {
                a.incrementAndGet();
                System.out.println("esperando conexion");
                Socket cliSo = sc.esperarConexion();

                Cliente c = new Cliente();
                c.setId(cliSo.getRemoteSocketAddress().hashCode());
                c.setSocket(cliSo);

                cs.añadirCliente(c);
                Thread t2 = new Thread(() -> {
                    Socket aux = cliSo;
                    Cliente cliAux = c;
                    int auxa = a.get();
                    while (true) {
                        try {
                            System.out.println("Cliente: " + auxa);
                            Comunication comu = sc.recibir(aux);
                            switch (comu.getTypeMessage()) {
                                case 0: //Ping
                                    
                                    break;
                                case 1: //Actualizar ficheros compartidos
                                    cs.actualizarFicheros(comu.getList(), cliAux);
                                    System.err.println("se ha actualizado el fichero");
                                    break;
                                case 2: //Busqueda de ficheros
                                    List<Fichero> res = cs.buscarFicheros(aux, comu.getMessage());
                                    break;
                                case 3: //Peticion de fichero (conxion con el otro cliente)
                                    cs.enviarPeticionFichero(comu.getMessage());
                                    break;
                                case 4: //Enviar al cliente solicitante la ip y puerto
                                    cs.enviarSolicitanteIpPuerto();
                                    break;
                                default:
                                    
                                    break;
                            }
                            //Thread.sleep(1000);
//                        sc.recibir(aux);
                        } catch (Exception ex) {
                            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                t2.start();
                System.out.println("aceptado conexion");
            }
        });

        t1.start();


    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> clientesList;
    private javax.swing.JPanel clientesPanel;
    private javax.swing.JTextField ficherosField;
    private javax.swing.JList<String> ficherosList;
    private javax.swing.JPanel ficherosPanel;
    private javax.swing.JPanel informacionPanel;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel ipLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField totalClientesField;
    private javax.swing.JLabel totalClientesLabel;
    private javax.swing.JLabel totalFicherosLabel;
    // End of variables declaration//GEN-END:variables
}
