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

/**
 * Archivo es la clase que contiene la información de un archivo del Servicio Social
 *
 * @author María Saarayim González Hernández
 * @version 1.0
 * @since 2019/05/28
 */
public class Archivo {

    private int id;
    private String titulo;
    private String rutaUbicacion;
    private String estado;
    private String motivoInvalidez = null;
    private int idHistorial;

    /**
     * Recurre una instancia Archivo
     *
     * @param titulo titulo del archivo
     * @param rutaUbicacion ruta de ubicación del archivo
     * @param estado estado del archivo
     * @param motivoInvalidez motivo por el que se invalida un archivo
     */
    public Archivo(int id, int idHistorial, String titulo, String rutaUbicacion, String estado, String motivoInvalidez) {
        this.titulo = titulo;
        this.rutaUbicacion = rutaUbicacion;
        this.estado = estado;
        this.motivoInvalidez = motivoInvalidez;
        this.id = id;
        this.idHistorial = idHistorial;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRutaUbicacion() {
        return rutaUbicacion;
    }

    public String getEstado() {
        return estado;
    }

    public String getMotivoInvalidez() {
        return motivoInvalidez;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setRutaUbicacion(String rutaUbicacion) {
        this.rutaUbicacion = rutaUbicacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMotivoInvalidez(String motivoInvalidez) {
        this.motivoInvalidez = motivoInvalidez;
    }

}
