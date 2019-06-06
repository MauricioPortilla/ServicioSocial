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
 * Clase Proyecto
 *
 * @author Bruno Antonio López Luján
 * @version 1.0
 * @since 2019/05/30
 */
public interface IProyectoDAO {

    public Proyecto getProyecto(int idProyecto);

    public boolean insertProyecto(Proyecto proyecto);

    public boolean updateProyecto(Proyecto proyecto);
}
