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
package sistemaserviciosocial;

import java.util.ArrayList;

import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

/**
 * SolicitudSeleccionadaDAO es la interfaz que maneja la información de las
 * Solicitud seleccionadas de un historial en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class SolicitudSeleccionadaDAO implements ISolicitudSeleccionadaDAO {

    @Override
    public ArrayList<Solicitud> getSolicitudesSeleccionadas(HistorialAlumnoSS historial) {
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        try {
            SQL.executeQuery(
                "SELECT idsolicitud FROM solicitudSeleccionada WHERE idhistorial = ?", 
                new ArrayList<Object>() {
                    {
                        add(historial.getId());
                    }
                }, (result) -> {
                    for (SQLRow row : result) {
                        solicitudes.add(new Solicitud((int) row.getColumnData("idsolicitud")));
                    }
                    return true;
                }, () -> {
                    return false;
                }
            );
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return solicitudes;
    }
    
}
