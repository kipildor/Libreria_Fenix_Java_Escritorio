package UI;

import DAO.TipoDocumentoDAO;
import Identidades.ImagenFondo;
import Identidades.TipoDocumento;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminTipoDocumentoUI extends javax.swing.JDialog {
    private final int INSERT = 1;
    private final int UPDATE = 2;
    int metodo;
//    ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();

    public AdminTipoDocumentoUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Tipo de Documento.");
        inicializarCajas();
        inicializarPantalla();
        
//        Container contenedor = getContentPane();
//        p.setRuta("/Images/documentos2.jpg");
    }
    
    private void inicializarCajas() {
        TextPrompt txtId = new TextPrompt("Ingrese el número de ID", txtID);
        txtId.setForeground(Color.GRAY);
        txtId.changeAlpha(0.5f);
        txtId.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        TextPrompt txtDescripcion = new TextPrompt("Ingrese el nombre o siglas", txtTipoDoc);
        txtDescripcion.setForeground(Color.GRAY);
        txtDescripcion.changeAlpha(0.5f);
        txtDescripcion.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
    }
    
    private void inicializarPantalla(){
        txtID.setText("");
        txtTipoDoc.setText("");
        txtIDAnterior.setText("0");
        txtID.setEnabled(false);
        txtTipoDoc.setEnabled(false);
        txtIDAnterior.setEnabled(false);
        txtIDAnterior.setVisible(false);
        
        //Estado de los botones
        lblBotonAgregar.setEnabled(true);
        lblBotonModificar.setEnabled(false);
        lblBotonGuardar.setEnabled(false);
        lblBotonBorrar.setEnabled(false);
        lblBotonCancelar.setText("Salir");
        InitTipoDocumentoGrid();
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblID);
        colores.ColorDeLabelDeLaPantalla(lblTipoDoc);
        
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
        colores.ColorDeBotonLabelPantalla(lblBotonBorrar);
        colores.ColorDeBotonLabelPantalla(lblBotonGuardar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }
    
    private void InitTipoDocumentoGrid() {
        TipoDocumentoDAO tipoDAO = new TipoDocumentoDAO();
        LinkedList<TipoDocumento> tipoList = tipoDAO.GetAllTipoDocumento();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Tipo de Documento");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Nombre");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[2];//   |  ID  |  Nombre  | Contraseña  |
        
        for (TipoDocumento doc : tipoList) {
            datos[0] = doc.getIdtipodocumento();
            datos[1] = doc.getDescripcion();
            modelo.addRow(datos);
        }
        
        tblTipoDocumento.setModel(modelo);
    }
    
    private boolean CamposLlenos(){
        boolean llenos = true;
        if(txtID.getText().isEmpty()){
            llenos = false;
            JOptionPane.showMessageDialog(null, "El campo del número de ID no puede estar vacio.");
            txtID.requestFocus();
        }else{
            if(txtTipoDoc.getText().isEmpty()){
                llenos = false;
                JOptionPane.showMessageDialog(null, "El campo del tipo de documento (nombre) no puede estar vacio.");
                txtTipoDoc.requestFocus();
            }
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
        lblTipoDoc = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTipoDoc = new javax.swing.JTextField();
        lblBotonAgregar = new javax.swing.JLabel();
        lblBotonModificar = new javax.swing.JLabel();
        lblBotonBorrar = new javax.swing.JLabel();
        lblBotonGuardar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoDocumento = new javax.swing.JTable();
        txtIDAnterior = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(730, 2147483647));
        setMinimumSize(new java.awt.Dimension(730, 590));
        setUndecorated(true);

        pnlFondoPP.setMaximumSize(new java.awt.Dimension(730, 590));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(730, 590));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(730, 590));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(32767, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(730, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(730, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N
        lblLogoEncabezado.setMaximumSize(new java.awt.Dimension(200, 35));
        lblLogoEncabezado.setMinimumSize(new java.awt.Dimension(200, 35));
        lblLogoEncabezado.setPreferredSize(new java.awt.Dimension(200, 35));

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
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMinimumSize(new java.awt.Dimension(730, 550));
        pnlCont.setPreferredSize(new java.awt.Dimension(730, 550));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("Administración de Tipos de Documentos.");
        lblTitulo.setOpaque(true);
        pnlCont.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 12, -1, -1));

        lblID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblID.setText("ID");
        lblID.setOpaque(true);
        pnlCont.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 61, 175, -1));

        lblTipoDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTipoDoc.setText("Tipo de Documento");
        lblTipoDoc.setOpaque(true);
        pnlCont.add(lblTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 118, -1, -1));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        pnlCont.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 59, 353, -1));

        txtTipoDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnlCont.add(txtTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 116, 353, -1));

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
        pnlCont.add(lblBotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 170, 50));

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
        pnlCont.add(lblBotonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 170, 50));

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
        pnlCont.add(lblBotonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 170, 50));

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
        pnlCont.add(lblBotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 170, 50));

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
        pnlCont.add(lblBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 170, 50));

        tblTipoDocumento.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTipoDocumento.setRowHeight(20);
        tblTipoDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoDocumentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTipoDocumento);

        pnlCont.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 304, 546, 220));
        pnlCont.add(txtIDAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 91, 181, -1));

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.CENTER);

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

    private void tblTipoDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoDocumentoMouseClicked
        lblBotonAgregar.setEnabled(false);
        lblBotonModificar.setEnabled(true);
        lblBotonGuardar.setEnabled(false);
        lblBotonBorrar.setEnabled(true);
        lblBotonCancelar.setText("Cancelar");
        
        txtID.setText(Integer.toString((int)(tblTipoDocumento.getValueAt((int) tblTipoDocumento.getSelectedRow(), 0))));
        txtTipoDoc.setText((String) (tblTipoDocumento.getValueAt(tblTipoDocumento.getSelectedRow(), 1)));
        txtIDAnterior.setText(Integer.toString((int)(tblTipoDocumento.getValueAt((int) tblTipoDocumento.getSelectedRow(), 0))));
        txtID.setEnabled(false);
        txtTipoDoc.setEnabled(false);
    }//GEN-LAST:event_tblTipoDocumentoMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void lblBotonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseClicked
        if(lblBotonAgregar.isEnabled()){
            txtID.setEnabled(true);
            txtTipoDoc.setEnabled(true);
            lblBotonAgregar.setEnabled(false);
            lblBotonModificar.setEnabled(false);
            lblBotonGuardar.setEnabled(true);
            lblBotonBorrar.setEnabled(false);
            lblBotonCancelar.setText("Cancelar");
            metodo = INSERT;
        }
    }//GEN-LAST:event_lblBotonAgregarMouseClicked

    private void lblBotonAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
    }//GEN-LAST:event_lblBotonAgregarMouseExited

    private void lblBotonAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseEntered
        if(lblBotonAgregar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonAgregar);
        }
    }//GEN-LAST:event_lblBotonAgregarMouseEntered

    private void lblBotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseClicked
        if(lblBotonModificar.isEnabled()){
            txtID.setEnabled(true);
            txtTipoDoc.setEnabled(true);
            lblBotonAgregar.setEnabled(false);
            lblBotonModificar.setEnabled(false);
            lblBotonGuardar.setEnabled(true);
            lblBotonBorrar.setEnabled(false);
            lblBotonCancelar.setText("Cancelar");
            metodo = UPDATE;
        }
    }//GEN-LAST:event_lblBotonModificarMouseClicked

    private void lblBotonModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
    }//GEN-LAST:event_lblBotonModificarMouseExited

    private void lblBotonModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseEntered
        if(lblBotonModificar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonModificar);
        }
    }//GEN-LAST:event_lblBotonModificarMouseEntered

    private void lblBotonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBorrarMouseClicked
        if(lblBotonBorrar.isEnabled()){
            if(CamposLlenos()){
                TipoDocumentoDAO tipoDAO = new TipoDocumentoDAO();
                if(tipoDAO.BorrarTipoDocumento(Integer.parseInt(txtID.getText())) > 0){
                    JOptionPane.showMessageDialog(null, "El tipo de documento se borró con exito.");
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

    private void lblBotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGuardarMouseClicked
        if(lblBotonGuardar.isEnabled()){
            if(CamposLlenos()){
                TipoDocumentoDAO tipoDAO = new TipoDocumentoDAO();
                TipoDocumento tipo = new TipoDocumento();
                tipo.setIdtipodocumento(Integer.parseInt(txtID.getText()));
                tipo.setDescripcion(txtTipoDoc.getText());
                int idAnt = Integer.parseInt(txtIDAnterior.getText());

                int id = tipo.getIdtipodocumento();
                switch(metodo){
                    case INSERT:
                        if(!(tipoDAO.ExisteElID(id))){
                            if(tipoDAO.AgregarTipoDocumento(tipo) > 0){
                                JOptionPane.showMessageDialog(null, "El tipo de documento se insertó con exito.");
                                inicializarPantalla();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "No se puede agregar el tipo de documento porque ya existe otro con el mismo ID");
                            txtID.requestFocus();
                            txtID.selectAll();
                        }
                        break;
                    case UPDATE:
                        if(id != idAnt){
                            if(!(tipoDAO.ExisteElID(id))){
                                if(tipoDAO.ActualizarTipoDocumento(tipo, idAnt) > 0){//Actualiza el ID y la descripción
                                    JOptionPane.showMessageDialog(null, "El tipo de documento se actualizó con exito.");
//                                    System.out.println("UI id+desc ant");
                                    inicializarPantalla();
//                                    System.out.println("UI id+desc desp");
                                }
                            }else{//id es distinto del original, pero ya existe el nuevo
                                JOptionPane.showMessageDialog(null, "Ya existe otro tipo de documento con ese ID.-");
                                txtID.requestFocus();
                                txtID.selectAll();
                            }
                        }else{
                            if(tipoDAO.ActualizarTipoDocumento(tipo) > 0){//Actualiza solo la descripción xq el ID es el mismo
                                JOptionPane.showMessageDialog(null, "El tipo de documento se actualizó con exito.");
//                                System.out.println("UI solo desc ant");
                                inicializarPantalla();
//                                System.out.println("UI solo desc desp");
                            }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBotonAgregar;
    private javax.swing.JLabel lblBotonBorrar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblBotonGuardar;
    private javax.swing.JLabel lblBotonModificar;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblTipoDoc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTable tblTipoDocumento;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDAnterior;
    private javax.swing.JTextField txtTipoDoc;
    // End of variables declaration//GEN-END:variables
}
