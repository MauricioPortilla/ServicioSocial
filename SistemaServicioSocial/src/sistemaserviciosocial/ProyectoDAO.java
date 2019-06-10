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

import java.sql.Date;
import java.util.ArrayList;
import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

/**
 * ProyectoDAO es la clase que lleva el manejo de los Proyectos registrados en la base
 * de datos.
 *
 * @author Bruno Antonio López Luján
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/30
 */
public class ProyectoDAO implements IProyectoDAO {

    /**
     * Crea una instancia vacía.
     */
    public ProyectoDAO() {
    }

    @Override
    public Proyecto getProyecto(int idProyecto) {
        try {
            Proyecto proyecto = new Proyecto();
            SQL.executeQuery("SELECT * FROM proyecto WHERE idproyecto = ?", new ArrayList<Object>() {
                {
                    add(idProyecto);
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                proyecto.setId(idProyecto);
                proyecto.setSolicitudBase(new Solicitud((int) row.getColumnData("idsolicitud")));
                proyecto.setResponsableProyecto(
                    new ResponsableProyecto((int) row.getColumnData("idresponsable"))
                );
                proyecto.setNombre(row.getColumnData("nombre").toString());
                proyecto.setDescripcion(row.getColumnData("descripcion").toString());
                proyecto.setHorarioAlumno(row.getColumnData("horarioAlumno").toString());
                proyecto.setNumAlumnos((int) row.getColumnData("numAlumnos"));
                proyecto.setActividades(row.getColumnData("actividades").toString());
                proyecto.setFechaRegistro(
                    ((Date) row.getColumnData("fechaRegistro")).toLocalDate()
                );
                return true;
            }, () -> {
                return false;
            });
            return proyecto;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getProyecto Exception -> " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertProyecto(Proyecto proyecto, ResponsableProyecto responsableProyecto) {
        if (SQL.executeTransactionUpdate(
            "INSERT INTO responsableProyecto VALUES (NULL, ?, ?, ?, ?, ?)", 
            new ArrayList<Object>() {
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
            try {
                SQL.executeQuery("SELECT MAX(idproyecto) AS lastId FROM proyecto", null, 
                    (result) -> {
                        SQLRow row = result.get(0);
                        proyecto.setId((int) row.getColumnData("lastId"));
                        return true;
                    }, () -> {
                        return false;
                    }
                );
			} catch (Exception e) {
				// TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("insertProyecto Exception -> " + e.getMessage());
			}
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
