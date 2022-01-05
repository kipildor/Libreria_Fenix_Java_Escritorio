package DAO;

import Identidades.Cliente;
import Identidades.TipoDocumento;
import Identidades.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Date;
import java.util.*;
import javax.swing.JOptionPane;

public class VentaDAO extends Conexion {
    private String SQL;
    
    
    
    public Venta VentaByID(int idV){
        Venta v = new Venta();
        SQL = "SELECT V.idventas, V.nroComprobante, V.fecha, V.montototal, V.idcliente, " +//1-2-3-4-5
            "C.idtipodocumento, T.descripcion AS tipo_doc, " +//6-7
            "C.nrodocumento, C.razonSocial, C.email, C.borrado " +//8-9-10-11
            "FROM tbventas AS V INNER JOIN tbcliente AS C ON V.idcliente = C.idcliente " +
            "INNER JOIN tbtipodocumento AS T ON C.idtipodocumento = T.idtipodocumento " +
            "WHERE V.idventas = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idV);
            ResultSet rs = ps.executeQuery();
            if(!(rs.first())){
                JOptionPane.showMessageDialog(null, "No se encontró la venta pedida.");
            }else{
//                System.out.println("jjjj");
                v.setIdventas(idV);
                v.setNrocomprobante(rs.getLong(2));
                v.setFecha(rs.getDate(3));
                v.setMontototal(rs.getDouble(4));
                TipoDocumento t = new TipoDocumento(rs.getInt(6), rs.getString(7));
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt(5));
                c.setTipodocumento(t);
                c.setNrodocumento(rs.getLong(8));
                c.setRazonsocial(rs.getString(9));
                c.setEmail(rs.getString(10));
                c.setBorrado(rs.getBoolean(11));
                v.setCliente(c);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando la venta. ??(Err:"+e+")");
        }
        return v;
    }
    
    public Venta VentaByNroComprobante(long idCompro){
        Venta v = new Venta();
        SQL = "SELECT V.idventas, V.nroComprobante, V.fecha, V.montototal, V.idcliente, " +//1-2-3-4-5
            "C.idtipodocumento, T.descripcion AS tipo_doc, " +//6-7
            "C.nrodocumento, C.razonSocial, C.email, C.borrado, " +//8-9-10-11
            "FROM tbventas AS V INNER JOIN tbcliente AS C ON V.idcliente = C.idcliente " +
            "INNER JOIN tbtipodocumento AS T ON C.idtipodocumento = T.idtipodocumento " +
            "WHERE V.nroComprobante = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, idCompro);
            ResultSet rs = ps.executeQuery();
            if(!(rs.first())){
                JOptionPane.showMessageDialog(null, "No se encontró la venta pedida.");
            }else{
                v.setIdventas(rs.getInt(1));
                v.setNrocomprobante(idCompro);
                v.setFecha(rs.getDate(3));
                v.setMontototal(rs.getDouble(4));
                TipoDocumento t = new TipoDocumento(rs.getInt(6), rs.getString(7));
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt(5));
                c.setTipodocumento(t);
                c.setNrodocumento(rs.getLong(8));
                c.setRazonsocial(rs.getString(9));
                c.setEmail(rs.getString(10));
                c.setBorrado(rs.getBoolean(11));
                v.setCliente(c);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando la venta. (Err:"+e+")");
        }
        return v;
    }
    
    public int CrearVenta(Venta v){
        //Venta v = new Venta();
        int res = -1;
        SQL = "INSERT INTO tbventas " +
            "(nroComprobante, fecha, idcliente, montototal) " +
            "VALUES(?, NOW(), ?, ?)";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, v.getNrocomprobante());
            //ps.setDate(2, new java.sql.Date(v.getFecha().getTime()));
            ps.setInt(2, v.getCliente().getIdcliente());
            ps.setDouble(3, v.getMontototal());
            
            if(ps.executeUpdate() > 0){
                res = 1;
            }else{
                JOptionPane.showMessageDialog(null, "No se puedo crear la Venta en el sistema.");
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error creando la venta. (Err:"+e+")");
        }
        return res;
    }
    
    public int getIDVentaByNroComprobante(long nroComp){
        int idVen = 0;
        SQL = "SELECT idventas FROM tbventas " +
            "WHERE nroComprobante = ? ORDER BY idventas DESC";
        Conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, nroComp);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                idVen = rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando el identificador de la venta");
        }
        return idVen;
    }
    
    public LinkedList<Venta> VentasByDayReducido(Date fecha){
        //System.out.println("2_"+fecha);
        LinkedList<Venta> listaV = new LinkedList<>();
        ManejarFecha castF = new ManejarFecha();
        java.sql.Date fechaSQL = castF.fechaUtilToSql(fecha);
        //System.out.println("3_"+fechaSQL);
        SQL = "SELECT idventas, nroComprobante, montototal " +//0-1-2
            "FROM tbventas " +
            "WHERE fecha = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setDate(1, fechaSQL);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron ventas en esa fecha.");
            }else{
                do{
                    Venta v = new Venta();
                    v.setIdventas(rs.getInt(1));
                    v.setNrocomprobante(rs.getLong(2));
                    //v.setFecha(fechaSQL);
                    v.setMontototal(rs.getDouble(3));
                    //System.out.println("4_"+rs.getInt(1));
                    listaV.add(v);
                }while(rs.next());
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando las ventas de la fecha. (Err:"+e+")");
        }
        return listaV;
    }
    
    public LinkedList<Venta> UltimasVentasReducido(){
        //System.out.println("2_"+fecha);
        LinkedList<Venta> listaV = new LinkedList<>();
//        ManejarFecha castF = new ManejarFecha();
//        java.sql.Date fechaSQL = castF.fechaUtilToSql(fecha);
        //System.out.println("3_"+fechaSQL);
        SQL = "SELECT idventas, nroComprobante, montototal " +//0-1-2
            "FROM tbventas " +
            "ORDER BY fecha DESC " +
            "LIMIT 10";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron ventas.");
            }else{
                do{
                    Venta v = new Venta();
                    v.setIdventas(rs.getInt(1));
                    v.setNrocomprobante(rs.getLong(2));
                    //v.setFecha(fechaSQL);
                    v.setMontototal(rs.getDouble(3));
                    //System.out.println("4_"+rs.getInt(1));
                    listaV.add(v);
                }while(rs.next());
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando las últimas ventas. (Err:"+e+")");
        }
        return listaV;
    }
    
    public boolean ExisteLaVenta(int idVenta){
        boolean existe = false;
        SQL = "SELECT 1 FROM tbventas WHERE idventas = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                existe = true;
            }else{
                JOptionPane.showMessageDialog(null, "No existe la venta buscada.");
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error desconocido. (Err:"+e+")");
        }
        return existe;
    }
    
    public long UltimoNroComprobanteMasUno(){
        long ultComp = 0;
        SQL = "SELECT MAX(nroComprobante) FROM tbventas";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                ultComp = rs.getLong(1);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error obteniendo el último comprobante. (Err:"+e+")");
        }
        ultComp += 1;
        return ultComp;
    }
    
    public String CadenaComprobante(long ultiComp){
        String cadComp = "";
        int cantNumeros = (Long.toString(ultiComp)).length();
        if(cantNumeros < 7){
            cadComp = "0000 - ";
            for(int x = 0; x < (6 - cantNumeros); x++){
                cadComp += "0";
            }
            cadComp += ultiComp;
        }else{
            for(int y = 0; y < (4 - (cantNumeros - 6)); y++){
                cadComp += "0";
            }
            String numAdelante = (Long.toString(ultiComp)).substring(0, (cantNumeros - 6));
            cadComp += numAdelante;
            String numAtras = (Long.toString(ultiComp)).substring((cantNumeros - 6), cantNumeros);
            cadComp += " - " + numAtras;
        }
        return cadComp;
    }
    
    public long ObtenerNroComprobante(String cadCompro){
        long numCompro = 0;
        //String numAdelante = cadCompro.su
        //int cantCarac = cadCompro.length();
        char [] cadena = cadCompro.toCharArray();
        String nuevaCad = "";
        
        for(int z = 0; z < cadena.length; z++){
            if(Character.isDigit(cadena[z])){
                nuevaCad += cadena[z];
                //cadCompro.charAt(z)
            }else{
                if(!((Character.isWhitespace(cadena[z])) || (Character.compare(cadena[z], '-') == 0))){
                    JOptionPane.showMessageDialog(null, "El número de comprobante contiene caracteres inválidos.");
                    return 0;
                }
            }
        }
        //if(cantCarac)
        try {
            if(nuevaCad.length() > 0){
                numCompro = Long.parseLong(nuevaCad);
                if(numCompro < 1){
                    JOptionPane.showMessageDialog(null, "El número de comprobante no puede ser 0 y debe poseer solo números");
                    return 0;
                }
            }else{
                JOptionPane.showMessageDialog(null, "El número de comprobante no puede ser vacio y debe poseer solo números");
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error con el número de comprobante. (Err:"+e+")");
        }
        return numCompro;
    }
}
