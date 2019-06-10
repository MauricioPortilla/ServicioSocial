/*
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

/**
 * IProyectoAsignadoDAO es la interfaz que maneja la información de los
 * Proyectos asignados en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/09
 */
public interface IProyectoAsignadoDAO {

    /**
     * Retorna el proyecto asignado al historial especificado.
     * 
     * @param historial historial del alumno
     * @return el proyecto
     */
    public Proyecto getProyectoAsignado(HistorialAlumnoSS historial);
    
    /**
     * Guarda en la base de datos una asignación de proyecto.
     * 
     * @param historial historial del alumno
     * @param proyecto proyecto a asignar
     * @return <code>true</code> si se asignó correctamente; <code>false</code> si no
     */
    public boolean insertProyectoAsignado(HistorialAlumnoSS historial, Proyecto proyecto);
}
