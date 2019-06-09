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
import java.util.ArrayList;

/**
 * HistorialAlumnoSS es la clase que lleva la información del historial de un Alumno 
 * registrado en el sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class HistorialAlumnoSS {
    private int id;
    private LocalDate fechaInicioSS;
    private LocalDate fechaFinSS;
    private int horasAcumuladas;
    private int numReportesEntregados;
    private Inscripcion inscripcion;
    private Solicitud solicitudAsignada = null;
    private ArrayList<Solicitud> solicitudesSeleccionadas = new ArrayList<>();

    /**
     * Crea una instacia vacía.
     */
    public HistorialAlumnoSS() {
    }

    /**
     * Crea una instancia con base en datos predefinidos.
     * 
     * @param id identificador del historial en la base de datos
     * @param fechaInicioSS fecha de inicio del servicio social
     * @param fechaFinSS fecha de fin del servicio social
     * @param horasAcumuladas horas acumuladas del servicio social
     * @param numReportesEntregados número de reportes entregados
     * @param inscripcion inscripción del alumno
     */
    public HistorialAlumnoSS(
        int id, LocalDate fechaInicioSS, LocalDate fechaFinSS, int horasAcumuladas, 
        int numReportesEntregados, Inscripcion inscripcion
    ) {
        this.id = id;
        this.fechaInicioSS = fechaInicioSS;
        this.fechaFinSS = fechaFinSS;
        this.horasAcumuladas = horasAcumuladas;
        this.numReportesEntregados = numReportesEntregados;
        this.inscripcion = inscripcion;
        initSolicitudes();
    }

    /**
     * Crea una instancia con base en un identificador y asigna sus datos correspondientes
     * desde la base de datos.
     * 
     * @param id identificador del historial
     */
    public HistorialAlumnoSS(int id) {
        this.id = id;
        if (inscripcion == null) {
            this.inscripcion = new InscripcionDAO().getInscripcion(this);
        }
        IHistorialAlumnoSSDAO historialAlumnoSSDAO = new HistorialAlumnoSSDAO();
        HistorialAlumnoSS historialAux = historialAlumnoSSDAO.getHistorial(inscripcion);
        this.fechaInicioSS = historialAux.fechaInicioSS;
        this.fechaFinSS = historialAux.fechaFinSS;
        this.horasAcumuladas = historialAux.horasAcumuladas;
        this.numReportesEntregados = historialAux.numReportesEntregados;
        this.inscripcion = historialAux.inscripcion;
        initSolicitudes();
    }

    /**
     * Asigna al historial las solicitudes seleccionadas del alumno y la solicitud asignada desde
     * la base de datos.
     */
    public void initSolicitudes() {
        if (id > 0) {
            this.solicitudAsignada = new SolicitudAsignadaDAO().getSolicitudAsignada(this);
            this.solicitudesSeleccionadas = 
                new SolicitudSeleccionadaDAO().getSolicitudesSeleccionadas(this);
        }
    }

    /**
     * Retorna el identificador del historial.
     * 
     * @return identificador del historial
     */
    public int getId() {
        return id;
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
     * Retorna la fecha de inicio del servicio social.
     * 
     * @return fecha de inicio del servicio social
     */
    public LocalDate getFechaInicioSS() {
        return fechaInicioSS;
    }

    /**
     * Establece la fecha de inicio del servicio social.
     * 
     * @param fechaInicioSS fecha de inicio del servicio social nueva
     */
    public void setFechaInicioSS(LocalDate fechaInicioSS) {
        this.fechaInicioSS = fechaInicioSS;
    }

    /**
     * Retorna la fecha de fin del servicio social.
     * 
     * @return fecha de fin del servicio social
     */
    public LocalDate getFechaFinSS() {
        return fechaFinSS;
    }

    /**
     * Establece la fecha de fin del servicio social.
     * 
     * @param fechaFinSS fecha de fin del servicio social nueva
     */
    public void setFechaFinSS(LocalDate fechaFinSS) {
        this.fechaFinSS = fechaFinSS;
    }

    /**
     * Retorna las horas acumuladas del servicio social.
     * 
     * @return horas acumuladas del servicio social
     */
    public int getHorasAcumuladas() {
        return horasAcumuladas;
    }

    /**
     * Establece las horas acumuladas del servicio social.
     * 
     * @param horasAcumuladas horas acumuladas del servicio social nuevas
     */
    public void setHorasAcumuladas(int horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    /**
     * Retorna el número de reportes entregados.
     * 
     * @return número de reportes entregados
     */
    public int getNumReportesEntregados() {
        return numReportesEntregados;
    }

    /**
     * Establece el número de reportes entregados.
     * 
     * @param numReportesEntregados número de reportes entregados nuevo
     */
    public void setNumReportesEntregados(int numReportesEntregados) {
        this.numReportesEntregados = numReportesEntregados;
    }

    /**
     * Retorna la inscripción del alumno asociada a este historial.
     * 
     * @return inscripción del alumno
     */
    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    /**
     * Establece la inscripción del alumno.
     * 
     * @param inscripcion inscripción del alumno
     */
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
    
    /**
     * Retorna la solicitud asignada al alumno pertenecedor de este historial.
     * 
     * @return solicitud asignada
     */
    public Solicitud getSolicitudAsignada() {
        return solicitudAsignada;
    }

    /**
     * Establece la solicitud asignada al alumno pertenecedor de este historial.
     * 
     * @param solicitudAsignada solicitud asignada nueva
     */
    public void setSolicitudAsignada(Solicitud solicitudAsignada) {
        this.solicitudAsignada = solicitudAsignada;
    }

    /**
     * Retorna las solicitudes seleccionadas por el alumno pertenecedor de este historial.
     * 
     * @return solicitudes seleccionadas
     */
    public ArrayList<Solicitud> getSolicitudesSeleccionadas() {
        return solicitudesSeleccionadas;
    }

    /**
     * Establece las solicitudes seleccionadas por el alumno pertenecedor de este
     * historial.
     * 
     * @param solicitudes solicitudes seleccionadas
     */
    public void setSolicitudesSeleccionadas(ArrayList<Solicitud> solicitudes) {
        this.solicitudesSeleccionadas = solicitudes;
    }
    
}
