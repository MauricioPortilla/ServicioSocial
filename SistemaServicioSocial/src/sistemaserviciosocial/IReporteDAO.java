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
 * IReporteDAO es la clase que maneja los Reportes en la base de datos.
 *
 * @author Maria Jose Hernandez Molinos
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/30
 */
public interface IReporteDAO {

    /**
     * Regresa un reporte de la base de datos
     *
     * @param id identificador del reporte
     * @return el reporte
     */
    public Reporte getReporte(int id);

    /**
     * Regresa un reporte de la base de datos con base en una fecha de entrega.
     * 
     * @param fechaEntregaReporte fecha de entrega
     * @return el reporte
     */
    public Reporte getReporte(FechaEntregaReporte fechaEntregaReporte);

    /**
     * Regresa una lista de los reportes de un historial.
     * 
     * @param historial historial del alumno
     * @return lista de reportes
     */
    public ArrayList<Reporte> getReportes(HistorialAlumnoSS historial);

    /**
     * Ingresa un nuevo reporte en la base de datos
     *
     * @param reporte reporte a guardar
     * @return <code>true</code> si se insertó correctamente; <code>false</code> si no
     */
    public boolean insertReporte(Reporte reporte);

    /**
     * Modifica un reporte de la base de datos.
     *
     * @param reporte reporte a modificar
     * @return <code>true</code> si se modificó correctamente; <code>false</code> si no
     */
    public boolean updateReporte(Reporte reporte);

}
