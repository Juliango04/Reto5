import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConsultasCRUD {
    public static void main(String[] args) {
        
        String dbURL = "jdbc:mysql://localhost:3306/reto5";
        String username = "root";
        String password = "xw5H4a3^";
         //conectar
        try {
     //*********CONSULTA***********      
             Connection conn = DriverManager.getConnection ( dbURL , username , password );
              System.out.println ("\n\033[0;31m\033[43m OPERACION CONSULTA: \n");
                String sql = "SELECT * FROM clientes";
               Statement statement = conn.createStatement ();
             ResultSet result = statement.executeQuery ( sql );
         while ( result.next() ){
            String alias = result.getString(1);
            String nombre = result.getString(2);
            String apellidos = result.getString(3);
            String email = result.getString(4);
            String celular = result.getString(5);
            String contra = result.getString(6);
        System.out.println("Alias: "+alias+"\tNombre: "+nombre+"\tApellidos: "+apellidos+"\tEmail: "+email+"\tCel: "+celular+"\tCel: "+contra);
        }
        } catch (SQLException ex) {
    
        System.out.println("Error de Conexion");
        }
         
        try{
         //Operación C, Create, Crear ----------------------------------------------------------
        
        Connection conn = DriverManager.getConnection ( dbURL , username , password );
        System.out.println ("\n\033[0;31m\033[43m OPERACION CREACION: \n");
        String sql = "INSERT INTO compras (id , alias, fabricante, fecha_hora)VALUES ( VALUES (? , ? , ? , ? , ? , ?)";
        PreparedStatement statement = conn.prepareStatement( sql );
         //Genero las inserciones en la posición y el valor (Columna, Valor)
        statement.setInt (1 , 119);
        statement.setString (2 , "djampi");
        statement.setString (3 , "starker");
        statement.setString (4 , "2022-08-4 20:45:00");
        int rowsInserted = statement.executeUpdate ();
            if ( rowsInserted > 0) {
                    System.out.println ("¡Inserción exitosa!");
            }  
        } catch (SQLException ex) {
    
        System.out.println("Error de Conexion");
        
        }
    }
}
