package UI;

import DAO.UsuarioDao;
import Identidades.ImagenFondo;
import Identidades.Usuario;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarUsuariosUI extends javax.swing.JDialog {
    private final int INSERT = 1;
    private final int UPDATE = 2;
    int metodo;
//    ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();
    
//DESPUES DE SELECCIONAR UN USUARIO COMO VUELVO PARA CREAR UNO NUEVO?????
    public MostrarUsuariosUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //inicializarCajas();
//        Toolkit miForm = Toolkit.getDefaultToolkit();
//        Image miIcono = miForm.getImage("src/Images/logo_icono_001.png");
//        setIconImage(miIcono);
        Image miIcono = Toolkit.getDefaultToolkit().getImage("/Images/LogoSolo_FondoSombra_icono.ico");
        parent.setIconImage(miIcono);
        setTitle("Usuarios");
        
        txtMostrarUserID.setVisible(false);
        IniciarPantalla();
        
        lblBotonSalir.setEnabled(true);
        
//        Container contenedor = getContentPane();//¿Puede ir en este archivos??? 
//        p.setRuta("/Images/vendedores-analizan-sus-ventas.jpg");
        //this.setContentPane(p);
        
    }
    
    private void IniciarPantalla() {
        txtMostrarUserNombre.setText("");
        txtMostrarUserContrasenia.setText("");
        txtMostrarUserID.setText("");
        inicializarCajas();
        txtMostrarUserNombre.setEnabled(false);
        txtMostrarUserContrasenia.setEnabled(false);
        //txtMostrarUserNombre.requestFocus();
//        btnMostrarUserAgregar.setEnabled(true);
//        btnMostrarUserModificar.setEnabled(false);
//        btnMostrarUserGuardar.setEnabled(false);
//        btnMostrarUserBorrar.setEnabled(false);
        
        //Estado de los Botones Label
        lblBotonAgregar.setEnabled(true);
        lblBotonModificar.setEnabled(false);
        lblBotonBorrar.setEnabled(false);
        lblBotonGuardar.setEnabled(false);
        lblBotonSalir.setEnabled(true);
        
        InitUsuarioGrid();
        
        //Colores
        colores.ColorDeEncabezadoDePantalla(pnlEncabezado);
        colores.ColorDeXParaCerrar(lblXCerrar);
        colores.ColorDeCuerpoDeLaPantalla(pnlCont1);
        colores.ColorDeLabelDeLaPantalla(lblMostrarUserTitulo);
        colores.ColorDeLabelDeLaPantalla(lblMostrarUserNombre);
        colores.ColorDeLabelDeLaPantalla(lblMostrarUserContrasenia);
        //colores.ColorDeLabelDeLaPantalla(lblMostrarUserTitulo);
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
        colores.ColorDeBotonLabelPantalla(lblBotonBorrar);
        colores.ColorDeBotonLabelPantalla(lblBotonGuardar);
        colores.ColorDeBotonLabelPantalla(lblBotonSalir);
    }

    private void inicializarCajas() {
        TextPrompt txtCrearUsrNombre = new TextPrompt("Ingrese el nombre", txtMostrarUserNombre);
        txtCrearUsrNombre.setForeground(Color.GRAY);
        txtCrearUsrNombre.changeAlpha(0.5f);
        txtCrearUsrNombre.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        TextPrompt txtCrearUsrcontrasenia = new TextPrompt("Ingrese la contraseña", txtMostrarUserContrasenia);
        txtCrearUsrcontrasenia.setForeground(Color.GRAY);
        txtCrearUsrcontrasenia.changeAlpha(0.5f);
        txtCrearUsrcontrasenia.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
    }
    
    private void InitUsuarioGrid() {
        UsuarioDao uDAO = new UsuarioDao();
        LinkedList<Usuario> userList = uDAO.GetAllUsers();        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Usuario");  // Acá definimos las Columnas del Modelo
        modelo.addColumn("Nombre");
        modelo.addColumn("Contraseña");
        // Acá cargamos las FILAS del Modelo
        Object[] datos = new Object[3];//   |  ID  |  Nombre  | Contraseña  |
        for (Usuario dato : userList) {
            datos[0] = dato.getIdusuario();
            datos[1] = dato.getNombre();
            datos[2] = dato.getContrasenia();
            modelo.addRow(datos);
        }
        tblMostrarUser.setModel(modelo);
        tblMostrarUser.getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarUser.getColumnModel().getColumn(0).setMinWidth(0);
        tblMostrarUser.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblMostrarUser.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoUsuarios = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        lblXCerrar = new javax.swing.JLabel();
        pnlCont1 = new javax.swing.JPanel();
        lblMostrarUserTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrarUser = new javax.swing.JTable();
        lblMostrarUserNombre = new javax.swing.JLabel();
        lblMostrarUserContrasenia = new javax.swing.JLabel();
        txtMostrarUserNombre = new javax.swing.JTextField();
        txtMostrarUserContrasenia = new javax.swing.JTextField();
        txtMostrarUserID = new javax.swing.JTextField();
        lblBotonAgregar = new javax.swing.JLabel();
        lblBotonModificar = new javax.swing.JLabel();
        lblBotonBorrar = new javax.swing.JLabel();
        lblBotonGuardar = new javax.swing.JLabel();
        lblBotonSalir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        //this.setContentPane(p);
        pnlFondoUsuarios.setBackground(new java.awt.Color(0, 51, 204));
        pnlFondoUsuarios.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnlFondoUsuariosComponentResized(evt);
            }
        });
        pnlFondoUsuarios.setLayout(new java.awt.BorderLayout());

        pnlEncabezado.setMinimumSize(new java.awt.Dimension(730, 40));
        pnlEncabezado.setPreferredSize(new java.awt.Dimension(730, 40));

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FenixDoradoTextoDerechaBlanco35Alto.png"))); // NOI18N

        lblXCerrar.setBackground(new java.awt.Color(255, 0, 0));
        lblXCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblXCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblXCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXCerrar.setText("X");
        lblXCerrar.setOpaque(true);
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
                .addContainerGap()
                .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblXCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlFondoUsuarios.add(pnlEncabezado, java.awt.BorderLayout.NORTH);

        pnlCont1.setMinimumSize(new java.awt.Dimension(730, 439));
        pnlCont1.setName(""); // NOI18N
        pnlCont1.setPreferredSize(new java.awt.Dimension(730, 439));

        lblMostrarUserTitulo.setBackground(new java.awt.Color(255, 255, 204));
        lblMostrarUserTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblMostrarUserTitulo.setText("Usuarios");
        lblMostrarUserTitulo.setOpaque(true);

        tblMostrarUser.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMostrarUser.setRowHeight(20);
        tblMostrarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMostrarUser);

        lblMostrarUserNombre.setBackground(new java.awt.Color(255, 255, 204));
        lblMostrarUserNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMostrarUserNombre.setText("Nombre de usuario");
        lblMostrarUserNombre.setOpaque(true);

        lblMostrarUserContrasenia.setBackground(new java.awt.Color(255, 255, 204));
        lblMostrarUserContrasenia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMostrarUserContrasenia.setText("Contraseña");
        lblMostrarUserContrasenia.setOpaque(true);

        txtMostrarUserNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtMostrarUserContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtMostrarUserID.setFocusable(false);
        txtMostrarUserID.setRequestFocusEnabled(false);

        lblBotonAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/new-user.png"))); // NOI18N
        lblBotonAgregar.setText("Agregar");
        lblBotonAgregar.setAlignmentY(0.0F);
        lblBotonAgregar.setIconTextGap(10);
        lblBotonAgregar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonAgregar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonAgregar.setOpaque(true);
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
        lblBotonModificar.setIconTextGap(10);
        lblBotonModificar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonModificar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonModificar.setOpaque(true);
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
        lblBotonBorrar.setIconTextGap(10);
        lblBotonBorrar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonBorrar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonBorrar.setOpaque(true);
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
        lblBotonGuardar.setIconTextGap(10);
        lblBotonGuardar.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonGuardar.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonGuardar.setOpaque(true);
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

        lblBotonSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Iconos_40px/salida.png"))); // NOI18N
        lblBotonSalir.setText("Salir");
        lblBotonSalir.setIconTextGap(10);
        lblBotonSalir.setMaximumSize(new java.awt.Dimension(160, 45));
        lblBotonSalir.setMinimumSize(new java.awt.Dimension(160, 45));
        lblBotonSalir.setOpaque(true);
        lblBotonSalir.setPreferredSize(new java.awt.Dimension(160, 45));
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

        javax.swing.GroupLayout pnlCont1Layout = new javax.swing.GroupLayout(pnlCont1);
        pnlCont1.setLayout(pnlCont1Layout);
        pnlCont1Layout.setHorizontalGroup(
            pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCont1Layout.createSequentialGroup()
                .addGroup(pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCont1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(lblMostrarUserTitulo))
                    .addGroup(pnlCont1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCont1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblMostrarUserNombre)
                        .addGap(48, 48, 48)
                        .addComponent(txtMostrarUserNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCont1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblMostrarUserContrasenia)
                        .addGap(44, 44, 44)
                        .addComponent(txtMostrarUserContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCont1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(txtMostrarUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCont1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblBotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(lblBotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCont1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(lblBotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        pnlCont1Layout.setVerticalGroup(
            pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCont1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMostrarUserTitulo)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMostrarUserNombre)
                    .addComponent(txtMostrarUserNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMostrarUserContrasenia)
                    .addComponent(txtMostrarUserContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCont1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtMostrarUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblBotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCont1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pnlFondoUsuarios.add(pnlCont1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMostrarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarUserMouseClicked
        //Usuario u = new Usuario();
        int id = (int) tblMostrarUser.getValueAt((int) tblMostrarUser.getSelectedRow(), 0);
        //UsuarioDao uDAO = new UsuarioDao();
        //u = uDAO.getUsuarioByID(id);
        //txtMostrarUserNombre.setText(u.getNombre());
        //txtMostrarUserContrasenia.setText(u.getContrasenia());
        //txtMostrarUserID.setText(Integer.toString(u.getIdusuario()));
        //****  TRATAR DE USAR LOS DATOS DE LA GRILLA   ****
        //System.out.println(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 0));
        //System.out.println(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 1));
        //System.out.println(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 2));
        txtMostrarUserID.setText(Integer.toString(id));
        txtMostrarUserNombre.setText((String)(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 1)));
        txtMostrarUserContrasenia.setText((String)(tblMostrarUser.getValueAt(tblMostrarUser.getSelectedRow(), 2)));
        
        txtMostrarUserNombre.setEnabled(false);
        txtMostrarUserContrasenia.setEnabled(false);
//        btnMostrarUserAgregar.setEnabled(false);
//        btnMostrarUserModificar.setEnabled(true);
//        btnMostrarUserGuardar.setEnabled(false);
//        btnMostrarUserBorrar.setEnabled(true);
        
        lblBotonAgregar.setEnabled(false);
        lblBotonModificar.setEnabled(true);
        lblBotonBorrar.setEnabled(true);
        lblBotonGuardar.setEnabled(false);
    }//GEN-LAST:event_tblMostrarUserMouseClicked

    private void pnlFondoUsuariosComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlFondoUsuariosComponentResized
//        pnlCont1.setLocation(((pnlFondoUsuarios.getWidth()/2)-(pnlCont1.getWidth()/2)),((pnlFondoUsuarios.getHeight()/2)-(pnlCont1.getHeight()/2)));
    }//GEN-LAST:event_pnlFondoUsuariosComponentResized

    private void lblXCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_lblXCerrarMouseClicked

    private void lblXCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseEntered
        colores.ColorDeXParaCerrarOver(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseEntered

    private void lblXCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXCerrarMouseExited
        colores.ColorDeXParaCerrar(lblXCerrar);
    }//GEN-LAST:event_lblXCerrarMouseExited

    private void lblBotonAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseEntered
        if(lblBotonAgregar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonAgregar);
        }
    }//GEN-LAST:event_lblBotonAgregarMouseEntered

    private void lblBotonAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonAgregar);
    }//GEN-LAST:event_lblBotonAgregarMouseExited

    private void lblBotonModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseEntered
        if(lblBotonModificar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonModificar);
        }
    }//GEN-LAST:event_lblBotonModificarMouseEntered

    private void lblBotonModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonModificar);
    }//GEN-LAST:event_lblBotonModificarMouseExited

    private void lblBotonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonAgregarMouseClicked
        if(lblBotonAgregar.isEnabled()){
            txtMostrarUserNombre.setEnabled(true);
            txtMostrarUserContrasenia.setEnabled(true);

            lblBotonAgregar.setEnabled(false);
            lblBotonModificar.setEnabled(false);
            lblBotonBorrar.setEnabled(false);
            lblBotonGuardar.setEnabled(true);

            metodo = INSERT;
        }
    }//GEN-LAST:event_lblBotonAgregarMouseClicked

    private void lblBotonBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBorrarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonBorrar);
    }//GEN-LAST:event_lblBotonBorrarMouseExited

    private void lblBotonBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBorrarMouseEntered
        if(lblBotonBorrar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonBorrar);
        }
    }//GEN-LAST:event_lblBotonBorrarMouseEntered

    private void lblBotonGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGuardarMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonGuardar);
    }//GEN-LAST:event_lblBotonGuardarMouseExited

    private void lblBotonGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGuardarMouseEntered
        if(lblBotonGuardar.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonGuardar);
        }
    }//GEN-LAST:event_lblBotonGuardarMouseEntered

    private void lblBotonSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseExited
        colores.ColorDeBotonLabelPantalla(lblBotonSalir);
    }//GEN-LAST:event_lblBotonSalirMouseExited

    private void lblBotonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseEntered
        if(lblBotonSalir.isEnabled()){
            colores.ColorDeBotonLabelPantallaOver(lblBotonSalir);
        }
    }//GEN-LAST:event_lblBotonSalirMouseEntered

    private void lblBotonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonBorrarMouseClicked
        if(lblBotonBorrar.isEnabled()){
            if(!(txtMostrarUserID.getText().isEmpty())){
                int idUsr = (Integer.parseInt(txtMostrarUserID.getText()));
                UsuarioDao usrDAO = new UsuarioDao();
                if(usrDAO.BorrarUsuario(idUsr) > 0){
                    JOptionPane.showMessageDialog(null, "Usuario borrado con exito.");
                    IniciarPantalla();
                    InitUsuarioGrid();
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar borrar el usuario.");
                    IniciarPantalla();
                    InitUsuarioGrid();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrió un error tratando de ubicar el usuario a borrar.");
                IniciarPantalla();
                InitUsuarioGrid();
            }
        }
    }//GEN-LAST:event_lblBotonBorrarMouseClicked

    private void lblBotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonGuardarMouseClicked
        if(lblBotonGuardar.isEnabled()){
            switch(metodo){
                case INSERT:
                    if(!((txtMostrarUserNombre.getText().isEmpty())||(txtMostrarUserContrasenia.getText().isEmpty()))){
                        Usuario usr = new Usuario();
                        UsuarioDao usrDAO = new UsuarioDao();
                        usr.setNombre(txtMostrarUserNombre.getText());
                        usr.setContrasenia(txtMostrarUserContrasenia.getText());

                        if(usrDAO.CrearUsuario(usr) > 0){
                            //System.out.println("El usuario se creó con exito!!");
                            JOptionPane.showMessageDialog(null, "El usuario se creó con exito!!!");
                            //this.dispose();
                        }else{
                            //JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el usuario");
                            txtMostrarUserNombre.requestFocus();
                        }
                    }else{
                        if(txtMostrarUserNombre.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "El Usuario no puede estar vacio");
                            txtMostrarUserNombre.requestFocus();
                        }else{
                            if(txtMostrarUserContrasenia.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null, "La Contraseña no puede estar vacia");
                                txtMostrarUserContrasenia.requestFocus();
                            }
                        }
                    }
                    break;
                case UPDATE:
                    if(!((txtMostrarUserNombre.getText().isEmpty())||(txtMostrarUserContrasenia.getText().isEmpty())||(txtMostrarUserID.getText().isEmpty()))){
                        Usuario usr = new Usuario();
                        UsuarioDao usrDAO = new UsuarioDao();
                        usr.setIdusuario(Integer.parseInt(txtMostrarUserID.getText()));
                        usr.setNombre(txtMostrarUserNombre.getText());
                        usr.setContrasenia(txtMostrarUserContrasenia.getText());

                        if(usrDAO.ModificarUsuario(usr) > 0){
                            IniciarPantalla();
                            InitUsuarioGrid();
                        }else{
                            txtMostrarUserNombre.requestFocus();
                            txtMostrarUserNombre.selectAll();
                        }
                    }else{
                        if(txtMostrarUserID.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Ocurrió un error tratando de ubicar el usuario a modificar.");
                            //txtMostrarUserNombre.requestFocus();
                        }else{
                            if(txtMostrarUserNombre.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio");
                            txtMostrarUserNombre.requestFocus();
                            txtMostrarUserNombre.selectAll();
                            }else{
                                if(txtMostrarUserContrasenia.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "La Contraseña no puede estar vacia");
                                    txtMostrarUserContrasenia.requestFocus();
                                    txtMostrarUserContrasenia.selectAll();
                                }
                            }
                        }
                    }                
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrió un error desconocido");
                    break;
            }
            IniciarPantalla();
            InitUsuarioGrid();
        }
    }//GEN-LAST:event_lblBotonGuardarMouseClicked

    private void lblBotonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonSalirMouseClicked
        if(lblBotonSalir.isEnabled()){
            dispose();
        }
    }//GEN-LAST:event_lblBotonSalirMouseClicked

    private void lblBotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonModificarMouseClicked
        if(lblBotonModificar.isEnabled()){
            txtMostrarUserNombre.setEnabled(true);
            txtMostrarUserContrasenia.setEnabled(true);

            lblBotonAgregar.setEnabled(false);
            lblBotonModificar.setEnabled(false);
            lblBotonBorrar.setEnabled(false);
            lblBotonGuardar.setEnabled(true);

            txtMostrarUserContrasenia.requestFocus();
            txtMostrarUserContrasenia.selectAll();
            metodo = UPDATE;
        }
    }//GEN-LAST:event_lblBotonModificarMouseClicked
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBotonAgregar;
    private javax.swing.JLabel lblBotonBorrar;
    private javax.swing.JLabel lblBotonGuardar;
    private javax.swing.JLabel lblBotonModificar;
    private javax.swing.JLabel lblBotonSalir;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblMostrarUserContrasenia;
    private javax.swing.JLabel lblMostrarUserNombre;
    private javax.swing.JLabel lblMostrarUserTitulo;
    private javax.swing.JLabel lblXCerrar;
    private javax.swing.JPanel pnlCont1;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondoUsuarios;
    private javax.swing.JTable tblMostrarUser;
    private javax.swing.JTextField txtMostrarUserContrasenia;
    private javax.swing.JTextField txtMostrarUserID;
    private javax.swing.JTextField txtMostrarUserNombre;
    // End of variables declaration//GEN-END:variables
}
