import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//Presentado por: Monica Lizette Calderon Urrego  CC: 1072072801  Milton Esguerra Suárez CC: 79842545 Oscar Julian Gonzalez Pachon CC: 1019060929;  



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
                        String sql = "SELECT * FROM compras";
                        Statement statement = conn.createStatement ();
                        ResultSet result = statement.executeQuery ( sql );
                                 while ( result.next() ){
                                        String id = result.getString(1);
                                        String alias = result.getString(2);
                                        String fabricante = result.getString(3);
                                        String fecha_hora = result.getString(4);
                                        
                                        System.out.println("I.D.: "+id+"\tAlias: "+alias+"\tFabricante: "+fabricante+"\tFecha y hora: "+fecha_hora);
                                            }
                          }catch (SQLException ex) {
                            System.out.println("EXCEPCION SQL: "+ex);
                            }
                }
         
        case 2 ->{
                     //Operación C, Create, Crear ---------------------------------------------------------- 
                try{
                    // Ejecutar este script en workbench para llaves foraneas SET GLOBAL FOREIGN_KEY_CHECKS=0	
                    Connection conn = DriverManager.getConnection ( dbURL , username , password );
                    System.out.println ("\n\033[0;31m\033[43m OPERACION CREACION: \n");
                    String sql = "INSERT INTO compras (id, alias, fabricante, fecha_hora) VALUES (?, ?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    //Genero las inserciones en la posición y el valor (Columna, Valor)
                    ps.setInt (1 , 118);
                    ps.setString (2 , "ouken");
                    ps.setString (3 , "starker");
                    ps.setString (4 , "2022-08-4 20:45:00");
                            int rows = ps.executeUpdate();
                            if ( rows > 0) {
                                    System.out.println("¡Inserción exitosa!");
                            }
                            } catch (SQLException ex) {
                            System.out.println("EXCEPCION SQL: "+ex);
                    } 
                }
           
        case 3 ->{
         
                try{
                    //Operación U, Update, Update------------------------------------------ ----------------
                    Connection conn = DriverManager.getConnection ( dbURL , username , password );
                    System.out.println ("\n\033[0;31m\033[43m OPERACION ACTUALIZACIÓN: \n");
                    String sql= "UPDATE compras SET alias =?, fabricante=?, fecha_hora=?  WHERE id =?";
                    PreparedStatement ps = conn . prepareStatement (sql);
                    //Genera la actualización en la posición y el valor (Columna, Valor)
                    ps.setString (1 , "Starlight" );
                    ps.setString (2 , "starker");
                    ps.setString (3 , "2022-08-4 20:45:00");
                    ps.setInt (4 , 118);
                                         
                        int rowsUpdated=ps.executeUpdate();
                        if ( rowsUpdated>0){
                        System.out.println("El registro fue " +" actualizado exitosamente!");

                        } 
                }catch( SQLException ex) {
                    System.out.println("EXCEPCION SQL: "+ex);
                    }
            
            }
        
        case 4 ->{
                
                try{
                    Connection conn = DriverManager.getConnection ( dbURL , username , password );
                    System.out.println ("\n\033[0;31m\033[43m OPERACION BORRAR: \n");
                    String sql = "DELETE FROM `reto5`.`compras` WHERE (`id` = ?);";
                    PreparedStatement statement = conn . prepareStatement (sql);
                    statement.setInt(1 , 118);
                    int rowsDeleted = statement.executeUpdate();
                    if ( rowsDeleted > 0) {
                         System.out.println("¡Borrado exitoso!");
                    }
                }catch(SQLException ex){
                System.out.println("EXCEPCION SQL: "+ex);
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
