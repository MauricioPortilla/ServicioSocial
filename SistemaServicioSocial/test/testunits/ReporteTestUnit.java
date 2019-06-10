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
import sistemaserviciosocial.Archivo;
import sistemaserviciosocial.FechaEntregaReporte;
import sistemaserviciosocial.Reporte;

import static org.junit.Assert.*;

import java.time.LocalDate;


/**
 * Pruebas de unidad para la clase Reporte
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/09
 */
public class ReporteTestUnit {
    
    /**
     * Prueba para verificar que se puede guardar un reporte en la base de datos.
     */
    @Test
    public void guardarReporteTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Reporte reporte = new Reporte(
            0, 3, 100, "Julio", LocalDate.now(), "No validado", null, 
            alumno.getInscripcion().getHistorial(), new FechaEntregaReporte(2), new Archivo(18)
        );
        boolean result = reporte.guardar();
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }
    
}
