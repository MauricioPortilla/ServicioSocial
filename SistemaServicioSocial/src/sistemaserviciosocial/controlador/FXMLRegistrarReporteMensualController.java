
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Clase que lleva el control de la ventana FXMLRegistrarReporteMensual
 * 
 * @author María Saarayim González Hernández 
 * @version 1.0
 * @since 2019/06/08
 */


public class FXMLRegistrarReporteMensualController implements Initializable {

  @FXML private TableView reportesTableView;
  @FXML private TableColumn reporteTableColumn;
  @FXML private TableColumn fechaEntregaTableColumn;
  @FXML private TableColumn fechaInicioTableColuml;
  @FXML private Button editarButton;
  @FXML private Button cancelarButton;
  
  
  /**
   * Evento que cierra la ventana
   * @return el evento del bottón
   */
    private EventHandler<ActionEvent> cancelarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage) cancelarButton.getScene().getWindow()).close();
            }
        };
    }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    cancelarButton.setOnAction(cancelarButtonHandler());
  }  
  
}
