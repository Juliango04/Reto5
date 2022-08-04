import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConsultasCRUD {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String dbURL = "jdbc:mysql://localhost:3306/reto5";
        String username = "root";//Editar con el usuario que tiene cada para workbench
        String password = "xw5H4a3^";//Editar con la clave que tiene cada para workbench
        // conectar
        try {
            Connection conn = DriverManager.getConnection ( dbURL , username , password );
            if ( conn != null ) {
                System.out.println ("\n Conexión exitosa\n");
            }
        } catch (SQLException ex) {
    }

// Operación R, Read, Retrieve, Leer, Consultar ---------------------------------------
       String sql = "SELECT * FROM motocicletas";
       ResultSet result = statement.executeQuery (sql);
        try {
            
            while ( result.next() ){
                String titulo = result.getString(2);
                int pub = result.getInt(3);
                Double costo = result.getDouble(6);
                System.out.println("id: " +titulo+ "\tFabricante: " +pub+ "\tprecio: " +costo );
            }       } catch (SQLException ex) {
            Logger.getLogger(ConsultasCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
    }


    }
}
    
    
