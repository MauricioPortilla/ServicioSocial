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

/**
 * Archivo es la clase que contiene la información de un archivo del Servicio Social
 *
 * @author María Saarayim González Hernández
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/28
 */
public class Archivo {

    private int id;
    private String titulo;
    private String rutaUbicacion;
    private String estado;
    private String motivoInvalidez = null;
    private HistorialAlumnoSS historial;

    /**
     * Crea una instancia vacía.
     */
    public Archivo() {
    }

    /**
     * Crea una instancia Archivo.
     *
     * @param id identificador del archivo
     * @param historial historial asociado con el archivo
     * @param titulo titulo del archivo
     * @param rutaUbicacion ruta de ubicación del archivo
     * @param estado estado del archivo
     * @param motivoInvalidez motivo por el que se invalida un archivo
     */
    public Archivo(
        int id, HistorialAlumnoSS historial, String titulo, String rutaUbicacion, 
        String estado, String motivoInvalidez
    ) {
        this.titulo = titulo;
        this.rutaUbicacion = rutaUbicacion;
        this.estado = estado;
        this.motivoInvalidez = motivoInvalidez;
        this.id = id;
        this.historial = historial;
    }

    /**
     * Crea una instancia con base en un identificador de la base de datos.
     * 
     * @param id identificador del archivo
     */
    public Archivo(int id) {
        this.id = id;
        IArchivoDAO archivoDAO = new ArchivoDAO();
        Archivo archivoAux = archivoDAO.getArchivo(id);
        this.titulo = archivoAux.titulo;
        this.rutaUbicacion = archivoAux.rutaUbicacion;
        this.estado = archivoAux.estado;
        this.motivoInvalidez = archivoAux.motivoInvalidez;
        this.historial = archivoAux.historial;
    }

    /**
     * Crea una instancia con base en un título y un historial de alumno de la base de datos.
     * 
     * @param titulo título del archivo
     * @param historial historial asociado al archivo
     */
    public Archivo(String titulo, HistorialAlumnoSS historial) {
        this.titulo = titulo;
        IArchivoDAO archivoDAO = new ArchivoDAO();
        Archivo archivoAux = archivoDAO.getArchivo(titulo, historial);
        this.titulo = archivoAux.titulo;
        this.rutaUbicacion = archivoAux.rutaUbicacion;
        this.estado = archivoAux.estado;
        this.motivoInvalidez = archivoAux.motivoInvalidez;
        this.historial = archivoAux.historial;
    }

    /**
     * Guarda este archivo en la base de datos, sólo si su identificador es igual a cero.
     * 
     * @return <code>true</code> si se guardó correctamente; <code>false</code> si no.
     */
    public boolean guardar() {
        if (id > 0) {
            return false;
        }
        IArchivoDAO archivoDAO = new ArchivoDAO();
        return (archivoDAO.insertArchivo(this));
    }

    /**
     * Elimina este archivo.
     * 
     * @return <code>true</code> si se eliminó correctamente; <code>false</code> si no.
     */
    public boolean eliminar() {
        File archivo = new File(this.rutaUbicacion);
        if (archivo.delete()) {
            IArchivoDAO archivoDAO = new ArchivoDAO();
            return (archivoDAO.deleteArchivo(this));
        }
        return false;
    }

    /**
     * Establece un identificador.
     * 
     * @param id identificador nuevo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el historial asociado al archivo.
     * 
     * @return el historial asociado al archivo
     */
    public HistorialAlumnoSS getHistorial() {
        return historial;
    }

    /**
     * Establece un historial.
     * 
     * @param historial historial nuevo
     */
    public void setHistorial(HistorialAlumnoSS historial) {
        this.historial = historial;
    }

    /**
     * Retorna el identificador.
     * 
     * @return el identificador
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna el titulo.
     * 
     * @return el titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna la ruta de ubicacion.
     * 
     * @return la ruta de ubicacion
     */
    public String getRutaUbicacion() {
        return rutaUbicacion;
    }

    /**
     * Retorna el estado.
     * 
     * @return el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Retorna el motivo de invalidez.
     * 
     * @return el motivo de invalidez
     */
    public String getMotivoInvalidez() {
        return motivoInvalidez;
    }

    /**
     * Establece un titulo.
     * 
     * @param titulo titulo nuevo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Establece una ruta de ubicacion.
     * 
     * @param rutaUbicacion ruta de ubicacion nuevo
     */
    public void setRutaUbicacion(String rutaUbicacion) {
        this.rutaUbicacion = rutaUbicacion;
    }

    /**
     * Establece un estado.
     * 
     * @param estado estado nuevo
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece un motivo de invalidez.
     * 
     * @param motivoInvalidez motivo de invalidez nuevo
     */
    public void setMotivoInvalidez(String motivoInvalidez) {
        this.motivoInvalidez = motivoInvalidez;
    }

}
