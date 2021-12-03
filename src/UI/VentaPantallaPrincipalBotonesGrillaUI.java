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

public class VentaPantallaPrincipalBotonesGrillaUI extends javax.swing.JDialog {
    DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateFormat fechaParaBDD = new SimpleDateFormat("yyyy-MM-dd");
    Cliente c = new Cliente();
    Cliente cliUltBusc = new Cliente();
    //Libro l = new Libro();
    Libro libSeleccionado = new Libro();
    VentaDetalle vd = new VentaDetalle();
    LinkedList<VentaDetalle> listaLibrosDeVenta = new LinkedList<>();
    //double montoVenta = 0;
    int nuevaCant = 1;
//    ImagenFondo p = new ImagenFondo();
    
    public VentaPantallaPrincipalBotonesGrillaUI(java.awt.Frame parent, boolean modal) {
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
    
    public VentaPantallaPrincipalBotonesGrillaUI(java.awt.Frame parent, boolean modal, Cliente cli) {
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
        pnlBuscarCliente.setVisible(false);
        txtDocumento.setText("");
        btnAceptarBuscarCliente.setEnabled(false);
        pnlSubPanelBuscarCliente.setVisible(false);
        
        listaLibrosDeVenta.clear();//elimino los elementos de la lista, la dejo vacia
        InicializarPanelBuscarLibro();
        pnlBuscarLibro.setVisible(false);
        /*** inicializar grilla venta vacias ***/
        GrillaBase();
        
        lblPrecioFinal.setText("0,00");
        
        ImagenFondo imgLbl = new ImagenFondo();
        imgLbl.pintarImagenEnLabel(lblLogo, "/Images/LogoTextoAbajo_FondoTransparente.png");
        
        //txtNumComprobante.setText("00001 - " + NativeString.substr("000000" + String.valueOf(ventasdao.getMaxNumCbte() + 1), 1, 8));
        VentaDAO vDAO = new VentaDAO();
        txtNumComprobante.setText(vDAO.CadenaComprobante(vDAO.UltimoNroComprobanteMasUno()));
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
    
    private void InicializarPanelBuscarLibro(){
        lblDatosSeleccionados1.setText("");
        lblDatosSeleccionados2.setText("");
        lblDatosSeleccionados3.setText("");
        txtCantidadDelLibro.setText("0");
        txtCantidadDelLibro.setEnabled(false);
        btnAceptarBuscarLibro.setEnabled(false);
        pnlSubPanelBuscarLibro.setVisible(false);
        txtNombreDelLibro.setText("");
        /*** inicializar grilla vacia  ***/
        GrillaResultLibrosVacia();
        pnlBuscarLibro.setVisible(false);
        //l.setIdlibro(0);//¿es necesario?????
    }
    
    private void GrillaResultLibrosVacia() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID del Libro");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("ISBN");
        modelo.addColumn("Nombre del Libro");
        modelo.addColumn("Autor");
        modelo.addColumn("Páginas");
        modelo.addColumn("Editorial");
        modelo.addColumn("Fecha de Public");
        modelo.addColumn("Precio");
        modelo.addColumn("ID Tema");
        modelo.addColumn("Género");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[10];// 
        
        tblResultLibros.setModel(modelo);
        tblResultLibros.getColumnModel().getColumn(0).setMaxWidth(0);
        tblResultLibros.getColumnModel().getColumn(0).setMinWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        tblResultLibros.getColumnModel().getColumn(4).setMaxWidth(0);
        tblResultLibros.getColumnModel().getColumn(4).setMinWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        
        tblResultLibros.getColumnModel().getColumn(6).setMaxWidth(0);
        tblResultLibros.getColumnModel().getColumn(6).setMinWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        
        tblResultLibros.getColumnModel().getColumn(8).setMaxWidth(0);
        tblResultLibros.getColumnModel().getColumn(8).setMinWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
        tblResultLibros.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);  
    }
        
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

        jScrollPane3 = new javax.swing.JScrollPane();
        pnlCont = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTituloVentaPP = new javax.swing.JLabel();
        lblNumComprobante = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        lblFechaActual = new javax.swing.JLabel();
        pnlCliente = new javax.swing.JPanel();
        lblTituloSeccionCliente = new javax.swing.JLabel();
        lblIDCliente = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        lblEmailCliente = new javax.swing.JLabel();
        lblTipoDocumentoCliente = new javax.swing.JLabel();
        lblNroDocCliente = new javax.swing.JLabel();
        btnCambiarCliente = new javax.swing.JButton();
        pnlBuscarCliente = new javax.swing.JPanel();
        lblTituloBuscarCliente = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        pnlSubPanelBuscarCliente = new javax.swing.JPanel();
        lblResultadoBuscarCliente = new javax.swing.JLabel();
        btnAceptarBuscarCliente = new javax.swing.JButton();
        btnCancelarBuscarCliente = new javax.swing.JButton();
        pnlLibrosVenta = new javax.swing.JPanel();
        btnBuscarLibro = new javax.swing.JButton();
        pnlBuscarLibro = new javax.swing.JPanel();
        lblTituloBuscarLibro = new javax.swing.JLabel();
        lblNombreDelLibro = new javax.swing.JLabel();
        txtNombreDelLibro = new javax.swing.JTextField();
        btnBuscarNombreDelLibro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultLibros = new javax.swing.JTable();
        pnlSubPanelBuscarLibro = new javax.swing.JPanel();
        lblDatosSeleccionados1 = new javax.swing.JLabel();
        lblDatosSeleccionados2 = new javax.swing.JLabel();
        lblDatosSeleccionados3 = new javax.swing.JLabel();
        lblCantidadDelLibro = new javax.swing.JLabel();
        txtCantidadDelLibro = new javax.swing.JTextField();
        btnAceptarBuscarLibro = new javax.swing.JButton();
        btnCancelarBuscarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibrosVenta = new javax.swing.JTable();
        lblTextoPreciofinal = new javax.swing.JLabel();
        lblPrecioFinal = new javax.swing.JLabel();
        btnCompletarVenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(153, 153, 255));

        pnlCont.setBackground(new java.awt.Color(153, 153, 255));
        pnlCont.setAutoscrolls(true);
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEncabezado.setBackground(new java.awt.Color(145, 145, 255));

        lblLogo.setBackground(new java.awt.Color(204, 204, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoTextoAbajo_FondoTransparente_mediano.png"))); // NOI18N
        lblLogo.setOpaque(true);

        lblTituloVentaPP.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        lblTituloVentaPP.setText("Venta");

        lblNumComprobante.setBackground(new java.awt.Color(204, 204, 255));
        lblNumComprobante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumComprobante.setText("n° de comprobante");
        lblNumComprobante.setOpaque(true);

        txtNumComprobante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFechaActual.setBackground(new java.awt.Color(204, 204, 255));
        lblFechaActual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaActual.setText("Fecha");
        lblFechaActual.setOpaque(true);

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addComponent(lblNumComprobante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(lblTituloVentaPP)
                    .addGap(214, 214, 214)
                    .addComponent(lblFechaActual)
                    .addGap(0, 213, Short.MAX_VALUE)))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumComprobante))
                .addGap(19, 19, 19))
            .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(lblTituloVentaPP))
                        .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(lblFechaActual)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlCont.add(pnlEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 810, 100));

        pnlCliente.setBackground(new java.awt.Color(204, 204, 255));

        lblTituloSeccionCliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTituloSeccionCliente.setText("Cliente");

        lblIDCliente.setText("ID Cliente");

        lblNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombreCliente.setText("Nombre: ");

        lblEmailCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmailCliente.setText("E-mail: ");

        lblTipoDocumentoCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTipoDocumentoCliente.setText("TipoDoc");

        lblNroDocCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNroDocCliente.setText("n° de documento");

        btnCambiarCliente.setText("Cambiar el Cliente");
        btnCambiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlClienteLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlClienteLayout.createSequentialGroup()
                                        .addComponent(lblIDCliente)
                                        .addGap(127, 127, 127)
                                        .addComponent(btnCambiarCliente))
                                    .addGroup(pnlClienteLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(lblEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblTipoDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNroDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTituloSeccionCliente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloSeccionCliente)
                    .addComponent(lblIDCliente)
                    .addComponent(btnCambiarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCliente)
                    .addComponent(lblEmailCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoDocumentoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNroDocCliente))
                .addContainerGap())
        );

        pnlCont.add(pnlCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        pnlBuscarCliente.setBackground(new java.awt.Color(204, 204, 255));

        lblTituloBuscarCliente.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTituloBuscarCliente.setText("Buscar Cliente por el n° de Documento.");

        lblDocumento.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDocumento.setText("Documento");

        txtDocumento.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        btnBuscarCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        pnlSubPanelBuscarCliente.setBackground(new java.awt.Color(255, 204, 153));

        lblResultadoBuscarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAceptarBuscarCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAceptarBuscarCliente.setText("Aceptar");
        btnAceptarBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarBuscarClienteActionPerformed(evt);
            }
        });

        btnCancelarBuscarCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCancelarBuscarCliente.setText("Cancelar");
        btnCancelarBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSubPanelBuscarClienteLayout = new javax.swing.GroupLayout(pnlSubPanelBuscarCliente);
        pnlSubPanelBuscarCliente.setLayout(pnlSubPanelBuscarClienteLayout);
        pnlSubPanelBuscarClienteLayout.setHorizontalGroup(
            pnlSubPanelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubPanelBuscarClienteLayout.createSequentialGroup()
                .addGroup(pnlSubPanelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubPanelBuscarClienteLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblResultadoBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSubPanelBuscarClienteLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnAceptarBuscarCliente)
                        .addGap(44, 44, 44)
                        .addComponent(btnCancelarBuscarCliente)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnlSubPanelBuscarClienteLayout.setVerticalGroup(
            pnlSubPanelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubPanelBuscarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultadoBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSubPanelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarBuscarCliente)
                    .addComponent(btnCancelarBuscarCliente))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBuscarClienteLayout = new javax.swing.GroupLayout(pnlBuscarCliente);
        pnlBuscarCliente.setLayout(pnlBuscarClienteLayout);
        pnlBuscarClienteLayout.setHorizontalGroup(
            pnlBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarClienteLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(pnlBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBuscarClienteLayout.createSequentialGroup()
                        .addComponent(lblTituloBuscarCliente)
                        .addGap(28, 28, 28))
                    .addComponent(pnlSubPanelBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarClienteLayout.createSequentialGroup()
                        .addComponent(lblDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        pnlBuscarClienteLayout.setVerticalGroup(
            pnlBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarClienteLayout.createSequentialGroup()
                .addComponent(lblTituloBuscarCliente)
                .addGap(18, 18, 18)
                .addGroup(pnlBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocumento)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSubPanelBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pnlCont.add(pnlBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 740, -1));

        pnlLibrosVenta.setBackground(new java.awt.Color(204, 255, 255));

        btnBuscarLibro.setText("Buscar Libro");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        pnlBuscarLibro.setBackground(new java.awt.Color(153, 204, 255));

        lblTituloBuscarLibro.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTituloBuscarLibro.setText("Buscar Libro");

        lblNombreDelLibro.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNombreDelLibro.setText("Nombre del Libro");

        txtNombreDelLibro.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        btnBuscarNombreDelLibro.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnBuscarNombreDelLibro.setText("Buscar");
        btnBuscarNombreDelLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNombreDelLibroActionPerformed(evt);
            }
        });

        tblResultLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        tblResultLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultLibrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblResultLibros);

        pnlSubPanelBuscarLibro.setOpaque(false);

        lblDatosSeleccionados1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatosSeleccionados1.setText("jLabel1");

        lblDatosSeleccionados2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatosSeleccionados2.setText("jLabel2");

        lblDatosSeleccionados3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatosSeleccionados3.setText("jLabel3");

        lblCantidadDelLibro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCantidadDelLibro.setText("Cantidad:");

        btnAceptarBuscarLibro.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAceptarBuscarLibro.setText("Aceptar");
        btnAceptarBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarBuscarLibroActionPerformed(evt);
            }
        });

        btnCancelarBuscarLibro.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCancelarBuscarLibro.setText("Cancelar");
        btnCancelarBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBuscarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSubPanelBuscarLibroLayout = new javax.swing.GroupLayout(pnlSubPanelBuscarLibro);
        pnlSubPanelBuscarLibro.setLayout(pnlSubPanelBuscarLibroLayout);
        pnlSubPanelBuscarLibroLayout.setHorizontalGroup(
            pnlSubPanelBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubPanelBuscarLibroLayout.createSequentialGroup()
                .addGroup(pnlSubPanelBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubPanelBuscarLibroLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(pnlSubPanelBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlSubPanelBuscarLibroLayout.createSequentialGroup()
                                .addComponent(lblDatosSeleccionados3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(lblCantidadDelLibro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadDelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDatosSeleccionados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDatosSeleccionados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlSubPanelBuscarLibroLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnAceptarBuscarLibro)
                        .addGap(57, 57, 57)
                        .addComponent(btnCancelarBuscarLibro)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnlSubPanelBuscarLibroLayout.setVerticalGroup(
            pnlSubPanelBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubPanelBuscarLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatosSeleccionados1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDatosSeleccionados2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSubPanelBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDatosSeleccionados3)
                    .addGroup(pnlSubPanelBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidadDelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCantidadDelLibro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSubPanelBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarBuscarLibro)
                    .addComponent(btnCancelarBuscarLibro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBuscarLibroLayout = new javax.swing.GroupLayout(pnlBuscarLibro);
        pnlBuscarLibro.setLayout(pnlBuscarLibroLayout);
        pnlBuscarLibroLayout.setHorizontalGroup(
            pnlBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLibroLayout.createSequentialGroup()
                .addGroup(pnlBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarLibroLayout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(lblTituloBuscarLibro))
                    .addGroup(pnlBuscarLibroLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblNombreDelLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreDelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarNombreDelLibro))
                    .addGroup(pnlBuscarLibroLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(pnlBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlSubPanelBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlBuscarLibroLayout.setVerticalGroup(
            pnlBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLibroLayout.createSequentialGroup()
                .addComponent(lblTituloBuscarLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBuscarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDelLibro)
                    .addComponent(txtNombreDelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarNombreDelLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSubPanelBuscarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        lblTextoPreciofinal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTextoPreciofinal.setText("Precio final     $");

        lblPrecioFinal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPrecioFinal.setText("0,00");

        btnCompletarVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCompletarVenta.setText("Completar Venta");
        btnCompletarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLibrosVentaLayout = new javax.swing.GroupLayout(pnlLibrosVenta);
        pnlLibrosVenta.setLayout(pnlLibrosVentaLayout);
        pnlLibrosVentaLayout.setHorizontalGroup(
            pnlLibrosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLibrosVentaLayout.createSequentialGroup()
                .addGroup(pnlLibrosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLibrosVentaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTextoPreciofinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLibrosVentaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlLibrosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlLibrosVentaLayout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(btnCompletarVenta)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLibrosVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscarLibro)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLibrosVentaLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(pnlBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        pnlLibrosVentaLayout.setVerticalGroup(
            pnlLibrosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLibrosVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLibrosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoPreciofinal)
                    .addComponent(lblPrecioFinal))
                .addGap(18, 18, 18)
                .addComponent(btnCompletarVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCont.add(pnlLibrosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 810, -1));

        jScrollPane3.setViewportView(pnlCont);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClienteActionPerformed
        c.setIdcliente(0);
//        BuscarClienteParaVentaUI panelBusqDoc = new BuscarClienteParaVentaUI(null, true);
//        panelBusqDoc.setLocationRelativeTo(null);
//        panelBusqDoc.setVisible(true);
        pnlBuscarCliente.setVisible(true);
        txtDocumento.setText("");
        txtDocumento.requestFocus();
        btnAceptarBuscarCliente.setEnabled(false);
        pnlSubPanelBuscarCliente.setVisible(false);
//        c = panelBusqDoc.cli;
//        if(c.getIdcliente() > 0){
//            CargarClienteEnVenta(c);
//        }
    }//GEN-LAST:event_btnCambiarClienteActionPerformed

    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
        //libSeleccionado.setIdlibro(0);        

        pnlBuscarLibro.setVisible(true);
        txtNombreDelLibro.requestFocus();
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

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        if(campoDNILleno()){
            ClienteDAO cliDAO = new ClienteDAO();
            cliUltBusc = cliDAO.GetClienteByDocumento(Long.parseLong(txtDocumento.getText()));
            if(cliUltBusc.getIdcliente() > 0){
                pnlSubPanelBuscarCliente.setVisible(true);
                lblResultadoBuscarCliente.setText(cliUltBusc.getRazonsocial());
                btnAceptarBuscarCliente.setEnabled(true);
            }else{
                lblResultadoBuscarCliente.setText("No se encontraron clientes con ese documento.");
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnCancelarBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBuscarClienteActionPerformed
        btnAceptarBuscarCliente.setEnabled(false);
        pnlBuscarCliente.setVisible(false);
    }//GEN-LAST:event_btnCancelarBuscarClienteActionPerformed

    private void btnAceptarBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarBuscarClienteActionPerformed
        c = cliUltBusc;
        CargarClienteEnVenta(c);
        pnlBuscarCliente.setVisible(false);
    }//GEN-LAST:event_btnAceptarBuscarClienteActionPerformed

    private void btnBuscarNombreDelLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNombreDelLibroActionPerformed
        if(campoNombreLibroLleno()){
            LibroDAO libDAO = new LibroDAO();
            String cad = (String)(txtNombreDelLibro.getText());
            //System.out.println(cad);
            LinkedList<Libro> librosRes = libDAO.GetLibrosByTitulo(cad);
            //LinkedList<Libro> librosRes = libDAO.GetLibrosByTitulo(txtNombreLibro.getText());
            //LinkedList<Libro> librosRes = libDAO.GetLibrosByTitulo();
            //LinkedList<Libro> librosRes = libDAO.GetAllLibros();
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID del Libro");  // Acá definimos las Columnas del Modelo
            modelo.addColumn("ISBN");
            modelo.addColumn("Nombre del Libro");
            modelo.addColumn("Autor");
            modelo.addColumn("Páginas");
            modelo.addColumn("Editorial");
            modelo.addColumn("Fecha de Public");
            modelo.addColumn("Precio");
            modelo.addColumn("ID Tema");
            modelo.addColumn("Género");
            // Acá cargamos las FILAS del Modelo
            Object[] datos = new Object[10];// 

            for (Libro book : librosRes) {
                //System.out.println(book.getIdlibro());
                datos[0] = book.getIdlibro();
                datos[1] = book.getIsbn();
                datos[2] = book.getTitulo();
                datos[3] = book.getAutor();
                datos[4] = book.getCantpaginas();
                datos[5] = book.getEditorial();
                datos[6] = book.getFechapublicacion();
                datos[7] = book.getPrecio();
                datos[8] = book.getTema().getIdtema();
                datos[9] = book.getTema().getDescripcion();
                modelo.addRow(datos);
            }
            tblResultLibros.setModel(modelo);
            tblResultLibros.getColumnModel().getColumn(0).setMaxWidth(0);
            tblResultLibros.getColumnModel().getColumn(0).setMinWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

            tblResultLibros.getColumnModel().getColumn(4).setMaxWidth(0);
            tblResultLibros.getColumnModel().getColumn(4).setMinWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);

            tblResultLibros.getColumnModel().getColumn(6).setMaxWidth(0);
            tblResultLibros.getColumnModel().getColumn(6).setMinWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);

            tblResultLibros.getColumnModel().getColumn(8).setMaxWidth(0);
            tblResultLibros.getColumnModel().getColumn(8).setMinWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
            tblResultLibros.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            
            //btnAceptarBuscarLibro.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Debe escribir parte del nombre del Libro.");
        }
    }//GEN-LAST:event_btnBuscarNombreDelLibroActionPerformed

    private void tblResultLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultLibrosMouseClicked
        pnlSubPanelBuscarLibro.setVisible(true);
        int idLibro = (int) (tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 0));
        String ISBNLibro = (String) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 1);
        String tituloLibro = (String) (tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 2));
        String autorLibro = (String) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 3);
        int cantPag = (int) (tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 4));
        String editorialLibro = (String) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 5);
        Date fechaPub = (Date)(tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 6));
        double precioLibro = (double) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 7);
        int idTema = (int)(tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 8));
        String descripTema = (String)(tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 9));
        Tema t = new Tema(idTema, descripTema);
        libSeleccionado = new Libro(idLibro, ISBNLibro, tituloLibro, autorLibro, cantPag, editorialLibro, fechaPub, precioLibro, t);
//String precioLibro = "corregir";
//        System.out.println("Al hacer Click");
//        for(VentaDetalle venD : listaLibrosDeVenta){
//                System.out.println(venD.getPreciovta());
//            }
        lblDatosSeleccionados1.setText("Libro: " + tituloLibro + " ** ISBN " + ISBNLibro);
        lblDatosSeleccionados2.setText("Escritor: " + autorLibro + " ** Editorial: " + editorialLibro);
        lblDatosSeleccionados3.setText("Precio: $" + precioLibro);
        txtCantidadDelLibro.setEnabled(true);
        txtCantidadDelLibro.setText("1");
        btnAceptarBuscarLibro.setEnabled(true);
    }//GEN-LAST:event_tblResultLibrosMouseClicked

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
    
    private void btnAceptarBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarBuscarLibroActionPerformed
        if(libSeleccionado.getIdlibro() > 0){
            if(!yaEstaElLibroEnLaLista(libSeleccionado.getIdlibro())){
                int cantLib = 0;
                try {
                    cantLib = Integer.parseInt(txtCantidadDelLibro.getText());
                    if(cantLib < 1){
                        JOptionPane.showMessageDialog(null, "La cantidad de unidades del libro, debe ser mayor a 0");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo la cantidad de unidades pedidas del libro. (Err:"+e+")");
                    txtCantidadDelLibro.requestFocus();
                }
                vd = new VentaDetalle();
                vd.setLibro(libSeleccionado);//System.out.println(vd.getLibro().getIdlibro());
                vd.setCantidad(cantLib);
                vd.setPreciovta(libSeleccionado.getPrecio());
    //            System.out.println("Antes");
    //            for(VentaDetalle venD : listaLibrosDeVenta){
    //                System.out.println(venD.getPreciovta());
    //            }
    //System.out.println(vd.getLibro().getIdlibro());
                listaLibrosDeVenta.add(vd);//Antes revisar que no esté el libro ya en la lista
    //            System.out.println("despues");
    //            for(VentaDetalle venD : listaLibrosDeVenta){
    //                System.out.println(venD.getLibro().getIdlibro());
    //            }


                CargarLibrosDeVentaGrid();
                InicializarPanelBuscarLibro();
                lblPrecioFinal.setText(Double.toString(CalcularTotalVenta()));
            }else{
                JOptionPane.showMessageDialog(null, "Ese libro ya fué agregado antes, si quiere cambiar la cantidad utilice el botón de la tabla.");
            }
        }
    }//GEN-LAST:event_btnAceptarBuscarLibroActionPerformed

    private void btnCancelarBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBuscarLibroActionPerformed
        InicializarPanelBuscarLibro();
    }//GEN-LAST:event_btnCancelarBuscarLibroActionPerformed

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
    
    private boolean campoDNILleno(){
        boolean lleno = true;
        if(txtDocumento.getText().isEmpty()){
            lleno = false;
        }
        return lleno;
    }
    
    private boolean campoNombreLibroLleno(){
        boolean lleno = true;
        if(txtNombreDelLibro.getText().isEmpty()){
            lleno = false;
        }
        return lleno;
    }
    
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
    private javax.swing.JButton btnAceptarBuscarCliente;
    private javax.swing.JButton btnAceptarBuscarLibro;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnBuscarNombreDelLibro;
    private javax.swing.JButton btnCambiarCliente;
    private javax.swing.JButton btnCancelarBuscarCliente;
    private javax.swing.JButton btnCancelarBuscarLibro;
    private javax.swing.JButton btnCompletarVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCantidadDelLibro;
    private javax.swing.JLabel lblDatosSeleccionados1;
    private javax.swing.JLabel lblDatosSeleccionados2;
    private javax.swing.JLabel lblDatosSeleccionados3;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblIDCliente;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreDelLibro;
    private javax.swing.JLabel lblNroDocCliente;
    private javax.swing.JLabel lblNumComprobante;
    private javax.swing.JLabel lblPrecioFinal;
    private javax.swing.JLabel lblResultadoBuscarCliente;
    private javax.swing.JLabel lblTextoPreciofinal;
    private javax.swing.JLabel lblTipoDocumentoCliente;
    private javax.swing.JLabel lblTituloBuscarCliente;
    private javax.swing.JLabel lblTituloBuscarLibro;
    private javax.swing.JLabel lblTituloSeccionCliente;
    private javax.swing.JLabel lblTituloVentaPP;
    private javax.swing.JPanel pnlBuscarCliente;
    private javax.swing.JPanel pnlBuscarLibro;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlLibrosVenta;
    private javax.swing.JPanel pnlSubPanelBuscarCliente;
    private javax.swing.JPanel pnlSubPanelBuscarLibro;
    private javax.swing.JTable tblLibrosVenta;
    private javax.swing.JTable tblResultLibros;
    private javax.swing.JTextField txtCantidadDelLibro;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombreDelLibro;
    private javax.swing.JTextField txtNumComprobante;
    // End of variables declaration//GEN-END:variables
}
