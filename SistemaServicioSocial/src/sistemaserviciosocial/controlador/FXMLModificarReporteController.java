package sistemaserviciosocial.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


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
    void initialize() {
        assert fechaEntregaTextField != null : "fx:id=\"fechaEntregaTextField\" was not injected: check your FXML file 'FXMLModificarReporte.fxml'.";
        assert horasReportadasTextField != null : "fx:id=\"horasReportadasTextField\" was not injected: check your FXML file 'FXMLModificarReporte.fxml'.";
        assert mesTextField != null : "fx:id=\"mesTextField\" was not injected: check your FXML file 'FXMLModificarReporte.fxml'.";
        assert modificarButton != null : "fx:id=\"modificarButton\" was not injected: check your FXML file 'FXMLModificarReporte.fxml'.";


    }

}
