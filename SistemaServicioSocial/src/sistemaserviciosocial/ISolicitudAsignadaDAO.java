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
 * ISolicitudAsignadaDAO es la interfaz que maneja la información de las Solicitud
 * asignadas a los historiales de los alumnos en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public interface ISolicitudAsignadaDAO {

    /**
     * Retorna una lista de historiales de alumnos que posean la solicitud ingresada como
     * asignada.
     * 
     * @param solicitud solicitud asignada
     * @return lista de historiales de alumnos
     */
    public ArrayList<HistorialAlumnoSS> getSolicitudesAsignadas(Solicitud solicitud);

    /**
     * Retorna una solicitud asignada al historial ingresado.
     * 
     * @param historial historial del alumno
     * @return solicitud asignada
     */
    public Solicitud getSolicitudAsignada(HistorialAlumnoSS historial);

    /**
     * Inserta una solicitud asignada a un historial en la base de datos.
     * 
     * @param historial historial del alumno
     * @param solicitud solicitud a asignar
     * @return <code>true</code> si se insertó correctamente. <code>false</code> si
     *         ocurrió un error.
     */
    public boolean insertSolicitudAsignada(HistorialAlumnoSS historial, Solicitud solicitud);
}
