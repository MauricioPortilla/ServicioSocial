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
package sistemaserviciosocial.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXMLSistemaServicioSocialController es la clase que lleva el control de la interfaz
 * FXMLSistemaServicioSocial, la cual muestra la ventana principal del programa.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/14
 */
public class FXMLSistemaServicioSocialController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button iniciarSesionButton;

	@FXML
	private Button registrarseButton;

	@FXML
	void initialize() {
		iniciarSesionButton.setOnAction(iniciarSesionButtonHandler());
	}

	/**
	 * Maneja el botón de Iniciar Sesión.
	 * 
	 * @return el evento del botón
	 */
	private EventHandler<ActionEvent> iniciarSesionButtonHandler() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource(
						"/sistemaserviciosocial/interfaz/FXMLSubirArchivo.fxml"
					));
					Stage stage = new Stage();
					stage.setScene(new Scene((AnchorPane) loader.load()));
					stage.setTitle("Asignar servicio social");
					stage.show();
				} catch (IOException e) {
					new Alert(AlertType.ERROR, "Ocurrió un error al abrir la ventana.").show();
					System.out.println(e.getMessage());
					System.out.println(e.getCause());
				}
			}
		};
	}

}
