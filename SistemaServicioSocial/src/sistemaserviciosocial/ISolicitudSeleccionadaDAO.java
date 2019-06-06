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

/**
 * ISolicitudSeleccionadaDAO es la interfaz que maneja la información de las
 * Solicitud seleccionadas de un historial en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public interface ISolicitudSeleccionadaDAO {

    /**
     * Retorna una lista de todas las solicitudes seleccionadas pertenecientes al
     * historial ingresado.
     * 
     * @param historial historial del alumno
     * @return lista de solicitudes seleccionadas
     */
    public ArrayList<Solicitud> getSolicitudesSeleccionadas(HistorialAlumnoSS historial);
}
