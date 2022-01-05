package UI;

import Identidades.ImagenFondo;
import java.awt.Container;

public class ExtrasUI extends javax.swing.JDialog {
//    ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();
    
    public ExtrasUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        InicializarPantalla();
//        Container contenedor = getContentPane();//¿Puede ir en este archivos??? 
//        p.setRuta("/Images/nubeDePalabras1.png");
//        this.setContentPane(p);
    }
    
    private void InicializarPantalla(){
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTituloExtras);
                
        colores.ColorDeBotonLabelPantalla(lblBotonTemas);
        colores.ColorDeBotonLabelPantalla(lblBotonTiposDeDocumentos);
        colores.ColorDeBotonLabelPantalla(lblBotonLocalidades);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        lblTituloExtras = new javax.swing.JLabel();
        lblBotonTemas = new javax.swing.JLabel();
        lblBotonTiposDeDocumentos = new javax.swing.JLabel();
        lblBotonLocalidades = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(200, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(200, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(200, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N

        lblXCerrar.setBackground(new java.awt.Color(255, 0, 0));
        lblXCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblXCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblXCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setText("X");
        lblXCerrar.setMaximumSize(new java.awt.Dimension(40, 40));
        lblXCerrar.setMinimumSize(new java.awt.Dimension(40, 40));
        lblXCerrar.setOpaque(true);
        lblXCerrar.setPreferredSize(new java.awt.Dimension(40, 40));
        lblXCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXCerrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblXCerrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblXCerrarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setBackground(new java.awt.Color(153, 153, 255));

        lblTituloExtras.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloExtras.setText("Administración de Elementos Extra");

        lblBotonTemas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonTemas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonTemas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/libros-apilados.png"))); // NOI18N
        lblBotonTemas.setText("Temas/Géneros literarios");
        lblBotonTemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonTemasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonTemasMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonTemasMouseEntered(evt);
            }
        });

        lblBotonTiposDeDocumentos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonTiposDeDocumentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonTiposDeDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/credencial-1.png"))); // NOI18N
        lblBotonTiposDeDocumentos.setText("Tipos de Documentos");
        lblBotonTiposDeDocumentos.setMaximumSize(new java.awt.Dimension(292, 30));
        lblBotonTiposDeDocumentos.setMinimumSize(new java.awt.Dimension(292, 30));
        lblBotonTiposDeDocumentos.setPreferredSize(new java.awt.Dimension(292, 30));
        lblBotonTiposDeDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonTiposDeDocumentosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonTiposDeDocumentosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonTiposDeDocumentosMouseEntered(evt);
            }
        });

        lblBotonLocalidades.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonLocalidades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonLocalidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/ciudad-solida.png"))); // NOI18N
        lblBotonLocalidades.setText("Localidades");
        lblBotonLocalidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonLocalidadesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonLocalidadesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonLocalidadesMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblTituloExtras)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBotonLocalidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBotonTemas, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addComponent(lblBotonTiposDeDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(158, 158, 158))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTituloExtras)
                .addGap(52, 52, 52)
                .addComponent(lblBotonTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblBotonTiposDeDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblBotonLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlFondoPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBotonTemasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonTemasMouseClicked
        AdminGenerosLiterariosUI panelTemas = new AdminGenerosLiterariosUI(null, true);
        panelTemas.setLocationRelativeTo(null);
        panelTemas.setVisible(true);
    }//GEN-LAST:event_lblBotonTemasMouseClicked

    private void lblBotonTiposDeDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonTiposDeDocumentosMouseClicked
        AdminTipoDocumentoUI panelTipoDoc = new AdminTipoDocumentoUI(null, true);
        panelTipoDoc.setLocationRelativeTo(null);
        panelTipoDoc.setVisible(true);
    }//GEN-LAST:event_lblBotonTiposDeDocumentosMouseClicked

    private void lblBotonLocalidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonLocalidadesMouseClicked
        AdminLocalidadesUI panelLocalidades = new AdminLocalidadesUI(null, true);
        panelLocalidades.setLocationRelativeTo(null);
        panelLocalidades.setVisible(true);
    }//GEN-LAST:event_lblBotonLocalidadesMouseClicked

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblBotonTemasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonTemasMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonTemas);
    }//GEN-LAST:event_lblBotonTemasMouseEntered

    private void lblBotonTiposDeDocumentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonTiposDeDocumentosMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonTiposDeDocumentos);
    }//GEN-LAST:event_lblBotonTiposDeDocumentosMouseEntered

    private void lblBotonLocalidadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonLocalidadesMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonLocalidades);
    }//GEN-LAST:event_lblBotonLocalidadesMouseEntered

    private void lblBotonTemasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonTemasMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonTemas);
    }//GEN-LAST:event_lblBotonTemasMouseExited

    private void lblBotonTiposDeDocumentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonTiposDeDocumentosMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonTiposDeDocumentos);
    }//GEN-LAST:event_lblBotonTiposDeDocumentosMouseExited

    private void lblBotonLocalidadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonLocalidadesMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonLocalidades);
    }//GEN-LAST:event_lblBotonLocalidadesMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBotonLocalidades;
    private javax.swing.JLabel lblBotonTemas;
    private javax.swing.JLabel lblBotonTiposDeDocumentos;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTituloExtras;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    // End of variables declaration//GEN-END:variables
}
