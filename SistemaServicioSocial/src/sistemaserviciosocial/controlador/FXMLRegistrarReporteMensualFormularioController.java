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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.Archivo;
import sistemaserviciosocial.FechaEntregaReporte;
import sistemaserviciosocial.HistorialAlumnoSS;
import sistemaserviciosocial.Reporte;
import sistemaserviciosocial.Utilities;
import sistemaserviciosocial.WindowManager;

/**
 * Clase que lleva el control de la ventana FXMLRegistrarReporteMensualFormulario
 *
 * @author María Saarayim González Hernández
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public class FXMLRegistrarReporteMensualFormularioController {

    @FXML
    private TextField horasReportadasTextField;
    @FXML
    private ComboBox<String> mesComboBox;
    @FXML
    private Button registrarButton;
    @FXML
    private Button cancelarButton;

    private Alumno alumno = null;
    private FechaEntregaReporte fechaEntregaReporte = null;

    @FXML
    void initialize() {
        mesComboBox.setItems(Utilities.MESES);
        registrarButton.setOnAction(registrarButtonHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
    }

    /**
     * Inicializa la ventana con datos especificados.
     * 
     * @param alumno alumno a utilizar
     * @param fechaEntregaReporte fecha de entrega a utilizar
     */
    public void initData(Alumno alumno, FechaEntregaReporte fechaEntregaReporte) {
        this.alumno = alumno;
        this.fechaEntregaReporte = fechaEntregaReporte;
        mesComboBox.getSelectionModel().select(fechaEntregaReporte.getMes());
        mesComboBox.setDisable(true);
    }

    /**
     * Registra el reporte en la base de datos.
     *
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String horasReportadas = horasReportadasTextField.getText();
                String mes = mesComboBox.getSelectionModel().getSelectedItem();
                if (horasReportadas.isEmpty() || mes.isEmpty()) {
                    new Alert(AlertType.WARNING, "Faltan campos por completar").show();
                    return;
                }
                FXMLSubirArchivoController subirArchivoController = 
                    WindowManager.showSubirArchivoWindow(
                        alumno, true, Utilities.TIPO_ARCHIVO_REPORTE
                    );
                if (!subirArchivoController.didFinish) {
                    new Alert(
                        AlertType.WARNING, 
                        "Debes subir el archivo del reporte para completar el registro"
                    ).showAndWait();
                    return;
                }
                HistorialAlumnoSS historialAlumno = alumno.getInscripcion().getHistorial();
                int numReportesEntregados = historialAlumno.getNumReportesEntregados() + 1;
                Archivo archivoSubido = 
                    historialAlumno.getArchivos().get(historialAlumno.getArchivos().size() - 1);
                Reporte reporteNuevo = new Reporte(
                    0, numReportesEntregados, Integer.parseInt(horasReportadas), mes, 
                    LocalDate.now(), "No validado", mes, historialAlumno, fechaEntregaReporte, 
                    archivoSubido
                );
                if (reporteNuevo.guardar()) {
                    new Alert(AlertType.INFORMATION, "Reporte guardado").show();
                    cancelarButton.fire();
                } else {
                    new Alert(AlertType.ERROR, "Ocurrió un error al guardar el reporte").show();
                    archivoSubido.eliminar();
                }
            }
        };
    }

    /**
     * Evento que cierra la ventana
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
