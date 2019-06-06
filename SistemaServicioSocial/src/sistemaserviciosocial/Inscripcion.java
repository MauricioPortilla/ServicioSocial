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
 * Inscripcion es la clase que lleva la información de una inscripción de un Alumno
 * registrado en el sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class Inscripcion {
    private int id;
    private Alumno alumno;
    private ServicioSocial servicioSocial;
    private LocalDate fecha;
    private String tipo;
    private HistorialAlumnoSS historial;

    /**
     * Crea una instancia vacía.
     */
    public Inscripcion() {
    }

    /**
     * Crea una instancia con base en datos predefinidos.
     * 
     * @param id identificador de la inscripción
     * @param alumno alumno de la inscripción
     * @param servicioSocial servicio social al que pertenece esta inscripción
     * @param fecha fecha de inscripción
     * @param tipo tipo de inscripción
     * @param historial historial de la inscripción
     */
    public Inscripcion(
        int id, Alumno alumno, ServicioSocial servicioSocial, LocalDate fecha, String tipo, 
        HistorialAlumnoSS historial
    ) {
        this.alumno = alumno;
        this.servicioSocial = servicioSocial;
        this.fecha = fecha;
        this.tipo = tipo;
        this.historial = historial;
        inicializarHistorial();
    }

    /**
     * Crea una instancia con base en un identificador de la base de datos.
     * 
     * @param id identificador de la inscripción
     */
    public Inscripcion(int id) {
        IInscripcionDAO inscripcionDAO = new InscripcionDAO();
        Inscripcion inscripcionAux = inscripcionDAO.getInscripcion(this.alumno);
        this.id = inscripcionAux.id;
        this.servicioSocial = inscripcionAux.servicioSocial;
        this.fecha = inscripcionAux.fecha;
        this.tipo = inscripcionAux.tipo;
        inicializarHistorial();
    }

    /**
     * Crea una instancia Inscripcion con base en un alumno y la inicializa con datos traidos
     * de la base de datos.
     * 
     * @param alumno alumno a utilizar
     */
    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        IInscripcionDAO inscripcionDAO = new InscripcionDAO();
        Inscripcion inscripcionAux = inscripcionDAO.getInscripcion(alumno);
        this.id = inscripcionAux.id;
        this.servicioSocial = inscripcionAux.servicioSocial;
        this.fecha = inscripcionAux.fecha;
        this.tipo = inscripcionAux.tipo;
        inicializarHistorial();
    }

    /**
     * Trae de la base de datos el historial de esta inscripción y lo asigna.
     */
    private void inicializarHistorial() {
        IHistorialAlumnoSSDAO historialAlumnoSSDAO = new HistorialAlumnoSSDAO();
        this.historial = historialAlumnoSSDAO.getHistorial(this);
    }

    /**
     * Retorna el identificador de la inscripción.
     * 
     * @return identificador de la inscripción
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la inscripción.
     * 
     * @param id identificador de la inscripción nuevo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el alumno asociado a esta inscripción.
     * 
     * @return alumno asociado a esta inscripción
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Establece el alumno asociado a esta inscripción.
     * 
     * @param alumno alumno asociado a esta inscripción nuevo
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Retorna el servicio social asociado a esta inscripción.
     * 
     * @return servicio social asociado a esta inscripción
     */
    public ServicioSocial getServicioSocial() {
        return servicioSocial;
    }

    /**
     * Establece el servicio social asociado a esta inscripción.
     * 
     * @param servicioSocial servicio social asociado a esta inscripción nuevo
     */
    public void setServicioSocial(ServicioSocial servicioSocial) {
        this.servicioSocial = servicioSocial;
    }

    /**
     * Retorna la fecha de inscripción.
     * 
     * @return fecha de inscripción
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de inscripción.
     * 
     * @param fecha fecha de inscripción nueva
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna el tipo de inscripción.
     * 
     * @return tipo de inscripción
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de inscripción.
     * 
     * @param tipo tipo de inscripción nueva
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el historial del alumno asociado a esta inscripción.
     * 
     * @return historial del alumno
     */
    public HistorialAlumnoSS getHistorial() {
        return historial;
    }

    /**
     * Establece el historial del alumno asociado a esta inscripción.
     * 
     * @param historial historial del alumno nuevo
     */
    public void setHistorial(HistorialAlumnoSS historial) {
        this.historial = historial;
    }
    
    
}
