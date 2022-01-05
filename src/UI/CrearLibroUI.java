package UI;

import DAO.LibroDAO;
import DAO.TemaDAO;
import Identidades.Libro;
import Identidades.Tema;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class CrearLibroUI extends javax.swing.JDialog {
    ColoresDePantallas colores = new ColoresDePantallas();
    
    public CrearLibroUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Agregar Libro");
        inicializarCajas();
        inicializarPantalla();
        llenarListaDesplegable();
    }
    
    private void inicializarPantalla(){
        txtISBN.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCantPaginas.setText("");
        txtEditorial.setText("");
        //dteFecha.setDate(Date.("01-01-2000"));
        //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        //Date fecha = new Date(System.currentTimeMillis());
        //dteFecha.setCalendar(Calendar.getInstance().setTime("11-11-1900"));
        txtPrecio.setText("");
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.BordeDePanel1(pnlFondoPP);
        colores.ColorDeLabelDeLaPantalla(lblTituloCrearLibro);
        colores.ColorDeLabelDeLaPantalla(lblISBN);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblAutor);
        colores.ColorDeLabelDeLaPantalla(lblCantPaginas);
        colores.ColorDeLabelDeLaPantalla(lblEditorial);
        colores.ColorDeLabelDeLaPantalla(lblFecha);
        colores.ColorDeLabelDeLaPantalla(lblPrecio);
        colores.ColorDeLabelDeLaPantalla(lblTema);
        
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
        
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
        lblTituloCrearLibro = new javax.swing.JLabel();
        lblISBN = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblCantPaginas = new javax.swing.JLabel();
        txtCantPaginas = new javax.swing.JTextField();
        lblEditorial = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        dteFecha = new com.toedter.calendar.JDateChooser();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblTema = new javax.swing.JLabel();
        cmbTema = new javax.swing.JComboBox<>();
        lblBotonAgregar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 510));
        setUndecorated(true);

        pnlFondoPP.setMaximumSize(new java.awt.Dimension(670, 510));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(670, 510));
        pnlFondoPP.setName(""); // NOI18N
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(670, 510));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(670, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(670, 40));
        pnlEncabezado.setName(""); // NOI18N
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(670, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N
        lblLogoEncabezado.setMaximumSize(new java.awt.Dimension(300, 35));
        lblLogoEncabezado.setMinimumSize(new java.awt.Dimension(300, 35));
        lblLogoEncabezado.setPreferredSize(new java.awt.Dimension(300, 35));

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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMaximumSize(new java.awt.Dimension(670, 470));
        pnlCont.setMinimumSize(new java.awt.Dimension(670, 470));
        pnlCont.setName(""); // NOI18N
        pnlCont.setPreferredSize(new java.awt.Dimension(670, 479));

        lblTituloCrearLibro.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTituloCrearLibro.setText("Crear Libro");

        lblISBN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblISBN.setText("ISBN");

        txtISBN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTitulo.setText("Título");

        txtTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAutor.setText("Autor");

        txtAutor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblCantPaginas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCantPaginas.setText("Cantidad de páginas");

        txtCantPaginas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblEditorial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEditorial.setText("Editorial");

        txtEditorial.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblFecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFecha.setText("Fecha de publicación");

        dteFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPrecio.setText("Precio");

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblTema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTema.setText("Tema");

        cmbTema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lblBotonAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/mas-en-circulo-negro.png"))); // NOI18N
        lblBotonAgregar.setText("Agregar");
        lblBotonAgregar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonAgregar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonAgregar.setPreferredSize(new java.awt.Dimension(160, 45));
        lblBotonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonAgregarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonAgregarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonAgregarMouseEntered(evt);
            }
        });

        lblBotonCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/x-cancelar.png"))); // NOI18N
        lblBotonCancelar.setText("Cancelar");
        lblBotonCancelar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonCancelar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonCancelar.setPreferredSize(new java.awt.Dimension(160, 45));
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

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(lblTituloCrearLibro))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblISBN)
                        .addGap(25, 25, 25)
                        .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(lblTitulo)
                        .addGap(26, 26, 26)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(lblAutor)
                        .addGap(26, 26, 26)
                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblCantPaginas)
                        .addGap(30, 30, 30)
                        .addComponent(txtCantPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lblEditorial)
                        .addGap(27, 27, 27)
                        .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblFecha)
                        .addGap(24, 24, 24)
                        .addComponent(dteFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblPrecio)
                        .addGap(30, 30, 30)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(lblTema)
                        .addGap(27, 27, 27)
                        .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(lblBotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTituloCrearLibro)
                .addGap(9, 9, 9)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCantPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCantPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dteFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void lblBotonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseClicked
        LibroDAO libDAO = new LibroDAO();
        Libro book = new Libro();
        
        //if(camposObligatoriosLlenos()){
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
        if(libDAO.AgregarLibro(book) > 0){
            JOptionPane.showMessageDialog(null, "El libro se creó con exito");
            dispose();
            
        }
    }//GEN-LAST:event_lblBotonAgregarMouseClicked

    private void lblBotonAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
    }//GEN-LAST:event_lblBotonAgregarMouseExited

    private void lblBotonAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonAgregar);
    }//GEN-LAST:event_lblBotonAgregarMouseEntered

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
    private javax.swing.JComboBox<Object> cmbTema;
    private com.toedter.calendar.JDateChooser dteFecha;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBotonAgregar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblCantPaginas;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloCrearLibro;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantPaginas;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
