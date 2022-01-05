package UI;

//import Identidades.Render;
import DAO.VentaDAO;
import Identidades.Venta;
//import Identidades.VentaDetalle;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InformeVentasDelDia extends javax.swing.JDialog {
    ColoresDePantallas colores = new ColoresDePantallas();
    
    public InformeVentasDelDia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Ventas del día");
        InicializarPantalla();
        
    }
    
    private void InicializarPantalla(){
        //GrillaBase();
        GrillaUltimasVentas();
        Calendar c2 = new GregorianCalendar();
        dteChFechaABuscar.setCalendar(c2);
        //btnDetalles.setEnabled(false);
        lblBotonDetalles.setEnabled(false);
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTituloInformeDia);
        colores.ColorDeLabelDeLaPantalla(lblFechaABuscar);
        
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
        colores.ColorDeBotonLabelPantalla(lblBotonDetalles);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);

    }
    
    private void GrillaBase() {
        DefaultTableModel modelo = new DefaultTableModel();
        //modelo.addColumn("ID Venta");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Comprobante");
        modelo.addColumn("Monto de Venta");
        tblResultadosVentas.setModel(modelo);
    }
    
    private void GrillaUltimasVentas(){
        LinkedList<Venta> listaDeVentas = new LinkedList<>();
        VentaDAO vDAO = new VentaDAO();
        listaDeVentas = vDAO.UltimasVentasReducido();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Venta");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Comprobante");
        modelo.addColumn("Monto de Venta");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[3];// 

        for (Venta v : listaDeVentas) {
            datos[0] = v.getIdventas();
            datos[1] = v.getNrocomprobante();
            datos[2] = v.getMontototal();
            modelo.addRow(datos);
        }

        tblResultadosVentas.setModel(modelo);
        tblResultadosVentas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblResultadosVentas.getColumnModel().getColumn(0).setMinWidth(0);
        tblResultadosVentas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblResultadosVentas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    private void GrillaResultVentasVacia() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Venta");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Comprobante");
        modelo.addColumn("Monto de Venta");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[3];// 
        
        tblResultadosVentas.setModel(modelo);
        tblResultadosVentas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblResultadosVentas.getColumnModel().getColumn(0).setMinWidth(0);
        tblResultadosVentas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblResultadosVentas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

    }
        
//    private void CargarResultVentaGrid() {
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("ID Venta");  // Acá definimos las Columnas del Modelo
//        modelo.addColumn("Comprobante");
//        modelo.addColumn("Monto de Venta");
//        // Acá cargamos las FILAS del Modelo
//        Object[] datos = new Object[3];// 
//        
//        for (Venta v : listaDeVentas) {
////            JTextField txtCeldaCantEjemplares = new JTextField();
////            txtCeldaCantEjemplares.setText(Integer.toString(book.getCantidad()));
////            datos[7].setCellEditor(new DefaultCellEditor(txtCeldaCantEjemplares));
//            
//            datos[0] = v.getLibro().getIdlibro();
//            datos[1] = v.getLibro().getIsbn();
//            datos[2] = v.getLibro().getTitulo();
//            modelo.addRow(datos);
//            
////            JTextField txtCeldaCantEjemplares = new JTextField();
////            txtCeldaCantEjemplares.setEditable(true);
////            txtCeldaCantEjemplares.setText(Integer.toString(book.getCantidad()));
////            (tblLibrosVenta.getColumnModel().getColumn(2)).setCellEditor(new DefaultCellEditor(txtCeldaCantEjemplares));
//        }
//        
//        tblResultadosVentas.setModel(modelo);
//        
//        
//    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        lblTituloInformeDia = new javax.swing.JLabel();
        lblFechaABuscar = new javax.swing.JLabel();
        dteChFechaABuscar = new com.toedter.calendar.JDateChooser();
        lblBotonBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultadosVentas = new javax.swing.JTable();
        lblBotonDetalles = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 440));
        setMinimumSize(new java.awt.Dimension(700, 440));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoPP.setMaximumSize(new java.awt.Dimension(700, 440));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(700, 440));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(700, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(700, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(700, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N

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

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMaximumSize(new java.awt.Dimension(700, 400));
        pnlCont.setMinimumSize(new java.awt.Dimension(700, 400));
        pnlCont.setPreferredSize(new java.awt.Dimension(700, 400));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloInformeDia.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblTituloInformeDia.setText("Informe de ventas del día");
        pnlCont.add(lblTituloInformeDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        lblFechaABuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFechaABuscar.setText("Fecha a buscar");
        pnlCont.add(lblFechaABuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, 27));

        dteChFechaABuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pnlCont.add(dteChFechaABuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 187, 27));

        lblBotonBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/lupa.png"))); // NOI18N
        lblBotonBuscar.setText("Buscar");
        lblBotonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonBuscarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonBuscarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonBuscarMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 150, 50));

        tblResultadosVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblResultadosVentas.setRowHeight(20);
        tblResultadosVentas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblResultadosVentasFocusLost(evt);
            }
        });
        tblResultadosVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadosVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultadosVentas);

        pnlCont.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 610, 200));

        lblBotonDetalles.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonDetalles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/prueba.png"))); // NOI18N
        lblBotonDetalles.setText("Detalles");
        lblBotonDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonDetallesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonDetallesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonDetallesMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 160, 50));

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
        pnlCont.add(lblBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 160, 50));

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlFondoPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultadosVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosVentasMouseClicked
        //btnDetalles.setEnabled(true);
        lblBotonDetalles.setEnabled(true);
//        System.out.println("click");
    }//GEN-LAST:event_tblResultadosVentasMouseClicked

    private void tblResultadosVentasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblResultadosVentasFocusLost
//        btnDetalles.setEnabled(false);
//        System.out.println("Perdió el foco");
    }//GEN-LAST:event_tblResultadosVentasFocusLost

    private void lblBotonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseClicked
        //        if(!(((String)dteChFechaABuscar.getDate().toString()).isEmpty())){
            Date fecha = dteChFechaABuscar.getDate();
//            System.out.println("1_"+fecha);
            LinkedList<Venta> listaDeVentas = new LinkedList<>();
            VentaDAO vDAO = new VentaDAO();
            listaDeVentas = vDAO.VentasByDayReducido(fecha);
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Venta");  // Acá definimos las Columnas del Modelo
            modelo.addColumn("Comprobante");
            modelo.addColumn("Monto de Venta");
            // Acá cargamos las FILAS del Modelo
            Object[] datos = new Object[3];// 
            
            for (Venta v : listaDeVentas) {
                datos[0] = v.getIdventas();
                datos[1] = v.getNrocomprobante();
                datos[2] = v.getMontototal();
                modelo.addRow(datos);
            }

            tblResultadosVentas.setModel(modelo);
            tblResultadosVentas.getColumnModel().getColumn(0).setMaxWidth(0);
            tblResultadosVentas.getColumnModel().getColumn(0).setMinWidth(0);
            tblResultadosVentas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tblResultadosVentas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
//        }else{
//            JOptionPane.showConfirmDialog(null, "La fecha no puede estar vacia.");
//            dteChFechaABuscar.requestFocus();        
//        }
    }//GEN-LAST:event_lblBotonBuscarMouseClicked

    private void lblBotonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_lblBotonCancelarMouseClicked

    private void lblBotonDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonDetallesMouseClicked
        int idVentaSelec = 0;        
        try {
            idVentaSelec = (int) tblResultadosVentas.getValueAt(tblResultadosVentas.getSelectedRow(), 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo la venta a detallar. (Err:"+e+")");
        }
        System.out.println("id venta: "+idVentaSelec);
        VentaDAO vDAO = new VentaDAO();
        if(idVentaSelec > 0 && vDAO.ExisteLaVenta(idVentaSelec)){
            VentanaDetallesDeVenta detV = new VentanaDetallesDeVenta(null, true, idVentaSelec);
            detV.setLocationRelativeTo(null);
            detV.setVisible(true);
            System.out.println("entró");
        }else{
            JOptionPane.showMessageDialog(null, "Vuelva a seleccionar (solo) una fila y luego use el botón Detalles.");
        }
    }//GEN-LAST:event_lblBotonDetallesMouseClicked

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblBotonDetallesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonDetallesMouseEntered
        if(lblBotonDetalles.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonDetalles);
        }
    }//GEN-LAST:event_lblBotonDetallesMouseEntered

    private void lblBotonBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonBuscar);
    }//GEN-LAST:event_lblBotonBuscarMouseEntered

    private void lblBotonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseEntered

    private void lblBotonBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
    }//GEN-LAST:event_lblBotonBuscarMouseExited

    private void lblBotonDetallesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonDetallesMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonDetalles);
    }//GEN-LAST:event_lblBotonDetallesMouseExited

    private void lblBotonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseExited

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dteChFechaABuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonBuscar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblBotonDetalles;
    private javax.swing.JLabel lblFechaABuscar;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTituloInformeDia;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTable tblResultadosVentas;
    // End of variables declaration//GEN-END:variables
}
