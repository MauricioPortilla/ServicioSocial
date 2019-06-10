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

import sistemaserviciosocial.Alumno;
import sistemaserviciosocial.Proyecto;
import sistemaserviciosocial.ResponsableProyecto;

import static org.junit.Assert.*;

import java.time.LocalDate;
import sistemaserviciosocial.Solicitud;

/**
 * Pruebas de unidad para la clase Proyecto
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/09
 */
public class ProyectoTestUnit {
    
    /**
     * Prueba para verificar que se guarda un proyecto en la base de datos.
     */
    @Test
    public void guardarProyectoTest() {
        Proyecto proyecto = new Proyecto(
            0, new Solicitud(1), 
            new ResponsableProyecto(1, "nombre", "paterno", "materno", "correo", "telefono"), 
            "ProyectoTest", "descripcion", "horarioAlumno", 1, "actividades", LocalDate.now()
        );
        boolean result = proyecto.guardar();
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }
    
}
