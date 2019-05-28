package sistemaserviciosocial.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.AlumnoDAO;
import sistemaserviciosocial.IAlumnoDAO;
import sistemaserviciosocial.ISolicitudDAO;
import sistemaserviciosocial.Solicitud;
import sistemaserviciosocial.SolicitudDAO;

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

		solicitudesTableView.setItems(solicitudDAO.getSolicitudes());

		matriculaTableColumn.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		nombreTableColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		paternoTableColumn.setCellValueFactory(new PropertyValueFactory<>("paterno"));
		maternoTableColumn.setCellValueFactory(new PropertyValueFactory<>("materno"));

		alumnosTableView.setItems(alumnoDAO.getAlumnos(true));
		solicitudesTableView.setItems(solicitudDAO.getSolicitudes());
	}

}
