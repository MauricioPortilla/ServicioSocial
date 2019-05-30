/**
 *Clase Proyecto
 *@author Bruno Antonio López Luján
 *@version 1.0
 *@since 2019/05/30
 */
package sistemaserviciosocial;
import java.time.LocalDate;

public class Proyecto {
  private String nombre;
  private String descripcion;
  private String horarioAlumno;
  private int numAlumnos;
  private String actividades;
  private LocalDate fechaRegistro;
  private int idProyecto;
  private int idSolicitud;
  private int idResponsable;

 public Proyecto(int idProyecto, int idSolicitud, int idResponsable, String nombre, String descripcion, String horarioAlumno, int numAlumnos, String actividades, LocalDate fechaRegistro){
   this.idProyecto = idProyecto;
   this.idSolicitud = idSolicitud;
   this.idResponsable = idResponsable;
   this.nombre = nombre;
   this.descripcion = descripcion;
   this.horarioAlumno = horarioAlumno;
   this.numAlumnos = numAlumnos;
   this.actividades = actividades;
   this.fechaRegistro = fechaRegistro;
 } 

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getHorarioAlumno() {
    return horarioAlumno;
  }

  public int getNumAlumnos() {
    return numAlumnos;
  }

  public String getActividades() {
    return actividades;
  }

  public LocalDate getFechaRegistro() {
    return fechaRegistro;
  }

  public int getIdProyecto() {
    return idProyecto;
  }

  public int getIdSolicitud() {
    return idSolicitud;
  }

  public int getIdResponsable() {
    return idResponsable;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setHorarioAlumno(String horarioAlumno) {
    this.horarioAlumno = horarioAlumno;
  }

  public void setNumAlumnos(int numAlumnos) {
    this.numAlumnos = numAlumnos;
  }

  public void setActividades(String actividades) {
    this.actividades = actividades;
  }

  public void setFechaRegistro(LocalDate fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  public void setIdProyecto(int idProyecto) {
    this.idProyecto = idProyecto;
  }

  public void setIdSolicitud(int idSolicitud) {
    this.idSolicitud = idSolicitud;
  }

  public void setIdResponsable(int idResponsable) {
    this.idResponsable = idResponsable;
  }

}
