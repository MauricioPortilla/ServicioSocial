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
 * IAlumnoDAO es la interfaz que maneja la información de los Alumno en la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public interface IAlumnoDAO {
    
    /**
     * Retorna los alumnos registrados en el sistema que posean una inscripción en el servicio
     * social indicado.
     * 
     * @param idServicioSocial identificador del servicio social
     * @return lista de alumnos
     */
    public ObservableList<Alumno> getAlumnos(int idServicioSocial);
    
    /**
     * Retorna un alumno registrado en el sistema que posea la matrícula especificada.
     * 
     * @param matricula matrícula del alumno
     * @return alumno
     */
    public Alumno getAlumno(String matricula);
}
