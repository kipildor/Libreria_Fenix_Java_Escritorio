package UI;

public class Informes extends javax.swing.JDialog {
    
    ColoresDePantallas colores = new ColoresDePantallas();
        
    public Informes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarPantalla();
    }
    
    private void iniciarPantalla(){
        //ColoresDePantallas colores = new ColoresDePantallas();
    
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
                
        colores.ColorDeBotonLabelPantalla(lblBotonVentasDelDia);
        colores.ColorDeBotonLabelPantalla(lblBotonGananciasMensuales);
        colores.ColorDeBotonLabelPantalla(lblBotonLibrosMasVendidos);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        lblBotonVentasDelDia = new javax.swing.JLabel();
        lblBotonGananciasMensuales = new javax.swing.JLabel();
        lblBotonLibrosMasVendidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 340));
        setMinimumSize(new java.awt.Dimension(400, 340));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 340));

        pnlFondoPP.setMaximumSize(new java.awt.Dimension(400, 340));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(400, 340));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(400, 340));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(400, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(400, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(400, 40));
        pnlEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixRojo35Alto.png"))); // NOI18N
        pnlEncabezado.add(lblLogoEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 179, 40));

        lblXCerrar.setBackground(new java.awt.Color(255, 0, 0));
        lblXCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblXCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblXCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setText("X");
        lblXCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        pnlEncabezado.add(lblXCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Informes");
        pnlEncabezado.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 30));

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMaximumSize(new java.awt.Dimension(400, 300));
        pnlCont.setMinimumSize(new java.awt.Dimension(400, 300));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBotonVentasDelDia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonVentasDelDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonVentasDelDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/informe-venta.png"))); // NOI18N
        lblBotonVentasDelDia.setText("Ventas del Día");
        lblBotonVentasDelDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonVentasDelDiaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonVentasDelDiaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonVentasDelDiaMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonVentasDelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 290, 60));

        lblBotonGananciasMensuales.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonGananciasMensuales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonGananciasMensuales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/grafico-lineal.png"))); // NOI18N
        lblBotonGananciasMensuales.setText("Ganancias por Mes");
        lblBotonGananciasMensuales.setEnabled(false);
        lblBotonGananciasMensuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonGananciasMensualesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonGananciasMensualesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonGananciasMensualesMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonGananciasMensuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 290, 60));

        lblBotonLibrosMasVendidos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonLibrosMasVendidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonLibrosMasVendidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/grafico-circular.png"))); // NOI18N
        lblBotonLibrosMasVendidos.setText("Libros Más Vendidos");
        lblBotonLibrosMasVendidos.setEnabled(false);
        lblBotonLibrosMasVendidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonLibrosMasVendidosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonLibrosMasVendidosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonLibrosMasVendidosMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonLibrosMasVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 290, 60));

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBotonVentasDelDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonVentasDelDiaMouseClicked
        InformeVentasDelDia infVen = new InformeVentasDelDia(null, true);
        infVen.setLocationRelativeTo(null);
        infVen.setVisible(true);
    }//GEN-LAST:event_lblBotonVentasDelDiaMouseClicked

    private void lblBotonGananciasMensualesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGananciasMensualesMouseClicked
        
    }//GEN-LAST:event_lblBotonGananciasMensualesMouseClicked

    private void lblBotonLibrosMasVendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonLibrosMasVendidosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBotonLibrosMasVendidosMouseClicked

    private void lblBotonVentasDelDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonVentasDelDiaMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonVentasDelDia);
    }//GEN-LAST:event_lblBotonVentasDelDiaMouseEntered

    private void lblBotonGananciasMensualesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGananciasMensualesMouseEntered
        if(lblBotonGananciasMensuales.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonGananciasMensuales);
        }
    }//GEN-LAST:event_lblBotonGananciasMensualesMouseEntered

    private void lblBotonLibrosMasVendidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonLibrosMasVendidosMouseEntered
        if(lblBotonLibrosMasVendidos.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonLibrosMasVendidos);
        }
    }//GEN-LAST:event_lblBotonLibrosMasVendidosMouseEntered

    private void lblBotonVentasDelDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonVentasDelDiaMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonVentasDelDia);
    }//GEN-LAST:event_lblBotonVentasDelDiaMouseExited

    private void lblBotonGananciasMensualesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGananciasMensualesMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonGananciasMensuales);
    }//GEN-LAST:event_lblBotonGananciasMensualesMouseExited

    private void lblBotonLibrosMasVendidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonLibrosMasVendidosMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonLibrosMasVendidos);
    }//GEN-LAST:event_lblBotonLibrosMasVendidosMouseExited

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBotonGananciasMensuales;
    private javax.swing.JLabel lblBotonLibrosMasVendidos;
    private javax.swing.JLabel lblBotonVentasDelDia;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    // End of variables declaration//GEN-END:variables
}
