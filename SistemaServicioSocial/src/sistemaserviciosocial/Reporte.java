/** 
 * Reporte es la clase que contiene la información de un reporte de Servicio Social.
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/28
 */

package sistemaserviciosocial;
import java.time.LocalDate;


public class Reporte {
    private int id;
    private int numero;
    private int horasReportadas;
    private String mes;
    private LocalDate fechaEntrega;
    private String estado;
    private String motivoInvalidez = null;
    private int idHistorial;
    private int idEntrega;
    
    /**
     * 
     * @param numero numero de reporte
     * @param horasReportadas numero de horas reportadas
     * @param mes mes de reporte
     * @param fechaEntrega fecha de entrega de reporte
     * @param estado estado en el que se enuentra el reporte
     * @param motivoInvalidez motivo de invalidez del reporte
     */
    
    public Reporte(int id,int numero, int horasReportadas, String mes, LocalDate fechaEntrega, String estado, String motivoInvalidez,int idHistorial, int idEntrega){
        this.id=id;
        this.numero = numero;
        this.horasReportadas = horasReportadas;
        this.mes = mes;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.motivoInvalidez = motivoInvalidez;
        this.idHistorial= idHistorial;
        this.idEntrega = idEntrega;
       
    }

    public int getId() {
        return id;
    }
    
    public int getNumero() {
        return numero;
    }

    public int getHorasReportadas() {
        return horasReportadas;
    }

    public String getMes() {
        return mes;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public String getMotivoInvalidez() {
        return motivoInvalidez;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public int getIdEntrega() {
        return idEntrega;
    }
    

    public void setId(int id) {
        this.id = id;
    }
    

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setHorasReportadas(int horasReportadas) {
        this.horasReportadas = horasReportadas;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMotivoInvalidez(String motivoInvalidez) {
        this.motivoInvalidez = motivoInvalidez;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }
    
    
    
}
