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
 * IProyectoDAO es la interfaz que se encarga del manejo de los Proyectos registrados en la base de
 * datos.
 *
 * @author Bruno Antonio López Luján
 * @author María Saarayim González Hernández
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/30
 */
public interface IProyectoDAO {

    /**
     * Regresa un proyecto de acuerdo a su id
     *
     * @param idProyecto id del proyecto
     * @return proyecto
     */
    public Proyecto getProyecto(int idProyecto);

    /**
     * Guarda un proyecto y responsable de proyecto
     *
     * @param proyecto proyecto
     * @param responsableProyecto responsable del proyecto
     * @return <code>true</code> al guardar exitosamente o <code>false</code> si no fue así
     */
    public boolean insertProyecto(Proyecto proyecto, ResponsableProyecto responsableProyecto);

    /**
     * Modifica un proyecto
     *
     * @param proyecto proyecto
     * @return <code>true</code> si se modificó exitosamente exitosamente o <code>false</code> si no
     * fue así
     */
    public boolean updateProyecto(Proyecto proyecto);
}
