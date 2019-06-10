/*
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

package testunits;

import org.junit.Test;
import static org.junit.Assert.*;
import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.Proyecto;
import sistemaserviciosocial.Solicitud;

/**
 * Pruebas de unidad para la clase Alumno
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/09
 */
public class AlumnoTestUnit {
    
    /**
     * Prueba para verificar que se puede obtener un alumno de la base de datos
     * mediante su matrícula.
     */
    @Test
    public void getAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        boolean result = alumno.isLoaded();
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }

    /**
     * Prueba para verificar que se puede asignar una solicitud a un alumno.
     */
    @Test
    public void asignarSolicitudAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Solicitud solicitud = new Solicitud(1);
        boolean result = alumno.asignarSolicitud(solicitud);
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }
    
    /**
     * Prueba para verificar que no se puede asignar más de una solicitud a un alumno.
     */
    @Test
    public void reasignarSolicitudAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Solicitud solicitud = new Solicitud(1);
        boolean result = alumno.asignarSolicitud(solicitud);
        boolean resultExpected = false;
        assertEquals(resultExpected, result);
    }

    /**
     * Prueba para verificar que se puede asignar un proyecto a un alumno.
     */
    @Test
    public void asignarProyectoAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Proyecto proyecto = new Proyecto(5);
        boolean result = alumno.asignarProyecto(proyecto);
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }
    
    /**
     * Prueba para verificar que no se puede asignar más de un proyecto a un alumno.
     */
    @Test
    public void reasignarProyectoAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Proyecto proyecto = new Proyecto(5);
        boolean result = alumno.asignarProyecto(proyecto);
        boolean resultExpected = false;
        assertEquals(resultExpected, result);
    }
    
}
