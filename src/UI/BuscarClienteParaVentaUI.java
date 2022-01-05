package UI;

import DAO.ClienteDAO;
import Identidades.Cliente;
import Identidades.ClienteConDirecc;
import Identidades.TipoDocumento;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarClienteParaVentaUI extends javax.swing.JDialog {
    //private VentaPantallaPrincipalUI ventanaVenta;
    //public int num = 28;
    private final int POR_NOMBRE = 1;
    private final int POR_DOCUMENTO = 2;
    int metodoBusq;
    
    //private Cliente c = new Cliente();
    Cliente cli = new Cliente();
    
    ColoresDePantallas colores = new ColoresDePantallas();
    
    public BuscarClienteParaVentaUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Buscar Cliente");
        initComponents();
        inicializarPantalla();
        cli.setIdcliente(0);
    }
    /*
    public BuscarClienteParaVentaUI(java.awt.Frame parent, boolean modal, String cad) {
        super(parent, modal);
        setTitle("Buscar Cliente");
        initComponents();
        cad = "modif";
    }
    */
    private void inicializarPantalla(){
        rbtnPorDocumento.setSelected(true);
        
        GrillaVacia();
        lblBotonAceptar.setEnabled(false);
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.BordeDePanel2(pnlFondoPP);
        colores.ColorDeCuerpoDeLaPantalla(pnlBuscarPor);
        
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(rbtnPorDocumento);
        colores.ColorDeLabelDeLaPantalla(rbtnPorNombre);
        
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
        colores.ColorDeBotonLabelPantalla(lblBotonAceptar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }
    
//    private boolean campoDNILleno(){
//        boolean lleno = true;
//        if(txtBuscarPor.getText().isEmpty()){
//            lleno = false;
//        }
//        return lleno;
//    }
    
    private void GrillaVacia(){
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Id Cliente");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Razón Social");
        modelo.addColumn("E-mail");
        modelo.addColumn("Borrado");
        modelo.addColumn("ID Tipo Doc");
        modelo.addColumn("Tipo de Documento");
        modelo.addColumn("N° de documento");
        // Acá cargamos las FILAS del Modelo
//        Object[] datos = new Object[7];

        tblMostrarClientes.setModel(modelo);

        tblMostrarClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(2).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(2).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(3).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(3).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(4).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(4).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(5).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(5).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlBuscarPor = new javax.swing.JPanel();
        rbtnPorDocumento = new javax.swing.JRadioButton();
        rbtnPorNombre = new javax.swing.JRadioButton();
        txtBuscarPor = new javax.swing.JTextField();
        lblBotonBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarClientes = new javax.swing.JTable();
        lblBotonAceptar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMinimumSize(new java.awt.Dimension(660, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(660, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixRojo35Alto.png"))); // NOI18N

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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMinimumSize(new java.awt.Dimension(660, 440));
        pnlCont.setPreferredSize(new java.awt.Dimension(660, 440));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Buscar Cliente");
        pnlCont.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        pnlBuscarPor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlBuscarPor.setMaximumSize(new java.awt.Dimension(590, 150));
        pnlBuscarPor.setMinimumSize(new java.awt.Dimension(590, 150));
        pnlBuscarPor.setName(""); // NOI18N

        buttonGroup1.add(rbtnPorDocumento);
        rbtnPorDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnPorDocumento.setText("N° de Documento");

        buttonGroup1.add(rbtnPorNombre);
        rbtnPorNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnPorNombre.setText("Nombre");

        txtBuscarPor.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblBotonBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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

        javax.swing.GroupLayout pnlBuscarPorLayout = new javax.swing.GroupLayout(pnlBuscarPor);
        pnlBuscarPor.setLayout(pnlBuscarPorLayout);
        pnlBuscarPorLayout.setHorizontalGroup(
            pnlBuscarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarPorLayout.createSequentialGroup()
                .addGroup(pnlBuscarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarPorLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(rbtnPorDocumento)
                        .addGap(59, 59, 59)
                        .addComponent(rbtnPorNombre))
                    .addGroup(pnlBuscarPorLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(txtBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBuscarPorLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(lblBotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );
        pnlBuscarPorLayout.setVerticalGroup(
            pnlBuscarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarPorLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(pnlBuscarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnPorDocumento)
                    .addComponent(rbtnPorNombre))
                .addGap(8, 8, 8)
                .addComponent(txtBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCont.add(pnlBuscarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 66, -1, 150));

        tblMostrarClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMostrarClientes.setRowHeight(20);
        tblMostrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMostrarClientes);

        pnlCont.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 590, 140));

        lblBotonAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/check-tilde.png"))); // NOI18N
        lblBotonAceptar.setText("Aceptar");
        lblBotonAceptar.setOpaque(true);
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
        pnlCont.add(lblBotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 140, 40));

        lblBotonCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/x-cancelar.png"))); // NOI18N
        lblBotonCancelar.setText("Cancelar");
        lblBotonCancelar.setOpaque(true);
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
        pnlCont.add(lblBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 140, 40));

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlFondoPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBotonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseClicked
        if(lblBotonBuscar.isEnabled()){
            ClienteDAO cliDAO = new ClienteDAO();
            if(rbtnPorNombre.isSelected()){
                metodoBusq = POR_NOMBRE;
            }else{
                if(rbtnPorDocumento.isSelected()){
                    metodoBusq = POR_DOCUMENTO;
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error entendiendo si debe buscarse por nombre o por documento.");
                    return;
                }            
            }

            //lblBotonDetalles.setEnabled(false);
            LinkedList<Cliente> listaCliente = new LinkedList<>();
            switch(metodoBusq){
                case POR_NOMBRE:
                    String nombreCli = txtBuscarPor.getText();
                    listaCliente = cliDAO.GetClientesPorNombre(nombreCli);
                    break;
                case POR_DOCUMENTO:
                    long num_doc = Long.parseLong(txtBuscarPor.getText());
                    listaCliente = cliDAO.GetClientesPorDocumento(num_doc);
                    break;
            }

            //LinkedList<ClienteConDirecc> listaCliente = cliDAO.GetAllClientesConDirecc();//************ CAMBIARRR******
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Id Cliente");  // Acá definimos las Columnas del Modelo
            modelo.addColumn("Razón Social");
            modelo.addColumn("E-mail");
            modelo.addColumn("Borrado");
            modelo.addColumn("ID Tipo Doc");
            modelo.addColumn("Tipo de Documento");
            modelo.addColumn("N° de documento");
            // Acá cargamos las FILAS del Modelo
            Object[] datos = new Object[7];//   |  ID  |  Nombre  | Contraseña  |

            for (Cliente c : listaCliente) {
                datos[0] = c.getIdcliente();
                datos[1] = c.getRazonsocial();
                datos[2] = c.getEmail();
                datos[3] = c.isBorrado();
                datos[4] = c.getTipodocumento().getIdtipodocumento();
                datos[5] = c.getTipodocumento().getDescripcion();
                datos[6] = c.getNrodocumento();
                modelo.addRow(datos);
            }

            tblMostrarClientes.setModel(modelo);

            tblMostrarClientes.getColumnModel().getColumn(0).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(0).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(2).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(2).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(3).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(3).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(4).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(4).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(5).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(5).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        }
    }//GEN-LAST:event_lblBotonBuscarMouseClicked

    private void lblBotonBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
    }//GEN-LAST:event_lblBotonBuscarMouseExited

    private void lblBotonBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseEntered
        if(lblBotonBuscar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonBuscar);
        }
    }//GEN-LAST:event_lblBotonBuscarMouseEntered

    private void tblMostrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarClientesMouseClicked
        if( ((int)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 0))) > 0) {
            lblBotonAceptar.setEnabled(true);
        }else{
            lblBotonAceptar.setEnabled(false);
        }
    }//GEN-LAST:event_tblMostrarClientesMouseClicked

    private void lblBotonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAceptarMouseClicked
        if( ((int)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 0))) > 0) {
            cli.setIdcliente((int)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 0)));
            
            int idTipoDoc = (int)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 4));
            String descripcionTipoDoc = (String)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 5));
            TipoDocumento t = new TipoDocumento(idTipoDoc, descripcionTipoDoc);
            cli.setTipodocumento(t);
            cli.setNrodocumento((long)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 6)));
            cli.setRazonsocial((String)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 1)));
            cli.setEmail((String)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 2)));
            cli.setBorrado((boolean)(tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 3)));
//            VentaPantallaPrincipalUI.setC(cli);
//            VentaPantallaPrincipalUI.
            dispose();
        }else{
            lblBotonAceptar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Debe elegir un cliente de la lista.");
        }
    }//GEN-LAST:event_lblBotonAceptarMouseClicked

    private void lblBotonAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAceptarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonAceptar);
    }//GEN-LAST:event_lblBotonAceptarMouseExited

    private void lblBotonAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAceptarMouseEntered
        if(lblBotonAceptar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonAceptar);
        }
    }//GEN-LAST:event_lblBotonAceptarMouseEntered

    private void lblBotonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_lblBotonCancelarMouseClicked

    private void lblBotonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseExited

    private void lblBotonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseEntered

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonAceptar;
    private javax.swing.JLabel lblBotonBuscar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlBuscarPor;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JRadioButton rbtnPorDocumento;
    private javax.swing.JRadioButton rbtnPorNombre;
    private javax.swing.JTable tblMostrarClientes;
    private javax.swing.JTextField txtBuscarPor;
    // End of variables declaration//GEN-END:variables
}
