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
 * Interfaz de Archivo
 *
 * @author María Saarayim González Hernández
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/30
 */
public interface IArchivoDAO {

    /**
     * Regresa un archivo de la base de datos
     *
     * @param id identificador del archivo
     * @return el archivo
     */
    public Archivo getArchivo(int id);

    /**
     * Regresa un archivo de la base de datos que coincida con el título y el historial
     * ingresado.
     * 
     * @param titulo título del archivo
     * @param historial historial asociado al archivo
     * @return el archivo
     */
    public Archivo getArchivo(String titulo, HistorialAlumnoSS historial);

    /**
     * Regresa una lista de archivos relacionados con el historial especificado.
     * 
     * @param historial historial del alumno
     * @return lista de archivos
     */
    public ArrayList<Archivo> getArchivos(HistorialAlumnoSS historial);

    /**
     * Ingresa un nuevo archivo en la base de datos.
     *
     * @param archivo archivo a guardar.
     * @return <code>true</code> si se insertó correctamente; <code>false</code> si no
     */
    public boolean insertArchivo(Archivo archivo);

    /**
     * Modifica un archivo de la base de datos.
     *
     * @param archivo archivo a modificar
     * @return <code>true</code> si se modificó correctamente; <code>false</code> si no
     */
    public boolean updateArchivo(Archivo archivo);

    /**
     * Elimina un archivo de la base de datos.
     * 
     * @param archivo archivo a eliminar
     * @return <code>true</code> si se eliminó correctamente; <code>false</code> si no
     */
    public boolean deleteArchivo(Archivo archivo);
}
