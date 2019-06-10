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
import sistemaserviciosocial.controlador.FXMLAsignarServicioSocialController;
import sistemaserviciosocial.controlador.FXMLModificarReporteController;
import sistemaserviciosocial.controlador.FXMLRegistrarProyectoController;
import sistemaserviciosocial.controlador.FXMLRegistrarReporteMensualController;
import sistemaserviciosocial.controlador.FXMLRegistrarReporteMensualFormularioController;
import sistemaserviciosocial.controlador.FXMLSubirArchivoController;

/**
 * WindowManager es la clase que administra el control de las ventanas del sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public class WindowManager {

    /**
     * Abre una ventana Asignar Servicio Social.
     * 
     * @return el controlador de la ventana
     */
    public static FXMLAsignarServicioSocialController showAsignarServicioSocialWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(
                "/sistemaserviciosocial/interfaz/FXMLAsignarServicioSocial.fxml"
            ));
            Stage stage = new Stage();
            stage.setScene(new Scene((AnchorPane) loader.load()));
            stage.setTitle("Asignar servicio social");
            FXMLAsignarServicioSocialController controller = loader.
                <FXMLAsignarServicioSocialController>getController();
            stage.showAndWait();
            return controller;
        } catch (IOException e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al abrir la ventana.").show();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Abre una ventana Registrar Proyecto.
     * 
     * @return el controlador de la ventana
     */
    public static FXMLRegistrarProyectoController showRegistrarProyectoWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(
                "/sistemaserviciosocial/interfaz/FXMLRegistrarProyecto.fxml"
            ));
            Stage stage = new Stage();
            stage.setScene(new Scene((AnchorPane) loader.load()));
            stage.setTitle("Registrar proyecto");
            FXMLRegistrarProyectoController controller = loader.
                <FXMLRegistrarProyectoController>getController();
            stage.showAndWait();
            return controller;
        } catch (IOException e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al abrir la ventana.").show();
            e.printStackTrace();
            return null;
        }
    }
    
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

    /**
     * Abre una ventana Registrar Reporte Mensual con datos especificados.
     * 
     * @param alumno alumno a utilizar
     * @return el controlador de la ventana
     */
    public static FXMLRegistrarReporteMensualController showRegistrarReporteWindow(Alumno alumno) {
        try {
            FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(
                "/sistemaserviciosocial/interfaz/FXMLRegistrarReporteMensual.fxml"
            ));
            Stage stage = new Stage();
            stage.setScene(new Scene((AnchorPane) loader.load()));
            stage.setTitle("Registrar reporte mensual");
            FXMLRegistrarReporteMensualController controller = loader.
                <FXMLRegistrarReporteMensualController>getController();
            controller.initData(alumno);
            stage.showAndWait();
            return controller;
        } catch (IOException e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al abrir la ventana.").show();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Abre una ventana Registrar Reporte Mensual Formulario con datos especificados.
     * 
     * @param alumno alumno a utilizar
     * @param fechaEntrega fecha de entrega del reporte
     * @return el controlador de la ventana
     */
    public static FXMLRegistrarReporteMensualFormularioController showRegistrarReporteFormWindow(
        Alumno alumno, FechaEntregaReporte fechaEntrega
    ) {
        try {
            FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(
                "/sistemaserviciosocial/interfaz/FXMLRegistrarReporteMensualFormulario.fxml"
            ));
            Stage stage = new Stage();
            stage.setScene(new Scene((AnchorPane) loader.load()));
            stage.setTitle("Registrar reporte");
            FXMLRegistrarReporteMensualFormularioController controller = loader.
                <FXMLRegistrarReporteMensualFormularioController>getController();
            controller.initData(alumno, fechaEntrega);
            stage.showAndWait();
            return controller;
        } catch (IOException e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al abrir la ventana.").show();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Abre una ventana Modificar Reporte con datos especificados.
     * 
     * @param reporte reporte a modificar
     * @return el controlador de la ventana
     */
    public static FXMLModificarReporteController showModificarReporteWindow(Reporte reporte) {
        try {
            FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(
                "/sistemaserviciosocial/interfaz/FXMLModificarReporte.fxml"
            ));
            Stage stage = new Stage();
            stage.setScene(new Scene((AnchorPane) loader.load()));
            stage.setTitle("Modificar reporte");
            FXMLModificarReporteController controller = loader.
                <FXMLModificarReporteController>getController();
            controller.initData(reporte);
            stage.showAndWait();
            return controller;
        } catch (IOException e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al abrir la ventana.").show();
            e.printStackTrace();
            return null;
        }
    }
}
