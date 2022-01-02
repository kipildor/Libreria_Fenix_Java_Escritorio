package UI;

import DAO.ClienteDAO;
import DAO.LibroDAO;
import DAO.VentaDAO;
import DAO.VentaDetalleDAO;
import Identidades.Cliente;
import Identidades.ImagenFondo;
import Identidades.Libro;
import Identidades.Render;
import Identidades.Tema;
import Identidades.Venta;
import Identidades.VentaDetalle;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import jdk.nashorn.internal.objects.NativeString;

public class VentaPantallaPrincipalUI extends javax.swing.JDialog {

    public static VentaDetalle getVd() {
        return vd;
    }

    public static void setVd(VentaDetalle aVd) {
        vd = aVd;
    }
    DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateFormat fechaParaBDD = new SimpleDateFormat("yyyy-MM-dd");
    private static Cliente c = new Cliente();
    Cliente cliUltBusc = new Cliente();
    Libro l = new Libro();
    Libro libSeleccionado = new Libro();
    private static VentaDetalle vd = new VentaDetalle();
    LinkedList<VentaDetalle> listaLibrosDeVenta = new LinkedList<>();
    ColoresDePantallas colores = new ColoresDePantallas();
    //double montoVenta = 0;
    int nuevaCant = 1;
//    ImagenFondo p = new ImagenFondo();
    
    public VentaPantallaPrincipalUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblFechaActual.setText("Fecha: "+fecha.format(LocalDateTime.now()));
        //CargarLibrosDeVentaGrid();
        GrillaBase();
        inicializarPantalla();
        
//        Image miIcono = Toolkit.getDefaultToolkit().getImage("/Images/LogoSolo_FondoSombra_icono.ico");
//        parent.setIconImage(miIcono);
        setTitle("Ventas");
        setIconImage(getIconImage());
//        Container contenedor = getContentPane();
//        p.setRuta("/Images/librosAbiertos.jpg");
    }
    
    public VentaPantallaPrincipalUI(java.awt.Frame parent, boolean modal, Cliente cli) {
        super(parent, modal);
        initComponents();
        lblFechaActual.setText("Fecha: "+fecha.format(LocalDateTime.now()));
        //CargarLibrosDeVentaGrid();
        GrillaBase();
        inicializarPantalla();
        
//        Image miIcono = Toolkit.getDefaultToolkit().getImage("/Images/LogoSolo_FondoSombra_icono.ico");
//        parent.setIconImage(miIcono);
        setTitle("Ventas");
        setIconImage(getIconImage());
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/LogoSoloCuadrado_64x64.png"));
        return retValue;
    }
    
    public void inicializarPantalla(){
        InicializarPanelClienteEnVenta();
//        pnlBuscarCliente.setVisible(false);
//        txtDocumento.setText("");
//        btnAceptarBuscarCliente.setEnabled(false);
//        pnlSubPanelBuscarCliente.setVisible(false);
        
        listaLibrosDeVenta.clear();//elimino los elementos de la lista, la dejo vacia
//        InicializarPanelBuscarLibro();
//        pnlBuscarLibro.setVisible(false);
        /*** inicializar grilla venta vacias ***/
        GrillaBase();
        
        lblPrecioFinal.setText("0,00");
        
        //ImagenFondo imgLbl = new ImagenFondo();
        //imgLbl.pintarImagenEnLabel(lblLogo, "/Images/LogoTextoAbajo_FondoTransparente.png");
        
        //txtNumComprobante.setText("00001 - " + NativeString.substr("000000" + String.valueOf(ventasdao.getMaxNumCbte() + 1), 1, 8));
        VentaDAO vDAO = new VentaDAO();
        txtNumComprobante.setText(vDAO.CadenaComprobante(vDAO.UltimoNroComprobanteMasUno()));
        
        //Colores
        
        colores.ColorDeBotonLabelPantalla(lblBotonCargarCliente);
        colores.ColorDeBotonLabelPantalla(lblBotonBuscarLibro);
    }
    
    public void InicializarPanelClienteEnVenta(){
        lblIDCliente.setText("ID Cliente");
        lblIDCliente.setVisible(false);
        lblNombreCliente.setText("Nombre: ");
        lblEmailCliente.setText("E-mail: ");
        lblTipoDocumentoCliente.setText("Tipo de documento: ");
        lblNroDocCliente.setText("n° de documento");
    }
    
    public void CargarClienteEnVenta(Cliente c){
        lblIDCliente.setText(Integer.toString(c.getIdcliente()));
        lblNombreCliente.setText("Nombre: "+c.getRazonsocial());
        lblEmailCliente.setText("E-mail: "+c.getEmail());
        lblTipoDocumentoCliente.setText("Documento: "+ c.getTipodocumento().getDescripcion());
        lblNroDocCliente.setText("n° "+ Long.toString(c.getNrodocumento()));
    }
    
//    private void InicializarPanelBuscarLibro(){
//        lblDatosSeleccionados1.setText("");
//        lblDatosSeleccionados2.setText("");
//        lblDatosSeleccionados3.setText("");
//        txtCantidadDelLibro.setText("0");
//        txtCantidadDelLibro.setEnabled(false);
//        btnAceptarBuscarLibro.setEnabled(false);
//        pnlSubPanelBuscarLibro.setVisible(false);
//        txtNombreDelLibro.setText("");
//        /*** inicializar grilla vacia  ***/
//        GrillaResultLibrosVacia();
//        pnlBuscarLibro.setVisible(false);
//        //l.setIdlibro(0);//¿es necesario?????
//    }
    
//    private void GrillaResultLibrosVacia() {
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("ID del Libro");  // Acá definimos las Columnas del Modelo
//        modelo.addColumn("ISBN");
//        modelo.addColumn("Nombre del Libro");
//        modelo.addColumn("Autor");
//        modelo.addColumn("Páginas");
//        modelo.addColumn("Editorial");
//        modelo.addColumn("Fecha de Public");
//        modelo.addColumn("Precio");
//        modelo.addColumn("ID Tema");
//        modelo.addColumn("Género");
//        // Acá cargamos las FILAS del Modelo
//        Object[] datos = new Object[10];// 
//        
//        tblResultLibros.setModel(modelo);
//        tblResultLibros.getColumnModel().getColumn(0).setMaxWidth(0);
//        tblResultLibros.getColumnModel().getColumn(0).setMinWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
//        
//        tblResultLibros.getColumnModel().getColumn(4).setMaxWidth(0);
//        tblResultLibros.getColumnModel().getColumn(4).setMinWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
//        
//        tblResultLibros.getColumnModel().getColumn(6).setMaxWidth(0);
//        tblResultLibros.getColumnModel().getColumn(6).setMinWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
//        
//        tblResultLibros.getColumnModel().getColumn(8).setMaxWidth(0);
//        tblResultLibros.getColumnModel().getColumn(8).setMinWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
//        tblResultLibros.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);  
//    }
        
    private void CargarLibrosDeVentaGrid() {
        tblLibrosVenta.setDefaultRenderer(Object.class, new Render());
        JButton btnQuitarLibro = new JButton("Quitar");
        btnQuitarLibro.setName("btnQuitarLibro");
        
        JButton btnModifLibro = new JButton("Modificar");
        btnModifLibro.setName("btnModifLibro");
        
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };
        modelo.addColumn("ID del Libro");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("ISBN");
        modelo.addColumn("Nombre del Libro");
        modelo.addColumn("Autor");
        modelo.addColumn("Páginas");
        modelo.addColumn("Editorial");
        modelo.addColumn("Fecha de Public");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio unitario");
        modelo.addColumn("ID Tema");
        modelo.addColumn("Género");
        modelo.addColumn("");
        modelo.addColumn("");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[13];// 
        
        for (VentaDetalle book : listaLibrosDeVenta) {
//            JTextField txtCeldaCantEjemplares = new JTextField();
//            txtCeldaCantEjemplares.setText(Integer.toString(book.getCantidad()));
//            datos[7].setCellEditor(new DefaultCellEditor(txtCeldaCantEjemplares));
            
            datos[0] = book.getLibro().getIdlibro();
            datos[1] = book.getLibro().getIsbn();
            datos[2] = book.getLibro().getTitulo();
            datos[3] = book.getLibro().getAutor();
            datos[4] = book.getLibro().getCantpaginas();
            datos[5] = book.getLibro().getEditorial();
            datos[6] = book.getLibro().getFechapublicacion();
            datos[7] = book.getCantidad();
            datos[8] = book.getLibro().getPrecio();
            datos[9] = book.getLibro().getTema().getIdtema();
            datos[10] = book.getLibro().getTema().getDescripcion();
            //datos[11] = new JButton("Quitar");
            datos[11] = btnModifLibro;
            datos[12] = btnQuitarLibro;
            modelo.addRow(datos);
            
//            JTextField txtCeldaCantEjemplares = new JTextField();
//            txtCeldaCantEjemplares.setEditable(true);
//            txtCeldaCantEjemplares.setText(Integer.toString(book.getCantidad()));
//            (tblLibrosVenta.getColumnModel().getColumn(2)).setCellEditor(new DefaultCellEditor(txtCeldaCantEjemplares));
        }
        
        tblLibrosVenta.setModel(modelo);
        
        //JButton btnBorrarLibro = new JButton();
        //textField.setEditable(true);
        //txtCeldaCantEjemplares.setText(Integer.toString(book.getCantidad()));
        //(tblLibrosVenta.getColumnModel().getColumn(2)).setCellEditor(new DefaultCellEditor(btnBorrarLibro));
        
        
//        JComboBox comboBox = new JComboBox();
//        for(int x = 0; x < 15; x++){
//            comboBox.addItem(x+1);
//        }
//        comboBox.addItem("Lima");
//        comboBox.addItem("Arequipa");
//        comboBox.addItem("Huaunuco");
//        comboBox.addItem("Iquitos");
//        comboBox.addItem("Madre de Dios");
//        comboBox.addItem("Trujillo");
        
        
//        tblLibrosVenta.getColumnModel().getColumn(0).setMaxWidth(0);
//        tblLibrosVenta.getColumnModel().getColumn(0).setMinWidth(0);
//        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
//        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        tblLibrosVenta.getColumnModel().getColumn(1).setMaxWidth(0);
        tblLibrosVenta.getColumnModel().getColumn(1).setMinWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        
        tblLibrosVenta.getColumnModel().getColumn(3).setMaxWidth(0);
        tblLibrosVenta.getColumnModel().getColumn(3).setMinWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        
        tblLibrosVenta.getColumnModel().getColumn(4).setMaxWidth(0);
        tblLibrosVenta.getColumnModel().getColumn(4).setMinWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        
        tblLibrosVenta.getColumnModel().getColumn(5).setMaxWidth(0);
        tblLibrosVenta.getColumnModel().getColumn(5).setMinWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        
        tblLibrosVenta.getColumnModel().getColumn(6).setMaxWidth(0);
        tblLibrosVenta.getColumnModel().getColumn(6).setMinWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        
        tblLibrosVenta.getColumnModel().getColumn(9).setMaxWidth(0);
        tblLibrosVenta.getColumnModel().getColumn(9).setMinWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);
        
        tblLibrosVenta.getColumnModel().getColumn(10).setMaxWidth(0);
        tblLibrosVenta.getColumnModel().getColumn(10).setMinWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
        tblLibrosVenta.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);
        
    }
    
    private void GrillaBase() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre del Libro");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio unitario");
        tblLibrosVenta.setModel(modelo);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblTituloVentaPP = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        pnlDatosEncabezado = new javax.swing.JPanel();
        lblNumComprobante = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        lblFechaActual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlCliente = new javax.swing.JPanel();
        lblTituloSeccionCliente = new javax.swing.JLabel();
        lblIDCliente = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        lblEmailCliente = new javax.swing.JLabel();
        lblTipoDocumentoCliente = new javax.swing.JLabel();
        lblNroDocCliente = new javax.swing.JLabel();
        lblBotonCargarCliente = new javax.swing.JLabel();
        pnlLibrosVenta = new javax.swing.JPanel();
        btnBuscarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibrosVenta = new javax.swing.JTable();
        lblTextoPreciofinal = new javax.swing.JLabel();
        lblPrecioFinal = new javax.swing.JLabel();
        btnCompletarVenta = new javax.swing.JButton();
        lblBotonBuscarLibro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(153, 153, 255));
        setMaximumSize(new java.awt.Dimension(820, 980));
        setMinimumSize(new java.awt.Dimension(820, 980));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(820, 980));

        pnlFondoPP.setMinimumSize(new java.awt.Dimension(820, 980));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(820, 980));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(820, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(820, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(820, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N

        lblTituloVentaPP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloVentaPP.setText("Venta");

        lblXCerrar.setBackground(new java.awt.Color(255, 0, 0));
        lblXCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblXCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblXCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setText("X");
        lblXCerrar.setMaximumSize(new java.awt.Dimension(40, 40));
        lblXCerrar.setMinimumSize(new java.awt.Dimension(40, 40));
        lblXCerrar.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 525, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                    .addGap(370, 370, 370)
                    .addComponent(lblTituloVentaPP)
                    .addContainerGap(371, Short.MAX_VALUE)))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(lblTituloVentaPP)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setBackground(new java.awt.Color(153, 153, 255));
        pnlCont.setAutoscrolls(true);

        pnlDatosEncabezado.setBackground(new java.awt.Color(145, 145, 255));
        pnlDatosEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumComprobante.setBackground(new java.awt.Color(204, 204, 255));
        lblNumComprobante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumComprobante.setText("n° de comprobante");
        pnlDatosEncabezado.add(lblNumComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        txtNumComprobante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumComprobante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlDatosEncabezado.add(txtNumComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 60, 160, -1));

        lblFechaActual.setBackground(new java.awt.Color(204, 204, 255));
        lblFechaActual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaActual.setText("Fecha");
        pnlDatosEncabezado.add(lblFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 20, 250, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoTextoAbajo_FondoTransparente_mediano.png"))); // NOI18N
        pnlDatosEncabezado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 80));

        pnlCliente.setBackground(new java.awt.Color(204, 204, 255));
        pnlCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloSeccionCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloSeccionCliente.setText("Cliente");
        pnlCliente.add(lblTituloSeccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblIDCliente.setText("ID Cliente");
        pnlCliente.add(lblIDCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        lblNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombreCliente.setText("Nombre: ");
        pnlCliente.add(lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 375, -1));

        lblEmailCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmailCliente.setText("E-mail: ");
        pnlCliente.add(lblEmailCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 380, -1));

        lblTipoDocumentoCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTipoDocumentoCliente.setText("TipoDoc");
        pnlCliente.add(lblTipoDocumentoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 254, -1));

        lblNroDocCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNroDocCliente.setText("n° de documento");
        pnlCliente.add(lblNroDocCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 203, -1));

        lblBotonCargarCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonCargarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonCargarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/upload-user.png"))); // NOI18N
        lblBotonCargarCliente.setText("Cargar Cliente");
        lblBotonCargarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonCargarClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonCargarClienteMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonCargarClienteMouseEntered(evt);
            }
        });
        pnlCliente.add(lblBotonCargarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 210, 40));

        pnlLibrosVenta.setBackground(new java.awt.Color(204, 255, 255));
        pnlLibrosVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarLibro.setText("Buscar Libro");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });
        pnlLibrosVenta.add(btnBuscarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        tblLibrosVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLibrosVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrosVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLibrosVenta);

        pnlLibrosVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 70, 730, 114));

        lblTextoPreciofinal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTextoPreciofinal.setText("Precio final     $");
        pnlLibrosVenta.add(lblTextoPreciofinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, -1));

        lblPrecioFinal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPrecioFinal.setText("0,00");
        pnlLibrosVenta.add(lblPrecioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 123, -1));

        btnCompletarVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCompletarVenta.setText("Completar Venta");
        btnCompletarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletarVentaActionPerformed(evt);
            }
        });
        pnlLibrosVenta.add(btnCompletarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        lblBotonBuscarLibro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonBuscarLibro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonBuscarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/book-lupa.png"))); // NOI18N
        lblBotonBuscarLibro.setText("Buscar Libro");
        lblBotonBuscarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonBuscarLibroMouseClicked(evt);
            }
        });
        pnlLibrosVenta.add(lblBotonBuscarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 190, 40));

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addComponent(pnlDatosEncabezado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLibrosVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlDatosEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlLibrosVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
//        libSeleccionado.setIdlibro(0);        
//
//        pnlBuscarLibro.setVisible(true);
//        txtNombreDelLibro.requestFocus();
    }//GEN-LAST:event_btnBuscarLibroActionPerformed
    
    private boolean camposLlenos(){//Validar entradas
        boolean llenos = true;
        try {
            if(txtNumComprobante.getText().isEmpty()){
                llenos = false;
            }
            if(!(Integer.parseInt(lblIDCliente.getText()) > 0)){
                llenos = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error, posiblemente debido a que no ingresó solo números en el Número de comprobante. (Err:"+e+")");
            llenos = false;
            txtNumComprobante.requestFocus();
        }
        
        if(listaLibrosDeVenta.size() < 1){
            llenos = false;
        }
        return llenos;
    }
    
    private void btnCompletarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarVentaActionPerformed
        if(camposLlenos()){
            VentaDAO vDAO = new VentaDAO();
            double montoTotal = 0;
            montoTotal = CalcularTotalVenta();
            
            //verificación extra desde acá
            int cantFilasTabla = tblLibrosVenta.getRowCount();
            int cantRegLista = listaLibrosDeVenta.size();
            if(cantFilasTabla != cantRegLista){
                JOptionPane.showMessageDialog(null, "Ocurrió un error no coincide la cantidad de filas de la tabla con la lista");
            }
            //verificación extra hasta acá
//            for (int z = 0; z < tblLibrosVenta.getRowCount(); z++) {
//                int cant = (int) tblLibrosVenta.getValueAt(z, 7);
//                double preUnit = (double) tblLibrosVenta.getValueAt(z, 8);
//                montoTotal += (cant * preUnit);
//            }
            
            long numComp = vDAO.ObtenerNroComprobante(txtNumComprobante.getText());
            if(numComp > 0){
                Venta v = new Venta();
                v.setNrocomprobante(numComp);
                v.setCliente(c);
                //la fecha queda automatica en el insert del SQL  NOW()
                v.setMontototal(montoTotal);
                if(vDAO.CrearVenta(v) > 0){
                    //JOptionPane.showMessageDialog(null, "La venta se creó con exito");
                    //int idV = vDAO.getIDVentaByNroComprobante(Long.parseLong(txtNumComprobante.getText()));
                    //int idV = vDAO.getIDVentaByNroComprobante(986);
                    //JOptionPane.showMessageDialog(null, idV);
                    v.setIdventas(vDAO.getIDVentaByNroComprobante(numComp));
                    VentaDetalleDAO vdDAO = new VentaDetalleDAO();
                    boolean erroresDetalles = false;
                    int contInserts = 0;
                    //for(int k = 0; k < tblLibrosVenta.getRowCount(); k++){
                    for (VentaDetalle venDet : listaLibrosDeVenta){
                        //VentaDetalle vd = new VentaDetalle();
                        venDet.setVenta(v);


                        if((vdDAO.crearDetallesDeVenta(venDet)) > 0){
                            contInserts++;
                        }else{
                            erroresDetalles = true;
                        }
                    }
                    if(cantFilasTabla != contInserts){
                        JOptionPane.showMessageDialog(null, "No se guardaron todos los items de la venta.");
                    }
                    if(!erroresDetalles){
                        JOptionPane.showMessageDialog(null, "Los items de la venta fueron agregados con exito.");
                        dispose();
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hay datos sin llenar.");
        }
    }//GEN-LAST:event_btnCompletarVentaActionPerformed

    private boolean yaEstaElLibroEnLaLista(int idLibro){
        boolean existe = false;
        for (VentaDetalle ventaD : listaLibrosDeVenta) {
            if(ventaD.getLibro().getIdlibro() == idLibro){
                existe = true;
                return existe;
            }
        }
        return existe;
    }
    
    private void quitarLibroDeLaLista(int idLibro){
        //boolean todoOK = false;
        if(yaEstaElLibroEnLaLista(idLibro)){
            LinkedList<VentaDetalle> listaNueva = new LinkedList<>();
        
            for (VentaDetalle ventaD : listaLibrosDeVenta) {
                if(ventaD.getLibro().getIdlibro() != idLibro){
                    listaNueva.add(ventaD);
                }
            }
            listaLibrosDeVenta.clear();
            listaLibrosDeVenta = listaNueva;
        }else{
            JOptionPane.showMessageDialog(null, "El libro que quiere quitar no está en la lista.");
        }
    }
    
    private void modificarLibroDeLaLista(int idLibro, int nuevaCantidad){
        //boolean todoOK = false;
        if(yaEstaElLibroEnLaLista(idLibro)){
            LinkedList<VentaDetalle> listaNueva = new LinkedList<>();
        
            for (VentaDetalle ventaD : listaLibrosDeVenta) {
                if(ventaD.getLibro().getIdlibro() != idLibro){
                    listaNueva.add(ventaD);
                }else{
                    ventaD.setCantidad(nuevaCantidad);
                    listaNueva.add(ventaD);
                }
            }
            listaLibrosDeVenta.clear();
            listaLibrosDeVenta = listaNueva;
        }else{
            JOptionPane.showMessageDialog(null, "El libro que quiere modificar no está en la lista.");
        }
    }
    
    private void tblLibrosVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrosVentaMouseClicked
        int colum = tblLibrosVenta.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY()/tblLibrosVenta.getRowHeight();
        int idLib = (int) tblLibrosVenta.getValueAt(tblLibrosVenta.getSelectedRow(), 0);
        
        if((fila >= 0 && fila < tblLibrosVenta.getRowCount()) && (colum >= 0 && colum < tblLibrosVenta.getColumnCount())){
            Object value =  tblLibrosVenta.getValueAt(fila, colum);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;
                
                if(boton.getName().equals("btnQuitarLibro")){
                    //System.out.println("btn quitar");
                    quitarLibroDeLaLista(idLib);
                    
                }
                if(boton.getName().equals("btnModifLibro")){
                    //System.out.println("btn modificar");
                    int cantActual = (int) tblLibrosVenta.getValueAt(tblLibrosVenta.getSelectedRow(), 7);
                    nuevaCant = 1;
                    
                    ModificarCantUnidadesVentaUI pnlCant = new ModificarCantUnidadesVentaUI(null, true, cantActual);
                    pnlCant.setLocationRelativeTo(null);
                    pnlCant.setVisible(true);
                    if(pnlCant.todoOK){
                        nuevaCant = pnlCant.newCantidad;
                        //System.out.println(nuevaCant);
                        modificarLibroDeLaLista(idLib, nuevaCant);
                    }
                }

                //System.out.println(idLib);
            }
            CargarLibrosDeVentaGrid();
            lblPrecioFinal.setText(Double.toString(CalcularTotalVenta()));
        }
    }//GEN-LAST:event_tblLibrosVentaMouseClicked

    private void lblBotonCargarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCargarClienteMouseClicked
        c.setIdcliente(0);
        BuscarClienteParaVentaUI panelBusqDoc = new BuscarClienteParaVentaUI(null, true);
        panelBusqDoc.setLocationRelativeTo(null);
        panelBusqDoc.setVisible(true);
        
//        pnlBuscarCliente.setVisible(true);
//        txtDocumento.setText("");
//        txtDocumento.requestFocus();
//        btnAceptarBuscarCliente.setEnabled(false);
//        pnlSubPanelBuscarCliente.setVisible(false);
        c = panelBusqDoc.cli;
        if(c.getIdcliente() > 0){
            CargarClienteEnVenta(c);
        }
    }//GEN-LAST:event_lblBotonCargarClienteMouseClicked

    private void lblBotonCargarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCargarClienteMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCargarCliente);
    }//GEN-LAST:event_lblBotonCargarClienteMouseExited

    private void lblBotonCargarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCargarClienteMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonCargarCliente);
    }//GEN-LAST:event_lblBotonCargarClienteMouseEntered

    private void lblBotonBuscarLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarLibroMouseClicked
        l.setIdlibro(0);        
        BuscarLibroParaVentaUI panelBusqLib = new BuscarLibroParaVentaUI(null, true);
        panelBusqLib.setLocationRelativeTo(null);
        panelBusqLib.setVisible(true);
        //l = BuscarLibroParaVentaUI.l
        vd = new VentaDetalle();
        vd = panelBusqLib.vdL;
        
        if(vd.getLibro().getIdlibro()> 0){
            //cargar elemento a la tabla y a una lista
            listaLibrosDeVenta.add(vd);
            CargarLibrosDeVentaGrid();
//            montoVenta += vd.getCantidad() * vd.getPreciovta();
//            lblPrecioFinal.setText(Double.toString(montoVenta));
        }
    }//GEN-LAST:event_lblBotonBuscarLibroMouseClicked
    
//    private boolean campoDNILleno(){
//        boolean lleno = true;
//        if(txtDocumento.getText().isEmpty()){
//            lleno = false;
//        }
//        return lleno;
//    }
    
//    private boolean campoNombreLibroLleno(){
//        boolean lleno = true;
//        if(txtNombreDelLibro.getText().isEmpty()){
//            lleno = false;
//        }
//        return lleno;
//    }
    
    private double CalcularTotalVenta(){
        double montoVenta = 0;
        for (VentaDetalle fila : listaLibrosDeVenta) {
            double precio = 0;
            precio = ((double) fila.getPreciovta()) * ((int) fila.getCantidad());
            montoVenta += precio;
        }
        return montoVenta;
    }
    
    DefaultTableModel model = new DefaultTableModel() {

            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false,false,false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
    };


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnCompletarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonBuscarLibro;
    private javax.swing.JLabel lblBotonCargarCliente;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblIDCliente;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNroDocCliente;
    private javax.swing.JLabel lblNumComprobante;
    private javax.swing.JLabel lblPrecioFinal;
    private javax.swing.JLabel lblTextoPreciofinal;
    private javax.swing.JLabel lblTipoDocumentoCliente;
    private javax.swing.JLabel lblTituloSeccionCliente;
    private javax.swing.JLabel lblTituloVentaPP;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlDatosEncabezado;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JPanel pnlLibrosVenta;
    private javax.swing.JTable tblLibrosVenta;
    private javax.swing.JTextField txtNumComprobante;
    // End of variables declaration//GEN-END:variables

    public static Cliente getC() {
        return c;
    }

    public static void setC(Cliente cli) {
        c = cli;
    }
}
