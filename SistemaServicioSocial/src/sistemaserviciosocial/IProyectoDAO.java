/**
 *Clase Proyecto
 *@author Bruno Antonio López Luján
 *@version 1.0
 *@since 2019/05/30
 */
package sistemaserviciosocial;

public interface IProyectoDAO {
  public Proyecto getProyecto (int idProyecto);
  public boolean insertProyeto (Proyecto proyecto);
  public boolean updateProyeto (Proyecto proyecto);
}