package UI;

import DAO.LibroDAO;
import DAO.TemaDAO;
import Identidades.Libro;
import Identidades.Tema;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;
import DAO.ComboBoxDAO;
import javax.swing.JComboBox;

public class ModificarLibroUI extends javax.swing.JDialog {
    Libro book = new Libro();
    public ModificarLibroUI(java.awt.Frame parent, boolean modal, Libro lib) {
        super(parent, modal);
        initComponents();
        setTitle("Modificar Libro");
        book = lib;
        inicializarCajas();
        txtID.setVisible(false);
        llenarListaDesplegable();
        inicializarPantalla();
    }
    
    private void inicializarPantalla(){
        txtISBN.setText(book.getIsbn());
        txtTitulo.setText(book.getTitulo());
        txtAutor.setText(book.getAutor());
        txtCantPaginas.setText(Integer.toString(book.getCantpaginas()));
        txtEditorial.setText(book.getEditorial());
        //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        //Date fecha = new Date(System.currentTimeMillis());
        dteFecha.setDate(book.getFechapublicacion());
        txtPrecio.setText(Double.toString(book.getPrecio()));
        //cmbTema.setSelectedIndex(0);
        txtID.setText(Integer.toString(book.getIdlibro()));
//        ComboBoxDAO cmbDao = new ComboBoxDAO();
//        cmbDao.TemaSetSelectItemByCampo(book.getTema().getIdtema(), cmbTema);
        int nuevoIDCmb = TemaSetSelectItemByCampo(book.getTema().getIdtema());
        cmbTema.setSelectedIndex(nuevoIDCmb);
    }
    
    private int TemaSetSelectItemByCampo(int idT) {
        int i = 0;
        int itemsDelCombo = cmbTema.getItemCount();
        for (; i < itemsDelCombo; i++) {
            if((((Tema)cmbTema.getItemAt(i)).getIdtema()) == idT){
                return i;
            }
        }
        return i;
    }
    
    private void inicializarCajas() {        
        TextPrompt txtLibroISBN = new TextPrompt("Ingrese el código ISBN", txtISBN);
        txtLibroISBN.setForeground(Color.GRAY);
        txtLibroISBN.changeAlpha(0.5f);
        txtLibroISBN.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtLibroTitulo = new TextPrompt("Ingrese el Título", txtTitulo);
        txtLibroTitulo.setForeground(Color.GRAY);
        txtLibroTitulo.changeAlpha(0.5f);
        txtLibroTitulo.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtLibroAutor = new TextPrompt("Ingrese el Autor/Escritor", txtAutor);
        txtLibroAutor.setForeground(Color.GRAY);
        txtLibroAutor.changeAlpha(0.5f);
        txtLibroAutor.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtLibroPaginas = new TextPrompt("Ingrese el Número de Páginas", txtCantPaginas);
        txtLibroPaginas.setForeground(Color.GRAY);
        txtLibroPaginas.changeAlpha(0.5f);
        txtLibroPaginas.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtLibroEditorial = new TextPrompt("Ingrese la Editorial", txtEditorial);
        txtLibroEditorial.setForeground(Color.GRAY);
        txtLibroEditorial.changeAlpha(0.5f);
        txtLibroEditorial.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        /*
        TextPrompt txtLibroFecha = new TextPrompt("Ingrese la Fecha", txtFecha);
        txtLibroFecha.setForeground(Color.GRAY);
        txtLibroFecha.changeAlpha(0.5f);
        txtLibroFecha.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        */
        TextPrompt txtLibroPrecio = new TextPrompt("Ingrese el Precio", txtPrecio);
        txtLibroPrecio.setForeground(Color.GRAY);
        txtLibroPrecio.changeAlpha(0.5f);
        txtLibroPrecio.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
    }
    
    private void llenarListaDesplegable(){
        TemaDAO temDAO = new TemaDAO();
        LinkedList<Tema> listaTemas = temDAO.GetAllTemas();
        
        for (Tema genero : listaTemas) {
            cmbTema.addItem(genero);
        }
        
    }

    private boolean camposObligatoriosLlenos(){
        boolean todosLlenos = true;
        String faltan = "Para crear el libro debe completar los campos:";
        
        
        if(todosLlenos = false){
            JOptionPane.showMessageDialog(null, faltan);
        }
        return todosLlenos;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloModificarLibro = new javax.swing.JLabel();
        lblISBN = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblCantPaginas = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblTema = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtCantPaginas = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        dteFecha = new com.toedter.calendar.JDateChooser();
        txtPrecio = new javax.swing.JTextField();
        cmbTema = new javax.swing.JComboBox<>();
        btnModificarLibro = new javax.swing.JButton();
        btnEliminarLibro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTituloModificarLibro.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTituloModificarLibro.setText("Modificar Libro");

        lblISBN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblISBN.setText("ISBN");

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTitulo.setText("Título");

        lblAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAutor.setText("Autor");

        lblCantPaginas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCantPaginas.setText("Cantidad de páginas");

        lblEditorial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEditorial.setText("Editorial");

        lblFecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFecha.setText("Fecha de publicación");

        lblPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPrecio.setText("Precio");

        lblTema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTema.setText("Tema");

        txtISBN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISBNActionPerformed(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtAutor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtCantPaginas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtEditorial.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        dteFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cmbTema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        btnModificarLibro.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnModificarLibro.setText("Modificar");
        btnModificarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLibroActionPerformed(evt);
            }
        });

        btnEliminarLibro.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnEliminarLibro.setText("Eliminar");
        btnEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLibroActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblISBN)
                                        .addComponent(lblTitulo)
                                        .addComponent(lblAutor)
                                        .addComponent(lblCantPaginas)
                                        .addComponent(lblEditorial)
                                        .addComponent(lblFecha)
                                        .addComponent(lblPrecio)
                                        .addComponent(lblTema))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtISBN, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                        .addComponent(txtTitulo)
                                        .addComponent(txtAutor)
                                        .addComponent(txtCantPaginas)
                                        .addComponent(txtEditorial)
                                        .addComponent(txtPrecio)
                                        .addComponent(cmbTema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dteFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(123, 123, 123)
                                    .addComponent(btnModificarLibro)
                                    .addGap(35, 35, 35)
                                    .addComponent(btnEliminarLibro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                    .addComponent(btnCancelar))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(251, 251, 251)
                            .addComponent(lblTituloModificarLibro)))
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloModificarLibro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblISBN)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutor)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditorial)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dteFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTema)
                    .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarLibro)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminarLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblAutor, lblCantPaginas, lblEditorial, lblFecha, lblISBN, lblPrecio, lblTema, lblTitulo});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLibroActionPerformed
        LibroDAO libDAO = new LibroDAO();
        Libro book = new Libro();
        
        //if(camposObligatoriosLlenos()){
            book.setIdlibro(Integer.parseInt(txtID.getText()));
            book.setIsbn(txtISBN.getText());
            book.setTitulo(txtTitulo.getText());
            book.setAutor(txtAutor.getText());
            book.setCantpaginas(Integer.parseInt(txtCantPaginas.getText()));
            book.setEditorial(txtEditorial.getText());
            //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            //Date fecha = dteFecha.getDate();
            //System.out.println("Fecha: "+formatoFecha.format(fecha));
            book.setFechapublicacion(dteFecha.getDate());
            //System.out.println("Fecha: "+dteFecha.getDate());
            book.setPrecio(Double.parseDouble(txtPrecio.getText()));
            Tema t = new Tema();
            book.setTema((Tema) cmbTema.getSelectedItem());
 
        //}
        if(libDAO.ModificarLibro(book) > 0){
            JOptionPane.showMessageDialog(null, "El libro se modificó con exito");
            dispose();
            
        }
    }//GEN-LAST:event_btnModificarLibroActionPerformed

    private void btnEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibroActionPerformed
        LibroDAO liDAO = new LibroDAO();
        if(!(txtID.getText().isEmpty())){
            if(liDAO.EliminarLibro(Integer.parseInt(txtID.getText())) > 0){
                JOptionPane.showMessageDialog(null, "El Libro se borró con exito.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró el identificador del Libro a borrar.\nPor favor vuelva a intentarlo.");
        }
        dispose();
    }//GEN-LAST:event_btnEliminarLibroActionPerformed

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarLibro;
    private javax.swing.JButton btnModificarLibro;
    private javax.swing.JComboBox<Object> cmbTema;
    private com.toedter.calendar.JDateChooser dteFecha;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCantPaginas;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloModificarLibro;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantPaginas;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
