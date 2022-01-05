package UI;

import javax.swing.JOptionPane;

public class ModificarCantUnidadesVentaUI extends javax.swing.JDialog {
    int newCantidad = 1;
    boolean todoOK = false;
    ColoresDePantallas colores = new ColoresDePantallas();

    public ModificarCantUnidadesVentaUI(java.awt.Frame parent, boolean modal, int cantActual) {
        super(parent, modal);
        initComponents();
        setTitle("Modificar cantidad");
        txtCantidad.setText(Integer.toString(cantActual));
        iniciarPantalla();
    }
    
    private void iniciarPantalla(){
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblCantidad);
        
        colores.ColorDeBotonLabelPantalla(lblBotonAceptar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblBotonAceptar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlFondoPP.setMaximumSize(new java.awt.Dimension(410, 220));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(410, 220));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(410, 220));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(410, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(410, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(410, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixRojo35Alto.png"))); // NOI18N

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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
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

        pnlCont.setMaximumSize(new java.awt.Dimension(410, 180));
        pnlCont.setPreferredSize(new java.awt.Dimension(410, 180));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Número de unidades");
        pnlCont.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 12, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCantidad.setText("Nueva cantidad");
        pnlCont.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 76, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pnlCont.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 74, 163, -1));

        lblBotonAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/check-tilde.png"))); // NOI18N
        lblBotonAceptar.setText("Aceptar");
        lblBotonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonAceptarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonAceptarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonAceptarMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 150, 40));

        lblBotonCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/x-cancelar.png"))); // NOI18N
        lblBotonCancelar.setText("Cancelar");
        lblBotonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonCancelarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonCancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonCancelarMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 150, 40));

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblBotonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAceptarMouseClicked
        try {
            newCantidad = Integer.parseInt(txtCantidad.getText());
//            VentaPantallaPrincipalV2UI.
            //super.nu
            todoOK = true;
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error con la nueva cantidad. (Err:"+e+")");
            txtCantidad.requestFocus();
            txtCantidad.selectAll();
        }
    }//GEN-LAST:event_lblBotonAceptarMouseClicked

    private void lblBotonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_lblBotonCancelarMouseClicked

    private void lblBotonAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAceptarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonAceptar);
    }//GEN-LAST:event_lblBotonAceptarMouseEntered

    private void lblBotonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseEntered

    private void lblBotonAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAceptarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonAceptar);
    }//GEN-LAST:event_lblBotonAceptarMouseExited

    private void lblBotonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBotonAceptar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
