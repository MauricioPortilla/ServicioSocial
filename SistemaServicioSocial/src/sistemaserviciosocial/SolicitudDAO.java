/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaserviciosocial;

import java.sql.Date;

import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mauricio CP
 */
public class SolicitudDAO implements ISolicitudDAO {

	@Override
	public ObservableList<Solicitud> getSolicitudes() {
        ObservableList<Solicitud> solicitudes = FXCollections.observableArrayList();
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
                        ((Date) row.getColumnData("fechaRegistro")).toLocalDate()
                    )
                );
            }
            return true;
        }, () -> {
            return false;
        });
        return solicitudes;
	}

	@Override
	public boolean insertSolicitud(Solicitud solicitud) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean updateSolicitud(Solicitud solicitud) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean deleteSolicitud(Solicitud solicitud) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
