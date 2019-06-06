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
 * IInscripcionDAO es la interfaz que maneja la información de las Inscripcion
 * en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public interface IInscripcionDAO {
    
    /**
     * Retorna una inscripción de la base de datos con base en un Alumno.
     * 
     * @param alumno alumno de la inscripción
     * @return inscripción del alumno
     */
    public Inscripcion getInscripcion(Alumno alumno);
}
