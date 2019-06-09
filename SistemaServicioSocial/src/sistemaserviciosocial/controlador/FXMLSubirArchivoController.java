/*
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.Archivo;
import sistemaserviciosocial.Utilities;

/**
 * FXMLSubirArchivoController es la clase que lleva el control de la interfaz FXMLSubirArchivo,
 * la cual se encarga de subir archivos de un alumno a su correspondiente carpeta.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/07
 */
public class FXMLSubirArchivoController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button cancelarButton;
    @FXML
    private Button examinarButton;
    @FXML
    private TextField rutaArchivoTextField;
    @FXML
    private Button subirButton;
    @FXML
    private ComboBox<String> tipoArchivoComboBox;

    private Alumno alumno = null;
    private File fileSelected = null;
    private boolean openedAsInclude = false;
    public boolean didFinish = false;

    @FXML
    void initialize() {
        rutaArchivoTextField.setDisable(true);

        tipoArchivoComboBox.setItems(Utilities.TIPOS_ARCHIVOS);

        examinarButton.setOnAction(examinarButtonHandler());
        subirButton.setOnAction(subirButtonHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
    }

    /**
     * Inicializa la ventana con un alumno.
     * 
     * @param alumno alumno a utilizar
     * @param openedAsInclude <code>true</code> si debería cerrarse la ventana al subirse
     *                        el archivo; <code>false</code> si no
     * @param tipoArchivo bloquea el combobox del tipo de archivo con uno especificado. Si
     *                    está vacío, no estará bloqueado
     */
    public void initData(Alumno alumno, boolean openedAsInclude, String tipoArchivo) {
        this.alumno = alumno;
        this.openedAsInclude = openedAsInclude;
        if (!tipoArchivo.isEmpty()) {
            tipoArchivoComboBox.setDisable(true);
            tipoArchivoComboBox.getSelectionModel().select(tipoArchivo);
        }
    }

    /**
     * Permite examinar un archivo.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> examinarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileSelected = fileChooser.showOpenDialog(
                    examinarButton.getScene().getWindow()
                );
                if (fileSelected == null) {
                    return;
                }
                rutaArchivoTextField.setText(fileSelected.getPath());
            }
        };
    }

    /**
     * Guarda el archivo y guarda sus datos en la base de datos.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> subirButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String rutaArchivo = rutaArchivoTextField.getText();
                String tipoArchivo = tipoArchivoComboBox.getSelectionModel().getSelectedItem();
                if (rutaArchivo.isEmpty() || tipoArchivo.isEmpty()) {
                    new Alert(AlertType.WARNING, "No se ha seleccionado ningún archivo").show();
                    return;
                }
                String nuevoNombreArchivo = Utilities.setFileName(
                    fileSelected, tipoArchivo, alumno
                );
                Path alumnoArchivosPath = Utilities.getArchivosPathAlumno(
                    alumno.getInscripcion().getServicioSocial(), alumno
                );
                Path destinoArchivo = Paths.get(alumnoArchivosPath + "/" + nuevoNombreArchivo);
                try {
                    if (Files.notExists(alumnoArchivosPath)) {
                        Files.createDirectories(alumnoArchivosPath);
                    }
					Files.copy(
					    fileSelected.toPath(), destinoArchivo, StandardCopyOption.REPLACE_EXISTING
					);
				} catch (IOException e) {
                    new Alert(AlertType.ERROR, "Ocurrió un error al guardar los datos").show();
                    return;
                }
                Archivo nuevoArchivo = new Archivo(
                    0, alumno.getInscripcion().getHistorial(), nuevoNombreArchivo, 
                    destinoArchivo.toString(), "No validado", null
                );
                if (nuevoArchivo.guardar()) {
                    new Alert(AlertType.INFORMATION, "Archivo subido con éxito").showAndWait();
                    alumno.getInscripcion().getHistorial().initArchivos();
                    if (openedAsInclude) {
                        didFinish = true;
                        ((Stage) subirButton.getScene().getWindow()).close();
                        return;
                    }
                    fileSelected = null;
                    rutaArchivoTextField.clear();
                } else {
                    new Alert(AlertType.ERROR, "Ocurrió un error al guardar los datos").show();
                    destinoArchivo.toFile().delete();
                }
            }
        };
    }

    /**
     * Cierra la ventana actual.
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
