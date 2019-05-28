package sistemaserviciosocial.controlador;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.AlumnoDAO;
import sistemaserviciosocial.IAlumnoDAO;
import sistemaserviciosocial.ISolicitudDAO;
import sistemaserviciosocial.Solicitud;
import sistemaserviciosocial.SolicitudDAO;
import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

public class FXMLAsignarServicioSocialController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<Solicitud, String> actividadesTableColumn;

	@FXML
	private TableView<Alumno> alumnosTableView;

	@FXML
	private Button asignarButton;

	@FXML
	private TableColumn<Solicitud, String> horarioTableColumn;

	@FXML
	private TableColumn<Solicitud, String> lugarTableColumn;

	@FXML
	private TableColumn<Alumno, String> maternoTableColumn;

	@FXML
	private TableColumn<Alumno, String> matriculaTableColumn;

	@FXML
	private TableColumn<Solicitud, Integer> noAlumnosTableColumn;

	@FXML
	private TableColumn<Alumno, String> nombreTableColumn;

	@FXML
	private TableColumn<Alumno, String> paternoTableColumn;

	@FXML
	private TableColumn<Solicitud, String> requisitosTableColumn;

	@FXML
	private TableColumn<Solicitud, String> responsableTableColumn;

	@FXML
	private Label solicitudesAlumnoSeleccionadoLabel;

	@FXML
	private TableView<Solicitud> solicitudesTableView;

	private ISolicitudDAO solicitudDAO = new SolicitudDAO();
	private IAlumnoDAO alumnoDAO = new AlumnoDAO();

	@FXML
	void initialize() {
		noAlumnosTableColumn.setCellValueFactory(new PropertyValueFactory<>("numAlumnos"));
		actividadesTableColumn.setCellValueFactory(new PropertyValueFactory<>("actividades"));
		horarioTableColumn.setCellValueFactory(new PropertyValueFactory<>("horario"));
		responsableTableColumn.setCellValueFactory(new PropertyValueFactory<>("responsableUnidad"));
		lugarTableColumn.setCellValueFactory(new PropertyValueFactory<>("lugar"));
		requisitosTableColumn.setCellValueFactory(new PropertyValueFactory<>("requisitos"));

		matriculaTableColumn.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		nombreTableColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		paternoTableColumn.setCellValueFactory(new PropertyValueFactory<>("paterno"));
		maternoTableColumn.setCellValueFactory(new PropertyValueFactory<>("materno"));

		alumnosTableView.setItems(alumnoDAO.getAlumnos(true));
		solicitudesTableView.setItems(solicitudDAO.getSolicitudes());

		asignarButton.setOnAction(asignarButtonHandler());
	}

	private EventHandler<ActionEvent> asignarButtonHandler() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (alumnosTableView.getSelectionModel().getSelectedItems().size() < 1) {
					new Alert(AlertType.WARNING, "Debes seleccionar un alumno de la tabla").show();
					return;
				} else if (solicitudesTableView.getSelectionModel().getSelectedItems().size() < 1) {
					new Alert(AlertType.WARNING, "Debes seleccionar una solicitud de la tabla").show();
					return;
				}
				Alert asignacionAlert = new Alert(AlertType.CONFIRMATION, "¿Desea realizar esta asignación?");
				if (asignacionAlert.showAndWait().get() == ButtonType.OK) {
					System.out.println("Asignando");
				}
			}
		};
	}

}
