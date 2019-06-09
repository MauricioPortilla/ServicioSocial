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

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.FechaEntregaReporte;
import sistemaserviciosocial.FechaEntregaReporteDAO;
import sistemaserviciosocial.IFechaEntregaReporteDAO;
import sistemaserviciosocial.IReporteDAO;
import sistemaserviciosocial.Reporte;
import sistemaserviciosocial.ReporteDAO;
import sistemaserviciosocial.WindowManager;

/**
 * Clase que lleva el control de la ventana FXMLRegistrarReporteMensual
 *
 * @author María Saarayim González Hernández
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public class FXMLRegistrarReporteMensualController {

    @FXML
    private Button cancelarButton;
    @FXML
    private Button editarButton;
    @FXML
    private TableView<FechaEntregaReporte> fechaEntregaReporteTableView;
    @FXML
    private TableColumn<FechaEntregaReporte, LocalDate> fechaLimiteTableColumn;
    @FXML
    private TableColumn<FechaEntregaReporte, LocalDate> fechaMinimaTableColumn;
    @FXML
    private TableColumn<FechaEntregaReporte, String> mesEntregaTableColumn;
    @FXML
    private Button registrarButton;

    private Alumno alumno = null;
    private IFechaEntregaReporteDAO fechaEntregaReporteDAO = new FechaEntregaReporteDAO();
    private IReporteDAO reporteDAO = new ReporteDAO();

    @FXML
    void initialize() {
        mesEntregaTableColumn.setCellValueFactory(new PropertyValueFactory<>("mes"));
        fechaMinimaTableColumn.setCellValueFactory(new PropertyValueFactory<>("fechaMinima"));
        fechaLimiteTableColumn.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));
        fechaEntregaReporteTableView.setItems(fechaEntregaReporteDAO.getFechaEntregas());

        registrarButton.setOnAction(registrarButtonHandler());
        editarButton.setOnAction(editarButtonHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
    }

    /**
     * Inicializa la ventana con un alumno.
     * 
     * @param alumno alumno a utilizar
     */
    public void initData(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Abre una ventana para registrar un reporte con base en la fecha de entrega seleccionada
     * de la tabla.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FechaEntregaReporte fechaEntregaSeleccionada = 
                    fechaEntregaReporteTableView.getSelectionModel().getSelectedItem();
                if (fechaEntregaSeleccionada == null) {
                    new Alert(
                        AlertType.WARNING, "Debes seleccionar una fecha de entrega de la tabla"
                    ).show();
                    return;
                }
                if (reporteDAO.getReporte(fechaEntregaSeleccionada).isLoaded()) {
                    new Alert(
                        AlertType.WARNING, "Ya hay un reporte registrado para esta fecha de entrega"
                    ).show();
                    return;
                }
                if (fechaEntregaSeleccionada.getFechaMinima().isAfter(LocalDate.now())) {
                    new Alert(
                        AlertType.WARNING, "Aún no puedes subir un reporte de esta fecha"
                    ).show();
                    return;
                }
                WindowManager.showRegistrarReporteFormWindow(alumno, fechaEntregaSeleccionada);
            }
        };
    }

    /**
     * Evento que cierra la ventana.
     *
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> editarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FechaEntregaReporte fechaEntregaSeleccionada = 
                    fechaEntregaReporteTableView.getSelectionModel().getSelectedItem();
                if (fechaEntregaSeleccionada == null) {
                    new Alert(
                        AlertType.WARNING, "Debes seleccionar una fecha de entrega de la tabla"
                    ).show();
                    return;
                }
                Reporte reporteFecha = reporteDAO.getReporte(fechaEntregaSeleccionada);
                if (!reporteFecha.isLoaded()) {
                    new Alert(
                        AlertType.WARNING, "No hay un reporte registrado para esta fecha de entrega"
                    ).show();
                    return;
                }
                WindowManager.showModificarReporteWindow(reporteFecha);
            }
        };
    }

    /**
     * Evento que cierra la ventana.
     *
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> cancelarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage) cancelarButton.getScene().getWindow()).close();
            }
        };
    }

}
