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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Utilities es la clase que brinda herramientas para manejar datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class Utilities {

    public static ObservableList<Alumno> filterAlumnos(
        ObservableList<Alumno> list, UtilitiesFilters filterType
    ) {
        ObservableList<Alumno> newList = FXCollections.observableArrayList();
        switch (filterType) {
            case FILTER_ALUMNOS_BY_NO_SOLICITUD_ASIGNADA:
                for (Alumno alumno : list) {
                    if (alumno.getInscripcion().getHistorial().getSolicitudAsignada() == null) {
                        newList.add(alumno);
                    }
                }
                break;
        }
        return newList;
    }
}
