package UI;

import DAO.UsuarioDao;
import Identidades.Usuario;
import java.awt.Color;
import java.awt.Font;
//import java.util.HashSet;
//import java.util.Set;
import javax.swing.JOptionPane;

public class LoginUI extends javax.swing.JFrame {


    public LoginUI() {
        initComponents();
        inicializarCajas();
        txtLoginUsuario.requestFocus();
    }
    
    private void inicializarCajas() {
        TextPrompt txtusuario = new TextPrompt("Ingrese el Usuario", txtLoginUsuario);
        txtusuario.setForeground(Color.GRAY);
        txtusuario.changeAlpha(0.5f);
        txtusuario.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);
        TextPrompt txtcontrasenia = new TextPrompt("Ingrese la contraseña", txtLoginContrasenia);
        txtcontrasenia.setForeground(Color.GRAY);
        txtcontrasenia.changeAlpha(0.5f);
        txtcontrasenia.changeStyle(Font.BOLD + Font.ROMAN_BASELINE + Font.ITALIC);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoginTitulo = new javax.swing.JLabel();
        lblLoginUsuario = new javax.swing.JLabel();
        lblLoginContrasenia = new javax.swing.JLabel();
        txtLoginUsuario = new javax.swing.JTextField();
        txtLoginContrasenia = new javax.swing.JPasswordField();
        btnLoginEntrar = new javax.swing.JButton();
        btnLoginSalir = new javax.swing.JButton();
        lblLoginFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso al Sistema");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLoginTitulo.setBackground(new java.awt.Color(204, 255, 204));
        lblLoginTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblLoginTitulo.setText("Ingreso al sistema");
        lblLoginTitulo.setOpaque(true);
        getContentPane().add(lblLoginTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 380, 50));

        lblLoginUsuario.setBackground(new java.awt.Color(204, 255, 204));
        lblLoginUsuario.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLoginUsuario.setText("Usuario");
        lblLoginUsuario.setOpaque(true);
        getContentPane().add(lblLoginUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        lblLoginContrasenia.setBackground(new java.awt.Color(204, 255, 204));
        lblLoginContrasenia.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLoginContrasenia.setText("Contraseña");
        lblLoginContrasenia.setOpaque(true);
        getContentPane().add(lblLoginContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        txtLoginUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtLoginUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLoginUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(txtLoginUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 159, 290, 30));

        txtLoginContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txtLoginContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 290, 30));

        btnLoginEntrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnLoginEntrar.setText("Entrar");
        btnLoginEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        btnLoginSalir.setBackground(new java.awt.Color(204, 0, 0));
        btnLoginSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginSalir.setMnemonic('x');
        btnLoginSalir.setText("X");
        btnLoginSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoginSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        lblLoginFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Libros_001.jpg"))); // NOI18N
        lblLoginFondo.setMaximumSize(new java.awt.Dimension(840, 525));
        getContentPane().add(lblLoginFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 670, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEntrarActionPerformed
        if(!(txtLoginUsuario.getText().isEmpty())){
            Usuario usr = new Usuario();
            usr.setNombre(txtLoginUsuario.getText());
            usr.setContrasenia(txtLoginContrasenia.getText());
            
            UsuarioDao usrDAO = new UsuarioDao();
            if(usrDAO.ValidarUsuario(usr)){
                //System.out.println("Usuario válido!!!!");
                this.dispose();
                MenuPP menuPPal = new MenuPP();
                menuPPal.setSize(this.getWidth()-10, this.getHeight()-50);
                menuPPal.setLocationRelativeTo(null);
                menuPPal.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                txtLoginUsuario.requestFocus();
            }
        }else{
            //JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio.");
            JOptionPane.showMessageDialog(null, "El Usuario NO puede estar en blanco!", "Usuario Inválido", HEIGHT);
            txtLoginUsuario.requestFocus();
            txtLoginUsuario.selectAll();
        }
    }//GEN-LAST:event_btnLoginEntrarActionPerformed
    /*
    private void txtLoginUsuarioKeyPressed(java.awt.event.KeyEvent evt) {                                      
        switch (evt.getKeyCode()) {
            case java.awt.event.KeyEvent.VK_ENTER:
                txtLoginContrasenia.requestFocus();
                txtLoginContrasenia.selectAll();
                break;
            case java.awt.event.KeyEvent.VK_TAB:
                txtLoginContrasenia.selectAll();
                break;
            case java.awt.event.KeyEvent.VK_F5:
                MenuPP mp = new MenuPP();
                mp.setVisible(true);
                this.dispose();
                
                break;
            default:
                
                break;
        }
    }                                     
*/
    
    private void txtLoginContraseniaKeyPressed(java.awt.event.KeyEvent evt) {                                          
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnLoginEntrar.requestFocus();
        }
    }
    
    private void btnLoginSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnLoginSalirActionPerformed

    private void txtLoginUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginUsuarioKeyPressed
        switch (evt.getKeyCode()) {
            case java.awt.event.KeyEvent.VK_ENTER:
                txtLoginContrasenia.requestFocus();
                txtLoginContrasenia.selectAll();
                break;
            case java.awt.event.KeyEvent.VK_TAB:
                txtLoginContrasenia.selectAll();
                break;
            case java.awt.event.KeyEvent.VK_F5:
                MenuPP mp = new MenuPP();
                mp.setVisible(true);
                this.dispose();
                
                break;
            default:
                
                break;
        }
    }//GEN-LAST:event_txtLoginUsuarioKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginEntrar;
    private javax.swing.JButton btnLoginSalir;
    private javax.swing.JLabel lblLoginContrasenia;
    private javax.swing.JLabel lblLoginFondo;
    private javax.swing.JLabel lblLoginTitulo;
    private javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JPasswordField txtLoginContrasenia;
    private javax.swing.JTextField txtLoginUsuario;
    // End of variables declaration//GEN-END:variables
}
