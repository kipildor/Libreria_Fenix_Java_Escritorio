package UI;

import DAO.LibroDAO;
import Identidades.Libro;
import Identidades.Tema;
import Identidades.VentaDetalle;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarLibroParaVentaUI extends javax.swing.JDialog {
    //private VentaPantallaPrincipalUI ventanaVenta;
    //public int num = 28;
    LinkedList<Libro> l = new LinkedList<>();
    Libro lib = new Libro();
    VentaDetalle vdL = new VentaDetalle();
    
    ColoresDePantallas colores = new ColoresDePantallas();
    
    public BuscarLibroParaVentaUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Buscar Libro");
        initComponents();
        inicializarPantalla();
        InitResultLibrosGrid();
        lib.setIdlibro(0);
        btnAceptar.setEnabled(false);
//        lblDatosSeleccionados1.setVisible(false);
//        lblDatosSeleccionados2.setVisible(false);
//        lblDatosSeleccionados3.setVisible(false);
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
        lblBotonAceptar.setEnabled(false);
        lblCantidad.setVisible(false);
        txtCantidad.setVisible(false);
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblNombreLibro);
        colores.ColorDeLabelDeLaPantalla(lblCantidad);
        
        colores.ColorLabelDeDetalles(lblDatosSeleccionados1);
        colores.ColorLabelDeDetalles(lblDatosSeleccionados2);
        colores.ColorLabelDeDetalles(lblDatosSeleccionados3);
        
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
        colores.ColorDeBotonLabelPantalla(lblBotonAceptar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
        
    }
    
    private void InitResultLibrosGrid() {
        //LibroDAO libDAO = new LibroDAO();
        //LinkedList<Libro> listaLib = new LinkedList<>();
        
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
        /*
        for (Libro book : listaLib) {
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
        */
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
    
    private boolean campoNombreLibroLleno(){
        boolean lleno = true;
        if(txtNombreLibro.getText().isEmpty()){
            lleno = false;
        }
        return lleno;
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
        lblNombreLibro = new javax.swing.JLabel();
        txtNombreLibro = new javax.swing.JTextField();
        lblBotonBuscar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultLibros = new javax.swing.JTable();
        lblDatosSeleccionados1 = new javax.swing.JLabel();
        lblDatosSeleccionados2 = new javax.swing.JLabel();
        lblDatosSeleccionados3 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblBotonAceptar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoPP.setMinimumSize(new java.awt.Dimension(700, 500));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(700, 500));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(32767, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(700, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(700, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixRojo35Alto.png"))); // NOI18N

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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMinimumSize(new java.awt.Dimension(700, 460));
        pnlCont.setPreferredSize(new java.awt.Dimension(700, 460));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitulo.setText("Buscar Libro.");
        pnlCont.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 12, -1, -1));

        lblNombreLibro.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNombreLibro.setText("Nombre del libro");
        pnlCont.add(lblNombreLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 63, -1, -1));

        txtNombreLibro.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        pnlCont.add(txtNombreLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 61, 320, -1));

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
        pnlCont.add(lblBotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 150, 30));

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlCont.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

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
        tblResultLibros.setRowHeight(20);
        tblResultLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultLibros);

        pnlCont.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 93, 679, 146));
        pnlCont.add(lblDatosSeleccionados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 245, 657, 20));
        pnlCont.add(lblDatosSeleccionados2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 271, 657, 20));
        pnlCont.add(lblDatosSeleccionados3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 297, 320, 20));

        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnlCont.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlCont.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblCantidad.setText("Cantidad de Unidades");
        pnlCont.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.setText("1");
        pnlCont.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 299, 90, 20));

        lblBotonAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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
        pnlCont.add(lblBotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 170, 40));

        lblBotonCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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
        pnlCont.add(lblBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 170, 40));

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlFondoPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(campoNombreLibroLleno()){
            LibroDAO libDAO = new LibroDAO();
            String cad = (String)(txtNombreLibro.getText());
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
            
            btnAceptar.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Debe escribir parte del nombre del Libro.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        lib.setIdlibro((int)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 0));
        lib.setIsbn((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 1));
        lib.setTitulo((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 2));
        lib.setAutor((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 3));
        lib.setCantpaginas((int)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 4));
        lib.setEditorial((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 5));
        lib.setFechapublicacion((Date)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 6));
        lib.setPrecio((double)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 7));
        Tema t = new Tema();
        t.setIdtema((int)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 8));
        t.setDescripcion((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 9));
        lib.setTema(t);
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblResultLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultLibrosMouseClicked
        String tituloLibro = (String) (tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 2));
        String editorialLibro = (String) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 5);
        String autorLibro = (String) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 3);
        double precioLibro = (double) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 7);
//String precioLibro = "corregir";
        String ISBNLibro = (String) tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 1);
        lblDatosSeleccionados1.setText("Libro: " + tituloLibro + " ** ISBN " + ISBNLibro);
        lblDatosSeleccionados2.setText("Escritor: " + autorLibro + " ** Editorial: " + editorialLibro);
        lblDatosSeleccionados3.setText("Precio: $" + precioLibro);
        
        lblCantidad.setVisible(true);
        txtCantidad.setVisible(true);
        
        lblBotonAceptar.setEnabled(true);
    }//GEN-LAST:event_tblResultLibrosMouseClicked

    private void lblBotonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseClicked
        if(campoNombreLibroLleno()){
            LibroDAO libDAO = new LibroDAO();
            String cad = (String)(txtNombreLibro.getText());
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
            
            btnAceptar.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Debe escribir parte del nombre del Libro.");
        }
    }//GEN-LAST:event_lblBotonBuscarMouseClicked

    private void lblBotonBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
    }//GEN-LAST:event_lblBotonBuscarMouseExited

    private void lblBotonBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonBuscar);
    }//GEN-LAST:event_lblBotonBuscarMouseEntered

    private void lblBotonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAceptarMouseClicked
        if(lblBotonAceptar.isEnabled()){
            int cantUnidades = 0;
            try {
                cantUnidades = ((int)(tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 0)));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error con la cantidad de unidades. (Err:"+e+")");
            }
            if(cantUnidades > 0){
                if((Integer.parseInt(txtCantidad.getText())) > 0){
                    lib.setIdlibro((int)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 0));
                    lib.setIsbn((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 1));
                    lib.setTitulo((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 2));
                    lib.setAutor((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 3));
                    lib.setCantpaginas((int)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 4));
                    lib.setEditorial((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 5));
                    lib.setFechapublicacion((Date)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 6));
                    lib.setPrecio((double)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 7));
                    Tema t = new Tema();
                    t.setIdtema((int)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 8));
                    t.setDescripcion((String)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 9));
                    lib.setTema(t);
                    
                    vdL.setLibro(lib);
                    vdL.setCantidad(cantUnidades);
                    vdL.setPreciovta((double)tblResultLibros.getValueAt(tblResultLibros.getSelectedRow(), 7));
                    
                    //VentaPantallaPrincipalUI.
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "La cantidad de unidades debe ser mayor a 0.");
                }
            }
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonAceptar;
    private javax.swing.JLabel lblBotonBuscar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDatosSeleccionados1;
    private javax.swing.JLabel lblDatosSeleccionados2;
    private javax.swing.JLabel lblDatosSeleccionados3;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblNombreLibro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTable tblResultLibros;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombreLibro;
    // End of variables declaration//GEN-END:variables
}
