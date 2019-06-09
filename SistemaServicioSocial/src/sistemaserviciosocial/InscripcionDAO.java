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
 * InscripcionDAO es la clase que maneja la información de las Inscripcion en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class InscripcionDAO implements IInscripcionDAO {

    @Override
    public Inscripcion getInscripcion(Alumno alumno) {
        try {
            Inscripcion inscripcion = new Inscripcion();
            SQL.executeQuery(
                "SELECT * FROM inscripcion WHERE matriculaAlumno = ?", new ArrayList<Object>() {
                {
                    add(alumno.getMatricula());
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                inscripcion.setId((int) row.getColumnData("idinscripcion"));
                inscripcion.setAlumno(alumno);
                inscripcion.setFecha(((Date) row.getColumnData("fecha")).toLocalDate());
                inscripcion.setServicioSocial(
                    new ServicioSocial((int) row.getColumnData("idserviciosocial"))
                );
                inscripcion.setTipo(row.getColumnData("tipo").toString());
                return true;
            }, () -> {
                return false;
            });
            return inscripcion;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Inscripcion getInscripcion(HistorialAlumnoSS historial) {
        try {
            Inscripcion inscripcion = new Inscripcion();
            SQL.executeQuery(
                "SELECT * FROM inscripcion WHERE idinscripcion IN (" +
                    "SELECT idinscripcion FROM historialAlumnoSS WHERE idhistorial = ?)", 
                new ArrayList<Object>() {
                {
                    add(historial.getId());
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                inscripcion.setId((int) row.getColumnData("idinscripcion"));
                inscripcion.setAlumno(new Alumno(row.getColumnData("matriculaAlumno").toString()));
                inscripcion.setFecha(((Date) row.getColumnData("fecha")).toLocalDate());
                inscripcion.setServicioSocial(
                    new ServicioSocial((int) row.getColumnData("idserviciosocial"))
                );
                inscripcion.setTipo(row.getColumnData("tipo").toString());
                return true;
            }, () -> {
                return false;
            });
            return inscripcion;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getInscripcion Exception -> " + e.getMessage());
            return null;
        }
    }
    
}
