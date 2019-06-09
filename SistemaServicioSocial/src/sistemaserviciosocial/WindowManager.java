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

package sistemaserviciosocial;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemaserviciosocial.controlador.FXMLSubirArchivoController;

/**
 *
 * @author Mauricio
 */
public class WindowManager {
    
    /**
     * Abre una ventana Subir Archivo con datos especificados.
     * 
     * @param alumno alumno a utilizar
     * @param openedAsInclude <code>true</code> si debería cerrarse la ventana al subirse
     *                        el archivo; <code>false</code> si no
     * @param tipoArchivo bloquea el combobox del tipo de archivo con uno especificado. Si
     *                    está vacío, no estará bloqueado
     * @return el controlador de la ventana
     */
    public static FXMLSubirArchivoController showSubirArchivoWindow(
        Alumno alumno, boolean openedAsInclude, String tipoArchivo
    ) {
        try {
            FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(
                "/sistemaserviciosocial/interfaz/FXMLSubirArchivo.fxml"
            ));
            Stage stage = new Stage();
            stage.setScene(new Scene((AnchorPane) loader.load()));
            stage.setTitle("Subir archivo");
            FXMLSubirArchivoController controller = loader.
                <FXMLSubirArchivoController>getController();
            controller.initData(alumno, openedAsInclude, tipoArchivo);
            stage.showAndWait();
            return controller;
        } catch (IOException e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al abrir la ventana.").show();
            return null;
        }
    }
}
