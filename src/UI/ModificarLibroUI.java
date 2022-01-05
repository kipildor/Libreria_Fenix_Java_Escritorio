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
    ColoresDePantallas colores = new ColoresDePantallas();
    
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
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTituloModificarLibro);
        colores.ColorDeLabelDeLaPantalla(lblISBN);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblAutor);
        colores.ColorDeLabelDeLaPantalla(lblCantPaginas);
        colores.ColorDeLabelDeLaPantalla(lblEditorial);
        colores.ColorDeLabelDeLaPantalla(lblFecha);
        colores.ColorDeLabelDeLaPantalla(lblPrecio);
        colores.ColorDeLabelDeLaPantalla(lblTema);
        
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
        colores.ColorDeBotonLabelPantalla(lblBotonEliminar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
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

        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
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
        txtID = new javax.swing.JTextField();
        lblBotonModificar = new javax.swing.JLabel();
        lblBotonEliminar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(750, 550));
        setMinimumSize(new java.awt.Dimension(750, 550));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoPP.setMaximumSize(new java.awt.Dimension(750, 550));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(750, 550));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(750, 550));
        pnlFondoPP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(750, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(750, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(750, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N

        lblXCerrar.setBackground(new java.awt.Color(255, 0, 0));
        lblXCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblXCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblXCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setText("X");
        lblXCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setMaximumSize(new java.awt.Dimension(40, 40));
        lblXCerrar.setMinimumSize(new java.awt.Dimension(40, 40));
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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlFondoPP.add(pnlEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlCont.setMaximumSize(new java.awt.Dimension(750, 490));
        pnlCont.setMinimumSize(new java.awt.Dimension(750, 490));
        pnlCont.setPreferredSize(new java.awt.Dimension(750, 490));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloModificarLibro.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        lblTituloModificarLibro.setText("Modificar Libro");
        pnlCont.add(lblTituloModificarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        lblISBN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblISBN.setText("ISBN");
        pnlCont.add(lblISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 59, -1, 23));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTitulo.setText("Título");
        pnlCont.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 100, -1, 23));

        lblAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAutor.setText("Autor");
        pnlCont.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 141, -1, 23));

        lblCantPaginas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCantPaginas.setText("Cantidad de páginas");
        pnlCont.add(lblCantPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 182, -1, 23));

        lblEditorial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEditorial.setText("Editorial");
        pnlCont.add(lblEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 223, -1, 23));

        lblFecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFecha.setText("Fecha de publicación");
        pnlCont.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 264, -1, 23));

        lblPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPrecio.setText("Precio");
        pnlCont.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 307, -1, 23));

        lblTema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTema.setText("Tema");
        pnlCont.add(lblTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 350, -1, 23));

        txtISBN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISBNActionPerformed(evt);
            }
        });
        pnlCont.add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 60, 400, -1));

        txtTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 101, 400, -1));

        txtAutor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 142, 400, -1));

        txtCantPaginas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtCantPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 183, 400, -1));

        txtEditorial.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 224, 400, -1));

        dteFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(dteFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 264, 223, 25));

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 308, 400, -1));

        cmbTema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pnlCont.add(cmbTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 348, 400, -1));
        pnlCont.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 443, 401, -1));

        lblBotonModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/editar.png"))); // NOI18N
        lblBotonModificar.setText("Modificar");
        lblBotonModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonModificarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonModificarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonModificarMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 160, 50));

        lblBotonEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/eliminar.png"))); // NOI18N
        lblBotonEliminar.setText("Eliminar");
        lblBotonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonEliminarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonEliminarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonEliminarMouseEntered(evt);
            }
        });
        pnlCont.add(lblBotonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 160, 50));

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
        pnlCont.add(lblBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 160, 50));

        pnlFondoPP.add(pnlCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 480));

        getContentPane().add(pnlFondoPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNActionPerformed

    private void lblBotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseClicked
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
    }//GEN-LAST:event_lblBotonModificarMouseClicked

    private void lblBotonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonEliminarMouseClicked
        LibroDAO liDAO = new LibroDAO();
        if(!(txtID.getText().isEmpty())){
            if(liDAO.EliminarLibro(Integer.parseInt(txtID.getText())) > 0){
                JOptionPane.showMessageDialog(null, "El Libro se borró con exito.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró el identificador del Libro a borrar.\nPor favor vuelva a intentarlo.");
        }
        dispose();
    }//GEN-LAST:event_lblBotonEliminarMouseClicked

    private void lblBotonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_lblBotonCancelarMouseClicked

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblBotonModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonModificar);
    }//GEN-LAST:event_lblBotonModificarMouseEntered

    private void lblBotonEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonEliminarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonEliminar);
    }//GEN-LAST:event_lblBotonEliminarMouseEntered

    private void lblBotonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseEntered

    private void lblBotonModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
    }//GEN-LAST:event_lblBotonModificarMouseExited

    private void lblBotonEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonEliminarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonEliminar);
    }//GEN-LAST:event_lblBotonEliminarMouseExited

    private void lblBotonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseExited

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cmbTema;
    private com.toedter.calendar.JDateChooser dteFecha;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblBotonEliminar;
    private javax.swing.JLabel lblBotonModificar;
    private javax.swing.JLabel lblCantPaginas;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloModificarLibro;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantPaginas;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
