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
 * HistorialAlumnoSSDAO es la clase que maneja la información de los HistorialAlumnoSS en la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class HistorialAlumnoSSDAO implements IHistorialAlumnoSSDAO {


    @Override
    public HistorialAlumnoSS getHistorial(int id) {
        try {
            HistorialAlumnoSS historial = new HistorialAlumnoSS();
            SQL.executeQuery(
                "SELECT * FROM historialAlumnoSS WHERE idhistorial = ?", new ArrayList<Object>() {
                {
                    add(id);
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                historial.setId(id);
                historial.setFechaInicioSS(
                    ((Date) row.getColumnData("fechaInicioSS")).toLocalDate()
                );
                historial.setFechaFinSS(((Date) row.getColumnData("fechaFinSS")).toLocalDate());
                historial.setHorasAcumuladas((int) row.getColumnData("horasAcumuladas"));
                historial.setNumReportesEntregados(
                    (int) row.getColumnData("numReportesEntregados")
                );
                historial.setInscripcion(new Inscripcion((int) row.getColumnData("idinscripcion")));
                return true;
            }, () -> {
                return false;
            });
            return historial;
        } catch (Exception e) {
            //TODO: handle exception
            return null;
        }
    }


    @Override
    public HistorialAlumnoSS getHistorial(Inscripcion inscripcion) {
        try {
            HistorialAlumnoSS historial = new HistorialAlumnoSS();
            SQL.executeQuery(
                "SELECT * FROM historialAlumnoSS WHERE idinscripcion = ?", new ArrayList<Object>() {
                {
                    add(inscripcion.getId());
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                historial.setId((int) row.getColumnData("idhistorial"));
                historial.setInscripcion(inscripcion);
                if (row.getColumnData("fechaInicioSS") != null) {
                    historial.setFechaInicioSS(
                        ((Date) row.getColumnData("fechaInicioSS")).toLocalDate()
                    );
                }
                if (row.getColumnData("fechaFinSS") != null) {
                    historial.setFechaInicioSS(
                        ((Date) row.getColumnData("fechaFinSS")).toLocalDate()
                    );
                }
                historial.setHorasAcumuladas((int) row.getColumnData("horasAcumuladas"));
                historial.setNumReportesEntregados(
                    (int) row.getColumnData("numReportesEntregados")
                );
                historial.initSolicitudes();
                return true;
            }, () -> {
                return false;
            });
            return historial;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
