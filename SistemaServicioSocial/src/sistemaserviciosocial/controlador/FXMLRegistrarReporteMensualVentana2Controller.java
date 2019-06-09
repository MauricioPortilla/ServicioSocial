
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Clase que lleva el control de la ventana FXMLRegistrarReporteMensualVentana2
 * 
 * @author María Saarayim González Hernández 
 * @version 1.0
 * @since 2019/06/08
 */


public class FXMLRegistrarReporteMensualVentana2Controller implements Initializable {

  @FXML private TextField horasReportadasTextField;
  @FXML private ComboBox mesComboBox;
  @FXML private Button aceptarButton;
  @FXML private Button cancelar;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
