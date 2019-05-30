/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaserviciosocial;

import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mauricio CP
 */
public class AlumnoDAO implements IAlumnoDAO {

	@Override
	public ObservableList<Alumno> getAlumnos(boolean periodoActual) { // SIN IMPLEMENTAR EL PARAMETRO
        ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
        SQL.executeQuery( // CONSIDERAR LIMIT 1 EN SUBQUERY PORQUE QUEREMOS EL ULTIMO SS CREADO
            "SELECT * FROM alumno a, inscripcion i WHERE i.idserviciosocial IN (" +
                "SELECT idserviciosocial FROM servicioSocial ORDER BY idServicioSocial DESC" +
            ") AND a.matricula = i.matriculaAlumno", null, (result) -> {
				for (SQLRow row : result) {
					alumnos.add(
						new Alumno(
							row.getColumnData("matricula").toString(),
							row.getColumnData("nombre").toString(),
							row.getColumnData("paterno").toString(),
							row.getColumnData("materno").toString(),
							row.getColumnData("telefono").toString(),
							row.getColumnData("correoPersonal").toString(),
							row.getColumnData("nombreContacto").toString(),
							row.getColumnData("correoContacto").toString(),
							row.getColumnData("telefonoContacto").toString(),
							(float) row.getColumnData("promedio"),
							row.getColumnData("estado").toString()
						)
					);
				}
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
