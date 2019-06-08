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
 * Alumno es la clase que lleva la información de un Alumno registrado en el sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/24
 */
public class Alumno {
    private String matricula;
    private String nombre;
    private String paterno;
    private String materno = null;
    private String telefono;
    private String correoPersonal;
    private String nombreContacto;
    private String correoContacto;
    private String telefonoContacto;
    private float promedio;
	private String estado;
	private Inscripcion inscripcion;
	private ServicioSocial[] serviciosSociales = new ServicioSocial[2];

	/**
	 * Crea uns instancia Alumno con datos predefinidos.
	 * 
	 * @param matricula matricula del alumno
	 * @param nombre nombre del alumno
	 * @param paterno apellido paterno del alumno
	 * @param materno apellido materno del alumno
	 * @param telefono telefono del alumno
	 * @param correoPersonal correo personal del alumno
	 * @param nombreContacto nombre del contacto del alumno
	 * @param correoContacto correo del contacto del alumno
	 * @param telefonoContacto telefono del contacto del alumno
	 * @param promedio promedio del alumno
	 * @param estado estado del alumno
	 */
	public Alumno(
		String matricula, String nombre, String paterno, String materno, String telefono, 
		String correoPersonal, String nombreContacto, String correoContacto, 
		String telefonoContacto, float promedio, String estado
	) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.telefono = telefono;
		this.correoPersonal = correoPersonal;
		this.nombreContacto = nombreContacto;
		this.correoContacto = correoContacto;
		this.telefonoContacto = telefonoContacto;
		this.promedio = promedio;
		this.estado = estado;
		this.inscripcion = new Inscripcion(this);
	}

	/**
	 * Asigna una solicitud para dar inicio a su servicio social.
	 * 
	 * @param solicitud solicitud a asignar
	 * @return <code>true</code> si se asignó correctamente. <code>false</code> si no se asignó.
	 */
	public boolean asignarSolicitud(Solicitud solicitud) {
		ISolicitudAsignadaDAO solicitudAsignadaDAO = new SolicitudAsignadaDAO();
		return solicitudAsignadaDAO.insertSolicitudAsignada(inscripcion.getHistorial(), solicitud);
	}

	/**
	 * Establece una matrícula.
	 * 
	 * @param matricula matrícula nueva
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Establece un nombre.
	 * 
	 * @param nombre nombre nuevo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Establece un apellido paterno.
	 * 
	 * @param paterno apellido paterno nuevo
	 */
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	/**
	 * Establece un apellido materno.
	 * 
	 * @param materno apellido materno nuevo
	 */
	public void setMaterno(String materno) {
		this.materno = materno;
	}

	/**
	 * Establece un telefono.
	 * 
	 * @param telefono telefono nuevo
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Establece un correo personal.
	 * 
	 * @param correoPersonal correo personal nuevo
	 */
	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	/**
	 * Establece un nombre de contacto.
	 * 
	 * @param nombreContacto nombre de contacto nuevo
	 */
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	/**
	 * Establece un correo de contacto.
	 * 
	 * @param correoContacto correo de contacto nuevo
	 */
	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	/**
	 * Establece un telefono de contacto.
	 * 
	 * @param telefonoContacto telefono de contacto nuevo
	 */
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	/**
	 * Establece un promedio.
	 * 
	 * @param promedio promedio nuevo
	 */
	public void setPromedio(float promedio) {
		this.promedio = promedio;
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
	 * Establece una inscripción.
	 * 
	 * @param inscripcion inscripción nueva
	 */
	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	/**
	 * Retorna la matrícula del alumno.
	 * 
	 * @return matricula del alumno
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Retorna el nombre del alumno.
	 * 
	 * @return nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna el apellido paterno del alumno.
	 * 
	 * @return apellido paterno del alumno
	 */
	public String getPaterno() {
		return paterno;
	}

	/**
	 * Retorna el apellido materno del alumno.
	 * 
	 * @return apellido materno del alumno
	 */
	public String getMaterno() {
		return materno;
	}

	/**
	 * Retorna el telefono del alumno.
	 * 
	 * @return telefono del alumno
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Retorna el correo personal del alumno.
	 * 
	 * @return correo personal del alumno
	 */
	public String getCorreoPersonal() {
		return correoPersonal;
	}

	/**
	 * Retorna el nombre de contacto del alumno.
	 * 
	 * @return nombre de contacto del alumno
	 */
	public String getNombreContacto() {
		return nombreContacto;
	}

	/**
	 * Retorna el correo de contacto del alumno.
	 * 
	 * @return correo de contacto del alumno
	 */
	public String getCorreoContacto() {
		return correoContacto;
	}

	/**
	 * Retorna el telefono de contacto del alumno.
	 * 
	 * @return telefono de contacto del alumno
	 */
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	/**
	 * Retorna el promedio del alumno.
	 * 
	 * @return promedio del alumno
	 */
	public float getPromedio() {
		return promedio;
	}

	/**
	 * Retorna el estado del alumno.
	 * 
	 * @return estado del alumno
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Retorna la inscripción del alumno.
	 * 
	 * @return inscripción del alumno
	 */
	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	/**
	 * Retorna el nombre completo del alumno.
	 * 
	 * @param reverse <code>true</code> si se desea el nombre comenzando por
	 *                apellidos; <code>false</code> si se desea comenzando por el
	 *                nombre.
	 * @param whiteSpaces <code>true</code> si se desea separar el nombre completo con espacios;
	 * 					  <code>false</code> si no se desea separar.
	 * @return nombre completo
	 */
	public String getFullName(boolean reverse, boolean whiteSpaces) {
		if (!reverse) {
			if (whiteSpaces) {
				return nombre + " " + paterno + " " + materno;
			}
			return nombre + paterno + materno;
		}
		if (whiteSpaces) {
			return paterno + " " + materno + " " + nombre;
		}
		return paterno + materno + nombre;
	}
    
}
