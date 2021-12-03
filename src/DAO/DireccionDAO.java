package DAO;

import Identidades.Direccion;
import Identidades.Localidad;
import Identidades.Provincia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;

public class DireccionDAO extends Conexion {
    private String SQL;
    
    public LinkedList<Direccion> GetAllDirecciones(){
        LinkedList<Direccion> listaDir = new LinkedList();
        SQL = "SELECT D.iddireccion, D.calle, D.numero, D.piso, D.departamento, " +
            "L.idlocalidad, L.nombre AS Localidad, L.nom_departamento, " +
            "P.idprovincia, P.nombre AS Provincia " +
            "FROM tbdireccion AS D INNER JOIN " +
            "tbprovincia AS P ON D.idprovincia = P.idprovincia INNER JOIN " +
            "tblocalidad AS L ON D.idlocalidad = L.idlocalidad";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "No se encontraron direcciones.");
            }else{
                do{
                    Direccion dire = new Direccion();
                    Provincia prov = new Provincia();
                    Localidad loc = new Localidad();
                    prov.setIdprovincia(rs.getInt(9));
                    prov.setNombre(rs.getString(10));
                    loc.setIdlocalidad(rs.getLong(6));
                    loc.setNombre(rs.getString(7));
                    loc.setNom_departamento(rs.getString(8));
                    loc.setProvincia(prov);
                    dire.setIddireccion(rs.getLong(1));
                    dire.setCalle(rs.getString(2));
                    dire.setNumero(rs.getInt(3));
                    dire.setPiso(rs.getInt(4));
                    dire.setDepartamento(rs.getString(5));
                    dire.setProvincia(prov);
                    dire.setLocalidad(loc);
                    listaDir.add(dire);
                }while(rs.next());
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando las direcciones. (Err:"+e+")");
        }
        return listaDir;
    }
    
    public Direccion GetDireccionByID(long idDire){
        Direccion dire = new Direccion();
        SQL = "SELECT D.iddireccion, D.calle, D.numero, D.piso, D.departamento, " +
            "L.idlocalidad, L.nombre AS Localidad, L.nom_departamento, " +
            "P.idprovincia, P.nombre AS Provincia " +
            "FROM tbdireccion AS D INNER JOIN " +
            "tbprovincia AS P ON D.idprovincia = P.idprovincia INNER JOIN " +
            "tblocalidad AS L ON D.idlocalidad = L.idlocalidad " +
            "WHERE D.iddireccion = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, idDire);
            ResultSet rs = ps.executeQuery();
            if(!rs.first()){
                JOptionPane.showMessageDialog(null, "No se encontró la dirección.");
            }else{
                Provincia prov = new Provincia();
                Localidad loc = new Localidad();
                prov.setIdprovincia(rs.getInt(9));
                prov.setNombre(rs.getString(10));
                loc.setIdlocalidad(rs.getLong(6));
                loc.setNombre(rs.getString(7));
                loc.setNom_departamento(rs.getString(8));
                loc.setProvincia(prov);
                dire.setIddireccion(rs.getLong(1));
                dire.setCalle(rs.getString(2));
                dire.setNumero(rs.getInt(3));
                dire.setPiso(rs.getInt(4));
                dire.setDepartamento(rs.getString(5));
                dire.setProvincia(prov);
                dire.setLocalidad(loc);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando la dirección. (Err:"+e+")");
        }
        return dire;
    }
    
    public int AgregarDireccion(Direccion dir){
        int res = -1;
        SQL = "INSERT INTO tbdireccion (iddireccion, calle, numero, piso, departamento, idlocalidad, idprovincia) "+
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, dir.getIddireccion());
            ps.setString(2, dir.getCalle());
            ps.setInt(3, dir.getNumero());
            ps.setInt(4, dir.getPiso());
            ps.setString(5, dir.getDepartamento());
            ps.setLong(6, dir.getLocalidad().getIdlocalidad());
            ps.setInt(7, dir.getProvincia().getIdprovincia());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error guardando la dirección. (Err:"+e+")");
        }
        return res;
    }
    
    public int ActualizarDireccion(Direccion dir){
        int res = -1;
        SQL = "UPDATE tbdireccion " +
            "SET iddireccion = ?, calle = ?, numero = ?, piso = ?, departamento = ?, idlocalidad = ?, idprovincia = ? " +
            "WHERE iddireccion = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, dir.getIddireccion());// Es el nro de Documento
            ps.setString(2, dir.getCalle());
            ps.setInt(3, dir.getNumero());
            ps.setInt(4, dir.getPiso());
            ps.setString(5, dir.getDepartamento());
            ps.setLong(6, dir.getLocalidad().getIdlocalidad());
            ps.setInt(7, dir.getProvincia().getIdprovincia());
            ps.setLong(8, dir.getIddireccion());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error actualizando la dirección. (Err:"+e+")");
        }
        return res;
    }
    
    public boolean ExisteIDDireccion(long idD){
        boolean existe = false;
        SQL = "SELECT 1 FROM tbdireccion WHERE iddireccion = ?";
        Conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, idD);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                existe = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error verificando si existe la dirección. (Err:"+e+")");
        }
        return existe;
    }
}
