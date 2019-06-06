/**
 * Sistema de Servicio Social
 * Descripción: Sistema para el control de alumnos que cursan o cursaron la experiencia educativa
 * 				de Servicio Social.
 * Autores: (en orden alfabético)
 * 			Cruz Portilla Mauricio
 * 			González Hernández María Saarayim
 * 			Hernández Molinos María José
 * 			López Lujan Bruno Antonio
 * Fecha de creación: Mayo, 2019
 */

package sistemaserviciosocial.engine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Database es la clase que lleva a cabo la conexion a la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/02/22
 */
public class Database {
    private Connection connection;

    /**
     * Crea la conexion a la base de datos
     * 
     * @throws SQLException
     */
    public Database() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Connecting...");
            String url = "jdbc:mysql://localhost:3306/serviciosocialdb";
            connection = DriverManager.getConnection(url, "ss_user", "tm4");
            System.out.println("Connected.");
        } catch(SQLException sqlException){
            System.out.println("Connection error -> " + sqlException.getMessage());
            new Alert(
                AlertType.ERROR, "No fue posible realizar la conexión a la base de datos."
            ).show();
        } catch(ClassNotFoundException classException){
            classException.printStackTrace();
        } catch(Exception e){
            System.out.println("Se produjo un error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Retorna la conexion a la base de datos
     * @return la conexion
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Cierra la conexion a la base de datos
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            System.err.println("Error: " + sqlException.getMessage () + "\n" + sqlException.getErrorCode ());
        }
    }
}
