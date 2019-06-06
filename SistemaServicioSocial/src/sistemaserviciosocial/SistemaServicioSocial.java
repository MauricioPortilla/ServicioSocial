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
package sistemaserviciosocial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * SistemaServicioSocial es la clase principal del programa y es quien lo inicializa.
 * 
 * @author Mauricio Cruz Portilla
 * @author María Saarayim González Hernández
 * @author María José Hernández Molinos
 * @author Bruno Antonio López Lujan
 * @version 1.0
 * @since 2019/05/14
 */
public class SistemaServicioSocial extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(
			getClass().getResource("interfaz/FXMLSistemaServicioSocial.fxml")
		);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
