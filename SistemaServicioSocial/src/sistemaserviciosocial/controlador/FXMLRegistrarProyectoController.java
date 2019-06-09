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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.HistorialAlumnoSS;
import sistemaserviciosocial.ISolicitudDAO;
import sistemaserviciosocial.Proyecto;
import sistemaserviciosocial.ResponsableProyecto;
import sistemaserviciosocial.Solicitud;
import sistemaserviciosocial.SolicitudAsignadaDAO;
import sistemaserviciosocial.SolicitudDAO;
import sistemaserviciosocial.Utilities;
import sistemaserviciosocial.WindowManager;

/**
 * FXMLRegistrarProyectoController es la clase que lleva el control de la interfaz
 * FXMLRegistrarProyecto, la cual registra un proyecto a partir de una solicitud no asignada.
 * 
 * @author Bruno Antonio López Luján
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/07
 */
public class FXMLRegistrarProyectoController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableColumn<Solicitud, String> actividadesTableColumn;
    @FXML
    private TableView<Alumno> alumnosAsignadosTableView;
    @FXML
    private Button cancelarButton;
    @FXML
    private TextField descripcionTextField;
    @FXML
    private TextField fechaInicioTextField;
    @FXML
    private TableColumn<Solicitud, String> horarioTableColumn;
    @FXML
    private TextField horarioTextField;
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
    private TextField nombreTextField;
    @FXML
    private TableColumn<Alumno, String> paternoTableColumn;
    @FXML
    private Button registrarButton;
    @FXML
    private TableColumn<Solicitud, String> requisitosTableColumn;
    @FXML
    private TableColumn<Solicitud, String> responsableTableColumn;
    @FXML
    private TableView<Solicitud> solicitudesTableView;
    @FXML
    private TableColumn<Solicitud, String> unidadTableColumn;

    private ISolicitudDAO solicitudDAO = new SolicitudDAO();

    @FXML
    void initialize() {
        unidadTableColumn.setCellValueFactory(new PropertyValueFactory<>("unidadReceptora"));
        noAlumnosTableColumn.setCellValueFactory(new PropertyValueFactory<>("numAlumnos"));
        actividadesTableColumn.setCellValueFactory(new PropertyValueFactory<>("actividades"));
        horarioTableColumn.setCellValueFactory(new PropertyValueFactory<>("horario"));
        responsableTableColumn.setCellValueFactory(new PropertyValueFactory<>("responsableUnidad"));
        lugarTableColumn.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        requisitosTableColumn.setCellValueFactory(new PropertyValueFactory<>("requisitos"));
        solicitudesTableView.setItems(solicitudDAO.getSolicitudesSinProyecto());
        solicitudesTableView.setOnMousePressed(dobleClicSolicitudesTableViewRow());

        matriculaTableColumn.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        paternoTableColumn.setCellValueFactory(new PropertyValueFactory<>("paterno"));
        maternoTableColumn.setCellValueFactory(new PropertyValueFactory<>("materno"));
        alumnosAsignadosTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        registrarButton.setOnAction(registrarButtonHandler());
    }

    /**
     * Permite seleccionar una fila de la tabla de solicitudes y mostrar los alumnos asociados
     * a la solicitud al dar doble clic sobre la fila.
     * 
     * @return el evento del botón
     */
    private EventHandler<MouseEvent> dobleClicSolicitudesTableViewRow() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Solicitud solicitudSeleccionada = 
                        solicitudesTableView.getSelectionModel().getSelectedItem();
                    if (solicitudSeleccionada == null) {
                        return;
                    }
                    ArrayList<HistorialAlumnoSS> listaHistorialesAlumnos = 
                        new SolicitudAsignadaDAO().getSolicitudesAsignadas(solicitudSeleccionada);
                    ObservableList<Alumno> listaAlumnos = FXCollections.observableArrayList();
                    for (HistorialAlumnoSS historial : listaHistorialesAlumnos) {
                        listaAlumnos.add(historial.getInscripcion().getAlumno());
                    }
                    alumnosAsignadosTableView.setItems(listaAlumnos);
                }
            }
        };
    }

    /**
     * Permite registrar el proyecto con respecto a los alumnos seleccionados y los datos
     * introducidos.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Solicitud solicitudSeleccionada = 
                    solicitudesTableView.getSelectionModel().getSelectedItem();
                ObservableList<Alumno> alumnosSeleccionados = 
                    alumnosAsignadosTableView.getSelectionModel().getSelectedItems();
                if (alumnosSeleccionados.size() == 0) {
                    new Alert(AlertType.WARNING, "Seleccione al menos un ALUMNO").showAndWait();
                    return;
                }

                String nombreProyecto = nombreTextField.getText();
                String descripcionProyecto = descripcionTextField.getText();
                String horarioProyecto = horarioTextField.getText();
                String fechaInicioProyecto = fechaInicioTextField.getText();
                if (nombreProyecto.isEmpty() || descripcionProyecto.isEmpty() ||
                    horarioProyecto.isEmpty() || fechaInicioProyecto.isEmpty()
                ) {
                    new Alert(AlertType.WARNING, "Faltan campos por completar").showAndWait();
                    return;
                }

                for (Alumno alumnoSeleccionado : alumnosSeleccionados) {
                    FXMLSubirArchivoController controller = WindowManager.showSubirArchivoWindow(
                        alumnoSeleccionado, true, Utilities.TIPO_ARCHIVO_CARTA_ACEPTACION
                    );
                    if (!controller.didFinish) {
                        new Alert(
                            AlertType.WARNING, "Debes subir la carta de aceptación de este alumno"
                        ).showAndWait();
                        return;
                    }
                }
                ResponsableProyecto responsableProyecto = new ResponsableProyecto(
                    0, solicitudSeleccionada.getResponsableUnidad(), "", "", "", ""
                );
                Proyecto proyectoNuevo = new Proyecto(
                    0, solicitudSeleccionada, responsableProyecto, nombreProyecto, 
                    descripcionProyecto, horarioProyecto, alumnosSeleccionados.size(), 
                    solicitudSeleccionada.getActividades(), LocalDate.now()
                );
                if (proyectoNuevo.guardar()) {
                    new Alert(AlertType.INFORMATION, "Proyecto registrado").show();
                } else {
                    new Alert(AlertType.ERROR, "Ocurrió un error con la base de datos").show();
                }
            }
        };
    }

}
