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

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Utilities es la clase que brinda herramientas para manejar datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class Utilities {

    public static final String TIPO_ARCHIVO_REPORTE = "Reporte";
    public static final String TIPO_ARCHIVO_CARTA_ACEPTACION = "Carta de aceptación";
    public static final String TIPO_ARCHIVO_OFICIO_ASIGNACION = "Oficio de asignación";
    

    public static final ObservableList<String> TIPOS_ARCHIVOS = FXCollections.observableArrayList(
        TIPO_ARCHIVO_REPORTE, TIPO_ARCHIVO_CARTA_ACEPTACION, TIPO_ARCHIVO_OFICIO_ASIGNACION
    );

    private static final Map<String, String> CONVERSION_TIPOS_ARCHIVOS = 
        new HashMap<String, String>() {
        {
            put(TIPO_ARCHIVO_REPORTE, "Reporte");
            put(TIPO_ARCHIVO_CARTA_ACEPTACION, "CartaAceptación");
            put(TIPO_ARCHIVO_OFICIO_ASIGNACION, "OficioAsignación");
        }
    };

    public static final String ARCHIVOS_RUTA = "Archivos";

    public static ObservableList<Alumno> filterAlumnos(
        ObservableList<Alumno> list, UtilitiesFilters filterType
    ) {
        ObservableList<Alumno> newList = FXCollections.observableArrayList();
        switch (filterType) {
            case FILTER_ALUMNOS_BY_NO_SOLICITUD_ASIGNADA:
                for (Alumno alumno : list) {
                    if (alumno.getInscripcion().getHistorial().getSolicitudAsignada() == null) {
                        newList.add(alumno);
                    }
                }
                break;
        }
        return newList;
    }

    /**
     * Retorna un nombre de archivo adaptado a un tipo de archivo y al nombre de un alumno.
     * 
     * @param archivo archivo a adaptar
     * @param tipoArchivo tipo de archivo
     * @param alumno alumno
     * @return nombre de archivo adaptado
     */
    public static String setFileName(File archivo, String tipoArchivo, Alumno alumno) {
        String nombreArchivo = archivo.getName();
        String[] nombreArchivoSplit = nombreArchivo.split("\\.");
        String nuevoNombre = CONVERSION_TIPOS_ARCHIVOS.get(tipoArchivo) + "_" + 
            alumno.getFullName(true, false) + "." + 
            nombreArchivoSplit[nombreArchivoSplit.length - 1];
        return nuevoNombre;
    }

    /**
     * Retorna la ruta donde se encuentran los archivos correspondientes a un
     * Servicio Social.
     * 
     * @param servicioSocial servicio social
     * @return ruta sin terminación <code>/</code>
     */
    public static Path getArchivosPath(ServicioSocial servicioSocial) {
        return Paths.get(ARCHIVOS_RUTA + "/SS_" + servicioSocial.getId());
    }

    /**
     * Retorna la ruta donde se encuentran los archivos de un ALumno correspondiente a un
     * Servicio Social.
     * 
     * @param servicioSocial servicio social
     * @param alumno alumno
     * @return ruta sin terminación <code>/</code>
     */
    public static Path getArchivosPathAlumno(ServicioSocial servicioSocial, Alumno alumno) {
        return Paths.get(getArchivosPath(servicioSocial) + "/" + alumno.getMatricula());
    }
}
