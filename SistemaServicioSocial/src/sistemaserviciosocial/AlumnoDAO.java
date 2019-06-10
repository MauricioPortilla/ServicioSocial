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

import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * AlumnoDAO es la clase que maneja la información de los Alumnos en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/24
 */
public class AlumnoDAO implements IAlumnoDAO {

	@Override
	public ObservableList<Alumno> getAlumnos(int idServicioSocial) {
        ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
        try {
			SQL.executeQuery(
				"SELECT * FROM alumno a, inscripcion i WHERE i.idserviciosocial = ? AND " + 
				"a.matricula = i.matriculaAlumno", new ArrayList<Object>() {
					{
						add(idServicioSocial);
					}
				}, (result) -> {
					for (SQLRow row : result) {
						alumnos.add(new Alumno(
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
						));
					}
			        return true;
			    }, () -> {
			        return false;
			    }
			);
		} catch (Exception e) {
			System.out.println("getAlumnos Exception -> " + e.getMessage());
			new Alert(AlertType.ERROR, "Ocurrió un error al cargar los alumnos").showAndWait();
		}
        return alumnos;
	}

	@Override
	public Alumno getAlumno(String matricula) {
		try {
			Alumno alumno = new Alumno();
			SQL.executeQuery("SELECT * FROM alumno WHERE matricula = ?", new ArrayList<Object>() {
				{
					add(matricula);
				}
			}, (result) -> {
				SQLRow row = result.get(0);
				alumno.setMatricula(matricula);
				alumno.setNombre(row.getColumnData("nombre").toString());
				alumno.setPaterno(row.getColumnData("paterno").toString());
				alumno.setMaterno(row.getColumnData("materno").toString());
				alumno.setTelefono(row.getColumnData("telefono").toString());
				alumno.setCorreoPersonal(row.getColumnData("correoPersonal").toString());
				alumno.setNombreContacto(row.getColumnData("nombreContacto").toString());
				alumno.setCorreoContacto(row.getColumnData("correoContacto").toString());
				alumno.setTelefonoContacto(row.getColumnData("telefonoContacto").toString());
				alumno.setPromedio((float) row.getColumnData("promedio"));
				alumno.setEstado(row.getColumnData("estado").toString());
				return true;
			}, () -> {
				return false;
			});
			return alumno;
		} catch (Exception e) {
			System.out.println("getAlumnos Exception -> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
}
