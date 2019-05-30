/**
 *Clase DAO de archivo
 * @author María Saarayim González Hernández
 * @version 1.0
 * @since 2019/05/30
 */
package sistemaserviciosocial;


import engine.SQL;
import java.util.ArrayList;


public class ArchivoDAO implements IArchivoDAO {
  
  public ArchivoDAO(){
  }
  
  @Override
  public Archivo getArchivo (int id){
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  @Override
  public boolean insertArchivo (Archivo archivo){
    if (SQL.executeUpdate(
            "INSERT INTO archivo VALUES (NULL, ?, ?, ?, ?, ?)",
            new ArrayList<Object>() {
                {
                  add(archivo.getIdHistorial());
                  add(archivo.getTitulo());
                  add(archivo.getRutaUbicacion());
                  add(archivo.getEstado());
                  add(archivo.getMotivoInvalidez());
                  
                    
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
  }
  
  @Override 
  public boolean updateArchivo (Archivo archivo){
    if (SQL.executeUpdate(
            "UPDATE archivo SET titulo = ?, rutaUbicacion = ?,estado= ?, motivoInvalidez = ? WHERE idArchivo = ?",
            new ArrayList<Object>() {
                {
                  add(archivo.getIdHistorial());
                  add(archivo.getTitulo());
                  add(archivo.getRutaUbicacion());
                  add(archivo.getEstado());
                  add(archivo.getMotivoInvalidez());
                  
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
  }
  
}
