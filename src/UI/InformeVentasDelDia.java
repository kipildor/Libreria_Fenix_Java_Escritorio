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

    public InformeVentasDelDia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Ventas del día");
        InicializarPantalla();
    }
    
    private void InicializarPantalla(){
        GrillaBase();
        Calendar c2 = new GregorianCalendar();
        dteChFechaABuscar.setCalendar(c2);
        btnDetalles.setEnabled(false);
    }
    
    private void GrillaBase() {
        DefaultTableModel modelo = new DefaultTableModel();
        //modelo.addColumn("ID Venta");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Comprobante");
        modelo.addColumn("Monto de Venta");
        tblResultadosVentas.setModel(modelo);
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

        pnlCont = new javax.swing.JPanel();
        lblTituloInformeDia = new javax.swing.JLabel();
        lblFechaABuscar = new javax.swing.JLabel();
        dteChFechaABuscar = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultadosVentas = new javax.swing.JTable();
        btnDetalles = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloInformeDia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloInformeDia.setText("Informe de ventas del día");

        lblFechaABuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFechaABuscar.setText("Fecha a buscar");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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

        btnDetalles.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDetalles.setText("Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblFechaABuscar)
                        .addGap(18, 18, 18)
                        .addComponent(dteChFechaABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnBuscar))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(lblTituloInformeDia))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btnDetalles)
                        .addGap(60, 60, 60)
                        .addComponent(btnCancelar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloInformeDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dteChFechaABuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(lblFechaABuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalles)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
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
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblResultadosVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosVentasMouseClicked
        btnDetalles.setEnabled(true);
//        System.out.println("click");
    }//GEN-LAST:event_tblResultadosVentasMouseClicked

    private void tblResultadosVentasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblResultadosVentasFocusLost
//        btnDetalles.setEnabled(false);
//        System.out.println("Perdió el foco");
    }//GEN-LAST:event_tblResultadosVentasFocusLost

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
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
    }//GEN-LAST:event_btnDetallesActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDetalles;
    private com.toedter.calendar.JDateChooser dteChFechaABuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechaABuscar;
    private javax.swing.JLabel lblTituloInformeDia;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JTable tblResultadosVentas;
    // End of variables declaration//GEN-END:variables
}
