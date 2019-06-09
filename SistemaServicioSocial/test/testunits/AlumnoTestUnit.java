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
import sistemaserviciosocial.Solicitud;

/**
 *
 * @author Mauricio
 */
public class AlumnoTestUnit {
    
    @Test
    public void getAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        boolean result = alumno.isLoaded();
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }

    @Test
    public void asignarSolicitudAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Solicitud solicitud = new Solicitud(1);
        boolean result = alumno.asignarSolicitud(solicitud);
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void reasignarSolicitudAlumnoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Solicitud solicitud = new Solicitud(1);
        boolean result = alumno.asignarSolicitud(solicitud);
        boolean resultExpected = false;
        assertEquals(resultExpected, result);
    }
    
}
