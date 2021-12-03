package DAO;

import Identidades.Cliente;
import Identidades.ClienteConDirecc;
import Identidades.Direccion;
import Identidades.Localidad;
import Identidades.Provincia;
import Identidades.TipoDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;



public class ClienteDAO extends Conexion {
    private String SQL;
    
    public LinkedList<ClienteConDirecc> GetAllClientesConDirecc(){
        LinkedList<ClienteConDirecc> listaCli = new LinkedList<>();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +//1 - 2 - 3 - 4
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +//5 - 6
            "C.nrodocumento, D.calle, D.numero, D.piso, D.departamento, " +//7-8-9-10-11
            "L.idlocalidad, L.nombre AS Localidad, L.nom_departamento, " +//12-13-14
            "P.idprovincia, P.nombre AS Provincia " +//15-16
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento INNER JOIN " +
            "tbdireccion AS D ON C.nrodocumento = D.iddireccion INNER JOIN " +
            "tbprovincia AS P ON D.idprovincia = P.idprovincia INNER JOIN " +
            "tblocalidad AS L ON D.idlocalidad = L.idlocalidad " +
            "ORDER BY C.idcliente DESC";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron Clientes.");
            }else{
                
                do{
                    TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                    Provincia p = new Provincia((rs.getInt(15)), (rs.getString(16)));
                    Localidad l = new Localidad((rs.getLong(12)), (rs.getString(13)), (rs.getString(14)));
                    Direccion d = new Direccion((rs.getLong(7)), (rs.getString(8)), (rs.getInt(9)), (rs.getInt(10)), (rs.getString(11)), l, p);
                    ClienteConDirecc cli = new ClienteConDirecc((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)), d);
                    listaCli.add(cli);
                }while(rs.next());
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes_. (Err:"+e+")");
        }
        return listaCli;
    }
     
    public ClienteConDirecc GetClientesConDireccPorIDCliente(int idCli){
        ClienteConDirecc cliente = new ClienteConDirecc();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +//1 - 2 - 3 - 4
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +//5 - 6
            "C.nrodocumento, D.calle, D.numero, D.piso, D.departamento, " +//7-8-9-10-11
            "L.idlocalidad, L.nombre AS Localidad, L.nom_departamento, " +//12-13-14
            "P.idprovincia, P.nombre AS Provincia " +//15-16
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento INNER JOIN " +
            "tbdireccion AS D ON C.nrodocumento = D.iddireccion INNER JOIN " +
            "tbprovincia AS P ON D.idprovincia = P.idprovincia INNER JOIN " +
            "tblocalidad AS L ON D.idlocalidad = L.idlocalidad " +
            "WHERE C.idCliente = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idCli);
            ResultSet rs = ps.executeQuery();
            if(!(rs.first())){
                JOptionPane.showMessageDialog(null, "No se encontró el Cliente.");
            }else{
                TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                Provincia p = new Provincia((rs.getInt(15)), (rs.getString(16)));
                Localidad l = new Localidad((rs.getLong(12)), (rs.getString(13)), (rs.getString(14)));
                Direccion d = new Direccion((rs.getLong(7)), (rs.getString(8)), (rs.getInt(9)), (rs.getInt(10)), (rs.getString(11)), l, p);
                cliente = new ClienteConDirecc((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)), d);
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes. (Err:"+e+")");
        }
        return cliente;
    }
    
    public LinkedList<ClienteConDirecc> GetClientesConDireccPorNombre(String nomb){
        LinkedList<ClienteConDirecc> listaCli = new LinkedList<>();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +//1 - 2 - 3 - 4
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +//5 - 6
            "C.nrodocumento, D.calle, D.numero, D.piso, D.departamento, " +//7-8-9-10-11
            "L.idlocalidad, L.nombre AS Localidad, L.nom_departamento, " +//12-13-14
            "P.idprovincia, P.nombre AS Provincia " +//15-16
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento INNER JOIN " +
            "tbdireccion AS D ON C.nrodocumento = D.iddireccion INNER JOIN " +
            "tbprovincia AS P ON D.idprovincia = P.idprovincia INNER JOIN " +
            "tblocalidad AS L ON D.idlocalidad = L.idlocalidad " +
            "WHERE C.razonSocial LIKE ? " +
            "ORDER BY C.idcliente DESC";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, "%"+nomb+"%");
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron Clientes con ese nombre.");
            }else{
                
                do{
                    TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                    Provincia p = new Provincia((rs.getInt(15)), (rs.getString(16)));
                    Localidad l = new Localidad((rs.getLong(12)), (rs.getString(13)), (rs.getString(14)));
                    Direccion d = new Direccion((rs.getLong(7)), (rs.getString(8)), (rs.getInt(9)), (rs.getInt(10)), (rs.getString(11)), l, p);
                    ClienteConDirecc cli = new ClienteConDirecc((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)), d);
                    listaCli.add(cli);
                }while(rs.next());
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes. (Err:"+e+")");
        }
        return listaCli;
    }
    
    public LinkedList<ClienteConDirecc> GetClientesConDireccPorDocumento(long doc){
        LinkedList<ClienteConDirecc> listaCli = new LinkedList<>();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +//1 - 2 - 3 - 4
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +//5 - 6
            "C.nrodocumento, D.calle, D.numero, D.piso, D.departamento, " +//7-8-9-10-11
            "L.idlocalidad, L.nombre AS Localidad, L.nom_departamento, " +//12-13-14
            "P.idprovincia, P.nombre AS Provincia " +//15-16
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento INNER JOIN " +
            "tbdireccion AS D ON C.nrodocumento = D.iddireccion INNER JOIN " +
            "tbprovincia AS P ON D.idprovincia = P.idprovincia INNER JOIN " +
            "tblocalidad AS L ON D.idlocalidad = L.idlocalidad " +
            "WHERE C.nrodocumento = ? " +
            "ORDER BY C.idcliente DESC";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, doc);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron Clientes con ese n° de documento.");
            }else{
                
                do{
                    TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                    Provincia p = new Provincia((rs.getInt(15)), (rs.getString(16)));
                    Localidad l = new Localidad((rs.getLong(12)), (rs.getString(13)), (rs.getString(14)));
                    Direccion d = new Direccion((rs.getLong(7)), (rs.getString(8)), (rs.getInt(9)), (rs.getInt(10)), (rs.getString(11)), l, p);
                    ClienteConDirecc cli = new ClienteConDirecc((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)), d);
                    listaCli.add(cli);
                }while(rs.next());
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes. (Err:"+e+")");
        }
        return listaCli;
    }
    
    public int AgregarClienteConDirecc(ClienteConDirecc cliente){
        int res = -1;
        DireccionDAO dirDAO = new DireccionDAO();
        if((dirDAO.AgregarDireccion(cliente.getDireccion())) > 0){
            SQL = "INSERT INTO tbcliente" +
                "(idcliente, idtipodocumento, nrodocumento, razonSocial, email, borrado) " +
                "VALUES(null, ?, ?, ?, ?, ?)";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setInt(1, cliente.getTipodocumento().getIdtipodocumento());
                ps.setLong(2, cliente.getNrodocumento());
                ps.setString(3, cliente.getRazonsocial());
                ps.setString(4, cliente.getEmail());
                ps.setBoolean(5, cliente.isBorrado());
                if(ps.executeUpdate() > 0){
                    res = 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error intentando agregar los datos del Cliente.");
                }
                ps.close();
                cn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error agregando el Cliente. (Err:"+e+")");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar agregar la dirección del cliente.");
        }
        return res;        
    }
    
    public int ActualizarClienteConDirecc(ClienteConDirecc cliente){
        int res = -1;
        DireccionDAO dirDAO = new DireccionDAO();
        if((dirDAO.ActualizarDireccion(cliente.getDireccion())) > 0){
            SQL = "UPDATE tbcliente " +
                "SET idtipodocumento = ?, nrodocumento = ?, razonSocial = ?, email = ?, borrado = ? " +
                "WHERE idcliente = ?";
            Conectar();
            try {
                PreparedStatement ps = cn.prepareStatement(SQL);
                ps.setInt(1, cliente.getTipodocumento().getIdtipodocumento());
                ps.setLong(2, cliente.getNrodocumento());
                ps.setString(3, cliente.getRazonsocial());
                ps.setString(4, cliente.getEmail());
                ps.setBoolean(5, cliente.isBorrado());
                ps.setInt(6, cliente.getIdcliente());
                if(ps.executeUpdate() > 0){
                    res = 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error intentando agregar los datos del Cliente.");
                }
                ps.close();
                cn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error agregando el Cliente. (Err:"+e+")");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar agregar la dirección del cliente.");
        }
        return res;        
    }
    
    /****************************************************************/
    /*****  Cliente sin dirección   *********************************/
    /****************************************************************/
    public Cliente GetClienteByIDCliente(int idCli){
        Cliente cliente = new Cliente();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +
            "C.nrodocumento " +
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento " +
            "WHERE C.idCliente = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, idCli);
            ResultSet rs = ps.executeQuery();
            if(!(rs.first())){
                JOptionPane.showMessageDialog(null, "No se encontró el Cliente.");
            }else{
                TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                cliente = new Cliente((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)));
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes. (Err:"+e+")");
        }
        return cliente;
    }
    
    public Cliente GetClienteByDocumento(long doc){
        Cliente cli = new Cliente();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +
            "C.nrodocumento " +
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento " +
            "WHERE C.nrodocumento = ? LIMIT 1";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, doc);
            ResultSet rs = ps.executeQuery();
            if(!(rs.first())){
                JOptionPane.showMessageDialog(null, "No se encontró el Cliente con ese n° de documento.");
            }else{
                TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                cli = new Cliente((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)));
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes. (Err:"+e+")");
        }
        return cli;
    }
    
    public LinkedList<Cliente> GetClientesPorNombre(String nomb){
        LinkedList<Cliente> listaCli = new LinkedList<>();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +
            "C.nrodocumento " +
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento " +
            "WHERE C.razonSocial LIKE ? " +
            "ORDER BY C.idcliente DESC";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setString(1, "%"+nomb+"%");
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron Clientes con ese nombre.");
            }else{
                
                do{
                    TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                    Cliente cli = new Cliente((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)));
                    listaCli.add(cli);
                }while(rs.next());
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes. (Err:"+e+")");
        }
        return listaCli;
    }
    //no sirve, debería haber uno solo, por eso devolvería 1 objeto no una linkedlist
    public LinkedList<Cliente> GetClientesPorDocumento(long doc){
        LinkedList<Cliente> listaCli = new LinkedList<>();
        SQL = "SELECT C.idcliente, C.razonSocial, C.email, C.borrado, " +
            "TD.idtipodocumento, TD.descripcion AS \"Tipo de documento\" , " +
            "C.nrodocumento " +
            "FROM tbcliente AS C INNER JOIN " +
            "tbtipodocumento AS TD ON C.idtipodocumento = TD.idtipodocumento " +
            "WHERE C.nrodocumento = ? " +
            "ORDER BY C.idcliente DESC";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, doc);
            ResultSet rs = ps.executeQuery();
            if(!(rs.next())){
                JOptionPane.showMessageDialog(null, "No se encontraron Clientes con ese n° de documento.");
            }else{
                
                do{
                    TipoDocumento tipoD = new TipoDocumento((rs.getInt(5)),(rs.getString(6)));
                    Cliente cli = new Cliente((rs.getInt(1)), tipoD, (rs.getLong(7)), (rs.getString(2)), (rs.getString(3)), (rs.getBoolean(4)));
                    listaCli.add(cli);
                }while(rs.next());
            }
            rs.close();
            cn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error recuperando los Clientes. (Err:"+e+")");
        }
        return listaCli;
    }
    
    public int ActualizarCliente(Cliente cliente){
        int res = -1;
        SQL = "UPDATE tbcliente " +
            "SET idtipodocumento = ?, nrodocumento = ?, razonSocial = ?, email = ?, borrado = ? " +
            "WHERE idcliente = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setInt(1, cliente.getTipodocumento().getIdtipodocumento());
            ps.setLong(2, cliente.getNrodocumento());
            ps.setString(3, cliente.getRazonsocial());
            ps.setString(4, cliente.getEmail());
            ps.setBoolean(5, cliente.isBorrado());
            ps.setInt(6, cliente.getIdcliente());
            if(ps.executeUpdate() > 0){
                res = 1;
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrió un error intentando agregar los datos del Cliente.");
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error agregando el Cliente. (Err:"+e+")");
        }
        return res;        
    }
    
    public boolean ExisteDocCliente(long doc){
        boolean existe = false;
        SQL = "SELECT 1 FROM tbcliente WHERE nrodocumento = ?";
        Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.setLong(1, doc);
            ResultSet rs = ps.executeQuery();
            if(rs.first()){
                existe = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error verificando si existe el cliente. (Err:"+e+")");
        }
        return existe;
    }
}
