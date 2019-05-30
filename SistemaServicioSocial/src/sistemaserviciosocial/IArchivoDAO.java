/**
 *Interfaz de Archivo
 * @author María Saarayim González Hernández
 * @version 1.0
 * @since 2019/05/30
 */
package sistemaserviciosocial;


public interface IArchivoDAO {
  
  /**
   * Regresa un archivo de la base de datos
   * @param id identificador del archivo
   * @return 
   */
  public Archivo getArchivo (int id);
  
  /**
   * Ingresa un nuevo archivo en la base de datos
   * @param archivo archivo a guardar.
   * @return 
   */
  public boolean insertArchivo (Archivo archivo);
  
  /**
   * Modifica un archivo de la base de datos
   * @param archivo archivo a modificar
   * @return 
   */
  public boolean updateArchivo (Archivo archivo);
  }
