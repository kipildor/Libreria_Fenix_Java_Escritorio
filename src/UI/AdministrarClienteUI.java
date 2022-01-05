package UI;

import DAO.ClienteDAO;
import DAO.ProvinciaLocalidadDAO;
import DAO.TipoDocumentoDAO;
import Identidades.ClienteConDirecc;
import Identidades.Direccion;
import Identidades.Localidad;
import Identidades.Provincia;
import Identidades.TipoDocumento;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AdministrarClienteUI extends javax.swing.JDialog {
    private final int INSERT = 1;
    private final int UPDATE = 2;
    int metodo = 1;
    ClienteConDirecc detallesCli = new ClienteConDirecc();
    ColoresDePantallas colores = new ColoresDePantallas();
        
    public AdministrarClienteUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Agregar Cliente");
        metodo = 1;
        inicializarCajas();
        inicializarPantalla();
        //llenarListaDesplegable();
        llenarListaTipodDoc();
        llenarListaProv();
        cmbLocalidad.setEnabled(false);
        chkbBorrado.setEnabled(false);
        txtIDCliente.setVisible(false);
    }
    
    public AdministrarClienteUI(java.awt.Frame parent, boolean modal, ClienteConDirecc clien) {
        super(parent, modal);
        initComponents();
        metodo = 2;
        lblBotonAgregar.setText("Guardar");
        setTitle("Detalles de Cliente");
        inicializarCajas();
        inicializarPantalla();
        //llenarListaDesplegable();
        llenarListaTipodDoc();
        llenarListaProv();
        txtIDCliente.setVisible(false);
        chkbBorrado.setEnabled(true);
        //System.out.println(cli.getDireccion().getCalle());
        detallesCli = clien;
        cargarClienteDelObjeto();
    }
   
    private void inicializarPantalla(){
        txtNombreCliente.setText("");
        //cmbTipoDocumento.
        txtNroDocumento.setText("");
        txtEmail.setText("");
        txtCalle.setText("");
        txtNroDireccion.setText("");
        txtPiso.setText("");
        txtDeptoDirecc.setText("");
        //cmbProvincia
        //cmbLocalidad
        //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        //Date fecha = new Date(System.currentTimeMillis());
        //dteFecha.setCalendar(Calendar.getInstance().setTime("11-11-1900"));
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.BordeDePanel2(pnlFondoPP);
        
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblNombreCliente);
        colores.ColorDeLabelDeLaPantalla(lblTipoDocumento);
        colores.ColorDeLabelDeLaPantalla(lblNroDocumento);
        colores.ColorDeLabelDeLaPantalla(lblEmail);
        colores.ColorDeLabelDeLaPantalla(lblSeccionDireccion);
        colores.ColorDeLabelDeLaPantalla(lblCalle);
        colores.ColorDeLabelDeLaPantalla(lblNroDireccion);
        colores.ColorDeLabelDeLaPantalla(lblPiso);
        colores.ColorDeLabelDeLaPantalla(lblDeptoDirecc);
        colores.ColorDeLabelDeLaPantalla(lblProvincia);
        colores.ColorDeLabelDeLaPantalla(lblLocalidad);
        colores.ColorDeLabelDeLaPantalla(chkbBorrado);
        
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
        
    }
    
    private void inicializarCajas() {        
        TextPrompt txtNombCli = new TextPrompt("Ingrese el Nombre", txtNombreCliente);
        txtNombCli.setForeground(Color.GRAY);
        txtNombCli.changeAlpha(0.5f);
        txtNombCli.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtNroDoc = new TextPrompt("Número de Documento", txtNroDocumento);
        txtNroDoc.setForeground(Color.GRAY);
        txtNroDoc.changeAlpha(0.5f);
        txtNroDoc.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtMail = new TextPrompt("Ingrese el E-mail", txtEmail);
        txtMail.setForeground(Color.GRAY);
        txtMail.changeAlpha(0.5f);
        txtMail.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtDirec = new TextPrompt("Ingrese el nombre de la calle", txtCalle);
        txtDirec.setForeground(Color.GRAY);
        txtDirec.changeAlpha(0.5f);
        txtDirec.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtNroDirec = new TextPrompt("Número", txtNroDireccion);
        txtNroDirec.setForeground(Color.GRAY);
        txtNroDirec.changeAlpha(0.5f);
        txtNroDirec.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtPi = new TextPrompt("Piso", txtPiso);
        txtPi.setForeground(Color.GRAY);
        txtPi.changeAlpha(0.5f);
        txtPi.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        
        TextPrompt txtDep = new TextPrompt("Depto", txtDeptoDirecc);
        txtDep.setForeground(Color.GRAY);
        txtDep.changeAlpha(0.5f);
        txtDep.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
    }
    
    private void llenarListaTipodDoc(){
        TipoDocumentoDAO tipoDocDAO = new TipoDocumentoDAO();
        LinkedList<TipoDocumento> listaTipos = tipoDocDAO.GetAllTipoDocumento();
        DefaultComboBoxModel tipo = new DefaultComboBoxModel();
        
        for (TipoDocumento tipoDoc : listaTipos) {
            tipo.addElement(tipoDoc);
        }
        cmbTipoDocumento.setModel(tipo);
    }
    
    private void llenarListaProv(){
        ProvinciaLocalidadDAO provDAO = new ProvinciaLocalidadDAO();
        LinkedList<Provincia> listaProv = provDAO.GetAllProvincias();
        DefaultComboBoxModel prov = new DefaultComboBoxModel();
        
        for (Provincia p : listaProv) {
            prov.addElement(p);
        }
        cmbProvincia.setModel(prov);
    }
    
    private void llenarListaLoc(){
        ProvinciaLocalidadDAO locDAO = new ProvinciaLocalidadDAO();
        int idProv = ((Provincia) cmbProvincia.getSelectedItem()).getIdprovincia();
        LinkedList<Localidad> listaLoc = locDAO.GetLocalidadesByIDProv(idProv);
        DefaultComboBoxModel loc = new DefaultComboBoxModel();
        
        for (Localidad l : listaLoc) {
            loc.addElement(l);
        }
        cmbLocalidad.setModel(loc);
    }
    
    private boolean camposObligatoriosLlenos(){
        boolean todosLlenos = true;
        String faltan = "Para crear el cliente debe completar los campos:";
        
        
        if(todosLlenos = false){
            JOptionPane.showMessageDialog(null, faltan);
        }
        return todosLlenos;
    }
    
    private void cargarClienteDelObjeto(){
        txtIDCliente.setText(Integer.toString(detallesCli.getIdcliente()));
        txtNombreCliente.setText(detallesCli.getRazonsocial());
        //cmbTipoDocumento.
        txtNroDocumento.setText(Long.toString(detallesCli.getNrodocumento()));
        txtEmail.setText(detallesCli.getEmail());
        txtCalle.setText(detallesCli.getDireccion().getCalle());
        txtNroDireccion.setText(Integer.toString(detallesCli.getDireccion().getNumero()));
        txtPiso.setText(Integer.toString(detallesCli.getDireccion().getPiso()));
        txtDeptoDirecc.setText(detallesCli.getDireccion().getDepartamento());
        chkbBorrado.setSelected(detallesCli.isBorrado());
        cmbTipoDocumento.setSelectedIndex(IDTipoSetSelectItemByCampo(detallesCli.getTipodocumento().getIdtipodocumento()));
        cmbProvincia.setSelectedIndex(ProvinciaClienteSetSelectItemByCampo(detallesCli.getDireccion().getProvincia().getIdprovincia()));
        cmbLocalidad.setSelectedIndex(LocalidadClienteSetSelectItemByCampo(detallesCli.getDireccion().getLocalidad().getIdlocalidad()));
        
    }
    
    private int IDTipoSetSelectItemByCampo(int idTip) {
        int i = 0;
        int itemsDelCombo = cmbTipoDocumento.getItemCount();
        for (; i < itemsDelCombo; i++) {
            if((((TipoDocumento)cmbTipoDocumento.getItemAt(i)).getIdtipodocumento()) == idTip){
                return i;
            }
        }
        return i;
    }
    
    private int ProvinciaClienteSetSelectItemByCampo(int idP) {
        int y = 0;
        int itemsDelCombo = cmbProvincia.getItemCount();
        for (; y < itemsDelCombo; y++) {
            if((((Provincia)cmbProvincia.getItemAt(y)).getIdprovincia()) == idP){
                return y;
            }
        }
        return y;
    }
    
    private int LocalidadClienteSetSelectItemByCampo(long idLoc){
        int z = 0;
        int itemsDelCombo = cmbLocalidad.getItemCount();
        for(; z < itemsDelCombo; z++){
            if((((Localidad)cmbLocalidad.getItemAt(z)).getIdlocalidad()) == idLoc){
                return z;
            }
        }
        return z;
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
        lblNombreCliente = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblTipoDocumento = new javax.swing.JLabel();
        cmbTipoDocumento = new javax.swing.JComboBox();
        lblNroDocumento = new javax.swing.JLabel();
        txtNroDocumento = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblSeccionDireccion = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        lblNroDireccion = new javax.swing.JLabel();
        txtNroDireccion = new javax.swing.JTextField();
        lblPiso = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        lblDeptoDirecc = new javax.swing.JLabel();
        txtDeptoDirecc = new javax.swing.JTextField();
        lblProvincia = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox();
        lblLocalidad = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        chkbBorrado = new javax.swing.JCheckBox();
        txtIDCliente = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblBotonAgregar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(670, 590));
        setMinimumSize(new java.awt.Dimension(670, 590));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoPP.setMinimumSize(new java.awt.Dimension(670, 590));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(670, 590));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(32767, 40));
        pnlEncabezado.setMinimumSize(new java.awt.Dimension(670, 40));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMaximumSize(new java.awt.Dimension(670, 550));
        pnlCont.setMinimumSize(new java.awt.Dimension(670, 550));
        pnlCont.setPreferredSize(new java.awt.Dimension(670, 550));
        pnlCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Administrar Clientes");
        pnlCont.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        lblNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombreCliente.setText("Nombre");
        pnlCont.add(lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, 23));

        txtNombreCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 401, -1));

        lblTipoDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTipoDocumento.setText("Tipo de Documento");
        pnlCont.add(lblTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 23));

        pnlCont.add(cmbTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 194, -1));

        lblNroDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNroDocumento.setText("N°");
        pnlCont.add(lblNroDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        txtNroDocumento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtNroDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 167, -1));

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEmail.setText("E-mail");
        pnlCont.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, 23));

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 401, -1));
        pnlCont.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 582, -1));

        lblSeccionDireccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSeccionDireccion.setText("DIRECCIÓN");
        pnlCont.add(lblSeccionDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        lblCalle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCalle.setText("Calle");
        pnlCont.add(lblCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 23));

        txtCalle.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 401, -1));

        lblNroDireccion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNroDireccion.setText("Altura (n°)");
        pnlCont.add(lblNroDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, 23));

        txtNroDireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtNroDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 141, -1));

        lblPiso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPiso.setText("Piso");
        pnlCont.add(lblPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        txtPiso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 51, -1));

        lblDeptoDirecc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDeptoDirecc.setText("Depto");
        pnlCont.add(lblDeptoDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        txtDeptoDirecc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlCont.add(txtDeptoDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 51, -1));

        lblProvincia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProvincia.setText("Provincia");
        pnlCont.add(lblProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, 23));

        cmbProvincia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });
        pnlCont.add(cmbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 401, -1));

        lblLocalidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLocalidad.setText("Localidad");
        pnlCont.add(lblLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, 23));

        cmbLocalidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pnlCont.add(cmbLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 401, -1));
        pnlCont.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 582, 10));

        chkbBorrado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        chkbBorrado.setText("¿Cliente borrado?");
        chkbBorrado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlCont.add(chkbBorrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, -1));
        pnlCont.add(txtIDCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 306, -1));
        pnlCont.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 582, 10));

        lblBotonAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/mas-en-circulo-negro.png"))); // NOI18N
        lblBotonAgregar.setText("Agregar");
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
        pnlCont.add(lblBotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 140, 50));

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
        pnlCont.add(lblBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 140, 50));

        pnlFondoPP.add(pnlCont, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlFondoPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
        if(evt.getStateChange() == 1){
            llenarListaLoc();
            cmbLocalidad.setEnabled(true);
            //btnCargar.setEnabled(false);
        }
    }//GEN-LAST:event_cmbProvinciaItemStateChanged

    private void lblBotonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseClicked
        if(lblBotonAgregar.isEnabled()){
            ClienteDAO cliDAO = new ClienteDAO();
            ClienteConDirecc cli = new ClienteConDirecc();

        //if(camposObligatoriosLlenos()){
            cli = CargarObjetoClienteConDirecc();
            switch(metodo){
                case(INSERT):
                    if(cliDAO.AgregarClienteConDirecc(cli) > 0){
                        dispose();
                    }
                    break;
                case(UPDATE):
                    if(cliDAO.ActualizarClienteConDirecc(cli) > 0){
                        dispose();
                    }
                    break;
            }
        //}
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

    private void lblBotonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCancelarMouseClicked
        dispose();
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

    private ClienteConDirecc CargarObjetoClienteConDirecc(){
        //ClienteConDirecc cli = new ClienteConDirecc();
        int idCli=0;
        if(!(txtIDCliente.getText().isEmpty())){
            idCli = Integer.parseInt(txtIDCliente.getText());
        }
        
        int idTipoDoc = ((TipoDocumento) cmbTipoDocumento.getSelectedItem()).getIdtipodocumento();
        String tipoDoc = ((TipoDocumento) cmbTipoDocumento.getSelectedItem()).getDescripcion();
        TipoDocumento tipo = new TipoDocumento(idTipoDoc, tipoDoc);
        long nroDoc = Long.parseLong(txtNroDocumento.getText());
        String nombre = txtNombreCliente.getText();
        String email = txtEmail.getText();
        boolean borrado = chkbBorrado.isSelected();        
        String calle = txtCalle.getText();
        int numDir = 0;
        if(!(txtNroDireccion.getText().isEmpty())){
            numDir = (Integer.parseInt(txtNroDireccion.getText()));
        }
        int pisoDir = 0;
        if(!(txtDeptoDirecc.getText().isEmpty())){
            pisoDir = (Integer.parseInt(txtPiso.getText()));
        }
        String deptoDir = txtDeptoDirecc.getText();
        
        long idLoc = ((Localidad) cmbLocalidad.getSelectedItem()).getIdlocalidad();
        String nombLoc = ((Localidad) cmbLocalidad.getSelectedItem()).getNombre();
        String deptoLoc = ((Localidad) cmbLocalidad.getSelectedItem()).getNom_departamento();
        int idProv = ((Provincia) cmbProvincia.getSelectedItem()).getIdprovincia();
        String NombProv = ((Provincia) cmbProvincia.getSelectedItem()).getNombre();
        Provincia prov = new Provincia(idProv, NombProv);
        Localidad loc = new Localidad(idLoc, nombLoc, deptoLoc, prov);
        Direccion direc = new Direccion(nroDoc, calle, numDir, pisoDir, deptoDir, loc, prov);
        ClienteConDirecc cli = new ClienteConDirecc(idCli, tipo, nroDoc, nombre, email, borrado, direc);

        return cli;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkbBorrado;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbTipoDocumento;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblBotonAgregar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblDeptoDirecc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNroDireccion;
    private javax.swing.JLabel lblNroDocumento;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSeccionDireccion;
    private javax.swing.JLabel lblTipoDocumento;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtDeptoDirecc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNroDireccion;
    private javax.swing.JTextField txtNroDocumento;
    private javax.swing.JTextField txtPiso;
    // End of variables declaration//GEN-END:variables
}
