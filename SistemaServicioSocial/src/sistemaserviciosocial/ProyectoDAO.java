/**
 *Clase Proyecto
 *@author Bruno Antonio López Luján
 *@version 1.0
 *@since 2019/05/30
 */
package sistemaserviciosocial;

import java.util.ArrayList;
import sistemaserviciosocial.engine.SQL;

public class ProyectoDAO implements IProyectoDAO{


public ProyectoDAO(){
}

@Override
  public Proyecto getProyecto(int idProyecto) {
    throw new UnsupportedOperationException("Not supported yet.");
   } 
 

  @Override
  public boolean insertProyeto(Proyecto proyecto) {
          if (SQL.executeUpdate(
            "INSERT INTO proyecto VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)",
            new ArrayList<Object>() {
                {
                    add(proyecto.getIdSolicitud());
                    add(proyecto.getIdResponsable());
                    add(proyecto.getNombre());
                    add(proyecto.getDescripcion());
                    add(proyecto.getHorarioAlumno());
                    add(proyecto.getNumAlumnos());
                    add(proyecto.getActividades());
                    add(proyecto.getFechaRegistro());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
  }

  @Override
  public boolean updateProyeto(Proyecto proyecto) {
        if (SQL.executeUpdate(
            "UPDATE proyecto SET nombre = ?, descripcion = ?, horarioAlumno = ?, numAlumnos = ?, " + 
            "acticidades = ?, fechaResgistro = ? WHERE idProyecto = ?",
            new ArrayList<Object>() {
                {
                    add(proyecto.getNombre());
                    add(proyecto.getDescripcion());
                    add(proyecto.getHorarioAlumno());
                    add(proyecto.getNumAlumnos());
                    add(proyecto.getActividades());
                    add(proyecto.getFechaRegistro());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
  }
}
