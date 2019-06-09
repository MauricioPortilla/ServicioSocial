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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * SolicitudDAO es la clase que maneja la información de las solicitudes
 * registradas en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/24
 */
public class SolicitudDAO implements ISolicitudDAO {

	@Override
	public ObservableList<Solicitud> getSolicitudes() {
        ObservableList<Solicitud> solicitudes = FXCollections.observableArrayList();
		try {
			SQL.executeQuery("SELECT * FROM solicitud;", null, (result) -> {
			    for (SQLRow row : result) {
			        solicitudes.add(
			            new Solicitud(
			                (int) row.getColumnData("idsolicitud"), 
			                (int) row.getColumnData("numAlumnos"), 
			                row.getColumnData("actividades").toString(), 
			                row.getColumnData("lugar").toString(), 
			                row.getColumnData("horario").toString(), 
			                row.getColumnData("responsableUnidad").toString(), 
			                row.getColumnData("requisitos").toString(), 
                            ((Date) row.getColumnData("fechaRegistro")).toLocalDate(),
                            new UnidadReceptora((int) row.getColumnData("idunidadreceptora"))
			            )
			        );
			    }
			    return true;
			}, () -> {
			    return false;
			});
		} catch (Exception e) {
			System.out.println("getSolicitudes Exception -> " + e.getMessage());
			new Alert(AlertType.ERROR, "Ocurrió un error al cargar las solicitudes").showAndWait();
		}
        return solicitudes;
    }
    
    @Override
    public Solicitud getSolicitud(int id) {
        try {
            Solicitud solicitud = new Solicitud();
            SQL.executeQuery(
                "SELECT * FROM solicitud WHERE idsolicitud = ?", new ArrayList<Object>() {
                {
                    add(id);
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                solicitud.setId((int) row.getColumnData("idsolicitud"));
                solicitud.setNumAlumnos((int) row.getColumnData("numAlumnos"));
                solicitud.setActividades(row.getColumnData("actividades").toString());
                solicitud.setLugar(row.getColumnData("lugar").toString());
                solicitud.setHorario(row.getColumnData("horario").toString());
                solicitud.setResponsableUnidad(row.getColumnData("responsableUnidad").toString());
                solicitud.setRequisitos(row.getColumnData("requisitos").toString());
                solicitud.setFechaRegistro(
                    ((Date) row.getColumnData("fechaRegistro")).toLocalDate()
                );
                return true;
            }, () -> {
                return false;
            });
            return solicitud;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ObservableList<Solicitud> getSolicitudesSinProyecto() {
        ObservableList<Solicitud> solicitudes = FXCollections.observableArrayList();
		try {
            SQL.executeQuery("SELECT * FROM solicitud WHERE idsolicitud NOT IN (" +
                "SELECT idsolicitud FROM proyecto);", null, (result) -> {
			    for (SQLRow row : result) {
			        solicitudes.add(
			            new Solicitud(
			                (int) row.getColumnData("idsolicitud"), 
			                (int) row.getColumnData("numAlumnos"), 
			                row.getColumnData("actividades").toString(), 
			                row.getColumnData("lugar").toString(), 
			                row.getColumnData("horario").toString(), 
			                row.getColumnData("responsableUnidad").toString(), 
			                row.getColumnData("requisitos").toString(), 
                            ((Date) row.getColumnData("fechaRegistro")).toLocalDate(),
                            new UnidadReceptora((int) row.getColumnData("idunidadreceptora"))
			            )
			        );
			    }
			    return true;
			}, () -> {
			    return false;
			});
		} catch (Exception e) {
            System.out.println("getSolicitudesSinProyecto Exception -> " + e.getMessage());
            e.printStackTrace();
			new Alert(AlertType.ERROR, "Ocurrió un error con la base de datos").showAndWait();
		}
        return solicitudes;
    }
	
}
