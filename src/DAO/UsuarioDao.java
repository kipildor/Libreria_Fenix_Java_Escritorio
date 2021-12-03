
package DAO;


import Identidades.Usuario;
import UI.MenuPP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDao extends Conexion {
    //private Connection cn;
    private String SQL;
    
    public Usuario getUsuarioByID(int id){
        Usuario usr = new Usuario();
        SQL = "SELECT * FROM tbusuario WHERE idusuario=?";
        Conectar();
        
        try {
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.first()){
                usr.setIdusuario(rs.getInt(1));
                usr.setNombre(rs.getString(2));
                usr.setContrasenia(rs.getString(3));
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener el Usuario. (Err:"+ex+")");
        }
        return usr;
    }
    
    public boolean ExisteUsuarioPorID(int id){
        boolean existe = false;
        SQL = "SELECT * FROM tbusuario WHERE idusuario=?";
        Conectar();
        
        try {
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.first()){
                existe = true;
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener el Usuario. (Err:"+ex+")");
        }
        return existe;
    }
    
    public boolean ExisteElNombreUsuario(String nomb){
        boolean existe = false;
        SQL = "SELECT * FROM tbusuario WHERE nombre=?";
        Conectar();
        
        try {
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1, nomb);
            ResultSet rs = st.executeQuery();
            if(rs.first()){
                existe = true;
            }
            rs.close();
            st.close();
            cn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar si existe el usuario (Err:"+ex+")");
        }
        return existe;
    }
    
    public boolean PuedeCambiarSuNombre(Usuario user){
        boolean puede = true;
        SQL = "SELECT * FROM tbusuario WHERE nombre = ? AND idusuario != ?";
        Conectar();
        
        try {
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1, user.getNombre());
            st.setInt(2, user.getIdusuario());
            ResultSet rs = st.executeQuery();
            if(rs.first()){
                puede = false;
            }
            rs.close();
            st.close();
            cn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar si existe otro usuario con el mismo nombre (Err:"+ex+")");
        }
        return puede;
    }
    
    public boolean ValidarUsuario(Usuario usr){
        //Usuario usr = new Usuario();
        boolean okUsr = false;
        SQL = "SELECT * FROM tbusuario WHERE nombre=? AND contrasenia=?";
        //System.out.println(SQL);
        Conectar();
        
        try {
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1, usr.getNombre());
            st.setString(2, usr.getContrasenia());
            ResultSet rs = st.executeQuery();
            if(rs.first()){
                okUsr = true;
                
                //System.out.println("encontro 1");
                
            }
            rs.close();
            st.close();
            cn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al validar el usuario (Err:"+ex+")");
        }
        
        return okUsr;
    }
    
    public int CrearUsuario(Usuario usr){
        //System.out.println(usr.getNombre()+" ** "+usr.getContrasenia());
        int res = -1;
        if(!ExisteElNombreUsuario(usr.getNombre())){
            SQL = "INSERT INTO tbusuario(idusuario,nombre,contrasenia) VALUES(null,?,?)";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setString(1, usr.getNombre());
                ps.setString(2, usr.getContrasenia());

                if(ps.executeUpdate() > 0){
                    try {
                        PreparedStatement st = cn.prepareStatement("SELECT MAX(idusuario) FROM tbusuario");
                        ResultSet rs = st.executeQuery();
                        if(rs.first()){
                            res = rs.getInt(1);
                        }
                        cn.close();
                        rs.close();
                        st.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de obtener el id de usuario nuevo" + e);
                    }
                }
                cn.close();
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error desconocido");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre.");
        }
        System.out.println(res);
        return res;
    }
    
    public int ModificarUsuario(Usuario user){
        int res = -1;
        if(PuedeCambiarSuNombre(user)){
            SQL = "UPDATE tbusuario SET nombre = ?, contrasenia = ?" +
                    "WHERE idusuario = ?";
            Conectar();

            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setString(1, user.getNombre());
                ps.setString(2, user.getContrasenia());
                ps.setInt(3, user.getIdusuario());
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Se actualizó el Usuario.");
                    //REFRESCAR LA TABLA
                }
                cn.close();
                ps.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el Usuario. (Err:"+e+")");
            }
        }
        return res;
    }
    
    public int BorrarUsuario(int idU){
        int borrado = -1;
        if(ExisteUsuarioPorID(idU)){
            SQL = "DELETE FROM tbusuario WHERE idusuario = ?";
            Conectar();
            
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setInt(1, idU);
                
                if(ps.executeUpdate() > 0){
                    borrado = 1;
                }
                cn.close();
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar borrar el Usuario. (Err:"+ex+")");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe el usuario que quiere borrar.");
        }
        return borrado;
    }
    
    public LinkedList<Usuario> GetAllUsers(){
        LinkedList<Usuario> listaUsr = new LinkedList<Usuario>();
        SQL = "SELECT * FROM tbusuario ORDER BY nombre";
        Conectar();
        try {
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            
            if (!rs.next()) {
                System.out.println("No se encontraron usuarios.");
            }else {
                do{
                    Usuario user = new Usuario();
                    user.setIdusuario(rs.getInt(1));
                    user.setNombre(rs.getString(2));
                    user.setContrasenia(rs.getString(3));
                    listaUsr.add(user);
                }while(rs.next());
                rs.close();
                st.close();
                cn.close();
            }
            
/*            
            if(rs.first()){
                usr.setIdusuario(rs.getInt(1));
                usr.setNombre(rs.getString(2));
                usr.setContrasenia(rs.getString(3));
            }

            rs.close();
            st.close();
            cn.close();
*/
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error a buscar los Usuarios. (Err:"+ex+")");
        }
        return listaUsr;
    }
}
