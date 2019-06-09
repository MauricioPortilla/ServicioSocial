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

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.WindowManager;

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
	private Button asignarServicioSocialButton;
	@FXML
	private Button registrarProyectoButton;
	@FXML
	private Button registrarReporteButton;
	@FXML
	private Button subirArchivoButton;

	private Alumno alumno = new Alumno("S17013001");

	@FXML
	void initialize() {
		asignarServicioSocialButton.setOnAction(asignarServicioSocialButtonHandler());
		registrarProyectoButton.setOnAction(registrarProyectoButtonHandler());
		registrarReporteButton.setOnAction(registrarReporteButtonHandler());
		subirArchivoButton.setOnAction(subirArchivoButtonHandler());
	}

	/**
	 * Maneja el botón de Asignar Servicio Social
	 * 
	 * @return el evento del botón
	 */
	private EventHandler<ActionEvent> asignarServicioSocialButtonHandler() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				WindowManager.showAsignarServicioSocialWindow();
			}
		};
	}
	
	/**
	 * Maneja el botón de Registrar Proyecto
	 * 
	 * @return el evento del botón
	 */
	private EventHandler<ActionEvent> registrarProyectoButtonHandler() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				WindowManager.showRegistrarProyectoWindow();
			}
		};
	}
    
    /**
	 * Maneja el botón de Registrar Reporte
	 * 
	 * @return el evento del botón
	 */
	private EventHandler<ActionEvent> registrarReporteButtonHandler() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				WindowManager.showRegistrarReporteWindow(alumno);
			}
		};
	}

	/**
	 * Maneja el botón de Subir Archivo
	 * 
	 * @return el evento del botón
	 */
	private EventHandler<ActionEvent> subirArchivoButtonHandler() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				WindowManager.showSubirArchivoWindow(alumno, false, "");
			}
		};
	}

}
