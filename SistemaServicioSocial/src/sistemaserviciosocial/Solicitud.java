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
 * Solicitud es la clase que lleva la información de una solicitud registrada en el
 * sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/24
 */
public class Solicitud {
    private int id;
    private int numAlumnos;
    private String actividades;
    private String lugar;
    private String horario;
    private String responsableUnidad;
    private String requisitos;
	private LocalDate fechaRegistro;
	
	/**
	 * Crea una instancia vacía.
	 */
	public Solicitud() {
	}

	/**
	 * Crea una instancia con base en datos predefinidos.
	 * 
	 * @param id identificador de la solicitud de la solicitud
	 * @param numAlumnos número de alumnos de la solicitud
	 * @param actividades actividades de la solicitud
	 * @param lugar lugar del servicio social
	 * @param horario horario de la solicitud
	 * @param responsableUnidad responsable de la solicitud
	 * @param requisitos requisitos de la solicitud
	 * @param fechaRegistro fecha de registro de la solicitud
	 */
    public Solicitud(
        int id, int numAlumnos, String actividades, String lugar, String horario, 
        String responsableUnidad, String requisitos, LocalDate fechaRegistro
    ) {
        this.id = id;
        this.numAlumnos = numAlumnos;
        this.actividades = actividades;
        this.lugar = lugar;
        this.horario = horario;
        this.responsableUnidad = responsableUnidad;
        this.requisitos = requisitos;
        this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Crea una instancia con base en un identificador de la base de datos.
	 * 
	 * @param id identificador de la solicitud
	 */
	public Solicitud(int id) {
		init(id);
	}
	
	/**
	 * Inicializa los datos de la solicitud con base en un identificador de la base de datos.
	 * @param id identificador de la solicitud
	 */
	public void init(int id) {
		ISolicitudDAO solicitudDAO = new SolicitudDAO();
		Solicitud solicitudAux = solicitudDAO.getSolicitud(id);
		this.id = id;
		this.numAlumnos = solicitudAux.numAlumnos;
		this.actividades = solicitudAux.actividades;
		this.lugar = solicitudAux.lugar;
		this.horario = solicitudAux.horario;
		this.responsableUnidad = solicitudAux.responsableUnidad;
		this.requisitos = solicitudAux.requisitos;
		this.fechaRegistro = solicitudAux.fechaRegistro;
	}

	/**
	 * Establece el identificador de la solicitud.
	 * 
	 * @param id identificador de la solicitud
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Establece el número de alumnos de la solicitud.
	 * 
	 * @param numAlumnos número de alumnos de la solicitud
	 */
	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}

	/**
	 * Establece las actividades de la solicitud.
	 * 
	 * @param actividades actividades de la solicitud
	 */
	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	/**
	 * Establece el lugar de la solicitud.
	 * 
	 * @param lugar lugar de la solicitud
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * Establece el horario de la solicitud.
	 * 
	 * @param horario horario de la solicitud
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * Establece el responsable de la solicitud.
	 * 
	 * @param responsableUnidad responsable de la solicitud
	 */
	public void setResponsableUnidad(String responsableUnidad) {
		this.responsableUnidad = responsableUnidad;
	}

	/**
	 * Establece los requisitos de la solicitud.
	 * 
	 * @param requisitos requisitos de la solicitud
	 */
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	/**
	 * Establece la fecha de registro de la solicitud.
	 * 
	 * @param fechaRegistro fecha de registro de la solicitud
	 */
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Retorna el identificador de la solicitud.
	 * 
	 * @return identificador de la solicitud
	 */
	public int getId() {
		return id;
	}

	/**
	 * Retorna el número de alumnos de la solicitud.
	 * 
	 * @return número de alumnos de la solicitud
	 */
	public int getNumAlumnos() {
		return numAlumnos;
	}

	/**
	 * Retorna las actividades de la solicitud.
	 * 
	 * @return actividades de la solicitud
	 */
	public String getActividades() {
		return actividades;
	}

	/**
	 * Retorna el lugar de la solicitud.
	 * 
	 * @return lugar de la solicitud
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Retorna el horario de la solicitud.
	 * 
	 * @return horario de la solicitud
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * Retorna el responsable de la solicitud.
	 * 
	 * @return responsable de la solicitud
	 */
	public String getResponsableUnidad() {
		return responsableUnidad;
	}

	/**
	 * Retorna los requisitos de la solicitud.
	 * 
	 * @return requisitos de la solicitud
	 */
	public String getRequisitos() {
		return requisitos;
	}

	/**
	 * Retorna la fecha de registro de la solicitud.
	 * 
	 * @return fecha de registro de la solicitud
	 */
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
    
}
