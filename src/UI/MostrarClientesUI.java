package UI;

import DAO.ClienteDAO;
import Identidades.ClienteConDirecc;
import Identidades.Direccion;
import Identidades.ImagenFondo;
import Identidades.Localidad;
import Identidades.Provincia;
import Identidades.TipoDocumento;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class MostrarClientesUI extends javax.swing.JDialog {
    private final int POR_NOMBRE = 1;
    private final int POR_DOCUMENTO = 2;
    int metodoBusq;
//    ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();

    public MostrarClientesUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        setTitle("Clientes");
        
        iniciarPantalla();
        inicializarCajas();
        //InitClientesGrid();
        GrillaVacia();
        
//        Container contenedor = getContentPane();
//        p.setRuta("/Images/personas-leyendo-1.jpg");
        
    }
    
    private void iniciarPantalla(){
        txtNombreCliente.setText("");
        txtDocumentoCliente.setText("");
        rbtnNombre.setSelected(true);
        txtNombreCliente.requestFocus();
        lblBotonDetalles.setEnabled(false);
        
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(rbtnNombre);
        colores.ColorDeLabelDeLaPantalla(rbtnDocumento);
        
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
        colores.ColorDeBotonLabelPantalla(lblBotonDetalles);
        colores.ColorDeBotonLabelPantalla(lblBotonCrearCliente);
        colores.ColorDeBotonLabelPantalla(lblBotonSalir);
    }

    private void inicializarCajas() {        
        TextPrompt txtPorNombre = new TextPrompt("Ingrese el nombre del Cliente", txtNombreCliente);
        txtPorNombre.setForeground(Color.GRAY);
        txtPorNombre.changeAlpha(0.5f);
        txtPorNombre.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtPorDNI = new TextPrompt("Ingrese el Documento del Cliente", txtDocumentoCliente);
        txtPorDNI.setForeground(Color.GRAY);
        txtPorDNI.changeAlpha(0.5f);
        txtPorDNI.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        rbtnNombre = new javax.swing.JRadioButton();
        rbtnDocumento = new javax.swing.JRadioButton();
        txtNombreCliente = new javax.swing.JTextField();
        txtDocumentoCliente = new javax.swing.JTextField();
        lblBotonBuscar = new javax.swing.JLabel();
        lblBotonDetalles = new javax.swing.JLabel();
        lblBotonCrearCliente = new javax.swing.JLabel();
        lblBotonSalir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        pnlFondoPP.setMaximumSize(new java.awt.Dimension(900, 2147483647));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(900, 600));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(900, 600));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(900, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(900, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(900, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N
        lblLogoEncabezado.setMaximumSize(new java.awt.Dimension(200, 35));
        lblLogoEncabezado.setMinimumSize(new java.awt.Dimension(200, 35));
        lblLogoEncabezado.setPreferredSize(new java.awt.Dimension(200, 35));

        lblXCerrar.setBackground(new java.awt.Color(255, 0, 0));
        lblXCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblXCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblXCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setText("X");
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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMinimumSize(new java.awt.Dimension(900, 560));
        pnlCont.setPreferredSize(new java.awt.Dimension(900, 560));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Busqueda de Clientes");
        lblTitulo.setOpaque(true);

        buttonGroup.add(rbtnNombre);
        rbtnNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnNombre.setText("Por Nombre");
        rbtnNombre.setMaximumSize(new java.awt.Dimension(147, 25));
        rbtnNombre.setMinimumSize(new java.awt.Dimension(147, 25));
        rbtnNombre.setPreferredSize(new java.awt.Dimension(147, 25));

        buttonGroup.add(rbtnDocumento);
        rbtnDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnDocumento.setText("Por Documento");

        txtNombreCliente.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        txtDocumentoCliente.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblBotonBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/lupa.png"))); // NOI18N
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

        lblBotonDetalles.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/detalles.png"))); // NOI18N
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

        lblBotonCrearCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonCrearCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/new-user.png"))); // NOI18N
        lblBotonCrearCliente.setText("Crear Cliente");
        lblBotonCrearCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonCrearClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonCrearClienteMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonCrearClienteMouseEntered(evt);
            }
        });

        lblBotonSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/salida.png"))); // NOI18N
        lblBotonSalir.setText("Salir");
        lblBotonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonSalirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonSalirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonSalirMouseEntered(evt);
            }
        });

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
        tblMostrarClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblMostrarClientesFocusLost(evt);
            }
        });
        tblMostrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMostrarClientes);

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContLayout.createSequentialGroup()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addComponent(rbtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addComponent(rbtnDocumento)
                        .addGap(13, 13, 13)
                        .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(214, 214, 214))
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(lblTitulo))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lblBotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBotonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBotonCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnDocumento)
                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBotonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void tblMostrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarClientesMouseClicked
        lblBotonDetalles.setEnabled(true);
        
        //int id = (int) tblMostrarClientes.getValueAt((int) tblMostrarClientes.getSelectedRow(), 0);
        //UsuarioDao uDAO = new UsuarioDao();
        //u = uDAO.getUsuarioByID(id);
        //txtMostrarUserNombre.setText(u.getNombre());
        //txtMostrarUserContrasenia.setText(u.getContrasenia());
        //txtMostrarUserID.setText(Integer.toString(u.getIdusuario()));
        //****  TRATAR DE USAR LOS DATOS DE LA GRILLA   ****
        //System.out.println(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 0));
        //System.out.println(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 1));
        //System.out.println(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 2));
        /*
        txtMostrarUserID.setText(Integer.toString(id));
        txtMostrarUserNombre.setText((String)(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 1)));
        txtMostrarUserContrasenia.setText((String)(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 2)));
        
        txtMostrarUserNombre.setEnabled(false);
        txtMostrarUserContrasenia.setEnabled(false);
        btnMostrarUserAgregar.setEnabled(false);
        btnMostrarUserModificar.setEnabled(true);
        btnMostrarUserGuardar.setEnabled(false);
        btnMostrarUserBorrar.setEnabled(true);
        */
    }//GEN-LAST:event_tblMostrarClientesMouseClicked

    private void tblMostrarClientesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblMostrarClientesFocusLost
        /*
        if(txtNombreCliente.isFocusOwner() || txtDocumentoCliente.isFocusOwner() || txtFiltrarEditorial.isFocusOwner() || cmbFiltrarTema.isFocusOwner()){
            btnDetallesCliente.setEnabled(false);
        }
        */
    }//GEN-LAST:event_tblMostrarClientesFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        //InitLibroGrid();
        iniciarPantalla();
        InitClientesGrid();
    }//GEN-LAST:event_formWindowGainedFocus

    private void lblBotonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseClicked
        if(lblBotonBuscar.isEnabled()){
            ClienteDAO cliDAO = new ClienteDAO();
            if(rbtnNombre.isSelected()){
                metodoBusq = POR_NOMBRE;
            }else{
                if(rbtnDocumento.isSelected()){
                    metodoBusq = POR_DOCUMENTO;
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error entendiendo si debe buscarse por nombre o por documento.");
                    return;
                }            
            }

            lblBotonDetalles.setEnabled(false);
            LinkedList<ClienteConDirecc> listaCliente = new LinkedList<>();
            switch(metodoBusq){
                case POR_NOMBRE:
                    String nombreCli = txtNombreCliente.getText();
                    listaCliente = cliDAO.GetClientesConDireccPorNombre(nombreCli);
                    break;
                case POR_DOCUMENTO:
                    long num_doc = Long.parseLong(txtDocumentoCliente.getText());
                    listaCliente = cliDAO.GetClientesConDireccPorDocumento(num_doc);
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
            modelo.addColumn("Dirección - Calle");
            modelo.addColumn("Número");
            modelo.addColumn("Piso");
            modelo.addColumn("Departamento");
            modelo.addColumn("ID Localidad");
            modelo.addColumn("Localidad");
            modelo.addColumn("Departamento de la Localidad");
            modelo.addColumn("ID Provincia");
            modelo.addColumn("Provincia");
            // Acá cargamos las FILAS del Modelo
            Object[] datos = new Object[16];//   |  ID  |  Nombre  | Contraseña  |

            for (ClienteConDirecc cli : listaCliente) {
                datos[0] = cli.getIdcliente();
                datos[1] = cli.getRazonsocial();
                datos[2] = cli.getEmail();
                datos[3] = cli.isBorrado();
                datos[4] = cli.getTipodocumento().getIdtipodocumento();
                datos[5] = cli.getTipodocumento().getDescripcion();
                datos[6] = cli.getNrodocumento();
                datos[7] = cli.getDireccion().getCalle();
                datos[8] = cli.getDireccion().getNumero();
                datos[9] = cli.getDireccion().getPiso();
                datos[10] = cli.getDireccion().getDepartamento();
                datos[11] = cli.getDireccion().getLocalidad().getIdlocalidad();
                datos[12] = cli.getDireccion().getLocalidad().getNombre();
                datos[13] = cli.getDireccion().getLocalidad().getNom_departamento();
                datos[14] = cli.getDireccion().getProvincia().getIdprovincia();
                datos[15] = cli.getDireccion().getProvincia().getNombre();
                //datos[16] = cli.getPrecio();
                modelo.addRow(datos);
            }

            tblMostrarClientes.setModel(modelo);

            tblMostrarClientes.getColumnModel().getColumn(0).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(0).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
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
            tblMostrarClientes.getColumnModel().getColumn(9).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(9).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(10).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(10).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(11).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(11).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(11).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(13).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(13).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(13).setMinWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(14).setMaxWidth(0);
            tblMostrarClientes.getColumnModel().getColumn(14).setMinWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(14).setMaxWidth(0);
            tblMostrarClientes.getTableHeader().getColumnModel().getColumn(14).setMinWidth(0);
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

    private void lblBotonDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonDetallesMouseClicked
        if(lblBotonDetalles.isEnabled()){
            ClienteConDirecc cli = CargarObjetoClienteConDirecc();

            AdministrarClienteUI panelAdminCli = new AdministrarClienteUI(null, true, cli);
            panelAdminCli.setLocationRelativeTo(null);
            panelAdminCli.setVisible(true);
        }
    }//GEN-LAST:event_lblBotonDetallesMouseClicked

    private void lblBotonDetallesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonDetallesMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonDetalles);
    }//GEN-LAST:event_lblBotonDetallesMouseExited

    private void lblBotonDetallesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonDetallesMouseEntered
        if(lblBotonDetalles.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonDetalles);
        }
    }//GEN-LAST:event_lblBotonDetallesMouseEntered

    private void lblBotonCrearClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCrearClienteMouseClicked
        if(lblBotonCrearCliente.isEnabled()){
            AdministrarClienteUI panelAdminCli = new AdministrarClienteUI(null, true);
            panelAdminCli.setLocationRelativeTo(null);
            panelAdminCli.setVisible(true);
        }
    }//GEN-LAST:event_lblBotonCrearClienteMouseClicked

    private void lblBotonCrearClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCrearClienteMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCrearCliente);
    }//GEN-LAST:event_lblBotonCrearClienteMouseExited

    private void lblBotonCrearClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCrearClienteMouseEntered
        if(lblBotonCrearCliente.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonCrearCliente);
        }
    }//GEN-LAST:event_lblBotonCrearClienteMouseEntered

    private void lblBotonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseClicked
        if(lblBotonSalir.isEnabled()){
            dispose();
        }
    }//GEN-LAST:event_lblBotonSalirMouseClicked

    private void lblBotonSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonSalir);
    }//GEN-LAST:event_lblBotonSalirMouseExited

    private void lblBotonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseEntered
        if(lblBotonSalir.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonSalir);
        }
    }//GEN-LAST:event_lblBotonSalirMouseEntered

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered
/*
    private Libro cargarObjetoLibro(){
        Libro book = new Libro();
        TemaDAO temDAO = new TemaDAO();
        Tema tem = new Tema();
        book.setIdlibro((int) tblMostrarClientes.getValueAt((int) tblMostrarClientes.getSelectedRow(), 0));
        book.setIsbn((String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 1));
        book.setTitulo((String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 2));
        book.setAutor((String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 3));
        book.setCantpaginas((int) tblMostrarClientes.getValueAt((int) tblMostrarClientes.getSelectedRow(), 4));
        book.setEditorial((String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 5));
        book.setFechapublicacion((Date) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 6));
        //String costo = ((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 7));
        //book.setPrecio(Double.parseDouble(costo));
        book.setPrecio((double) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 7));
        //book.setPrecio(100);
        //int idTema = (int) tblMostrarLibros.getValueAt((int) tblMostrarLibros.getSelectedRow(), 8);
        //tem.setIdtema(((Tema) tblMostrarLibros.getValueAt((int)tblMostrarLibros.getSelectedRow(), 8)).getIdtema());//funciona??
        //tem.setDescripcion(((Tema) tblMostrarLibros.getValueAt((String)tblMostrarLibros.getSelectedRow(), 8)).getDescripcion());
        //String descTema = (((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 8)));
        String descTema = ((String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 8));
        //tem.setDescripcion((String)(((Tema) tblMostrarLibros.getValueAt((String) tblMostrarLibros.getSelectedRow(), 8)).getDescripcion()));
        //tem = ((Tema) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 8));//funciona
        //book.setTema((Tema) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 8));
        book.setTema(temDAO.GetTemaByDescripcion(descTema));
        //book.setTema((Tema)tem);
        return book;
    }
*/
    private void GrillaVacia() {
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Id Cliente");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Razón Social");
        modelo.addColumn("E-mail");
        modelo.addColumn("Borrado");
        modelo.addColumn("ID Tipo Doc");
        modelo.addColumn("Tipo de Documento");
        modelo.addColumn("N° de documento");
        modelo.addColumn("Dirección - Calle");
        modelo.addColumn("Número");
        modelo.addColumn("Piso");
        modelo.addColumn("Departamento");
        modelo.addColumn("ID Localidad");
        modelo.addColumn("Localidad");
        modelo.addColumn("Departamento de la Localidad");
        modelo.addColumn("ID Provincia");
        modelo.addColumn("Provincia");

        tblMostrarClientes.setModel(modelo);
        
        tblMostrarClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
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
        tblMostrarClientes.getColumnModel().getColumn(9).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(9).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(10).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(10).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(11).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(11).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(11).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(13).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(13).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(13).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(14).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(14).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(14).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(14).setMinWidth(0);
        
        
        
    }
    
    private void InitClientesGrid() {
        ClienteDAO cliDAO = new ClienteDAO();
        
        LinkedList<ClienteConDirecc> listaCliente = cliDAO.GetAllClientesConDirecc();//************ CAMBIARRR******
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Id Cliente");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Razón Social");
        modelo.addColumn("E-mail");
        modelo.addColumn("Borrado");
        modelo.addColumn("ID Tipo Doc");
        modelo.addColumn("Tipo de Documento");
        modelo.addColumn("N° de documento");
        modelo.addColumn("Dirección - Calle");
        modelo.addColumn("Número");
        modelo.addColumn("Piso");
        modelo.addColumn("Departamento");
        modelo.addColumn("ID Localidad");
        modelo.addColumn("Localidad");
        modelo.addColumn("Departamento de la Localidad");
        modelo.addColumn("ID Provincia");
        modelo.addColumn("Provincia");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[16];//   |  ID  |  Nombre  | Contraseña  |
        
        for (ClienteConDirecc cli : listaCliente) {
            datos[0] = cli.getIdcliente();
            datos[1] = cli.getRazonsocial();
            datos[2] = cli.getEmail();
            datos[3] = cli.isBorrado();
            datos[4] = cli.getTipodocumento().getIdtipodocumento();
            datos[5] = cli.getTipodocumento().getDescripcion();
            datos[6] = cli.getNrodocumento();
            datos[7] = cli.getDireccion().getCalle();
            datos[8] = cli.getDireccion().getNumero();
            datos[9] = cli.getDireccion().getPiso();
            datos[10] = cli.getDireccion().getDepartamento();
            datos[11] = cli.getDireccion().getLocalidad().getIdlocalidad();
            datos[12] = cli.getDireccion().getLocalidad().getNombre();
            datos[13] = cli.getDireccion().getLocalidad().getNom_departamento();
            datos[14] = cli.getDireccion().getProvincia().getIdprovincia();
            datos[15] = cli.getDireccion().getProvincia().getNombre();
            //datos[16] = cli.getPrecio();
            modelo.addRow(datos);
        }
        
        tblMostrarClientes.setModel(modelo);
        
        tblMostrarClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
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
        tblMostrarClientes.getColumnModel().getColumn(9).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(9).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(10).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(10).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(11).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(11).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(11).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(13).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(13).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(13).setMinWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(14).setMaxWidth(0);
        tblMostrarClientes.getColumnModel().getColumn(14).setMinWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(14).setMaxWidth(0);
        tblMostrarClientes.getTableHeader().getColumnModel().getColumn(14).setMinWidth(0);

    }
    
    private ClienteConDirecc CargarObjetoClienteConDirecc(){
        //ClienteConDirecc cli = new ClienteConDirecc();
        int idCli = (int) tblMostrarClientes.getValueAt((int) tblMostrarClientes.getSelectedRow(), 0);
        
        int idTipoDoc = (int) tblMostrarClientes.getValueAt((int) tblMostrarClientes.getSelectedRow(), 4);
        String tipoDoc = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 5);
        TipoDocumento tipo = new TipoDocumento(idTipoDoc, tipoDoc);
        long nroDoc = (long) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 6);
        String nombre = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 1);
        String email = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 2);
        boolean borrado = (boolean) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 3);
        
        String calle = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 7);
        int numDir = (int) tblMostrarClientes.getValueAt((int) tblMostrarClientes.getSelectedRow(), 8);
        int pisoDir = (int) tblMostrarClientes.getValueAt((int) tblMostrarClientes.getSelectedRow(), 9);
        String deptoDir = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 10);
        long idLoc = (long) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 11);
        String nombLoc = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 12);
        String deptoLoc = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 13);
        int idProv = (int) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 14);
        String NombProv = (String) tblMostrarClientes.getValueAt(tblMostrarClientes.getSelectedRow(), 15);
        Provincia prov = new Provincia(idProv, NombProv);
        Localidad loc = new Localidad(idLoc, nombLoc, deptoLoc, prov);
        Direccion direc = new Direccion(nroDoc, calle, numDir, pisoDir, deptoDir, loc, prov);
        ClienteConDirecc cli = new ClienteConDirecc(idCli, tipo, nroDoc, nombre, email, borrado, direc);

        return cli;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonBuscar;
    private javax.swing.JLabel lblBotonCrearCliente;
    private javax.swing.JLabel lblBotonDetalles;
    private javax.swing.JLabel lblBotonSalir;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JRadioButton rbtnDocumento;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JTable tblMostrarClientes;
    private javax.swing.JTextField txtDocumentoCliente;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
/*
    @Override
    public void stateChanged(ChangeEvent e) {
        if(chkbFiltrarAutor.isSelected()){
            txtFiltrarAutor.setVisible(true);
        }else{
            txtFiltrarAutor.setVisible(false);
        }
    }
*/
}
