import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConsultasCRUD {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        boolean salida =  false;  
        //conectar
        String dbURL = "jdbc:mysql://localhost:3306/reto5";
        String username = "root";
        String password = "xw5H4a3^";
         
         do{
        
            System.out.println("\n INDIQUE LA OPERACION QUE DESEA REALIZAR\n");
            System.out.println("[1]-->CONSULTAR Registro");
            System.out.println("[2]-->AÑADIR Registro");
            System.out.println("[3]-->ACTUALIZAR Registro");
            System.out.println("[4]-->BORRAR Registro");
            System.out.println("[5]-->FINALIZAR PROGRAMA");
            
            int op = 0;
            boolean prueba = false;
            
            do{
                String opcion = sc.nextLine();
                if ("1".equals(opcion) || "2".equals(opcion) || "3".equals(opcion) || "4".equals(opcion) || "5".equals(opcion)){
                    op = Integer.parseInt(opcion);
                    prueba = true;
            
                }else{
                    System.out.println("***OPCION NO VALIDA*** INDIQUE UNA OPCION VALIDA");
                }
            
            }while(prueba == false);
         
        switch(op){
                case 1 -> {
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
                }
         
        case 2 ->{
                     //Operación C, Create, Crear ---------------------------------------------------------- 
                try{

                    Connection conn = DriverManager.getConnection ( dbURL , username , password );
                    System.out.println ("\n\033[0;31m\033[43m OPERACION CREACION: \n");
                    String sql = "INSERT INTO compras (id , alias, fabricante, fecha_hora)VALUES ( VALUES (? , ? , ? , ? , ? , ?))";
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
           
        case 3 ->{
         
                try{
                    //Operación U, Update, Update------------------------------------------ ----------------
                    Connection conn = DriverManager.getConnection ( dbURL , username , password );
                    System.out.println ("\n\033[0;31m\033[43m OPERACION ACTUALIZACIÓN: \n");
                    String sql= " UPDATE compras SET (alias,fabricante, fecha_hora) WHERE id =3";
                    PreparedStatement statement = conn . prepareStatement (sql );
                    
                    //Genera la actualización en la posición y el valor (Columna, Valor)

                    statement.setString (1, "GWB");
                    statement.setString (2, "Gwbicicletas");
                    statement.setDouble (3 , 100000.0);
               
                    int rowsUpdated=statement.executeUpdate();

                    if ( rowsUpdated>0){

                    System.out.println("El registro fue " +" actualizado exitosamente!");

                        } 
                }catch( SQLException ex) {
                    System.out.println( "Error de conexion" );
                    }
            
            }
        
        case 4 ->{
                
                try{
                    Connection conn = DriverManager.getConnection ( dbURL , username , password );
                    System.out.println ("\n\033[0;31m\033[43m OPERACION BORRAR: \n");
                    String sql = "DELETE FROM proveedor WHERE prov_id =?";
                    PreparedStatement statement = conn . prepareStatement (sql );
                    statement.setInt(1 , 1010);
                    int rowsDeleted = statement.executeUpdate();
                    if ( rowsDeleted > 0) {
                         System.out.println("¡Borrado exitoso!");
                    }
                }catch(SQLException ex){
                System.out.println( "Error de conexion" );
                }
            }
  
        case 5 ->{
                    System.out.println("\n\033[0;31m\033[43m***PROGRAMA FINALIZADO***");
                    salida = true;
                }
        }        
        }while(salida == false);  
    }   
}