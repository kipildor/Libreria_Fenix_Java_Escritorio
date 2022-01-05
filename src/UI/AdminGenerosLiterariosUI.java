package UI;

import DAO.TemaDAO;
import Identidades.ImagenFondo;
import Identidades.Tema;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminGenerosLiterariosUI extends javax.swing.JDialog {
    private final int INSERT = 1;
    private final int UPDATE = 2;
    int metodo;
    //librosDiversosGenerosLiterarios1.jpg
    //ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();
    
    public AdminGenerosLiterariosUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Géneros Literarios.");
        inicializarCajas();
        inicializarPantalla();
        txtID.setEnabled(false);
        
//        Container contenedor = getContentPane();
//        p.setRuta("/Images/librosDiversosGenerosLiterarios1.jpg");
        //pnlCont.setOpaque(false);
    }
    
    private void inicializarCajas() {
        //TextPrompt txtId = new TextPrompt("Ingrese el número de ID", txtID);
        //txtId.setForeground(Color.GRAY);
        //txtId.changeAlpha(0.5f);
        //txtId.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        TextPrompt txtDescripcion = new TextPrompt("Ingrese el nombre del tema/género", txtGenero);
        txtDescripcion.setForeground(Color.GRAY);
        txtDescripcion.changeAlpha(0.5f);
        txtDescripcion.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
    }
    
    private void inicializarPantalla(){
        txtID.setText("");
        txtGenero.setText("");
        //txtID.setEnabled(false);
        txtGenero.setEnabled(false);

        lblBotonAgregar.setEnabled(true);
        lblBotonModificar.setEnabled(false);
        lblBotonGuardar.setEnabled(false);
        lblBotonBorrar.setEnabled(false);
        lblBotonCancelar.setText("Salir");
        InitGenerosLiterariosGrid();
        
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblID);
        colores.ColorDeLabelDeLaPantalla(lblGenero);
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
        colores.ColorDeBotonLabelPantalla(lblBotonBorrar);
        colores.ColorDeBotonLabelPantalla(lblBotonGuardar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
        
    }
    
    private void InitGenerosLiterariosGrid() {
        TemaDAO temaDAO = new TemaDAO();
        LinkedList<Tema> temaList = temaDAO.GetAllTemas();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID del Tema");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Nombre del Tema/Género");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[2];//   |  ID  |  Nombre  | Contraseña  |
        
        for (Tema t : temaList) {
            datos[0] = t.getIdtema();
            datos[1] = t.getDescripcion();
            modelo.addRow(datos);
        }
        tblGeneros.setModel(modelo);
    }
    
    private boolean CamposLlenos(){
        boolean llenos = true;
        if(txtGenero.getText().isEmpty()){
            llenos = false;
            JOptionPane.showMessageDialog(null, "El campo del nombre del Tema/Género no puede estar vacio.");
            txtGenero.requestFocus();
        }
        return llenos;
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
        lblID = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        lblBotonAgregar = new javax.swing.JLabel();
        lblBotonModificar = new javax.swing.JLabel();
        lblBotonBorrar = new javax.swing.JLabel();
        lblBotonGuardar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGeneros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 540));
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlFondoPP.setMinimumSize(new java.awt.Dimension(730, 540));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(730, 540));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(32767, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(730, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N
        lblLogoEncabezado.setMaximumSize(new java.awt.Dimension(200, 35));
        lblLogoEncabezado.setMinimumSize(new java.awt.Dimension(200, 35));
        lblLogoEncabezado.setPreferredSize(new java.awt.Dimension(200, 35));

        lblXCerrar.setBackground(new java.awt.Color(255, 0, 0));
        lblXCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblXCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblXCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setText("X");
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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMinimumSize(new java.awt.Dimension(730, 500));
        pnlCont.setPreferredSize(new java.awt.Dimension(730, 500));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("Administración de Temas de los Libros.");
        lblTitulo.setOpaque(true);

        lblID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblID.setText("ID");
        lblID.setOpaque(true);

        lblGenero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblGenero.setText("Género literario");
        lblGenero.setOpaque(true);

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtGenero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblBotonAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/mas-en-circulo.png"))); // NOI18N
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

        lblBotonModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/editar.png"))); // NOI18N
        lblBotonModificar.setText("Modificar");
        lblBotonModificar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonModificar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonModificar.setPreferredSize(new java.awt.Dimension(160, 45));
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

        lblBotonBorrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/eliminar.png"))); // NOI18N
        lblBotonBorrar.setText("Borrar");
        lblBotonBorrar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonBorrar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonBorrar.setPreferredSize(new java.awt.Dimension(160, 45));
        lblBotonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonBorrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonBorrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonBorrarMouseEntered(evt);
            }
        });

        lblBotonGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/guardar-archivo.png"))); // NOI18N
        lblBotonGuardar.setText("Guardar");
        lblBotonGuardar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonGuardar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonGuardar.setPreferredSize(new java.awt.Dimension(160, 45));
        lblBotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonGuardarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonGuardarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonGuardarMouseEntered(evt);
            }
        });

        lblBotonCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/x-eliminar.png"))); // NOI18N
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

        tblGeneros.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGeneros.setRowHeight(20);
        tblGeneros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGenerosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGeneros);

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(lblBotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(lblBotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lblGenero)
                        .addGap(18, 18, 18)
                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlContLayout.createSequentialGroup()
                                .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lblBotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(lblBotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblTitulo)))
                .addGap(32, 32, 32))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblTitulo)
                .addGap(36, 36, 36)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblID))
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblGenero))
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlFondoPP);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGenerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGenerosMouseClicked
        lblBotonAgregar.setEnabled(false);
        lblBotonModificar.setEnabled(true);
        lblBotonGuardar.setEnabled(false);
        lblBotonBorrar.setEnabled(true);
        lblBotonCancelar.setText("Cancelar");
        
        txtID.setText(Integer.toString((int)(tblGeneros.getValueAt((int) tblGeneros.getSelectedRow(), 0))));
        txtGenero.setText((String) (tblGeneros.getValueAt(tblGeneros.getSelectedRow(), 1)));
        //txtID.setEnabled(false);
        txtGenero.setEnabled(false);
    }//GEN-LAST:event_tblGenerosMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblBotonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseClicked
        if(lblBotonAgregar.isEnabled()){
            txtGenero.setEnabled(true);
            txtGenero.requestFocus();
    //        btnAgregar.setEnabled(false);
    //        btnModificar.setEnabled(false);
    //        btnGuardar.setEnabled(true);
    //        btnBorrar.setEnabled(false);
    //        btnCancelar.setText("Cancelar");
            lblBotonAgregar.setEnabled(false);
            lblBotonModificar.setEnabled(false);
            lblBotonGuardar.setEnabled(true);
            lblBotonBorrar.setEnabled(false);
            lblBotonCancelar.setText("Cancelar");

            metodo = INSERT;
        }
    }//GEN-LAST:event_lblBotonAgregarMouseClicked

    private void lblBotonAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseEntered
        if(lblBotonAgregar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonAgregar);
        }
    }//GEN-LAST:event_lblBotonAgregarMouseEntered

    private void lblBotonAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
    }//GEN-LAST:event_lblBotonAgregarMouseExited

    private void lblBotonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBorrarMouseClicked
        if(lblBotonBorrar.isEnabled()){
            if(CamposLlenos()){
                TemaDAO tipoDAO = new TemaDAO();
                if(tipoDAO.BorrarTema(Integer.parseInt(txtID.getText())) > 0){
                    JOptionPane.showMessageDialog(null, "El Tema/Género Literario se borró con exito.");
                    inicializarPantalla();
                }
            }
        }
    }//GEN-LAST:event_lblBotonBorrarMouseClicked

    private void lblBotonBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBorrarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonBorrar);
    }//GEN-LAST:event_lblBotonBorrarMouseExited

    private void lblBotonBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBorrarMouseEntered
        if(lblBotonBorrar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonBorrar);
        }
    }//GEN-LAST:event_lblBotonBorrarMouseEntered

    private void lblBotonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseClicked
        if(lblBotonCancelar.isEnabled()){
            if(lblBotonCancelar.getText() == "Salir"){
                dispose();
            }else{
                if(lblBotonCancelar.getText() == "Cancelar"){
                    inicializarPantalla();
                }
            }
        }
    }//GEN-LAST:event_lblBotonCancelarMouseClicked

    private void lblBotonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }//GEN-LAST:event_lblBotonCancelarMouseExited

    private void lblBotonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseEntered
        if(lblBotonCancelar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonCancelar);
        }
    }//GEN-LAST:event_lblBotonCancelarMouseEntered

    private void lblBotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGuardarMouseClicked
        if(lblBotonGuardar.isEnabled()){
            if(CamposLlenos()){
                TemaDAO temaDAO = new TemaDAO();
                Tema t = new Tema();
                if(!(txtID.getText().isEmpty())){
                    t.setIdtema(Integer.parseInt(txtID.getText()));
                }
                t.setDescripcion(txtGenero.getText());

                switch(metodo){
                    case INSERT:
                        if(temaDAO.AddTema(t) > 0){
                            JOptionPane.showMessageDialog(null, "El tema se insertó con exito.");
                            inicializarPantalla();
                        }
                        break;
                    case UPDATE:
                        if(temaDAO.ExisteElTema(t.getIdtema())){
                            if(temaDAO.ModificarTema(t) > 0){
                                JOptionPane.showMessageDialog(null, "El tema se actualizó con exito.");
                                inicializarPantalla();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontró un tema con ese ID.-");
                            //txtID.requestFocus();
                            //txtID.selectAll();
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ocurrió un error desconocido.");
                        break;
                }
            }
        }
    }//GEN-LAST:event_lblBotonGuardarMouseClicked

    private void lblBotonGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGuardarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonGuardar);
    }//GEN-LAST:event_lblBotonGuardarMouseExited

    private void lblBotonGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGuardarMouseEntered
        if(lblBotonGuardar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonGuardar);
        }
    }//GEN-LAST:event_lblBotonGuardarMouseEntered

    private void lblBotonModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseEntered
        if(lblBotonModificar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonModificar);
        }
    }//GEN-LAST:event_lblBotonModificarMouseEntered

    private void lblBotonModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
    }//GEN-LAST:event_lblBotonModificarMouseExited

    private void lblBotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseClicked
        if(lblBotonModificar.isEnabled()){
            txtGenero.setEnabled(true);
            txtGenero.requestFocus();
            txtGenero.selectAll();
            lblBotonAgregar.setEnabled(false);
            lblBotonModificar.setEnabled(false);
            lblBotonGuardar.setEnabled(true);
            lblBotonBorrar.setEnabled(false);
            lblBotonCancelar.setText("Cancelar");
            metodo = UPDATE;
        }
    }//GEN-LAST:event_lblBotonModificarMouseClicked

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonAgregar;
    private javax.swing.JLabel lblBotonBorrar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblBotonGuardar;
    private javax.swing.JLabel lblBotonModificar;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTable tblGeneros;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
