package UI;

import DAO.LibroDAO;
import DAO.TemaDAO;
import Identidades.ImagenFondo;
import Identidades.Libro;
import Identidades.Tema;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class AdministrarLibrosUI extends javax.swing.JDialog {
//    ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();
    
    public AdministrarLibrosUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Libros");
        inicializarCajas();
        iniciarPantalla();
        
//        Container contenedor = getContentPane();
//        p.setRuta("/Images/libro_003.jpg");
    }
    
    private void iniciarPantalla(){
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
        lblBotonDetalles.setEnabled(false);
        InitLibroGrid();
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTituloAdminLibros);
        colores.ColorDeLabelDeLaPantalla(lblNombreLibro);
        colores.ColorDeLabelDeLaPantalla(lblFiltrarTema);
        colores.ColorDeLabelDeLaPantalla(chkbFiltrarAutor);
        colores.ColorDeLabelDeLaPantalla(chkbFiltrarEditorial);
        
        colores.ColorDeBotonLabelPantalla(lblBotonBuscar);
        colores.ColorDeBotonLabelPantalla(lblBotonDetalles);
        colores.ColorDeBotonLabelPantalla(lblBotonCrear);
        colores.ColorDeBotonLabelPantalla(lblBotonSalir);
        //cmbFiltrarTema.setSelectedIndex(4);//ese indice es el orden en combo
        //selectItemByCampo(9);
    }
//    private void selectItemByCampo(int idT) {
//        int itemsDelCombo = cmbFiltrarTema.getItemCount();
//        for (int i = 0; i < itemsDelCombo; i++) {
//            if((((Tema)cmbFiltrarTema.getItemAt(i)).getIdtema()) == idT){
//                cmbFiltrarTema.setSelectedIndex(i);
//                break;
//            }
//        }
//        //return;
//    }

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

        pnlFondoPP = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont = new javax.swing.JPanel();
        lblTituloAdminLibros = new javax.swing.JLabel();
        lblNombreLibro = new javax.swing.JLabel();
        txtNombreLibro = new javax.swing.JTextField();
        chkbFiltrarAutor = new javax.swing.JCheckBox();
        txtFiltrarAutor = new javax.swing.JTextField();
        chkbFiltrarEditorial = new javax.swing.JCheckBox();
        txtFiltrarEditorial = new javax.swing.JTextField();
        lblFiltrarTema = new javax.swing.JLabel();
        cmbFiltrarTema = new javax.swing.JComboBox<>();
        lblBotonBuscar = new javax.swing.JLabel();
        lblBotonDetalles = new javax.swing.JLabel();
        lblBotonCrear = new javax.swing.JLabel();
        lblBotonSalir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarLibros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 520));
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        pnlFondoPP.setMinimumSize(new java.awt.Dimension(820, 520));
        pnlFondoPP.setName(""); // NOI18N
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(820, 520));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(820, 480));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(820, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(820, 40));

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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 413, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMinimumSize(new java.awt.Dimension(820, 480));
        pnlCont.setPreferredSize(new java.awt.Dimension(820, 480));

        lblTituloAdminLibros.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTituloAdminLibros.setText("Consulta y administración de los libros.");
        lblTituloAdminLibros.setOpaque(true);

        lblNombreLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreLibro.setText("Nombre del libro");
        lblNombreLibro.setOpaque(true);

        txtNombreLibro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        chkbFiltrarAutor.setText("Filtrar por Autor");

        txtFiltrarAutor.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        chkbFiltrarEditorial.setText("Filtrar por Editorial");
        chkbFiltrarEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtFiltrarEditorial.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblFiltrarTema.setText("Elegir Género del libro");
        lblFiltrarTema.setOpaque(true);

        cmbFiltrarTema.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblBotonBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/lupa.png"))); // NOI18N
        lblBotonBuscar.setText("Buscar");
        lblBotonBuscar.setMaximumSize(new java.awt.Dimension(98, 45));
        lblBotonBuscar.setMinimumSize(new java.awt.Dimension(98, 45));
        lblBotonBuscar.setPreferredSize(new java.awt.Dimension(98, 45));
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
        lblBotonDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/prueba.png"))); // NOI18N
        lblBotonDetalles.setText("Detalles");
        lblBotonDetalles.setMaximumSize(new java.awt.Dimension(98, 45));
        lblBotonDetalles.setMinimumSize(new java.awt.Dimension(98, 45));
        lblBotonDetalles.setPreferredSize(new java.awt.Dimension(98, 45));
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

        lblBotonCrear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/mas-en-circulo-negro.png"))); // NOI18N
        lblBotonCrear.setText("Crear Libro");
        lblBotonCrear.setMaximumSize(new java.awt.Dimension(120, 45));
        lblBotonCrear.setMinimumSize(new java.awt.Dimension(120, 45));
        lblBotonCrear.setPreferredSize(new java.awt.Dimension(120, 45));
        lblBotonCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonCrearMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonCrearMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonCrearMouseEntered(evt);
            }
        });

        lblBotonSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/salida.png"))); // NOI18N
        lblBotonSalir.setText("Salir");
        lblBotonSalir.setMaximumSize(new java.awt.Dimension(98, 45));
        lblBotonSalir.setMinimumSize(new java.awt.Dimension(98, 45));
        lblBotonSalir.setPreferredSize(new java.awt.Dimension(98, 45));
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
        tblMostrarLibros.setRowHeight(20);
        tblMostrarLibros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblMostrarLibrosFocusLost(evt);
            }
        });
        tblMostrarLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMostrarLibros);

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTituloAdminLibros)
                .addGap(133, 133, 133))
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblFiltrarTema)
                        .addGap(24, 24, 24)
                        .addComponent(cmbFiltrarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblBotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBotonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBotonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlContLayout.createSequentialGroup()
                                .addComponent(chkbFiltrarEditorial)
                                .addGap(23, 23, 23)
                                .addComponent(txtFiltrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlContLayout.createSequentialGroup()
                                    .addComponent(chkbFiltrarAutor)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtFiltrarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlContLayout.createSequentialGroup()
                                    .addComponent(lblNombreLibro)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTituloAdminLibros)
                .addGap(32, 32, 32)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblNombreLibro))
                    .addComponent(txtNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(chkbFiltrarAutor))
                    .addComponent(txtFiltrarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(chkbFiltrarEditorial))
                    .addComponent(txtFiltrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblFiltrarTema))
                    .addComponent(cmbFiltrarTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBotonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void tblMostrarLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarLibrosMouseClicked
        lblBotonDetalles.setEnabled(true);
        
        //Usuario u = new Usuario();
        int id = (int) tblMostrarLibros.getValueAt((int) tblMostrarLibros.getSelectedRow(), 0);
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
    }//GEN-LAST:event_tblMostrarLibrosMouseClicked

    private void tblMostrarLibrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblMostrarLibrosFocusLost
        if(txtNombreLibro.isFocusOwner() || txtFiltrarAutor.isFocusOwner() || txtFiltrarEditorial.isFocusOwner() || cmbFiltrarTema.isFocusOwner()){
            lblBotonDetalles.setEnabled(false);
        }
    }//GEN-LAST:event_tblMostrarLibrosFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        //InitLibroGrid();
        iniciarPantalla();
    }//GEN-LAST:event_formWindowGainedFocus

    private void lblBotonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBuscarMouseClicked
        if(lblBotonBuscar.isEnabled()){
            LibroDAO libDAO = new LibroDAO();
            boolean busqTit = false;
            boolean busqAutor = false;
            boolean busqEditorial = false;
            String titulo = "";
            String autor = "";
            String editorial = "";
            lblBotonDetalles.setEnabled(false);
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
            Libro lib = cargarObjetoLibro();
            ModificarLibroUI panelModifLibro = new ModificarLibroUI(null, true, lib);
            panelModifLibro.setLocationRelativeTo(null);
            panelModifLibro.setVisible(true);
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

    private void lblBotonCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCrearMouseClicked
        if(lblBotonCrear.isEnabled()){
            CrearLibroUI panelLibro = new CrearLibroUI(null, true);
            panelLibro.setLocationRelativeTo(null);
            panelLibro.setVisible(true);
        }
    }//GEN-LAST:event_lblBotonCrearMouseClicked

    private void lblBotonCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCrearMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonCrear);
    }//GEN-LAST:event_lblBotonCrearMouseExited

    private void lblBotonCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCrearMouseEntered
        if(lblBotonCrear.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonCrear);
        }
    }//GEN-LAST:event_lblBotonCrearMouseEntered

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblBotonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseClicked
        dispose();
    }//GEN-LAST:event_lblBotonSalirMouseClicked

    private void lblBotonSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonSalir);
    }//GEN-LAST:event_lblBotonSalirMouseExited

    private void lblBotonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseEntered
        colores.ColorDeBotonLabelPantallaOver(lblBotonSalir);
    }//GEN-LAST:event_lblBotonSalirMouseEntered
/**/
    private Libro cargarObjetoLibro(){
        Libro book = new Libro();
        TemaDAO temDAO = new TemaDAO();
        Tema tem = new Tema();
        book.setIdlibro((int) tblMostrarLibros.getValueAt((int) tblMostrarLibros.getSelectedRow(), 0));
        book.setIsbn((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 1));
        book.setTitulo((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 2));
        book.setAutor((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 3));
        book.setCantpaginas((int) tblMostrarLibros.getValueAt((int) tblMostrarLibros.getSelectedRow(), 4));
        book.setEditorial((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 5));
        book.setFechapublicacion((Date) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 6));
        //String costo = ((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 7));
        //book.setPrecio(Double.parseDouble(costo));
        book.setPrecio((double) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 7));
        //book.setPrecio(100);
        //int idTema = (int) tblMostrarLibros.getValueAt((int) tblMostrarLibros.getSelectedRow(), 8);
        //tem.setIdtema(((Tema) tblMostrarLibros.getValueAt((int)tblMostrarLibros.getSelectedRow(), 8)).getIdtema());//funciona??
        //tem.setDescripcion(((Tema) tblMostrarLibros.getValueAt((String)tblMostrarLibros.getSelectedRow(), 8)).getDescripcion());
        //String descTema = (((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 8)));
        String descTema = ((String) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 8));
        //tem.setDescripcion((String)(((Tema) tblMostrarLibros.getValueAt((String) tblMostrarLibros.getSelectedRow(), 8)).getDescripcion()));
        //tem = ((Tema) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 8));//funciona
        //book.setTema((Tema) tblMostrarLibros.getValueAt(tblMostrarLibros.getSelectedRow(), 8));
        book.setTema(temDAO.GetTemaByDescripcion(descTema));
        //book.setTema((Tema)tem);
        return book;
    }
    
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
    private javax.swing.JCheckBox chkbFiltrarAutor;
    private javax.swing.JCheckBox chkbFiltrarEditorial;
    private javax.swing.JComboBox<Object> cmbFiltrarTema;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonBuscar;
    private javax.swing.JLabel lblBotonCrear;
    private javax.swing.JLabel lblBotonDetalles;
    private javax.swing.JLabel lblBotonSalir;
    private javax.swing.JLabel lblFiltrarTema;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblNombreLibro;
    private javax.swing.JLabel lblTituloAdminLibros;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
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
