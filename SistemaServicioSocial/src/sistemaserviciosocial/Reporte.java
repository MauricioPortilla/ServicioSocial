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

    /**
     * Modifica un reporte
     * @return reporte modificado
     */
    public boolean modificar() {
        IReporteDAO reporteDAO = new ReporteDAO();
        return (reporteDAO.updateReporte(this));
    }

    /**
     * Regresa el id del reporte
     * @return id de reporte
     */
    public int getId() {
        return id;
    }

    /**
     * Establece un id de reporte
     * @param id id de reporte
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa el número de reporte
     * @return número de reporte
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de reporte
     * @param numero número de reporte
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Regresa las horas reportadas
     * @return horas reportadas
     */
    public int getHorasReportadas() {
        return horasReportadas;
    }

    /**
     * Establece las horas reportadas
     * @param horasReportadas horas reportadas
     */
    public void setHorasReportadas(int horasReportadas) {
        this.horasReportadas = horasReportadas;
    }

    /**
     * Regresa el mes del reporte
     * @return mes del reporte
     */
    public String getMes() {
        return mes;
    }

    /**
     * Establece el mes de reporte
     * @param mes mes de reporte
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Regresa la fecha de entrega del reporte
     * @return fecha de entrega
     */
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Establece la fecha de entrega del reporte
     * @param fechaEntrega fecha de entrega del reporte
     */
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Regresa el estado del reporte
     * @return estado del reporte
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del reporte
     * @param estado estado del reporte
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa el motivo de invalidez del reporte
     * @return motivo de invalidez del reporte
     */
    public String getMotivoInvalidez() {
        return motivoInvalidez;
    }

    /**
     * Establece el motivo de invalidez del reporte
     * @param motivoInvalidez motivo de invalidez del reporte
     */
    public void setMotivoInvalidez(String motivoInvalidez) {
        this.motivoInvalidez = motivoInvalidez;
    }
    
    /**
     * Regresa el historial del alumno
     * @return historial del alumno
     */
    public HistorialAlumnoSS getHistorialAlumno() {
        return historialAlumno;
    }

    /**
     * Establece el historial del laumno
     * @param historialAlumno historial del alumno
     */
    public void setHistorialAlumno(HistorialAlumnoSS historialAlumno) {
        this.historialAlumno = historialAlumno;
    }

    /**
     * Regresa la fehca de entrega del reporte
     * @return fecha de entrega del reporte
     */
    public FechaEntregaReporte getFechaEntregaReporte() {
        return fechaEntregaReporte;
    }

    /**
     * Establece la fecha de entrega del reporte
     * @param fechaEntregaReporte fecha de entrega del reporte
     */
    public void setFechaEntregaReporte(FechaEntregaReporte fechaEntregaReporte) {
        this.fechaEntregaReporte = fechaEntregaReporte;
    }

    /**
     * Regresa el archivo reporte
     * @return archivo reporte
     */
    public Archivo getArchivoReporte() {
        return archivoReporte;
    }

    /**
     * Establece un archivo reporte
     * @param archivoReporte archivo reporte
     */
    public void setArchivoReporte(Archivo archivoReporte) {
        this.archivoReporte = archivoReporte;
    }

}
