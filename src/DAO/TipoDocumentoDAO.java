package DAO;

import Identidades.TipoDocumento;
import Interfaces.TipoDocumentoIF;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;

public class TipoDocumentoDAO extends Conexion implements TipoDocumentoIF{
    private String SQL;
    @Override
    public LinkedList<TipoDocumento> GetAllTipoDocumento() {
        LinkedList<TipoDocumento> listaTipo = new LinkedList<>();
        Conectar();
        SQL = "SELECT * FROM tbtipodocumento ORDER BY descripcion";
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se los tipos de documento.");
            }else {
                do{
                    TipoDocumento tipo = new TipoDocumento();
                    tipo.setIdtipodocumento(rs.getInt(1));
                    tipo.setDescripcion(rs.getString(2));
                    listaTipo.add(tipo);
                }while(rs.next());
                rs.close();
                ps.close();
                cn.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los tipos de documento. (Err:"+e+")");
        }
        return listaTipo;
    }

    @Override
    public TipoDocumento GetTipoDocumentoByID(int id) {
        TipoDocumento tipo = new TipoDocumento();
        SQL = "SELECT * FROM tbtipodocumento WHERE idtipodocumento = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                tipo.setIdtipodocumento(rs.getInt(1));
                tipo.setDescripcion(rs.getString(2));
            }else{
                //JOptionPane.showMessageDialog(null, "No se encontró el ID proporcionado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando el tipo de documento. (Err:"+e+")");
        }
        return tipo;
    }
    
    public boolean ExisteElID(int id){
        boolean existe = false;
        SQL = "SELECT * FROM tbtipodocumento WHERE idtipodocumento = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                existe = true;
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error verificando si ya existe el ID. (Err:"+e+")");
        }
        return existe;
    }

    @Override
    public int AgregarTipoDocumento(TipoDocumento tipo) {
        int res = -1;
        SQL = "INSERT INTO tbtipodocumento (idtipodocumento, descripcion) VALUES(?,?)";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, tipo.getIdtipodocumento());
            ps.setString(2, tipo.getDescripcion());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error agregan un nuevo tipo de documento. (Err:"+e+")");
        }
        return res;
    }

    public int ActualizarTipoDocumento(TipoDocumento tipo) {
        int res = -1;
        SQL = "UPDATE tbtipodocumento SET descripcion = ? WHERE idtipodocumento = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, tipo.getDescripcion());
            ps.setInt(2, tipo.getIdtipodocumento());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el tipo de documento. (Err:"+e+")");
        }
        System.out.println("Actualiza solo descripcion");
        return res;
    }

    public int ActualizarTipoDocumento(TipoDocumento tipo, int idAnt) {
        int res = -1;
        SQL = "UPDATE tbtipodocumento SET idtipodocumento = ?, descripcion = ? WHERE idtipodocumento = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, tipo.getIdtipodocumento());
            ps.setString(2, tipo.getDescripcion());
            ps.setInt(3, idAnt);
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el tipo de documento. (Err:"+e+")");
        }
        System.out.println("Actualiza id y descripcion");
        return res;
    }
    
    @Override
    public int BorrarTipoDocumento(int id) {
        int res = -1;
        SQL = "DELETE FROM tbtipodocumento WHERE idtipodocumento = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el tipo de documento. (Err:"+e+")");
        }
        return res;
    }

    
}
