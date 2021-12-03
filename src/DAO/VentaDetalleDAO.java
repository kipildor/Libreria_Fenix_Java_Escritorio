package DAO;

import Identidades.Cliente;
import Identidades.Libro;
import Identidades.Tema;
import Identidades.TipoDocumento;
import Identidades.Venta;
import Identidades.VentaDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;

public class VentaDetalleDAO extends Conexion {
    private String SQL;
    
    public LinkedList<VentaDetalle> GetVentaDetalleByIDVenta(int idV){
        LinkedList<VentaDetalle> listaVD = new LinkedList<>();
        SQL = "SELECT VD.idventas, VD.cantidad, VD.preciovta, " +//1-2-3
                "V.idventas, V.nroComprobante, V.fecha, V.montototal, " +//4-5-6-7
                "L.idlibro, L.isbn, L.titulo, L.autor, L.cantpaginas, L.editorial, L.fechaPublicacion, L.precio, " +//8-...-15
                "T.idtema, T.descripcion AS Genero_literario, " +//16-17
                "C.idcliente, C.nrodocumento, C.razonSocial, C.email, C.borrado, " +//18-19-20-21-22
                "TD.idtipodocumento, TD.descripcion AS tipo_doc " +//23-24
            "FROM tbventasdetalle AS VD " +
                "INNER JOIN tbventas AS V ON VD.idventas = V.idventas " +
                "INNER JOIN tblibro AS L ON VD.idlibro = L.idlibro " +
                "INNER JOIN tbtema AS T ON L.idtema = T.idtema " +
                "INNER JOIN tbcliente AS C ON V.idcliente = C.idcliente " +
                "INNER JOIN tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento " +
            "WHERE VD.idventas = 18";
        Conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            //ps.setInt(1, idV);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron los Detalles de la Venta pedida.");
            }else{
                do{
//                    TipoDocumento t = new TipoDocumento(rs.getInt(23), rs.getString(24));
//                    Cliente c = new Cliente();
//                    c.setIdcliente(rs.getInt(18));
//                    c.setTipodocumento(t);
//                    c.setNrodocumento(rs.getLong(19));
//                    c.setRazonsocial(rs.getString(20));
//                    c.setEmail(rs.getString(21));
//                    c.setBorrado(rs.getBoolean(22));
//                    
//                    Venta v = new Venta();
//                    v.setIdventas(idV);
//                    v.setNrocomprobante(rs.getLong(5));
//                    v.setFecha(rs.getDate(6));
//                    v.setMontototal(rs.getDouble(7));
//                    v.setCliente(c);
//                    
//                    Tema tem = new Tema();
//                    tem.setIdtema(rs.getInt(16));
//                    tem.setDescripcion(rs.getString(17));
//                    Libro l = new Libro();
//                    l.setIdlibro(rs.getInt(8));
//                    l.setIsbn(rs.getString(9));
//                    l.setTitulo(rs.getString(10));
//                    l.setAutor(rs.getString(11));
//                    l.setCantpaginas(rs.getInt(12));
//                    l.setEditorial(rs.getString(13));
//                    l.setFechapublicacion(rs.getDate(14));
//                    l.setPrecio(rs.getDouble(15));
//                    l.setTema(tem);
//                    
//                    int cantUnidades = rs.getInt(2);
//                    double precioUnitario = rs.getDouble(3);
//                    VentaDetalle vd = new VentaDetalle(v, l, cantUnidades, precioUnitario);
//????? AGREGAR A LA LISTA???
//                    System.out.println(rs.getString(10));
                }while(rs.next());
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error buscando los detalles de la venta. (Err:"+e+")");
        }
        return listaVD;
    }
    
    public LinkedList<VentaDetalle> GetVentaDetalleReducidoByIDVenta(int idV){//modificar y usar
        LinkedList<VentaDetalle> listaVD = new LinkedList<>();
        SQL = "SELECT VD.idventas, VD.cantidad, VD.preciovta, " +//1-2-3
                "L.idlibro, L.isbn, L.titulo, L.autor, L.cantpaginas, L.editorial, L.fechaPublicacion, L.precio " +//4-...-11
            "FROM tbventasdetalle AS VD " +
                "INNER JOIN tblibro AS L ON VD.idlibro = L.idlibro " +
            "WHERE VD.idventas = ?";
        Conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idV);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron los Detalles de la Venta pedida.");
            }else{
                do{
                    Libro l = new Libro();
                    l.setIdlibro(rs.getInt(4));
                    l.setIsbn(rs.getString(5));
                    l.setTitulo(rs.getString(6));
                    l.setAutor(rs.getString(7));
                    l.setCantpaginas(rs.getInt(8));
                    l.setEditorial(rs.getString(9));
                    l.setFechapublicacion(rs.getDate(10));
                    l.setPrecio(rs.getDouble(11));
                    
                    int cantUnidades = rs.getInt(2);
                    double precioUnitario = rs.getDouble(3);
                    VentaDetalle vd = new VentaDetalle();
                    vd.setLibro(l);
                    vd.setCantidad(cantUnidades);
                    vd.setPreciovta(precioUnitario);
                    
                    listaVD.add(vd);
                }while(rs.next());
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error buscando los detalles de la venta. (Err:"+e+")");
        }
        return listaVD;
    }
    
    public int crearDetallesDeVenta(VentaDetalle vd){
        int res = -1;
        SQL = "INSERT INTO tbventasdetalle " +
            "(idventas, idlibro, cantidad, preciovta) " +
            "VALUES(?, ?, ?, ?)";
        Conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, vd.getVenta().getIdventas());
            ps.setInt(2, vd.getLibro().getIdlibro());
            ps.setInt(3, vd.getCantidad());
            ps.setDouble(4, vd.getPreciovta());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error creando los detalles de la venta_dao. (Err:"+e+")");
        }
        return res;
    }
    
    public int GuardarDetallesVenta(LinkedList<VentaDetalle> vd){//Igual que crearDetallesDeVenta pero con todas las filas
        int res = 0;
        for (VentaDetalle ventD : vd) {
            if(crearDetallesDeVenta(ventD) > 0){
                res++;
            }
        }
        return res;
    }
    
    public int TestDetallesDeVenta(VentaDetalle vd){
        int res = -1;
//        SQL = "INSERT INTO tbventasdetalle " +
//            "(idventas, idlibro, cantidad, preciovta) " +
//            "VALUES(?, ?, ?, ?)";
//        Conectar();
        
        try {
            //System.out.println("Tit:"+vd.getLibro().getTitulo()+" ID Venta:"+vd.getVenta().getIdventas());
            System.out.println("Val1:"+vd.getVenta().getIdventas()+" val2:"+vd.getLibro().getIdlibro()+
                    " val3:"+vd.getCantidad()+" val4:"+vd.getPreciovta());
                res = 1;
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error creando los detalles de la venta_dao. (Err:"+e+")");
        }
        return res;
    }
    
}
