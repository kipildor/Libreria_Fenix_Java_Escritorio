package DAO;

import Identidades.Libro;
import Identidades.Tema;
import com.sun.prism.impl.Disposer;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;


public class LibroDAO extends Conexion {
    private String SQL;
    
    public Libro GetLibroByID(int id){
        Libro lib = new Libro();
        SQL = "SELECT * FROM tblibro WHERE idlibro = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                lib.setIdlibro(rs.getInt("idlibro"));
                lib.setIsbn(rs.getString("isbn"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setCantpaginas(rs.getInt("cantpaginas"));
                lib.setEditorial(rs.getString("editorial"));
                lib.setFechapublicacion(rs.getDate("fechaPublicacion"));
                lib.setPrecio(rs.getFloat("precio"));
                //lib.setTema(rs.getObject(SQL, type));
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar el Libro. (Err:"+e+")");
        }
        return lib;
    }
    
//    public LinkedList<Libro> GetLibrosByTitulooo(){
//        LinkedList<Libro> listaLib = new LinkedList<>();
//        Conectar();
//        //SQL = "SELECT * FROM tblibro ORDER BY titulo";
//        SQL = "SELECT * FROM tblibro L INNER JOIN tbtema T ON L.idtema=T.idtema ORDER BY idlibro DESC";
////SQL = "SELECT * FROM tblibro L INNER JOIN tbtema T ON L.idtema = T.idtema ORDER BY idlibro DESC";
//        try {
//            PreparedStatement ps = cn.prepareStatement(SQL);
//            ResultSet rs = ps.executeQuery();
//            if (!rs.next()) {
//                JOptionPane.showMessageDialog(null, "No se encontraron libros que coincidan.");
//            }else {
//                do{
//                    Libro book = new Libro();
//                    TemaDAO teDAO = new TemaDAO();
//                    Tema te = new Tema();
//                    //te = teDAO.GetTemaByID(rs.getInt(9));
//                    //te.setDescripcion(teDAO.GetTemaByID(rs.getInt(9)).getDescripcion());
//                    //te.setIdtema(rs.getInt(9));
//                    book.setIdlibro(rs.getInt(1));
//                    book.setIsbn(rs.getString(2));
//                    book.setTitulo(rs.getString(3));
//                    book.setAutor(rs.getString(4));
//                    book.setCantpaginas(rs.getInt(5));
//                    book.setEditorial(rs.getString(6));
//                    book.setFechapublicacion(rs.getDate(7));
//                    book.setPrecio(rs.getDouble(8));
//                    //book.setTema(te);
//                    te.setIdtema(rs.getInt(9));
//                    te.setDescripcion(rs.getString(11));
//                    book.setTema(te);
//                    //book.setTema(teDAO.GetTemaByID(rs.getInt(9)));
//                    listaLib.add(book);
////                    Tema tem = new Tema(rs.getInt(9), rs.getString(10));
////                    book.setTema(tem);
//                }while(rs.next());
//            }
//            rs.close();
//            ps.close();
//            cn.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los libros. (Err:"+e+")");
//        }
//        //System.out.println("mmmmm");
//        return listaLib;
//    }
    public LinkedList<Libro> GetLibrosByTitulo(String tit){
        LinkedList<Libro> listaLib = new LinkedList<>();
        //Libro libr = new Libro();

        SQL = "SELECT * " +
            "FROM tblibro AS L INNER JOIN tbtema AS T ON L.idtema = T.idtema " +
            "WHERE titulo LIKE ? " +
            "ORDER BY idlibro DESC";
//        SQL = "SELECT L.idlibro, L.isbn, L.titulo, L.autor, L.cantpaginas, L.editorial, "
//                + "L.fechaPublicacion, L.precio, L.idtema, T.descripcion "
//                + "FROM tblibro L INNER JOIN tbtema T ON L.idtema = T.idtema " +
//                "WHERE L.titulo LIKE ? ORDER BY L.idlibro DESC";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, "%"+tit+"%");
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron Libros que contengan ese título.");
            }else{
                do{
                    Libro libr = new Libro();
                    libr.setIdlibro(rs.getInt("idlibro"));
                    libr.setIsbn(rs.getString("isbn"));
                    libr.setTitulo(rs.getString("titulo"));
                    libr.setAutor(rs.getString("autor"));
                    libr.setCantpaginas(rs.getInt("cantpaginas"));
                    libr.setEditorial(rs.getString("editorial"));
                    libr.setFechapublicacion(rs.getDate("fechaPublicacion"));
                    libr.setPrecio(rs.getFloat("precio"));
                    //System.out.println(lib.getTitulo());
                    Tema t = new Tema(rs.getInt("idtema"), rs.getString("descripcion"));
                    //Tema t = new Tema(44, rs.getString("descripcion"));

//                    Libro libr = new Libro();
//                    libr.setIdlibro(rs.getInt(1));
//                    libr.setIsbn(rs.getString(2));
//                    libr.setTitulo(rs.getString(3));
//                    libr.setAutor(rs.getString(4));
//                    libr.setCantpaginas(rs.getInt(5));
//                    libr.setEditorial(rs.getString(6));
//                    libr.setFechapublicacion(rs.getDate(7));
//                    libr.setPrecio(rs.getFloat(8));
//                    //System.out.println(lib.getTitulo());
//                    //Tema t = new Tema(rs.getInt("idtema"), rs.getString("descripcion"));
//                    Tema t = new Tema();
//                    t.setIdtema(rs.getInt(9));
//                    t.setDescripcion(rs.getString(11));
                    libr.setTema(t);
                    listaLib.add(libr);
                }while(rs.next());
//                for (Libro libro : listaLib) {
//                    System.out.println(libro.toString());
//                }
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar el Libro. (Err:"+e+")");
        }
        return listaLib;
    }
    
    public LinkedList<Libro> GetAllLibros(){
        LinkedList<Libro> listaLib = new LinkedList<>();
        Conectar();
        //SQL = "SELECT * FROM tblibro ORDER BY titulo";
        SQL = "SELECT * FROM tblibro ORDER BY idlibro DESC";
//SQL = "SELECT * FROM tblibro L INNER JOIN tbtema T ON L.idtema = T.idtema ORDER BY idlibro DESC";
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron libros que coincidan.");
            }else {
                do{
                    Libro book = new Libro();
                    TemaDAO teDAO = new TemaDAO();
                    //Tema te = new Tema();
                    //te = teDAO.GetTemaByID(rs.getInt(9));
                    //te.setDescripcion(teDAO.GetTemaByID(rs.getInt(9)).getDescripcion());
                    //te.setIdtema(rs.getInt(9));
                    book.setIdlibro(rs.getInt(1));
                    book.setIsbn(rs.getString(2));
                    book.setTitulo(rs.getString(3));
                    book.setAutor(rs.getString(4));
                    book.setCantpaginas(rs.getInt(5));
                    book.setEditorial(rs.getString(6));
                    book.setFechapublicacion(rs.getDate(7));
                    book.setPrecio(rs.getDouble(8));
                    //book.setTema(te);
                    book.setTema(teDAO.GetTemaByID(rs.getInt(9)));
                    listaLib.add(book);
//                    Tema tem = new Tema(rs.getInt(9), rs.getString(10));
//                    book.setTema(tem);
                }while(rs.next());
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los libros. (Err:"+e+")");
        }
        //System.out.println("mmmmm");
        return listaLib;
    }
    
    public int ModificarLibro(Libro lib){
        int res = -1;
        Conectar();

        SQL = "UPDATE tblibro " +
            "SET isbn = ?, titulo = ?, autor = ?, cantpaginas = ?, editorial = ?, " +
                "fechaPublicacion = ?, precio = ?, idtema = ? " +
            "WHERE idlibro = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, lib.getIsbn());
            ps.setString(2, lib.getTitulo());
            ps.setString(3, lib.getAutor());
            ps.setInt(4, lib.getCantpaginas());
            ps.setString(5, lib.getEditorial());
            ps.setDate(6, new java.sql.Date(lib.getFechapublicacion().getTime()));
            ps.setDouble(7, lib.getPrecio());
            ps.setInt(8, lib.getTema().getIdtema());
            ps.setInt(9, lib.getIdlibro());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el Libro. (Err:"+e+")");
        }
        //System.out.println("el resultado es "+res);
        return res;
    }
    
    public int AgregarLibro(Libro lib){
        int res = -1;
        Conectar();
        SQL = "INSERT INTO tblibro(idlibro, isbn, titulo, autor, cantpaginas, editorial, fechaPublicacion, precio, idtema)"
                + "VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, lib.getIsbn());
            ps.setString(2, lib.getTitulo());
            ps.setString(3, lib.getAutor());
            ps.setInt(4, lib.getCantpaginas());
            ps.setString(5, lib.getEditorial());
            //ps.setDate(6, (Date) lib.getFechapublicacion());
            //ps.setDate(6, ("1995-10-22"));
            ps.setDate(6, new java.sql.Date(lib.getFechapublicacion().getTime()));
            ps.setDouble(7, lib.getPrecio());
            ps.setInt(8, lib.getTema().getIdtema());
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error creando el libro_. (Err:"+e+")");
        }
        return res;
    }
    
    public int EliminarLibro(int idLibro){
        int res = -1;
        SQL = "DELETE FROM tblibro WHERE idlibro = ?";
        Conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idLibro);
            if(ps.executeUpdate() > 0){
                res = 1;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error intentado borrar el Libro. (Err:"+e+")");
        }
        return res;
    }
    
        
    public LinkedList<Libro> GetBookPersonalizado (boolean busqTit, String titulo, boolean busqAutor, String autor, boolean busqEditor, String editor, int tema){
        LinkedList<Libro> listaLibros = new LinkedList<Libro>();
        TemaDAO teDAO = new TemaDAO();
        SQL = "SELECT * FROM tblibro";
        int cont = 0;
        if(busqTit){
           SQL += " WHERE titulo LIKE ?";
           cont++;
        }
        if(busqAutor){
            if(cont > 0){
                SQL += " AND autor LIKE ?";
            }else{
                SQL += " WHERE autor LIKE ?";
            }
            cont++;
        }
        if(busqEditor){
            if(cont > 0){
                SQL += " AND editorial LIKE ?";
            }else{
                SQL += " WHERE editorial LIKE ?";
            }
            cont++;
        }
        if(tema > 0){
            if(cont > 0){
                SQL += " AND idtema = ?";
            }else{
                SQL += " WHERE idtema = ?";
            }
            cont++;
        }
        
        SQL += " ORDER BY idlibro DESC";

        Conectar();
        try {
            int cont2 = 0;
            PreparedStatement ps = cn.prepareStatement(SQL);
            if(busqTit){
                cont2++;
                ps.setString(1, "%"+titulo+"%");
            }
            if(busqAutor){
                cont2++;
                ps.setString(cont2, "%"+autor+"%");
            }
            if(busqEditor){
                cont2++;
                ps.setString(cont2, "%"+editor+"%");
            }
            if(tema > 0){
                cont2++;
                ps.setInt(cont2, tema);
            }
            ResultSet rs = ps.executeQuery();
            //System.out.println(ps);
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron libros que coincidan.");
            }else {
                do{
                    Libro book = new Libro();
                    book.setIdlibro(rs.getInt(1));
                    book.setIsbn(rs.getString(2));
                    book.setTitulo(rs.getString(3));
                    book.setAutor(rs.getString(4));
                    book.setCantpaginas(rs.getInt(5));
                    book.setEditorial(rs.getString(6));
                    book.setFechapublicacion(rs.getDate(7));
                    book.setPrecio(rs.getDouble(8));
                    book.setTema(teDAO.GetTemaByID(rs.getInt(9)));
                    listaLibros.add(book);
                }while(rs.next());
                rs.close();
                ps.close();
                cn.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error realizando la busqueda personalizada de libros. (Err:"+e+")");
        }
//        System.out.println(SQL);
        return listaLibros;
    }
    
    public LinkedList<Libro> GetBookPersonalizado2 (boolean busqTit, String titulo, boolean busqAutor, String autor, boolean busqEditor, String editor, int tema){
        LinkedList<Libro> listaLibros = new LinkedList<Libro>();
        TemaDAO teDAO = new TemaDAO();
        SQL = "SELECT * FROM tblibro";
        int cont = 0;
        if(busqTit){
           SQL += " WHERE titulo LIKE '%"+titulo+"%'";
           cont++;
        }
        if(busqAutor){
            if(cont > 0){
                SQL += " AND autor LIKE '%"+autor+"%'";
            }else{
                SQL += " WHERE autor LIKE '%"+autor+"%'";
            }
            cont++;
        }
        if(busqEditor){
            if(cont > 0){
                SQL += " AND editorial LIKE '%"+editor+"%'";
            }else{
                SQL += " WHERE editorial LIKE '%"+editor+"%'";
            }
            cont++;
        }
        if(tema > 0){
            if(cont > 0){
                SQL += " AND idtema = "+tema;
            }else{
                SQL += " WHERE idtema = "+tema;
            }
            cont++;
        }
        Conectar();
        try {
            int cont2 = 0;
            PreparedStatement ps = cn.prepareStatement(SQL);
            if(busqTit){
                cont2++;
                ps.setString(cont2, titulo);
                System.out.println("tit");
            }
            if(busqAutor){
                cont2++;
                ps.setString(cont2, autor);
                System.out.println("aut");
            }
            if(busqEditor){
                cont2++;
                ps.setString(cont2, editor);
                System.out.println("edit");
            }
            if(tema > 0){
                cont2++;
                ps.setInt(cont2, tema);
                System.out.println("tem");
            }
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontraron libros que coincidan.");
            }else {
                while(rs.next()){
                    Libro book = new Libro();
                    System.out.println("*************");
                    book.setIdlibro(rs.getInt(1));
                    book.setIsbn(rs.getString(2));
                    book.setTitulo(rs.getString(3));
                    book.setAutor(rs.getString(4));
                    book.setCantpaginas(rs.getInt(5));
                    book.setEditorial(rs.getString(6));
                    book.setFechapublicacion(rs.getDate(7));
                    book.setPrecio(rs.getDouble(8));
                    book.setTema(teDAO.GetTemaByID(rs.getInt(9)));
                    listaLibros.add(book);
                }
                rs.close();
                ps.close();
                cn.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error realizando la busqueda personalizada de libros. (Err:"+e+")");
        }
        System.out.println(SQL);
        System.out.println("-1- "+busqTit+" -2- "+busqAutor+" -3- "+busqEditor+" -4- "+tema);
        System.out.println("-1- "+titulo+" -2- "+autor+" -3- "+editor+" -4- "+tema);
        return listaLibros;
    }
    
}
