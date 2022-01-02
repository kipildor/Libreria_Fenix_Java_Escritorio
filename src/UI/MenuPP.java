package UI;

import DAO.UsuarioDao;
import Identidades.ImagenFondo;
import Identidades.Usuario;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPP extends JFrame {
    ImagenFondo p = new ImagenFondo();
    ColoresDePantallas colores = new ColoresDePantallas();
    public MenuPP() {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("SISTEMA DE LIBRERIA");
        
//        Container contenedor = getContentPane();//¿Puede ir en este archivos??? 
        p.setRuta("/Images/estanterialibros.jpg");
//        this.setContentPane(p);
        
        Imagenes imgIco = new Imagenes();
        setIconImage(imgIco.getIconImage());
        
        InicializarPantalla();
        
    }
    
    void InicializarPantalla(){
        //Colores de Paneles
        colores.ColorMenuVerticalIzq(pnlContMenuVertical);
        colores.ColorFondoEscritorio(pnlContEscritorioDerecha);
        colores.ColorBarraVerticalChica(pnlVerticalDerecha);
        //Colores de Botones
        colores.ColorDeBoton(lblVentas);
        colores.ColorDeBoton(lblClientes);
        colores.ColorDeBoton(lblLibros);
        colores.ColorDeBoton(lblInformes);
        colores.ColorDeBoton(lblMenuSistema);
        colores.ColorDeBoton(lblUsuarios);
        colores.ColorDeBoton(lblGenerosLiterarios);
        colores.ColorDeBoton(lblTiposDeDocumentos);
        colores.ColorDeBoton(lblLocalidades);
    }
    
//    void InitForm(){
//        Toolkit miForm = Toolkit.getDefaultToolkit();
//        Image miIcono = miForm.getImage("src/Images/logo_icono_001.jpg");
//        setIconImage(miIcono);
//    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoPP = new ImagenFondo();
        this.setContentPane(p);
        pnlContMenuVertical = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        sepLogoYMenu = new javax.swing.JSeparator();
        lblVentas = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        lblLibros = new javax.swing.JLabel();
        lblInformes = new javax.swing.JLabel();
        lblMenuSistema = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        lblGenerosLiterarios = new javax.swing.JLabel();
        lblTiposDeDocumentos = new javax.swing.JLabel();
        lblLocalidades = new javax.swing.JLabel();
        lblVentas1 = new javax.swing.JLabel();
        pnlContEscritorioDerecha = new javax.swing.JPanel();
        pnlVerticalDerecha = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        mnuSistema = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenuItem();
        mnuInformes = new javax.swing.JMenuItem();
        mnuBackup = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnuABM = new javax.swing.JMenu();
        mnuClientes = new javax.swing.JMenuItem();
        mnuLibros = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExtras = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuIngresarVenta = new javax.swing.JMenuItem();
        mnuExportarVenta = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAyudaContenido = new javax.swing.JMenuItem();
        mnuAyudaAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Libreria Fenix");
        setPreferredSize(new java.awt.Dimension(900, 800));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlFondoPP.setBackground(new java.awt.Color(0, 153, 51));
        pnlFondoPP.setMinimumSize(new java.awt.Dimension(900, 750));
        pnlFondoPP.setPreferredSize(new java.awt.Dimension(1000, 848));
        pnlFondoPP.setLayout(new java.awt.BorderLayout(5, 5));

        pnlContMenuVertical.setDoubleBuffered(false);
        pnlContMenuVertical.setMaximumSize(new java.awt.Dimension(265, 2147483647));
        pnlContMenuVertical.setMinimumSize(new java.awt.Dimension(260, 60));
        pnlContMenuVertical.setPreferredSize(new java.awt.Dimension(265, 60));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fenix2_LetrasAbajoBlanco240Ancho.png"))); // NOI18N
        lblLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        sepLogoYMenu.setBackground(new java.awt.Color(0, 0, 0));
        sepLogoYMenu.setForeground(new java.awt.Color(255, 153, 0));

        lblVentas.setBackground(new java.awt.Color(0, 0, 0));
        lblVentas.setFont(new java.awt.Font("Ubuntu Light", 1, 28)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVentas.setText("Ventas");
        lblVentas.setAlignmentX(10.0F);
        lblVentas.setAlignmentY(0.0F);
        lblVentas.setOpaque(true);
        lblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVentasMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVentasMouseEntered(evt);
            }
        });

        lblClientes.setBackground(new java.awt.Color(0, 0, 0));
        lblClientes.setFont(new java.awt.Font("Ubuntu Light", 1, 28)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClientes.setText("Clientes");
        lblClientes.setAlignmentX(10.0F);
        lblClientes.setAlignmentY(0.0F);
        lblClientes.setOpaque(true);
        lblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClientesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblClientesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblClientesMouseEntered(evt);
            }
        });

        lblLibros.setBackground(new java.awt.Color(0, 0, 0));
        lblLibros.setFont(new java.awt.Font("Ubuntu Light", 1, 28)); // NOI18N
        lblLibros.setForeground(new java.awt.Color(255, 255, 255));
        lblLibros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLibros.setText("Libros");
        lblLibros.setAlignmentX(10.0F);
        lblLibros.setAlignmentY(0.0F);
        lblLibros.setOpaque(true);
        lblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLibrosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLibrosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLibrosMouseEntered(evt);
            }
        });

        lblInformes.setBackground(new java.awt.Color(0, 0, 0));
        lblInformes.setFont(new java.awt.Font("Ubuntu Light", 1, 28)); // NOI18N
        lblInformes.setForeground(new java.awt.Color(255, 255, 255));
        lblInformes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInformes.setText("Informes");
        lblInformes.setAlignmentX(10.0F);
        lblInformes.setAlignmentY(0.0F);
        lblInformes.setOpaque(true);
        lblInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInformesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInformesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInformesMouseEntered(evt);
            }
        });

        lblMenuSistema.setBackground(new java.awt.Color(0, 0, 0));
        lblMenuSistema.setFont(new java.awt.Font("Ubuntu Light", 1, 28)); // NOI18N
        lblMenuSistema.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuSistema.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenuSistema.setText("Sistema");
        lblMenuSistema.setAlignmentX(10.0F);
        lblMenuSistema.setAlignmentY(0.0F);
        lblMenuSistema.setOpaque(true);

        lblUsuarios.setBackground(new java.awt.Color(0, 0, 0));
        lblUsuarios.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        lblUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsuarios.setText("Usuarios");
        lblUsuarios.setAlignmentX(10.0F);
        lblUsuarios.setAlignmentY(0.0F);
        lblUsuarios.setOpaque(true);
        lblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUsuariosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUsuariosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUsuariosMouseEntered(evt);
            }
        });

        lblGenerosLiterarios.setBackground(new java.awt.Color(0, 0, 0));
        lblGenerosLiterarios.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        lblGenerosLiterarios.setForeground(new java.awt.Color(255, 255, 255));
        lblGenerosLiterarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGenerosLiterarios.setText("Géneros Literarios");
        lblGenerosLiterarios.setAlignmentX(10.0F);
        lblGenerosLiterarios.setAlignmentY(0.0F);
        lblGenerosLiterarios.setOpaque(true);
        lblGenerosLiterarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGenerosLiterariosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGenerosLiterariosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGenerosLiterariosMouseEntered(evt);
            }
        });

        lblTiposDeDocumentos.setBackground(new java.awt.Color(0, 0, 0));
        lblTiposDeDocumentos.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        lblTiposDeDocumentos.setForeground(new java.awt.Color(255, 255, 255));
        lblTiposDeDocumentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTiposDeDocumentos.setText("Tipos de Documentos");
        lblTiposDeDocumentos.setAlignmentX(10.0F);
        lblTiposDeDocumentos.setAlignmentY(0.0F);
        lblTiposDeDocumentos.setOpaque(true);
        lblTiposDeDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTiposDeDocumentosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTiposDeDocumentosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTiposDeDocumentosMouseEntered(evt);
            }
        });

        lblLocalidades.setBackground(new java.awt.Color(0, 0, 0));
        lblLocalidades.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        lblLocalidades.setForeground(new java.awt.Color(255, 255, 255));
        lblLocalidades.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLocalidades.setText("Localidades");
        lblLocalidades.setAlignmentX(10.0F);
        lblLocalidades.setAlignmentY(0.0F);
        lblLocalidades.setOpaque(true);
        lblLocalidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLocalidadesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLocalidadesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLocalidadesMouseEntered(evt);
            }
        });

        lblVentas1.setBackground(new java.awt.Color(0, 0, 0));
        lblVentas1.setFont(new java.awt.Font("Ubuntu Light", 1, 28)); // NOI18N
        lblVentas1.setForeground(new java.awt.Color(255, 255, 255));
        lblVentas1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVentas1.setText("VentasPaneles");
        lblVentas1.setAlignmentX(10.0F);
        lblVentas1.setAlignmentY(0.0F);
        lblVentas1.setOpaque(true);
        lblVentas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentas1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVentas1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVentas1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlContMenuVerticalLayout = new javax.swing.GroupLayout(pnlContMenuVertical);
        pnlContMenuVertical.setLayout(pnlContMenuVerticalLayout);
        pnlContMenuVerticalLayout.setHorizontalGroup(
            pnlContMenuVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContMenuVerticalLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlContMenuVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTiposDeDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocalidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenerosLiterarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
            .addGroup(pnlContMenuVerticalLayout.createSequentialGroup()
                .addGroup(pnlContMenuVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContMenuVerticalLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlContMenuVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMenuSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlContMenuVerticalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sepLogoYMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContMenuVerticalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContMenuVerticalLayout.setVerticalGroup(
            pnlContMenuVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContMenuVerticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepLogoYMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lblClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblMenuSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGenerosLiterarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTiposDeDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lblVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlFondoPP.add(pnlContMenuVertical, java.awt.BorderLayout.WEST);

        javax.swing.GroupLayout pnlContEscritorioDerechaLayout = new javax.swing.GroupLayout(pnlContEscritorioDerecha);
        pnlContEscritorioDerecha.setLayout(pnlContEscritorioDerechaLayout);
        pnlContEscritorioDerechaLayout.setHorizontalGroup(
            pnlContEscritorioDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        pnlContEscritorioDerechaLayout.setVerticalGroup(
            pnlContEscritorioDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );

        pnlFondoPP.add(pnlContEscritorioDerecha, java.awt.BorderLayout.CENTER);

        pnlVerticalDerecha.setMaximumSize(new java.awt.Dimension(9, 32767));
        pnlVerticalDerecha.setPreferredSize(new java.awt.Dimension(9, 848));

        javax.swing.GroupLayout pnlVerticalDerechaLayout = new javax.swing.GroupLayout(pnlVerticalDerecha);
        pnlVerticalDerecha.setLayout(pnlVerticalDerechaLayout);
        pnlVerticalDerechaLayout.setHorizontalGroup(
            pnlVerticalDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlVerticalDerechaLayout.setVerticalGroup(
            pnlVerticalDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );

        pnlFondoPP.add(pnlVerticalDerecha, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlFondoPP);

        mnuSistema.setMnemonic('s');
        mnuSistema.setText("Sistema");
        mnuSistema.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        mnuUsuarios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuUsuarios.setMnemonic('u');
        mnuUsuarios.setText("Usuarios");
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });
        mnuSistema.add(mnuUsuarios);

        mnuInformes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuInformes.setMnemonic('i');
        mnuInformes.setText("Informes");
        mnuInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformesActionPerformed(evt);
            }
        });
        mnuSistema.add(mnuInformes);

        mnuBackup.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuBackup.setMnemonic('b');
        mnuBackup.setText("BackUp");
        mnuSistema.add(mnuBackup);

        mnuSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuSalir.setMnemonic('s');
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuSistema.add(mnuSalir);

        menuBar.add(mnuSistema);

        mnuABM.setMnemonic('a');
        mnuABM.setText("ABM");
        mnuABM.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        mnuClientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuClientes.setText("Clientes");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        mnuABM.add(mnuClientes);

        mnuLibros.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuLibros.setText("Libros");
        mnuLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLibrosActionPerformed(evt);
            }
        });
        mnuABM.add(mnuLibros);
        mnuABM.add(jSeparator1);

        mnuExtras.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuExtras.setText("Extras");
        mnuExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExtrasActionPerformed(evt);
            }
        });
        mnuABM.add(mnuExtras);

        menuBar.add(mnuABM);

        mnuVentas.setMnemonic('v');
        mnuVentas.setText("Ventas");
        mnuVentas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        mnuIngresarVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuIngresarVenta.setMnemonic('v');
        mnuIngresarVenta.setText("Ingresar Venta");
        mnuIngresarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngresarVentaActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuIngresarVenta);

        mnuExportarVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuExportarVenta.setMnemonic('e');
        mnuExportarVenta.setText("Exportar");
        mnuVentas.add(mnuExportarVenta);

        menuBar.add(mnuVentas);

        mnuAyuda.setMnemonic('y');
        mnuAyuda.setText("Ayuda");
        mnuAyuda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        mnuAyudaContenido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuAyudaContenido.setMnemonic('c');
        mnuAyudaContenido.setText("Contenido");
        mnuAyudaContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaContenidoActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaContenido);

        mnuAyudaAcercaDe.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mnuAyudaAcercaDe.setMnemonic('a');
        mnuAyudaAcercaDe.setText("Acerca de...");
        mnuAyudaAcercaDe.setToolTipText("");
        mnuAyudaAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaAcercaDe);

        menuBar.add(mnuAyuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed
        //UsuarioDao usrDAO = new UsuarioDao();
        //LinkedList<Usuario> listaUsr = new LinkedList<>();
        //listaUsr = usrDAO.GetAllUsers();
        MostrarUsuariosUI panelUsu = new MostrarUsuariosUI(this, true);
        panelUsu.setLocationRelativeTo(null);
        panelUsu.setVisible(true);
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void mnuLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLibrosActionPerformed
        AdministrarLibrosUI panelLibros = new AdministrarLibrosUI(this, true);
        panelLibros.setLocationRelativeTo(null);
        //panelLibros.setVisible(rootPaneCheckingEnabled);
        panelLibros.setVisible(true);
    }//GEN-LAST:event_mnuLibrosActionPerformed

    private void mnuExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExtrasActionPerformed
        ExtrasUI panelExtras = new ExtrasUI(this, true);
        panelExtras.setLocationRelativeTo(null);
        panelExtras.setVisible(true);
    }//GEN-LAST:event_mnuExtrasActionPerformed

    private void mnuAyudaAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaAcercaDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAyudaAcercaDeActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        MostrarClientesUI panelClientes = new MostrarClientesUI(this, true);
        //panelClientes.setSize(this.getWidth()-10, this.getHeight()-50);
        panelClientes.setLocationRelativeTo(null);
        panelClientes.setVisible(true);
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuIngresarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngresarVentaActionPerformed
        //VentaPantallaPrincipalBotonesGrillaUI ventaPP = new VentaPantallaPrincipalBotonesGrillaUI(this, true);
        VentaPantallaPrincipalUI ventaPP = new VentaPantallaPrincipalUI(this, true);
        ventaPP.setLocationRelativeTo(null);
        ventaPP.setVisible(true);
    }//GEN-LAST:event_mnuIngresarVentaActionPerformed

    private void mnuAyudaContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaContenidoActionPerformed
        VentaPantallaPrincipalBorrarloUI ventaPP = new VentaPantallaPrincipalBorrarloUI(this, true);
        //VentaPantallaPrincipalV3UI ventaPP = new VentaPantallaPrincipalComboCantUI(this, true);
        ventaPP.setLocationRelativeTo(null);
        ventaPP.setVisible(true);
    }//GEN-LAST:event_mnuAyudaContenidoActionPerformed

    private void mnuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformesActionPerformed
        Informes pnlInformes = new Informes(this, true);
        pnlInformes.setLocationRelativeTo(null);
        pnlInformes.setVisible(true);
    }//GEN-LAST:event_mnuInformesActionPerformed

    private void lblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseClicked
        VentaPantallaPrincipalBotonesGrillaUI ventaPP = new VentaPantallaPrincipalBotonesGrillaUI(this, true);
        ventaPP.setLocationRelativeTo(null);
        ventaPP.setVisible(true);
    }//GEN-LAST:event_lblVentasMouseClicked

    private void lblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClientesMouseClicked
        MostrarClientesUI panelClientes = new MostrarClientesUI(this, true);
        panelClientes.setLocationRelativeTo(null);
        panelClientes.setVisible(true);
    }//GEN-LAST:event_lblClientesMouseClicked

    private void lblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLibrosMouseClicked
        AdministrarLibrosUI panelLibros = new AdministrarLibrosUI(this, true);
        panelLibros.setLocationRelativeTo(null);
        panelLibros.setVisible(true);
    }//GEN-LAST:event_lblLibrosMouseClicked

    private void lblInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformesMouseClicked
        Informes pnlInformes = new Informes(this, true);
        pnlInformes.setLocationRelativeTo(null);
        pnlInformes.setVisible(true);
    }//GEN-LAST:event_lblInformesMouseClicked

    private void lblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuariosMouseClicked
        MostrarUsuariosUI panelUsu = new MostrarUsuariosUI(this, true);
        panelUsu.setLocationRelativeTo(null);
        panelUsu.setVisible(true);
    }//GEN-LAST:event_lblUsuariosMouseClicked

    private void lblGenerosLiterariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerosLiterariosMouseClicked
        AdminGenerosLiterariosUI panelTemas = new AdminGenerosLiterariosUI(null, true);
        panelTemas.setLocationRelativeTo(null);
        panelTemas.setVisible(true);
    }//GEN-LAST:event_lblGenerosLiterariosMouseClicked

    private void lblTiposDeDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiposDeDocumentosMouseClicked
        AdminTipoDocumentoUI panelTipoDoc = new AdminTipoDocumentoUI(null, true);
        panelTipoDoc.setLocationRelativeTo(null);
        panelTipoDoc.setVisible(true);
    }//GEN-LAST:event_lblTiposDeDocumentosMouseClicked

    private void lblLocalidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalidadesMouseClicked
        AdminLocalidadesUI panelLocalidades = new AdminLocalidadesUI(null, true);
        panelLocalidades.setLocationRelativeTo(null);
        panelLocalidades.setVisible(true);
    }//GEN-LAST:event_lblLocalidadesMouseClicked

    private void lblUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuariosMouseEntered
        colores.ColorDeBotonOver(lblUsuarios);
    }//GEN-LAST:event_lblUsuariosMouseEntered

    private void lblUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuariosMouseExited
        colores.ColorDeBoton(lblUsuarios);
    }//GEN-LAST:event_lblUsuariosMouseExited

    private void lblVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseEntered
        colores.ColorDeBotonOver(lblVentas);
    }//GEN-LAST:event_lblVentasMouseEntered

    private void lblVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseExited
        colores.ColorDeBoton(lblVentas);
    }//GEN-LAST:event_lblVentasMouseExited

    private void lblClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClientesMouseEntered
        colores.ColorDeBotonOver(lblClientes);
    }//GEN-LAST:event_lblClientesMouseEntered

    private void lblClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClientesMouseExited
        colores.ColorDeBoton(lblClientes);
    }//GEN-LAST:event_lblClientesMouseExited

    private void lblLibrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLibrosMouseEntered
        colores.ColorDeBotonOver(lblLibros);
    }//GEN-LAST:event_lblLibrosMouseEntered

    private void lblLibrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLibrosMouseExited
        colores.ColorDeBoton(lblLibros);
    }//GEN-LAST:event_lblLibrosMouseExited

    private void lblInformesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformesMouseEntered
        colores.ColorDeBotonOver(lblInformes);
    }//GEN-LAST:event_lblInformesMouseEntered

    private void lblInformesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformesMouseExited
        colores.ColorDeBoton(lblInformes);
    }//GEN-LAST:event_lblInformesMouseExited

    private void lblGenerosLiterariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerosLiterariosMouseEntered
        colores.ColorDeBotonOver(lblGenerosLiterarios);
    }//GEN-LAST:event_lblGenerosLiterariosMouseEntered

    private void lblGenerosLiterariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerosLiterariosMouseExited
        colores.ColorDeBoton(lblGenerosLiterarios);
    }//GEN-LAST:event_lblGenerosLiterariosMouseExited

    private void lblTiposDeDocumentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiposDeDocumentosMouseEntered
        colores.ColorDeBotonOver(lblTiposDeDocumentos);
    }//GEN-LAST:event_lblTiposDeDocumentosMouseEntered

    private void lblTiposDeDocumentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiposDeDocumentosMouseExited
        colores.ColorDeBoton(lblTiposDeDocumentos);
    }//GEN-LAST:event_lblTiposDeDocumentosMouseExited

    private void lblLocalidadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalidadesMouseEntered
        colores.ColorDeBotonOver(lblLocalidades);
    }//GEN-LAST:event_lblLocalidadesMouseEntered

    private void lblLocalidadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalidadesMouseExited
        colores.ColorDeBoton(lblLocalidades);
    }//GEN-LAST:event_lblLocalidadesMouseExited

    private void lblVentas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentas1MouseClicked
        VentaPantallaPrincipalUI ventaPP = new VentaPantallaPrincipalUI(this, true);
        ventaPP.setLocationRelativeTo(null);
        ventaPP.setVisible(true);
    }//GEN-LAST:event_lblVentas1MouseClicked

    private void lblVentas1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentas1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblVentas1MouseExited

    private void lblVentas1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentas1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblVentas1MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblGenerosLiterarios;
    private javax.swing.JLabel lblInformes;
    private javax.swing.JLabel lblLibros;
    private javax.swing.JLabel lblLocalidades;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMenuSistema;
    private javax.swing.JLabel lblTiposDeDocumentos;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JLabel lblVentas1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuABM;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuAyudaAcercaDe;
    private javax.swing.JMenuItem mnuAyudaContenido;
    private javax.swing.JMenuItem mnuBackup;
    private javax.swing.JMenuItem mnuClientes;
    private javax.swing.JMenuItem mnuExportarVenta;
    private javax.swing.JMenuItem mnuExtras;
    private javax.swing.JMenuItem mnuInformes;
    private javax.swing.JMenuItem mnuIngresarVenta;
    private javax.swing.JMenuItem mnuLibros;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuSistema;
    private javax.swing.JMenuItem mnuUsuarios;
    private javax.swing.JMenu mnuVentas;
    private javax.swing.JPanel pnlContEscritorioDerecha;
    private javax.swing.JPanel pnlContMenuVertical;
    private javax.swing.JPanel pnlFondoPP;
    private javax.swing.JPanel pnlVerticalDerecha;
    private javax.swing.JSeparator sepLogoYMenu;
    // End of variables declaration//GEN-END:variables


}
