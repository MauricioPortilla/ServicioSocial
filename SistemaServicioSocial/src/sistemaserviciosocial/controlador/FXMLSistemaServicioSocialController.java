package sistemaserviciosocial.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/sistemaserviciosocial/interfaz/FXMLAsignarServicioSocial.fxml"));
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

}
