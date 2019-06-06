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
 * Interfaz de Archivo
 *
 * @author María Saarayim González Hernández
 * @version 1.0
 * @since 2019/05/30
 */
public interface IArchivoDAO {

    /**
     * Regresa un archivo de la base de datos
     *
     * @param id identificador del archivo
     * @return
     */
    public Archivo getArchivo(int id);

    /**
     * Ingresa un nuevo archivo en la base de datos
     *
     * @param archivo archivo a guardar.
     * @return
     */
    public boolean insertArchivo(Archivo archivo);

    /**
     * Modifica un archivo de la base de datos
     *
     * @param archivo archivo a modificar
     * @return
     */
    public boolean updateArchivo(Archivo archivo);
}
