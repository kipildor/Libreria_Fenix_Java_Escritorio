package UI;

import DAO.ManejarFecha;
import DAO.VentaDAO;
import DAO.VentaDetalleDAO;
import Identidades.Venta;
import Identidades.VentaDetalle;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class VentanaDetallesDeVenta extends javax.swing.JDialog {
    int idV = 0;
    LinkedList<VentaDetalle> listaVD = new LinkedList<>();
    Venta v = new Venta();
    VentaDetalleDAO vdDAO = new VentaDetalleDAO();
    VentaDAO vDAO = new VentaDAO();
    
    public VentanaDetallesDeVenta(java.awt.Frame parent, boolean modal, int idVenta) {
        super(parent, modal);
        initComponents();
        setTitle("Detalles de venta");
        idV = idVenta;
        InicializarPantalla();
    }
    
    private void InicializarPantalla(){
        v = vDAO.VentaByID(idV);
        CargarCabecera();
        CargarCliente();
        
        listaVD = vdDAO.GetVentaDetalleReducidoByIDVenta(idV);
        
//        primerFila = listaVD.getFirst();
        GrillaItems();
        lblMontoTotal.setText("Total $ " + CalcularMontoTotal());
    }
    
    private void CargarCabecera(){
        long comp = v.getNrocomprobante();
        String comprobanteConvertido = vDAO.CadenaComprobante(comp);
        lblComprobante.setText("Comprobante n° "+comprobanteConvertido);
        
        Date fechaBDD = v.getFecha();
        ManejarFecha manejFech = new ManejarFecha();
        //0fechaBDD = manejFech.formatearFechaAddMMyyyy(fechaBDD);
        lblFecha.setText("Fecha "+manejFech.formatearFechaAddMMyyyy(fechaBDD));
    }
    
    private void CargarCliente(){
        lblRazonSocial.setText("Razón Social: " + v.getCliente().getRazonsocial());
        String cadDoc = v.getCliente().getTipodocumento().getDescripcion();
        cadDoc += " " + v.getCliente().getNrodocumento();
        lblDocumento.setText("Documento: "+cadDoc);
    }
    
    private void GrillaItems(){
        DefaultTableModel modelo = new DefaultTableModel();
        //modelo.addColumn("ID Venta");  // Acá definimos las Columnas del Modelo
        //modelo.addColumn("ID Venta");
        modelo.addColumn("Título");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        //modelo.addColumn("Monto de Venta");
        Object[] datos = new Object[3];// 
            
        for (VentaDetalle vd : listaVD) {
            datos[0] = vd.getLibro().getTitulo();
            datos[1] = vd.getCantidad();
            datos[2] = vd.getPreciovta();
            //System.out.println(datos[0]);
            modelo.addRow(datos);
        }
        tblDetalleItems.setModel(modelo);
        
        //lblMontoTotal.setText("Total $ "+ CalcularMontoTotal());
    }

    private double CalcularMontoTotal(){
        double mt = 0;
        for(int t = 0; t < tblDetalleItems.getRowCount(); t++){
            int cant = (int)(tblDetalleItems.getValueAt(t, 1));
            //System.out.println(cant);
            double preUnit = (double)(tblDetalleItems.getValueAt(t, 2));
            mt += (cant * preUnit);
        }
        //System.out.println(mt);
        return mt;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCont = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogo1 = new javax.swing.JLabel();
        lblComprobante = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        pnlCliente = new javax.swing.JPanel();
        lblRazonSocial = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        pnlContTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleItems = new javax.swing.JTable();
        pnlMontoTotal = new javax.swing.JPanel();
        lblMontoTotal = new javax.swing.JLabel();
        pnlPieDePagina = new javax.swing.JPanel();
        lblLogoPie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCont.setBackground(new java.awt.Color(0, 102, 0));
        pnlCont.setAutoscrolls(true);

        pnlEncabezado.setBackground(new java.awt.Color(153, 255, 153));
        pnlEncabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));
        pnlEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoTextoAbajo_FondoVerde1_mediano.jpg"))); // NOI18N
        pnlEncabezado.add(lblLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblComprobante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblComprobante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComprobante.setText("Comprobante n°");
        pnlEncabezado.add(lblComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 500, 20));

        lblFecha.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");
        pnlEncabezado.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 70, 370, -1));

        pnlCliente.setBackground(new java.awt.Color(153, 255, 153));
        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null), "Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        pnlCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pnlCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRazonSocial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblRazonSocial.setText("Razón Social: ");
        pnlCliente.add(lblRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 730, -1));

        lblDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDocumento.setText("Documento:");
        pnlCliente.add(lblDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 730, -1));

        pnlContTabla.setBackground(new java.awt.Color(153, 255, 153));
        pnlContTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDetalleItems.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetalleItems.setRowHeight(20);
        jScrollPane1.setViewportView(tblDetalleItems);

        pnlContTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 736, 114));

        pnlMontoTotal.setBackground(new java.awt.Color(153, 255, 153));

        lblMontoTotal.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        lblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoTotal.setText("Total $ ");

        javax.swing.GroupLayout pnlMontoTotalLayout = new javax.swing.GroupLayout(pnlMontoTotal);
        pnlMontoTotal.setLayout(pnlMontoTotalLayout);
        pnlMontoTotalLayout.setHorizontalGroup(
            pnlMontoTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMontoTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        pnlMontoTotalLayout.setVerticalGroup(
            pnlMontoTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMontoTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMontoTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPieDePagina.setBackground(new java.awt.Color(0, 0, 0));

        lblLogoPie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoTextoAbajo_FondoTransparente_chico.png"))); // NOI18N

        javax.swing.GroupLayout pnlPieDePaginaLayout = new javax.swing.GroupLayout(pnlPieDePagina);
        pnlPieDePagina.setLayout(pnlPieDePaginaLayout);
        pnlPieDePaginaLayout.setHorizontalGroup(
            pnlPieDePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieDePaginaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoPie)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPieDePaginaLayout.setVerticalGroup(
            pnlPieDePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieDePaginaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoPie, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPieDePagina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPieDePagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblComprobante;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogoPie;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlContTabla;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlMontoTotal;
    private javax.swing.JPanel pnlPieDePagina;
    private javax.swing.JTable tblDetalleItems;
    // End of variables declaration//GEN-END:variables
}
