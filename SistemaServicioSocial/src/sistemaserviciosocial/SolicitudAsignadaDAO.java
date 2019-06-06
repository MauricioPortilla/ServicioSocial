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

import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

/**
 * SolicitudAsignadaDAO es la clase que maneja la información de las solicitudes
 * asignadas a los historiales de los alumnos registrados en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class SolicitudAsignadaDAO implements ISolicitudAsignadaDAO {

    @Override
    public ArrayList<HistorialAlumnoSS> getSolicitudesAsignadas(Solicitud solicitud) {
        try {
            ArrayList<HistorialAlumnoSS> historiales = new ArrayList<>();
            SQL.executeQuery(
                "SELECT idhistorial FROM solicitudAsignada WHERE idsolicitud = ?", 
                new ArrayList<Object>() {
                    {
                        add(solicitud.getId());
                    }
                }, (result) -> {
                    for (SQLRow row : result) {
                        historiales.add(
                            new HistorialAlumnoSS((int) row.getColumnData("idhistorial"))
                        );
                    }
                    return true;
                }, () -> {
                    return false;
                }
            );
            return historiales;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Solicitud getSolicitudAsignada(HistorialAlumnoSS historial) {
        try {
            Solicitud solicitud = new Solicitud();
            if (SQL.executeQuery("SELECT idsolicitud FROM solicitudAsignada WHERE idhistorial = ?", 
                new ArrayList<Object>() {
                    {
                        add(historial.getId());
                    }
                }, (result) -> {
                    System.out.println("Found");
                    SQLRow row = result.get(0);
                    solicitud.init((int) row.getColumnData("idsolicitud"));
                    return true;
                }, () -> {
                    System.out.println("Not found");
                    return false;
                }
            )) {
                return solicitud;
            } else {
                return null;
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insertSolicitudAsignada(HistorialAlumnoSS historial, Solicitud solicitud) {
        int rowsAffected = SQL.executeUpdate(
            "INSERT INTO solicitudAsignada VALUES (?, ?)", new ArrayList<Object>() {
            {
                add(historial.getId());
                add(solicitud.getId());
            }
        });
        return (rowsAffected > SQL.NO_ROWS_AFFECTED);
    }

}
