package UI;

import DAO.LibroDAO;
import DAO.TemaDAO;
import Identidades.Libro;
import Identidades.Tema;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class AdministrarLibrosUIConRadioButtons extends javax.swing.JDialog {

    public AdministrarLibrosUIConRadioButtons(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        rbtnBuscarLibro.setSelected(true);
        InitLibroGrid();
        inicializarCajas();
        iniciarPantalla();
    }
    
    private void iniciarPantalla(){
        pnlRadioButtons.setVisible(false);
        rbtnBuscarLibro.setSelected(true);
        txtNombreLibro.setText("");
        txtFiltrarAutor.setText("");
        txtFiltrarEditorial.setText("");
        //txtFiltrarAutor.setVisible(false);
        //txtFiltrarEditorial.setVisible(false);
        //cmbFiltrarTema.
        chkbFiltrarAutor.setSelected(false);
        chkbFiltrarEditorial.setSelected(false);
        txtNombreLibro.requestFocus();
        llenarListaDesplegable();
        
    }

    private void inicializarCajas() {        
        TextPrompt txtNombreLib = new TextPrompt("Ingrese el nombre del libro", txtNombreLibro);
        txtNombreLib.setForeground(Color.GRAY);
        txtNombreLib.changeAlpha(0.5f);
        txtNombreLib.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtFiltrarPorAutor = new TextPrompt("Ingrese el Autor", txtFiltrarAutor);
        txtFiltrarPorAutor.setForeground(Color.GRAY);
        txtFiltrarPorAutor.changeAlpha(0.5f);
        txtFiltrarPorAutor.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtFiltrarPorEditorial = new TextPrompt("Ingrese la Editorial", txtFiltrarEditorial);
        txtFiltrarPorEditorial.setForeground(Color.GRAY);
        txtFiltrarPorEditorial.changeAlpha(0.5f);
        txtFiltrarPorEditorial.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        lblTituloAdminLibros = new javax.swing.JLabel();
        pnlRadioButtons = new javax.swing.JPanel();
        rbtnBuscarLibro = new javax.swing.JRadioButton();
        rbtnCrearlibro = new javax.swing.JRadioButton();
        lblNombreLibro = new javax.swing.JLabel();
        txtNombreLibro = new javax.swing.JTextField();
        chkbFiltrarAutor = new javax.swing.JCheckBox();
        txtFiltrarAutor = new javax.swing.JTextField();
        chkbFiltrarEditorial = new javax.swing.JCheckBox();
        txtFiltrarEditorial = new javax.swing.JTextField();
        lblFiltrarTema = new javax.swing.JLabel();
        cmbFiltrarTema = new javax.swing.JComboBox<>();
        btnBuscarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarLibros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTituloAdminLibros.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTituloAdminLibros.setText("Consulta y administración de los libros.");

        buttonGroup.add(rbtnBuscarLibro);
        rbtnBuscarLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbtnBuscarLibro.setText("Buscar Libro");
        pnlRadioButtons.add(rbtnBuscarLibro);

        buttonGroup.add(rbtnCrearlibro);
        rbtnCrearlibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbtnCrearlibro.setText("Crear Libro");
        rbtnCrearlibro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnCrearlibroStateChanged(evt);
            }
        });
        pnlRadioButtons.add(rbtnCrearlibro);

        lblNombreLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreLibro.setText("Nombre del libro");

        txtNombreLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        chkbFiltrarAutor.setText("Filtrar por Autor");

        txtFiltrarAutor.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        chkbFiltrarEditorial.setText("Filtrar por Editorial");
        chkbFiltrarEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtFiltrarEditorial.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblFiltrarTema.setText("Elegir Género del libro");

        cmbFiltrarTema.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        btnBuscarLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscarLibro.setText("Buscar");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        tblMostrarLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMostrarLibros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkbFiltrarEditorial)
                            .addComponent(lblFiltrarTema)
                            .addComponent(lblNombreLibro)
                            .addComponent(chkbFiltrarAutor))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreLibro)
                            .addComponent(txtFiltrarAutor)
                            .addComponent(txtFiltrarEditorial)
                            .addComponent(cmbFiltrarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(lblTituloAdminLibros))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(300, 300, 300)
                                        .addComponent(btnBuscarLibro))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(pnlRadioButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTituloAdminLibros)
                .addGap(11, 11, 11)
                .addComponent(pnlRadioButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreLibro)
                    .addComponent(txtNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltrarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbFiltrarAutor))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbFiltrarEditorial)
                    .addComponent(txtFiltrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltrarTema)
                    .addComponent(cmbFiltrarTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnBuscarLibro)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
        LibroDAO libDAO = new LibroDAO();
        boolean busqTit = false;
        boolean busqAutor = false;
        boolean busqEditorial = false;
        String titulo = "";
        String autor = "";
        String editorial = "";
        int tema = 0;
        if(!(txtNombreLibro.getText().isEmpty())){
            busqTit = true;
            titulo = txtNombreLibro.getText();
        }
        
        if(chkbFiltrarAutor.isSelected() && !(txtFiltrarAutor.getText().isEmpty())){
            busqAutor = true;
            autor = txtFiltrarAutor.getText();
        }
        if(chkbFiltrarEditorial.isSelected() && !(txtFiltrarEditorial.getText().isEmpty())){
            busqEditorial = true;
            editorial = txtFiltrarEditorial.getText();
        }
        tema = ((Tema) cmbFiltrarTema.getSelectedItem()).getIdtema();
        
        LinkedList<Libro> bookList = libDAO.GetBookPersonalizado(busqTit, titulo, busqAutor, autor, busqEditorial, editorial, tema);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Libro");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("ISBN");
        modelo.addColumn("Título");
        modelo.addColumn("Autor");
        modelo.addColumn("Páginas");
        modelo.addColumn("Editorial");
        modelo.addColumn("Fecha de publicación");
        modelo.addColumn("Precio");
        modelo.addColumn("Género");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[9];//   |  ID  |  Nombre  | Contraseña  |
        
        for (Libro libro : bookList) {
            datos[0] = libro.getIdlibro();
            datos[1] = libro.getIsbn();
            datos[2] = libro.getTitulo();
            datos[3] = libro.getAutor();
            datos[4] = libro.getCantpaginas();
            datos[5] = libro.getEditorial();
            datos[6] = libro.getFechapublicacion();
            datos[7] = libro.getPrecio();
            datos[8] = libro.getTema().getDescripcion();
            modelo.addRow(datos);
        }
        
        tblMostrarLibros.setModel(modelo);
        tblMostrarLibros.getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(0).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        tblMostrarLibros.getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(1).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        
        tblMostrarLibros.getColumnModel().getColumn(4).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(4).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        
        tblMostrarLibros.getColumnModel().getColumn(6).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(6).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        /*
        tblMostrarLibros.getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(1).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        */
    }//GEN-LAST:event_btnBuscarLibroActionPerformed

    private void rbtnCrearlibroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtnCrearlibroStateChanged
        if(rbtnBuscarLibro.isSelected()){
            
        }
    }//GEN-LAST:event_rbtnCrearlibroStateChanged
/**/
    private void InitLibroGrid() {
        LibroDAO libDAO = new LibroDAO();
        LinkedList<Libro> bookList = libDAO.GetAllLibros();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Libro");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("ISBN");
        modelo.addColumn("Título");
        modelo.addColumn("Autor");
        modelo.addColumn("Páginas");
        modelo.addColumn("Editorial");
        modelo.addColumn("Fecha de publicación");
        modelo.addColumn("Precio");
        modelo.addColumn("Género");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[9];//   |  ID  |  Nombre  | Contraseña  |
        
        for (Libro libro : bookList) {
            datos[0] = libro.getIdlibro();
            datos[1] = libro.getIsbn();
            datos[2] = libro.getTitulo();
            datos[3] = libro.getAutor();
            datos[4] = libro.getCantpaginas();
            datos[5] = libro.getEditorial();
            datos[6] = libro.getFechapublicacion();
            datos[7] = libro.getPrecio();
            datos[8] = libro.getTema().getDescripcion();
            modelo.addRow(datos);
        }
        
        tblMostrarLibros.setModel(modelo);
        tblMostrarLibros.getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(0).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        tblMostrarLibros.getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(1).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        
        tblMostrarLibros.getColumnModel().getColumn(4).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(4).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        
        tblMostrarLibros.getColumnModel().getColumn(6).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(6).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        /*
        tblMostrarLibros.getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getColumnModel().getColumn(1).setMinWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblMostrarLibros.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        */
    }
    
    private void llenarListaDesplegable(){
        TemaDAO temDAO = new TemaDAO();
        LinkedList<Tema> listaTemas = temDAO.GetAllTemas();
        
        for (Tema genero : listaTemas) {
            cmbFiltrarTema.addItem(genero);
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JCheckBox chkbFiltrarAutor;
    private javax.swing.JCheckBox chkbFiltrarEditorial;
    private javax.swing.JComboBox<Object> cmbFiltrarTema;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltrarTema;
    private javax.swing.JLabel lblNombreLibro;
    private javax.swing.JLabel lblTituloAdminLibros;
    private javax.swing.JPanel pnlRadioButtons;
    private javax.swing.JRadioButton rbtnBuscarLibro;
    private javax.swing.JRadioButton rbtnCrearlibro;
    private javax.swing.JTable tblMostrarLibros;
    private javax.swing.JTextField txtFiltrarAutor;
    private javax.swing.JTextField txtFiltrarEditorial;
    private javax.swing.JTextField txtNombreLibro;
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
