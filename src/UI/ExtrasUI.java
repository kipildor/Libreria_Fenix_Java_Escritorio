package UI;

import Identidades.ImagenFondo;
import java.awt.Container;

public class ExtrasUI extends javax.swing.JDialog {
//    ImagenFondo p = new ImagenFondo();
    
    public ExtrasUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
//        Container contenedor = getContentPane();//¿Puede ir en este archivos??? 
//        p.setRuta("/Images/nubeDePalabras1.png");
//        this.setContentPane(p);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCont = new javax.swing.JPanel();
        lblTituloExtras = new javax.swing.JLabel();
        btnTemas = new javax.swing.JButton();
        btnTipoDocumentos = new javax.swing.JButton();
        btnLocalidades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCont.setBackground(new java.awt.Color(153, 153, 255));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloExtras.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloExtras.setText("Administración de Elementos Extra");
        pnlCont.add(lblTituloExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 38, -1, -1));

        btnTemas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTemas.setText("Temas/Géneros literarios");
        btnTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemasActionPerformed(evt);
            }
        });
        pnlCont.add(btnTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 103, 290, 65));

        btnTipoDocumentos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTipoDocumentos.setText("Tipos de Documentos");
        btnTipoDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoDocumentosActionPerformed(evt);
            }
        });
        pnlCont.add(btnTipoDocumentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 288, 65));

        btnLocalidades.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLocalidades.setText("Localidades");
        btnLocalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalidadesActionPerformed(evt);
            }
        });
        pnlCont.add(btnLocalidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 288, 65));

        getContentPane().add(pnlCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTipoDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoDocumentosActionPerformed
        AdminTipoDocumentoUI panelTipoDoc = new AdminTipoDocumentoUI(null, true);
        panelTipoDoc.setLocationRelativeTo(null);
        panelTipoDoc.setVisible(true);
    }//GEN-LAST:event_btnTipoDocumentosActionPerformed

    private void btnTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemasActionPerformed
        AdminGenerosLiterariosUI panelTemas = new AdminGenerosLiterariosUI(null, true);
        panelTemas.setLocationRelativeTo(null);
        panelTemas.setVisible(true);
    }//GEN-LAST:event_btnTemasActionPerformed

    private void btnLocalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalidadesActionPerformed
        AdminLocalidadesUI panelLocalidades = new AdminLocalidadesUI(null, true);
        panelLocalidades.setLocationRelativeTo(null);
        panelLocalidades.setVisible(true);
    }//GEN-LAST:event_btnLocalidadesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocalidades;
    private javax.swing.JButton btnTemas;
    private javax.swing.JButton btnTipoDocumentos;
    private javax.swing.JLabel lblTituloExtras;
    private javax.swing.JPanel pnlCont;
    // End of variables declaration//GEN-END:variables
}
