/*
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
 * FechaEntregaReporte es la clase que contiene la información de un Fecha de Entrega de reportes.
 *
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public class FechaEntregaReporte {
    private int id;
    private LocalDate fechaMinima;
    private LocalDate fechaLimite;
    private String mes;

    /**
     * Crea una instancia vacía.
     */
    public FechaEntregaReporte() {
    }

    /**
     * Crea una instancia con base en datos predefinidos.
     * 
     * @param id identificador de la fecha de entrega
     * @param fechaMinima fecha mínima de la fecha de entrega
     * @param fechaLimite fecha límite de la fecha de entrega
     * @param mes mes de la fecha de entrega
     */
    public FechaEntregaReporte(int id, LocalDate fechaMinima, LocalDate fechaLimite, String mes) {
        this.id = id;
        this.fechaMinima = fechaMinima;
        this.fechaLimite = fechaLimite;
        this.mes = mes;
    }

    /**
     * Crea una instancia a partir de un identificador de la base de datos.
     * 
     * @param id identificador de la fecha de entrega
     */
    public FechaEntregaReporte(int id) {
        this.id = id;
        IFechaEntregaReporteDAO fechaEntregaReporteDAO = new FechaEntregaReporteDAO();
        FechaEntregaReporte fechaEntregaAux = fechaEntregaReporteDAO.getFechaEntrega(id);
        this.fechaMinima = fechaEntregaAux.fechaMinima;
        this.fechaLimite = fechaEntregaAux.fechaLimite;
        this.mes = fechaEntregaAux.mes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaMinima() {
        return fechaMinima;
    }

    public void setFechaMinima(LocalDate fechaMinima) {
        this.fechaMinima = fechaMinima;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    

}
