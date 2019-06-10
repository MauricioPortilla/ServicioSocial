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

import java.time.LocalDate;

/**
 * Proyecto es la clase que lleva la información de un proyecto registrado.
 *
 * @author Bruno Antonio López Luján
 * @author María Saarayim González Hernández
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/30
 */
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

    /**
     * Crea una instancia vacía.
     */
    public Proyecto() {
    }

    /**
     * Crea una instancia con base en datos predefinidos.
     * 
     * @param id identificador del proyecto
     * @param solicitudBase solicitud base del proyecto
     * @param responsableProyecto responsable del proyecto
     * @param nombre nombre del proyecto
     * @param descripcion descripcion del proyecto
     * @param horarioAlumno horario del proyecto
     * @param numAlumnos numero de alumnos del proyecto
     * @param actividades actividades del proyecto
     * @param fechaRegistro fecha de registro del proyecto
     */
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
     * Crea una instancia con base en un identificador de la base de datos.
     * 
     * @param id identificador del proyecto
     */
    public Proyecto(int id) {
        init(id);
    }

    /**
     * Inicializa la instancia con su identificador y trae
     * de la base de datos sus datos.
     */
    public void init(int id) {
        this.id = id;
        IProyectoDAO proyectoDAO = new ProyectoDAO();
        Proyecto proyectoAux = proyectoDAO.getProyecto(id);
        this.solicitudBase = proyectoAux.solicitudBase;
        this.responsableProyecto = proyectoAux.responsableProyecto;
        this.nombre = proyectoAux.nombre;
        this.descripcion = proyectoAux.descripcion;
        this.horarioAlumno = proyectoAux.horarioAlumno;
        this.numAlumnos = proyectoAux.numAlumnos;
        this.actividades = proyectoAux.actividades;
        this.fechaRegistro = proyectoAux.fechaRegistro;
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

    /**
     * Regresa el nombre del proyecto
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Regresa la descripción del proyecto
     * 
     * @return descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Regresa el horario del alumno
     * 
     * @return horario del alumno
     */
    public String getHorarioAlumno() {
        return horarioAlumno;
    }

    /**
     * Regresa el número de alumnos
     * 
     * @return numero de alumnos
     */
    public int getNumAlumnos() {
        return numAlumnos;
    }

    /**
     * Regresa las actividades del proyecto
     * 
     * @return actividades
     */
    public String getActividades() {
        return actividades;
    }

    /**
     * Regresa la fecha de registro del proyecto
     * 
     * @return fecha de registro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece el nombre del proyecto
     * 
     * @param nombre nombre del proyecto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la descripción del proyecto
     * 
     * @param descripcion descripción del proyecto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece el horario del alumno
     * 
     * @param horarioAlumno horario del alumno
     */
    public void setHorarioAlumno(String horarioAlumno) {
        this.horarioAlumno = horarioAlumno;
    }

    /**
     * Establece el número de alumnos
     * 
     * @param numAlumnos número de alumnos
     */
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    /**
     * Establece las actividades del proyecto
     * 
     * @param actividades actividades del proyecto
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    /**
     * Establece la fecha de registro del proyecto
     * 
     * @param fechaRegistro fecha de registro del proyecto
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Regresa el id del proyecto
     * 
     * @return id del proyecto
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del proyecto
     * 
     * @param id id del proyecto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa la solicitud del proyecto
     * 
     * @return solicitud
     */
    public Solicitud getSolicitudBase() {
        return solicitudBase;
    }

    /**
     * Establece la solicitud del proyecto
     * 
     * @param solicitudBase solicitud
     */
    public void setSolicitudBase(Solicitud solicitudBase) {
        this.solicitudBase = solicitudBase;
    }

    /**
     * Regresa el responsable del proyecto
     * 
     * @return responsable de proyecto
     */
    public ResponsableProyecto getResponsableProyecto() {
        return responsableProyecto;
    }

    /**
     * Establece un responsable de proyecto
     * 
     * @param responsableProyecto responsable de proyecto
     */
    public void setResponsableProyecto(ResponsableProyecto responsableProyecto) {
        this.responsableProyecto = responsableProyecto;
    }
    
}
