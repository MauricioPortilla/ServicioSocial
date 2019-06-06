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
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import sistemaserviciosocial.HistorialAlumnoSS;
import sistemaserviciosocial.IAlumnoDAO;
import sistemaserviciosocial.ISolicitudAsignadaDAO;
import sistemaserviciosocial.ISolicitudDAO;
import sistemaserviciosocial.ServicioSocial;
import sistemaserviciosocial.ServicioSocialDAO;
import sistemaserviciosocial.Solicitud;
import sistemaserviciosocial.SolicitudAsignadaDAO;
import sistemaserviciosocial.SolicitudDAO;
import sistemaserviciosocial.Utilities;
import sistemaserviciosocial.UtilitiesFilters;

/**
 * FXMLAsignarServicioSocialController es la clase que lleva el control de la interfaz
 * FXMlAsignarServicioSocial, la cual asigna solicitudes a los alumnos que no posean una.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/17
 */
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
	private ISolicitudAsignadaDAO solicitudAsignadaDAO = new SolicitudAsignadaDAO();
	private ServicioSocial servicioSocial = new ServicioSocialDAO().getLatestServicioSocial();

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

		alumnosTableView.setItems(Utilities.filterAlumnos(
			alumnoDAO.getAlumnos(servicioSocial.getId()), 
			UtilitiesFilters.FILTER_ALUMNOS_BY_NO_SOLICITUD_ASIGNADA
		));
		alumnosTableView.getSelectionModel().selectedItemProperty().addListener(
			(obs, oldSelection, newSelection) -> {
				if (newSelection != null) {
					String actividadesSolicitudes = "";
					ArrayList<Solicitud> solicitudes = 
						newSelection.getInscripcion().getHistorial().getSolicitudesSeleccionadas();
					for (Solicitud solicitud : solicitudes) {
						actividadesSolicitudes += "> " + solicitud.getActividades() + "\n";
					}
					solicitudesAlumnoSeleccionadoLabel.setText(actividadesSolicitudes);
				}
			}
		);
		solicitudesTableView.setItems(solicitudDAO.getSolicitudes());

		asignarButton.setOnAction(asignarButtonHandler());
	}

	/**
	 * Maneja el evento del botón de Asignar.
	 * 
	 * @return el evento del botón
	 */
	private EventHandler<ActionEvent> asignarButtonHandler() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Alumno> alumnosSeleccionados = 
					alumnosTableView.getSelectionModel().getSelectedItems();
				Solicitud solicitudSeleccionada = 
					solicitudesTableView.getSelectionModel().getSelectedItem();

				if (alumnosSeleccionados.size() < 1) {
					new Alert(AlertType.WARNING, "Debes seleccionar un alumno de la tabla").show();
					return;
				} else if (solicitudSeleccionada == null) {
					new Alert(
						AlertType.WARNING, "Debes seleccionar una solicitud de la tabla"
					).show();
					return;
				}

				Alert asignacionAlert = new Alert(
					AlertType.CONFIRMATION, "¿Desea realizar esta asignación?"
				);
				if (asignacionAlert.showAndWait().get() == ButtonType.OK) {
					ArrayList<HistorialAlumnoSS> historialesAsignados = 
						solicitudAsignadaDAO.getSolicitudesAsignadas(solicitudSeleccionada);
					if (historialesAsignados == null) {
						new Alert(
							AlertType.ERROR, 
							"Ocurrió un error al momento de verificar la disponibilidad"
						).show();
						return;
					}

					if (historialesAsignados.size() >= solicitudSeleccionada.getNumAlumnos()) {
						new Alert(
							AlertType.WARNING, 
							"Ya no hay disponibilidad para asignar esta solicitud a este alumno"
						).show();
						return;
					}
					
					boolean didSuccess = 
						alumnosSeleccionados.get(0).asignarSolicitud(solicitudSeleccionada);
					if (didSuccess) {
						new Alert(AlertType.INFORMATION, "Asignación realizada").showAndWait();
						for (Alumno alumnoSeleccionado : alumnosSeleccionados) {
							alumnosTableView.getItems().remove(alumnoSeleccionado);
						}
					} else {
						new Alert(
							AlertType.ERROR, "Ocurrió un error al momento de realizar la asignación"
						).show();
					}
				}
			}
		};
	}

}
