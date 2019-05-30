/**
 * Archivo es la clase que contiene la información de un archivo del Servicio Social
 * @author María Saarayim González Hernández
 * @version 1.0
 * @since 2019/05/28
 */
package sistemaserviciosocial;


public class Archivo {
  private int id;
  private String titulo;
  private String rutaUbicacion;
  private String estado;
  private String motivoInvalidez = null;
  
  
  /**
   * Recurre una instancia Archivo
   * @param titulo titulo del archivo
   * @param rutaUbicacion ruta de ubicación del archivo
   * @param estado estado del archivo
   * @param motivoInvalidez motivo por el que se invalida un archivo 
   */
  public Archivo(int id, String titulo, String rutaUbicacion, String estado, String motivoInvalidez){
    this.titulo=titulo;
    this.rutaUbicacion=rutaUbicacion;
    this.estado=estado;
    this.motivoInvalidez=motivoInvalidez;
    this.id=id;
  }

  public void setId(int id) {
    this.id = id;
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
