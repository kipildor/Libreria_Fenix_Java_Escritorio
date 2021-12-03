
package DAO;

import ConfigManager.Config;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection cn = null;
    private final String URL = Config.MySQL+Config.HOST+Config.PORT+Config.DB;
    
    public Connection Conectar(){
        try {
            Class.forName(Config.DRIVER);
            cn = (Connection)DriverManager.getConnection(URL,Config.USR,Config.PWD);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo conectar a la Base, error: " + ex);
            
            
        }
        System.out.println("Conexión exitosa!!");
        return cn;
    }
}
