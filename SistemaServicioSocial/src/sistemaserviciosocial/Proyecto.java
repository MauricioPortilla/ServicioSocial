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
 * Clase Proyecto
 *
 * @author Bruno Antonio López Luján
 * @version 1.0
 * @since 2019/05/30
 */
import java.time.LocalDate;

public class Proyecto {

    private int id;
    private String nombre;
    private String descripcion;
    private String horarioAlumno;
    private int numAlumnos;
    private String actividades;
    private LocalDate fechaRegistro;
    private Solicitud solicitudBase;
    private ResponsableProyecto responsableProyecto;

    public Proyecto(
        int id, Solicitud solicitudBase, ResponsableProyecto responsableProyecto, String nombre, 
        String descripcion, String horarioAlumno, int numAlumnos, String actividades, 
        LocalDate fechaRegistro
    ) {
        this.id = id;
        this.solicitudBase = solicitudBase;
        this.responsableProyecto = responsableProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horarioAlumno = horarioAlumno;
        this.numAlumnos = numAlumnos;
        this.actividades = actividades;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Guarda el proyecto en la base de datos.
     * 
     * @return <code>true</code> si se guardó correctamente; <code>false</code> si no
     */
    public boolean guardar() {
        IProyectoDAO proyectoDAO = new ProyectoDAO();
        return proyectoDAO.insertProyecto(this, responsableProyecto);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Solicitud getSolicitudBase() {
        return solicitudBase;
    }

    public void setSolicitudBase(Solicitud solicitudBase) {
        this.solicitudBase = solicitudBase;
    }

    public ResponsableProyecto getResponsableProyecto() {
        return responsableProyecto;
    }

    public void setResponsableProyecto(ResponsableProyecto responsableProyecto) {
        this.responsableProyecto = responsableProyecto;
    }
    
    

}
