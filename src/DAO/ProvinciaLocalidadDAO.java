package DAO;

import Identidades.Localidad;
import Identidades.Provincia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;



public class ProvinciaLocalidadDAO extends Conexion {
    private String SQL;
    
    public Provincia GetProvinciaByID(int idProv){
        Provincia prov = new Provincia();
        SQL = "SELECT * FROM tbprovincia WHERE idprovincia = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idProv);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                prov.setIdprovincia(rs.getInt(1));
                prov.setNombre(rs.getString(2));
                prov.setAbreviatura(rs.getString(3));
            }
            rs.close();
            ps.close();
            cn.close();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar la Provincia. (Err:"+ex+")");
        }
        return prov;
    }
    
    public Localidad GetLocalidadByID(long idloc){
        Localidad loc = new Localidad();
        //Provincia prov = new Provincia();
        SQL = "SELECT * FROM tblocalidad WHERE idlocalidad = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, idloc);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                loc.setIdlocalidad(rs.getLong(1));
                loc.setNombre(rs.getString(2));
                loc.setNom_departamento(rs.getString(3));
                /***  REVISAAAARRRRR  ****/
                //loc.setProvincia((Provincia) rs.getObject(4));
                loc.setProvincia(GetProvinciaByID(rs.getInt(4)));
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo la localidad. (Err:"+ex+")");
        }
        return loc;
    }
    
    public LinkedList<Provincia> GetAllProvincias(){
        LinkedList<Provincia> listaProv = new LinkedList<Provincia>();
        SQL = "SELECT * FROM tbprovincia ORDER BY nombre";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "No se encontraron Provincias.");
            }else{
                Provincia item0 = new Provincia();
                item0.setIdprovincia(0);
                item0.setNombre("Seleccione una Provincia");
                listaProv.add(item0);
                do{
                    Provincia prov = new Provincia();
                    prov.setIdprovincia(rs.getInt(1));
                    prov.setNombre(rs.getString(2));
                    prov.setAbreviatura(rs.getString(3));
                    listaProv.add(prov);
                }while(rs.next());
            }
            rs.close();
            ps.close();
            cn.close();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar las Provincias. (Err:"+ex+")");
        }
        return listaProv;
    }
    /*
    public LinkedList<Localidad> GetAllLocalidades(){
        LinkedList<Localidad> listaLoc = new LinkedList<Localidad>();
        SQL = "SELECT * FROM tblocalidad";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(true){
                // RECORRER Y CARGAR LA LISTA DE PROVINCIAS
            }
            rs.close();
            ps.close();
            cn.close();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar las Localidades. (Err:"+ex+")");
        }
        return listaLoc;
    }
    */
    public LinkedList<Localidad> GetLocalidadesByIDProv(int idProv){
        
        LinkedList<Localidad> listaLoc = new LinkedList<Localidad>();
        Localidad item0 = new Localidad();
        item0.setIdlocalidad(0);
        item0.setNombre("Seleccione una Localidad");
        listaLoc.add(item0);
        if(idProv > 0){
            SQL = "SELECT * FROM tblocalidad WHERE idprovincia = ? ORDER BY nombre";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setInt(1, idProv);
                ResultSet rs = ps.executeQuery();
                if(!rs.next()){
                    JOptionPane.showMessageDialog(null, "No se encontraron Localidades.");
                }else{
                    Provincia p = new Provincia(idProv);
//                    Localidad item0 = new Localidad();
//                    item0.setIdlocalidad(0);
//                    item0.setNombre("Seleccione una Localidad");
//                    listaLoc.add(item0);
                    do{
                        Localidad loc = new Localidad();
                        loc.setIdlocalidad(rs.getLong(1));
                        loc.setNombre(rs.getString(2));
                        loc.setNom_departamento(rs.getString(3));
                        //loc.setProvincia(GetProvinciaByID(rs.getInt(4)));
                        loc.setProvincia(p);
                        listaLoc.add(loc);
                    }while(rs.next());
                }
                rs.close();
                ps.close();
                cn.close();            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar las Localidades. (Err:"+ex+")");
            }
        }
        return listaLoc;
    }
    
    public boolean ExisteProvinciaPorID(int idProv){
        boolean existe = false;
        SQL = "SELECT * FROM tbprovincia WHERE idprovincia = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idProv);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                existe = true;
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error verificando si existe la Provincia. (Err:"+e+")");
        }
        return existe;
    }
    
    public boolean ExisteLocalidadPorID(long idLoc){
        boolean existe = false;
        SQL = "SELECT * FROM tblocalidad WHERE idlocalidad = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, idLoc);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                existe = true;
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error verificando si existe la Provincia. (Err:"+e+")");
        }
        return existe;
    }
    
    public int ModificarProvincia(Provincia prov){
        int res = -1;
        if(ExisteProvinciaPorID(prov.getIdprovincia())){
            SQL = "UPDATE tbprovincia SET nombre = ?, abreviatura = ? "+
                    "WHERE idprovincia = ?";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setString(1, prov.getNombre());
                ps.setString(2, prov.getAbreviatura());
                ps.setInt(3, prov.getIdprovincia());
                if(ps.executeUpdate() > 0){
                    //JOptionPane.showMessageDialog(null, "Se actualizó con exito la Provincia");
                    res = 1;
                }
                ps.close();
                cn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar la Provincia. (Err:"+e+")");
            }
        }
        return res;
    }
    
    public int ModificarLocalidad(Localidad loc){
        int res = -1;
        if(ExisteLocalidadPorID(loc.getIdlocalidad())){
            SQL = "UPDATE tblocalidad SET nombre = ?, nom_departamento = ?, idprovincia = ? "+
                    "WHERE idlocalidad = ?";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setString(1, loc.getNombre());
                ps.setString(2, loc.getNom_departamento());
                ps.setInt(3, loc.getProvincia().getIdprovincia());
                ps.setLong(4, loc.getIdlocalidad());
                if(ps.executeUpdate() > 0){
                    //JOptionPane.showMessageDialog(null, "Se actualizó con exito la Localidad");
                    res = 1;
                }
                ps.close();
                cn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar la Localidad. (Err:"+e+")");
            }
        }
        return res;
    }
    
    public int AgregarProvincia(Provincia prov){
        int res = -1;
        SQL = "INSERT INTO tbprovincia(idprovincia,nombre,abreviatura) VALUES(null, ?, ?)";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, prov.getNombre());
            ps.setString(2, prov.getAbreviatura());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar la Provincia. (Err:"+e+")");
        }
        return res;
    }
    
    public int AgregarLocalidad(Localidad loc){
        int res = -1;
        SQL = "INSERT INTO tblocalidad(idlocalidad,nombre,nom_departamento,idprovincia) VALUES(?, ?, ?, ?)";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, (UltimoIDLocalidad()+1));
            ps.setString(2, loc.getNombre());
            ps.setString(3, loc.getNom_departamento());
            ps.setInt(4, loc.getProvincia().getIdprovincia());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar la Localidad. (Err:"+e+")");
        }
        return res;
    }
    
    public int BorrarProvincia(int id){
        int res = -1;
        if(ExisteProvinciaPorID(id)){
            SQL = "DELETE FROM tbprovincia WHERE idprovincia = ?";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setInt(1, id);
                if(ps.executeUpdate() > 0){
                    res = 1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error tratando de borrar la Provincia.");
            }
        }
        return res;
    }
    
    public int BorrarLocalidad(long id){
        int res = -1;
        if(ExisteLocalidadPorID(id)){
            SQL = "DELETE FROM tblocalidad WHERE idlocalidad = ?";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setLong(1, id);
                if(ps.executeUpdate() > 0){
                    res = 1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error tratando de borrar la Localidad.");
            }
        }
        return res;
    }
    
    public long UltimoIDLocalidad(){
        long ult = -1;
        SQL = "SELECT MAX(idlocalidad) AS utimoID FROM tblocalidad";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                ult = rs.getLong(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un erro buscando la ultima localidad. (Err:"+e+")");
        }
        return ult;
    }
}
