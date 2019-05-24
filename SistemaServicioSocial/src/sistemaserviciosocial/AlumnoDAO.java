/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaserviciosocial;

import engine.SQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mauricio CP
 */
public class AlumnoDAO implements IAlumnoDAO {

	@Override
	public ObservableList<Alumno> getAlumnos(boolean periodoActual) {
        ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
        SQL.executeQuery(
            "SELECT * FROM alumno WHERE idServicioSocial IN (" +
                "SELECT * FROM servicioSocial ORDER BY idServicioSocial DESC LIMIT 1" +
            ")", null, (result) -> {
                return true;
            }, () -> {
                return false;
            }
        );
        return alumnos;
	}

	@Override
	public boolean insertAlumno(Alumno alumno) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean updateAlumno(Alumno alumno) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean deleteAlumno(Alumno alumno) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
