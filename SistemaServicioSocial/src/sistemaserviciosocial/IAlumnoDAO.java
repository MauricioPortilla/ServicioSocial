/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaserviciosocial;

import javafx.collections.ObservableList;

/**
 *
 * @author Mauricio CP
 */
public interface IAlumnoDAO {
	ObservableList<Alumno> getAlumnos(boolean periodoActual);

    boolean insertAlumno(Alumno alumno);

    boolean updateAlumno(Alumno alumno);

    boolean deleteAlumno(Alumno alumno);
}
