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
 * Reporte es la clase que contiene la información de un reporte de Servicio Social.
 *
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/28
 */
import java.time.LocalDate;

public class Reporte {

    private int id;
    private int numero;
    private int horasReportadas;
    private String mes;
    private LocalDate fechaEntrega;
    private String estado;
    private String motivoInvalidez = null;
    private HistorialAlumnoSS historialAlumno;
    private FechaEntregaReporte fechaEntregaReporte;
    private Archivo archivoReporte;

    /**
     * Crea una instancia vacía.
     */
    public Reporte() {
    }

    /**
     * 
     * @param id
     * @param numero
     * @param horasReportadas
     * @param mes
     * @param fechaEntrega
     * @param estado
     * @param historialAlumno
     * @param fechaEntregaReporte
     * @param archivoReporte
     */
    public Reporte(
        int id, int numero, int horasReportadas, String mes, LocalDate fechaEntrega, 
        String estado, String motivoInvalidez, HistorialAlumnoSS historialAlumno, 
        FechaEntregaReporte fechaEntregaReporte, Archivo archivoReporte
    ) {
        this.id = id;
        this.numero = numero;
        this.horasReportadas = horasReportadas;
        this.mes = mes;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.motivoInvalidez = motivoInvalidez;
        this.historialAlumno = historialAlumno;
        this.fechaEntregaReporte = fechaEntregaReporte;
        this.archivoReporte = archivoReporte;
    }

    /**
     * Indica si el reporte tiene datos cargados.
     * 
     * @return <code>true</code> si el identificador es mayor a cero; <code>false</code> si no
     */
    public boolean isLoaded() {
        return (id > 0);
    }

    /**
     * Guarda el reporte en la base de datos.
     * 
     * @return <code>true</code> si se guardó correctamente; <code>false</code> si no
     */
    public boolean guardar() {
        IReporteDAO reporteDAO = new ReporteDAO();
        return (reporteDAO.insertReporte(this));
    }

    public boolean modificar() {
        IReporteDAO reporteDAO = new ReporteDAO();
        return (reporteDAO.updateReporte(this));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getHorasReportadas() {
        return horasReportadas;
    }

    public void setHorasReportadas(int horasReportadas) {
        this.horasReportadas = horasReportadas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivoInvalidez() {
        return motivoInvalidez;
    }

    public void setMotivoInvalidez(String motivoInvalidez) {
        this.motivoInvalidez = motivoInvalidez;
    }

    public HistorialAlumnoSS getHistorialAlumno() {
        return historialAlumno;
    }

    public void setHistorialAlumno(HistorialAlumnoSS historialAlumno) {
        this.historialAlumno = historialAlumno;
    }

    public FechaEntregaReporte getFechaEntregaReporte() {
        return fechaEntregaReporte;
    }

    public void setFechaEntregaReporte(FechaEntregaReporte fechaEntregaReporte) {
        this.fechaEntregaReporte = fechaEntregaReporte;
    }

    public Archivo getArchivoReporte() {
        return archivoReporte;
    }

    public void setArchivoReporte(Archivo archivoReporte) {
        this.archivoReporte = archivoReporte;
    }

}
