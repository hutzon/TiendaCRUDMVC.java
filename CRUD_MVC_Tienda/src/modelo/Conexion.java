
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class Conexion {
       public static final String URL = "jdbc:mysql://localhost:3306/tienda?autoReconnect=true&useSSL=false";
    public static final String usuario = "root";
    public static final String contraseña = "CriGen15";
    
      public Connection getConnection (){
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL, usuario, contraseña);
            //JOptionPane.showMessageDialog(null,"Conexion Exitosa");
            
        }catch(Exception ex){
            System.err.println("Error, "+ex);
            
        }
        
        return conexion;
        
    }
    
    
}
