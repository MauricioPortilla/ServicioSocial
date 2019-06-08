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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.Solicitud;

/**
 * FXMLRegistrarProyectoController es la clase que lleva el control de la interfaz
 * FXMLRegistrarProyecto, la cual registra un proyecto a partir de una solicitud no asignada.
 * 
 * @author Bruno Antonio López Luján 
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
    private TableColumn<Solicitud, String> noAlumnosTableColumn;

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

  /**
   * Initializes the controller class.
   */
    @FXML
    void initialize() {
        assert actividadesTableColumn != null : "fx:id=\"actividadesTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert alumnosAsignadosTableView != null : "fx:id=\"alumnosAsignadosTableView\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert cancelarButton != null : "fx:id=\"cancelarButton\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert descripcionTextField != null : "fx:id=\"descripcionTextField\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert fechaInicioTextField != null : "fx:id=\"fechaInicioTextField\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert horarioTableColumn != null : "fx:id=\"horarioTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert horarioTextField != null : "fx:id=\"horarioTextField\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert lugarTableColumn != null : "fx:id=\"lugarTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert maternoTableColumn != null : "fx:id=\"maternoTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert matriculaTableColumn != null : "fx:id=\"matriculaTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert noAlumnosTableColumn != null : "fx:id=\"noAlumnosTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert nombreTableColumn != null : "fx:id=\"nombreTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert nombreTextField != null : "fx:id=\"nombreTextField\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert paternoTableColumn != null : "fx:id=\"paternoTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert registrarButton != null : "fx:id=\"registrarButton\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert requisitosTableColumn != null : "fx:id=\"requisitosTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert responsableTableColumn != null : "fx:id=\"responsableTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert solicitudesTableView != null : "fx:id=\"solicitudesTableView\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";
        assert unidadTableColumn != null : "fx:id=\"unidadTableColumn\" was not injected: check your FXML file 'FXMLRegistrarProyecto.fxml'.";


    }

}
