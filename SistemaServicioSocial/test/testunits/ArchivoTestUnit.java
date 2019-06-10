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

import static org.junit.Assert.*;

/**
 * Pruebas de unidad para la clase Archivo
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/09
 */
public class ArchivoTestUnit {
    
    /**
     * Prueba para verificar que se puede registrar un archivo en la base de datos.
     */
    @Test
    public void guardarArchivoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Archivo archivo = new Archivo(
            0, alumno.getInscripcion().getHistorial(), 
            "Archivo Nuevo", "Ruta", "No validado", null
        );
        boolean result = archivo.guardar();
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
    }

    /**
     * Prueba para verificar que no se puede borrar un registro de la base de datos
     * si no se pudo eliminar su archivo.
     */
    @Test
    public void eliminarArchivoTest() {
        String matricula = "S17013001";
        Alumno alumno = new Alumno(matricula);
        Archivo archivo = new Archivo(
            18, alumno.getInscripcion().getHistorial(), 
            "Archivo Nuevo", "Ruta", "No validado", null
        );
        boolean result = archivo.eliminar();
        boolean resultExpected = false;
        assertEquals(resultExpected, result);
    }
    
}
