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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sistemaserviciosocial.IReporteDAO;
import sistemaserviciosocial.Reporte;
import sistemaserviciosocial.ReporteDAO;

/**
 * Clase que lleva el control de la ventana FXMLModificarReporte
 *
 * @author María José Hernández Molinos
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public class FXMLModificarReporteController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField fechaEntregaTextField;
    @FXML
    private TextField horasReportadasTextField;
    @FXML
    private TextField mesTextField;
    @FXML
    private Button modificarButton;
    @FXML
    private Label numReporteLabel;

    private Reporte reporte = null;

    @FXML
    void initialize() {
        mesTextField.setDisable(true);
        fechaEntregaTextField.setDisable(true);
        modificarButton.setOnAction(modificarButtonHandler());
    }

    /**
     * Inicializa la ventana con un reporte.
     * 
     * @param reporte reporte a utilizar
     */
    public void initData(Reporte reporte) {
        this.reporte = reporte;
        numReporteLabel.setText(numReporteLabel.getText() + " " + reporte.getNumero());
        mesTextField.setText(reporte.getMes());
        fechaEntregaTextField.setText(reporte.getFechaEntrega().toString());
        horasReportadasTextField.setText(String.valueOf(reporte.getHorasReportadas()));
    }

    /**
     * Modifica el reporte y guarda los cambios en la base de datos.
     * 
     * @return el evento del botón
     */
    public EventHandler<ActionEvent> modificarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (horasReportadasTextField.getText().isEmpty()) {
                    new Alert(AlertType.WARNING, "Faltan campos por completar").show();
                    return;
                }
                reporte.setHorasReportadas(Integer.parseInt(horasReportadasTextField.getText()));
                Alert confirmacionAlert = new Alert(
                    AlertType.CONFIRMATION, "¿Está seguro de que sea modificar el reporte?"
                );
                if (confirmacionAlert.showAndWait().get() == ButtonType.OK) {
                    if (reporte.modificar()) {
                        new Alert(
                            AlertType.INFORMATION, "El reporte ha sido modificado exitosamente"
                        ).showAndWait();
                        ((Stage) modificarButton.getScene().getWindow()).close();
                    } else {
                        new Alert(
                            AlertType.INFORMATION, "Ocurrió un error al modificar el reporte"
                        ).show();
                    }
                }
            }
        };
    }

}
