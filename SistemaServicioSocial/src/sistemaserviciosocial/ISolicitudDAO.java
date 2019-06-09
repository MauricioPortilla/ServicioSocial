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

import javafx.collections.ObservableList;

/**
 * ISolicitudDAO es la interfaz que maneja la información de las Solicitud
 * en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/24
 */
public interface ISolicitudDAO {

    /**
     * Retorna una lista de todas las solicitudes registradas en el sistema.
     * 
     * @return lista de solicitudes
     */
    public ObservableList<Solicitud> getSolicitudes();

    /**
     * Retorna una solicitud que coincida con el identificador ingresado en la base
     * de datos.
     * 
     * @param id identificador de la solicitud
     * @return solicitud encontrada
     */
    public Solicitud getSolicitud(int id);

    /**
     * Retorna una lista de todas las solicitudes que no estén relacionadas con
     * un Proyecto.
     * 
     * @return lista de solicitudes
     */
    public ObservableList<Solicitud> getSolicitudesSinProyecto();
}
