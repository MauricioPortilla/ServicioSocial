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

/**
 * IHistorialAlumnoSSDAO es la interfaz que maneja la información de los HistorialAlumnoSS
 * en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public interface IHistorialAlumnoSSDAO {

    /**
     * Retorna una instancia HistorialAlumnoSS con base en su ID.
     * 
     * @param id ID del historial a buscar
     * @return Historial del Alumno
     */
    public HistorialAlumnoSS getHistorial(int id);

    /**
     * Retorna una instancia HistorialAlumnoSS con base en una Inscripcion.
     * @param inscripcion Inscripcion asociada al Historial
     * @return Historial del Alumno
     */
    public HistorialAlumnoSS getHistorial(Inscripcion inscripcion);
}
