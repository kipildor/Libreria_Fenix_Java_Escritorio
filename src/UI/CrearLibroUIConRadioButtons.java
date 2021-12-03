package UI;

import java.awt.Color;
import java.awt.Font;

public class CrearLibroUIConRadioButtons extends javax.swing.JDialog {

    public CrearLibroUIConRadioButtons(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarCajas();
    }
    
    private void inicializarPantalla(){
        txtISBN.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCantPaginas.setText("");
        txtEditorial.setText("");
        txtFecha.setText("");
        txtPrecio.setText("");        
        
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
        
        TextPrompt txtLibroFecha = new TextPrompt("Ingrese la Fecha", txtFecha);
        txtLibroFecha.setForeground(Color.GRAY);
        txtLibroFecha.changeAlpha(0.5f);
        txtLibroFecha.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtLibroPrecio = new TextPrompt("Ingrese el Precio", txtPrecio);
        txtLibroPrecio.setForeground(Color.GRAY);
        txtLibroPrecio.changeAlpha(0.5f);
        txtLibroPrecio.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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
        txtFecha = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        cmbTema = new javax.swing.JComboBox<>();
        btnCrearLibro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Crear Libro");

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

        txtFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cmbTema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        btnCrearLibro.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnCrearLibro.setText("Crear Libro");

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
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
                            .addComponent(txtFecha)
                            .addComponent(txtPrecio)
                            .addComponent(cmbTema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrearLibro)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(btnCancelar)))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnCrearLibro)
                    .addComponent(btnCancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblAutor, lblCantPaginas, lblEditorial, lblFecha, lblISBN, lblPrecio, lblTema, lblTitulo});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNActionPerformed

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearLibro;
    private javax.swing.JComboBox<String> cmbTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCantPaginas;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantPaginas;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
