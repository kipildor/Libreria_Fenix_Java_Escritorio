package UI;

import DAO.ProvinciaLocalidadDAO;
import Identidades.ImagenFondo;
//import DAO.TemaDAO;
import Identidades.Localidad;
import Identidades.Provincia;
//import Identidades.Tema;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminLocalidadesUI extends javax.swing.JDialog {
    private final int INSERT = 1;
    private final int UPDATE = 2;
    int metodo;
//    ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();

    public AdminLocalidadesUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);        
        initComponents();        
        setTitle("Localidades y Departamentos.");
        LlenarComboProvincias1();
        LlenarComboProvincias2();
        inicializarCajas();
        inicializarPantalla();
        //txtLocSelec.setEnabled(false);
        
//        Container contenedor = getContentPane();
//        p.setRuta("/Images/banderaArgentina.jpg");
    }
    
    private void inicializarCajas() {
        TextPrompt txtNombLoc = new TextPrompt("Nombre de la Localidad", txtLocSelec);
        txtNombLoc.setForeground(Color.GRAY);
        txtNombLoc.changeAlpha(0.5f);
        txtNombLoc.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        TextPrompt txtDepartLoc = new TextPrompt("Departamento al que pertenece", txtDepartSelec);
        txtDepartLoc.setForeground(Color.GRAY);
        txtDepartLoc.changeAlpha(0.5f);
        txtDepartLoc.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
    }
    
    private int ProvSetSelectItemByCampo(int idP) {
        int i = 0;
        int itemsDelCombo = cmbProvSelec.getItemCount();
        for (; i < itemsDelCombo; i++) {
            if((((Provincia)cmbProvSelec.getItemAt(i)).getIdprovincia()) == idP){
                return i;
            }
        }
        return i;
    }
    
    private void inicializarPantalla(){
        cmbProvincia.setSelectedIndex(0);
        //cmbLocalidad.setSelectedIndex(0);
        txtLocSelec.setText("");
        txtDepartSelec.setText("");
        //cmbProvSelec.setSelectedIndex(0);
        
        cmbProvincia.setEnabled(true);
        cmbLocalidad.setEnabled(false);
        txtLocSelec.setEnabled(false);
        txtDepartSelec.setEnabled(false);
        cmbProvSelec.setEnabled(false);
        
        //Estado de los botones Label
        lblBotonCargar.setEnabled(false);/**false**/
        lblBotonAgregar.setEnabled(true);
        lblBotonModificar.setEnabled(false);
        lblBotonBorrar.setEnabled(false);
        lblBotonGuardar.setEnabled(false);
        lblBotonCancelar.setText("Salir");
        txtIDLocSelec.setVisible(false);
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont);
        colores.ColorDeLabelDeLaPantalla(lblTitulo);
        colores.ColorDeLabelDeLaPantalla(lblProvincia);
        colores.ColorDeLabelDeLaPantalla(lblLocalidad);
        colores.ColorDeLabelDeLaPantalla(lblLocSelec);
        colores.ColorDeLabelDeLaPantalla(lblDepartSelec);
        colores.ColorDeLabelDeLaPantalla(lblProvSelec);
        
        colores.ColorDeBotonLabelPantalla(lblBotonCargar);
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
        colores.ColorDeBotonLabelPantalla(lblBotonBorrar);
        colores.ColorDeBotonLabelPantalla(lblBotonGuardar);
        colores.ColorDeBotonLabelPantalla(lblBotonCancelar);
    }
    
    private void LlenarComboProvincias1(){
        ProvinciaLocalidadDAO provDAO = new ProvinciaLocalidadDAO();
        DefaultComboBoxModel prov = new DefaultComboBoxModel();
        LinkedList<Provincia> lista = provDAO.GetAllProvincias();
        //prov.addElement("Seleccione una Provincia");//yo saque
        /*    lista.forEach((provincia) -> {
            prov.addElement(provincia);
        });
         */
        for (Provincia provincia : lista) {
            prov.addElement(provincia);
        }
        cmbProvincia.setModel(prov);
    }
    
    private void LlenarComboLocalidades(){
        //Provincia pro = new Provincia();
        ProvinciaLocalidadDAO locDAO = new ProvinciaLocalidadDAO();
        DefaultComboBoxModel loc = new DefaultComboBoxModel();
        int idProv = ((Provincia) cmbProvincia.getSelectedItem()).getIdprovincia();
        LinkedList<Localidad> listaLoc = locDAO.GetLocalidadesByIDProv(idProv);
        //loc.addElement("Seleccione la Localidad");//yo saque
        for (Localidad lo : listaLoc) {
            loc.addElement(lo);
        }
        cmbLocalidad.setModel(loc);
    }
    
    private void LlenarComboProvincias2(){
        ProvinciaLocalidadDAO provDAO2 = new ProvinciaLocalidadDAO();
        DefaultComboBoxModel prov = new DefaultComboBoxModel();
        LinkedList<Provincia> listaProv2 = provDAO2.GetAllProvincias();
        //prov.addElement("Seleccione la Provincia");//yo saque
        for (Provincia p : listaProv2) {
            prov.addElement(p);
        }
        cmbProvSelec.setModel(prov);
    }
    
    private boolean CamposLlenos(){
        boolean llenos = true;
        if(txtLocSelec.getText().isEmpty()){
            llenos = false;
            JOptionPane.showMessageDialog(null, "El campo del nombre de la Localidad no puede estar vacio.");
            txtLocSelec.requestFocus();
        }else{
            if(txtDepartSelec.getText().isEmpty()){
                llenos = false;
                JOptionPane.showMessageDialog(null, "El campo del nombre del Departamento no puede estar vacio.");
                txtDepartSelec.requestFocus();
            }else{
                if(cmbProvSelec.getSelectedIndex() == 0){
                    llenos = false;
                    JOptionPane.showMessageDialog(null, "Debe seleccionar a que Provincia pertenece la Localidad..");
                }
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
        lblProvincia = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox();
        cmbLocalidad = new javax.swing.JComboBox();
        lblBotonCargar = new javax.swing.JLabel();
        lblBotonAgregar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLocSelec = new javax.swing.JLabel();
        lblDepartSelec = new javax.swing.JLabel();
        lblProvSelec = new javax.swing.JLabel();
        txtLocSelec = new javax.swing.JTextField();
        txtDepartSelec = new javax.swing.JTextField();
        cmbProvSelec = new javax.swing.JComboBox();
        lblBotonModificar = new javax.swing.JLabel();
        lblBotonBorrar = new javax.swing.JLabel();
        lblBotonGuardar = new javax.swing.JLabel();
        lblBotonCancelar = new javax.swing.JLabel();
        txtIDLocSelec = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(730, 2147483647));
        setMinimumSize(new java.awt.Dimension(730, 550));
        setUndecorated(true);

        pnlFondoPP.setMinimumSize(new java.awt.Dimension(730, 590));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(730, 590));
        pnlFondoPP.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMaximumSize(new java.awt.Dimension(730, 40));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlFondoPP.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont.setMaximumSize(new java.awt.Dimension(730, 2147483647));
        pnlCont.setMinimumSize(new java.awt.Dimension(730, 510));
        pnlCont.setPreferredSize(new java.awt.Dimension(730, 510));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Administración de Localidades.");
        lblTitulo.setOpaque(true);

        lblProvincia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProvincia.setText("Provincia");
        lblProvincia.setOpaque(true);

        lblLocalidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLocalidad.setText("Localidad");
        lblLocalidad.setOpaque(true);

        cmbProvincia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });

        cmbLocalidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cmbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLocalidadItemStateChanged(evt);
            }
        });

        lblBotonCargar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBotonCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/upload.png"))); // NOI18N
        lblBotonCargar.setText("Cargar Seleccionada");
        lblBotonCargar.setMaximumSize(new java.awt.Dimension(196, 35));
        lblBotonCargar.setMinimumSize(new java.awt.Dimension(196, 35));
        lblBotonCargar.setPreferredSize(new java.awt.Dimension(196, 35));
        lblBotonCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonCargarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBotonCargarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBotonCargarMouseEntered(evt);
            }
        });

        lblBotonAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/mas-en-circulo-negro.png"))); // NOI18N
        lblBotonAgregar.setText("Agregar");
        lblBotonAgregar.setMaximumSize(new java.awt.Dimension(98, 35));
        lblBotonAgregar.setMinimumSize(new java.awt.Dimension(98, 35));
        lblBotonAgregar.setPreferredSize(new java.awt.Dimension(98, 35));
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

        lblLocSelec.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblLocSelec.setText("Nombre de la Localidad");
        lblLocSelec.setOpaque(true);

        lblDepartSelec.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDepartSelec.setText("Partido/Departamento");
        lblDepartSelec.setOpaque(true);

        lblProvSelec.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblProvSelec.setText("Provincia en la que está");
        lblProvSelec.setOpaque(true);

        txtLocSelec.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtDepartSelec.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cmbProvSelec.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblBotonModificar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBotonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/editar.png"))); // NOI18N
        lblBotonModificar.setText("Modificar");
        lblBotonModificar.setMaximumSize(new java.awt.Dimension(98, 35));
        lblBotonModificar.setMinimumSize(new java.awt.Dimension(98, 35));
        lblBotonModificar.setPreferredSize(new java.awt.Dimension(98, 35));
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

        lblBotonBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBotonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/eliminar.png"))); // NOI18N
        lblBotonBorrar.setText("Borrar");
        lblBotonBorrar.setMaximumSize(new java.awt.Dimension(98, 35));
        lblBotonBorrar.setMinimumSize(new java.awt.Dimension(98, 35));
        lblBotonBorrar.setPreferredSize(new java.awt.Dimension(98, 35));
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

        lblBotonGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/guardar.png"))); // NOI18N
        lblBotonGuardar.setText("Guardar");
        lblBotonGuardar.setMaximumSize(new java.awt.Dimension(98, 35));
        lblBotonGuardar.setMinimumSize(new java.awt.Dimension(98, 35));
        lblBotonGuardar.setPreferredSize(new java.awt.Dimension(98, 35));
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

        lblBotonCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBotonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_30px/x-cancelar.png"))); // NOI18N
        lblBotonCancelar.setText("Cancelar");
        lblBotonCancelar.setMaximumSize(new java.awt.Dimension(98, 35));
        lblBotonCancelar.setMinimumSize(new java.awt.Dimension(98, 35));
        lblBotonCancelar.setPreferredSize(new java.awt.Dimension(98, 35));
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

        txtIDLocSelec.setText("0");

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lblBotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lblLocSelec)
                        .addGap(25, 25, 25)
                        .addComponent(txtLocSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lblDepartSelec)
                        .addGap(32, 32, 32)
                        .addComponent(txtDepartSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlContLayout.createSequentialGroup()
                                .addComponent(lblBotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblBotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblBotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblBotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIDLocSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lblProvSelec)
                        .addGap(18, 18, 18)
                        .addComponent(cmbProvSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo)
                .addGap(21, 21, 21)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblProvincia))
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblLocalidad))
                    .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLocSelec)
                    .addComponent(txtLocSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDepartSelec)
                    .addComponent(txtDepartSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblProvSelec))
                    .addComponent(cmbProvSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtIDLocSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addComponent(pnlFondoPP, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
        if(evt.getStateChange() == 1){
            LlenarComboLocalidades();
            cmbLocalidad.setEnabled(true);
            lblBotonCargar.setEnabled(false);
        }
    }//GEN-LAST:event_cmbProvinciaItemStateChanged

    private void cmbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLocalidadItemStateChanged
        if(evt.getStateChange() == 1){
            lblBotonCargar.setEnabled(true);
        }
    }//GEN-LAST:event_cmbLocalidadItemStateChanged

    private void lblBotonCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCargarMouseClicked
        if(lblBotonCargar.isEnabled()){
            Provincia p = (Provincia)(cmbProvincia.getSelectedItem());
            int idProv = p.getIdprovincia();

            Localidad l = (Localidad)(cmbLocalidad.getSelectedItem());
            txtLocSelec.setText(l.getNombre());
            txtDepartSelec.setText(l.getNom_departamento());

            lblBotonModificar.setEnabled(true);
            lblBotonBorrar.setEnabled(true);
            txtIDLocSelec.setText(Long.toString(l.getIdlocalidad()));
            int nuevoIDP = ProvSetSelectItemByCampo(idProv);
//            System.out.println(nuevoIDP);
            cmbProvSelec.setSelectedIndex(nuevoIDP);
        }
    }//GEN-LAST:event_lblBotonCargarMouseClicked

    private void lblBotonCargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCargarMouseExited
        colores.Color2DeBotonLabelPantalla(lblBotonCargar);
    }//GEN-LAST:event_lblBotonCargarMouseExited

    private void lblBotonCargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCargarMouseEntered
        if(lblBotonCargar.isEnabled()){
            colores.Color2DeBotonLabelPantallaOver(lblBotonCargar);
        }
    }//GEN-LAST:event_lblBotonCargarMouseEntered

    private void lblBotonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseClicked
        if(lblBotonAgregar.isEnabled()){
            txtLocSelec.setText("");
            txtDepartSelec.setText("");
            cmbProvSelec.setSelectedIndex(0);

            cmbProvincia.setEnabled(false);
            cmbLocalidad.setEnabled(false);
            txtLocSelec.setEnabled(true);
            txtDepartSelec.setEnabled(true);
            cmbProvSelec.setEnabled(true);

            lblBotonCargar.setEnabled(false);
            lblBotonAgregar.setEnabled(false);
            lblBotonModificar.setEnabled(false);
            lblBotonBorrar.setEnabled(false);
            lblBotonGuardar.setEnabled(true);
            lblBotonCancelar.setText("Cancelar");

            metodo = INSERT;
        }
    }//GEN-LAST:event_lblBotonAgregarMouseClicked

    private void lblBotonAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseExited
        colores.Color2DeBotonLabelPantalla(lblBotonAgregar);
    }//GEN-LAST:event_lblBotonAgregarMouseExited

    private void lblBotonAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseEntered
        if(lblBotonAgregar.isEnabled()){
            colores.Color2DeBotonLabelPantallaOver(lblBotonAgregar);
        }
    }//GEN-LAST:event_lblBotonAgregarMouseEntered

    private void lblBotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseClicked
        if(lblBotonModificar.isEnabled()){
            txtLocSelec.setEnabled(true);
            txtDepartSelec.setEnabled(true);
            cmbProvSelec.setEnabled(true);

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
                ProvinciaLocalidadDAO locDAO = new ProvinciaLocalidadDAO();
                if(locDAO.BorrarLocalidad(Long.parseLong(txtIDLocSelec.getText())) > 0){
                    JOptionPane.showMessageDialog(null, "La Localidad se borró con exito.");
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
                ProvinciaLocalidadDAO locDAO = new ProvinciaLocalidadDAO();
                Localidad l = new Localidad();
                Provincia prov = new Provincia(((Provincia)cmbProvSelec.getSelectedItem()).getIdprovincia());
                if(!(txtIDLocSelec.getText().isEmpty())){
                    l.setIdlocalidad(Long.parseLong(txtIDLocSelec.getText()));
                }
                l.setNombre(txtLocSelec.getText());
                l.setNom_departamento(txtDepartSelec.getText());
                l.setProvincia(prov);
                //l.setDescripcion(txtGenero.getText());
                switch(metodo){
                    case INSERT:
                        if(locDAO.AgregarLocalidad(l) > 0){
                            JOptionPane.showMessageDialog(null, "La Localidad se insertó con exito.");
                            inicializarPantalla();
                        }
                        break;
                    case UPDATE:
                        if(locDAO.ExisteLocalidadPorID(l.getIdlocalidad())){
                            if(locDAO.ModificarLocalidad(l) > 0){
                                JOptionPane.showMessageDialog(null, "La Localidad se actualizó con exito_.");
                                inicializarPantalla();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontró un tema con ese ID.-");
                            inicializarPantalla();
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
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvSelec;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBotonAgregar;
    private javax.swing.JLabel lblBotonBorrar;
    private javax.swing.JLabel lblBotonCancelar;
    private javax.swing.JLabel lblBotonCargar;
    private javax.swing.JLabel lblBotonGuardar;
    private javax.swing.JLabel lblBotonModificar;
    private javax.swing.JLabel lblDepartSelec;
    private javax.swing.JLabel lblLocSelec;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblProvSelec;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JTextField txtDepartSelec;
    private javax.swing.JTextField txtIDLocSelec;
    private javax.swing.JTextField txtLocSelec;
    // End of variables declaration//GEN-END:variables
}
