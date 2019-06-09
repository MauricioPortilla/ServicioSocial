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
import java.util.ArrayList;
import sistemaserviciosocial.engine.SQL;

public class ProyectoDAO implements IProyectoDAO {

    public ProyectoDAO() {
    }

    @Override
    public Proyecto getProyecto(int idProyecto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean insertProyecto(Proyecto proyecto, ResponsableProyecto responsableProyecto) {
        if (SQL.executeTransactionUpdate("INSERT INTO responsableProyecto VALUES (NULL, ?, ?, ?, ?, ?)", new ArrayList<Object>() {
            {
                add(responsableProyecto.getNombre());
                add(responsableProyecto.getPaterno());
                add(responsableProyecto.getMaterno());
                add(responsableProyecto.getCorreo());
                add(responsableProyecto.getTelefono());
            }
        }, "INSERT INTO proyecto VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)", new ArrayList<Object>() {
            {
                add(proyecto.getSolicitudBase().getId());
                add("RETURNED_ID");
                add(proyecto.getNombre());
                add(proyecto.getDescripcion());
                add(proyecto.getHorarioAlumno());
                add(proyecto.getNumAlumnos());
                add(proyecto.getActividades());
                add(proyecto.getFechaRegistro());
            }
        }) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProyecto(Proyecto proyecto) {
        if (SQL.executeUpdate(
            "UPDATE proyecto SET nombre = ?, descripcion = ?, horarioAlumno = ?, numAlumnos = ?, "
            + "acticidades = ?, fechaResgistro = ? WHERE idProyecto = ?",
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
