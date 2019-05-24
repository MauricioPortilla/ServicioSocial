/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaserviciosocial;

import java.time.LocalDate;

/**
 *
 * @author Mauricio CP
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

	public void setId(int id) {
		this.id = id;
	}

	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setResponsableUnidad(String responsableUnidad) {
		this.responsableUnidad = responsableUnidad;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getId() {
		return id;
	}

	public int getNumAlumnos() {
		return numAlumnos;
	}

	public String getActividades() {
		return actividades;
	}

	public String getLugar() {
		return lugar;
	}

	public String getHorario() {
		return horario;
	}

	public String getResponsableUnidad() {
		return responsableUnidad;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
    
}
