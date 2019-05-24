/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaserviciosocial;

/**
 *
 * @author Mauricio CP
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

	public Alumno(
		String matricula, String nombre, String paterno, String telefono, 
		String correoPersonal, String nombreContacto, String correoContacto, 
		String telefonoContacto, float promedio, String estado
	) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.paterno = paterno;
		this.telefono = telefono;
		this.correoPersonal = correoPersonal;
		this.nombreContacto = nombreContacto;
		this.correoContacto = correoContacto;
		this.telefonoContacto = telefonoContacto;
		this.promedio = promedio;
		this.estado = estado;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreoPersonal() {
		return correoPersonal;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public float getPromedio() {
		return promedio;
	}

	public String getEstado() {
		return estado;
	}
    
}
