package DAO;

import Identidades.Tema;
import Interfaces.TemaIF;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;

public class TemaDAO extends Conexion implements TemaIF {
    private String SQL;
    
    public Tema GetTemaByID(int id){
        Tema tema = new Tema();
        SQL = "SELECT * FROM tbtema WHERE idtema = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                tema.setIdtema(rs.getInt(1));
                tema.setDescripcion(rs.getString(2));
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando el Tema. (Err:"+e+")");
        }
        return tema;
    }
    
    public Tema GetTemaByDescripcion(String desc){
        Tema tem = new Tema();
        SQL = "SELECT * FROM tbtema WHERE descripcion = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, desc);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                tem.setIdtema(rs.getInt(1));
                tem.setDescripcion(rs.getString(2));
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando el id del género. (Err:"+e+")");
        }
        return tem;
    }
    
    public boolean ExisteElTema(int id){
        boolean existe = false;
        SQL = "SELECT * FROM tbtema WHERE idtema = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                existe = true;
            }
        } catch (Exception e) {
        }
        return existe;
    }
    
    public LinkedList<Tema> GetAllTemas(){
        LinkedList<Tema> listaTemas = new LinkedList<>();
        SQL = "SELECT * FROM tbtema ORDER BY descripcion";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron los temas/Generos.");
            }else{
                Tema item0 = new Tema();
                item0.setIdtema(0);
                item0.setDescripcion("Seleccione un Género");
                listaTemas.add(item0);
                do{
                    Tema genero = new Tema();
                    genero.setIdtema(rs.getInt(1));
                    genero.setDescripcion(rs.getString(2));
                    listaTemas.add(genero);
                }while(rs.next());
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error recuperando los temas. (Err:"+e+")");
        }
        return listaTemas;
    }
    
    public int ModificarTema(Tema tema){
        int res = -1;
        SQL = "UPDATE tbtema SET descripcion = ? WHERE idtema = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, tema.getDescripcion());
            ps.setInt(2, tema.getIdtema());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un erro al modificar el nombre del Tema. (Err:"+e+")");
        }
        return res;
    }
    
    public int AddTema(Tema tema){
        int res = -1;
        SQL = "INSERT INTO tbtema(idtema, descripcion) VALUES(null, ?)";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, tema.getDescripcion());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el Tema. (Err:"+e+")");
        }
        return res;
    }

    @Override
    public int BorrarTema(int id) {
        int res = -1;
        SQL = "DELETE FROM tbtema WHERE idtema = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al borrar el Tema. (Err:"+e+")");
        }
        return res;
    }

}
