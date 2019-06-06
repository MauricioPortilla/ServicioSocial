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

import java.util.ArrayList;

/**
 * UnidadReceptora es la clase que lleva la información de una unidad receptora
 * registrada en el sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class UnidadReceptora {
    private String nombre;
    private String correo;
    private String calle;
    private String numExt;
    private String colonia;
    private String codigoPostal;
    private ArrayList<Solicitud> solicitudes = new ArrayList<>();

    /**
     * Crea una instancia con base en datos predefinidos.
     * 
     * @param nombre nombre de la unidad receptora
     * @param correo correo de la unidad receptora
     * @param calle calle de la unidad receptora
     * @param numExt número exterior de la unidad receptora
     * @param colonia colonia de la unidad receptora
     * @param codigoPostal código postal de la unidad receptora
     */
    public UnidadReceptora(
        String nombre, String correo, String calle, String numExt, String colonia, 
        String codigoPostal
    ) {
        this.nombre = nombre;
        this.correo = correo;
        this.calle = calle;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Retorna el nombre de la unidad receptora.
     * 
     * @return nombre de la unidad receptora
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la unidad receptora.
     * 
     * @param nombre nombre de la unidad receptora nuevo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el correo de la unidad receptora.
     * 
     * @return correo de la unidad receptora
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo de la unidad receptora.
     * 
     * @param correo correo de la unidad receptora nuevo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Retorna la calle de la unidad receptora.
     * 
     * @return calle de la unidad receptora
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la unidad receptora.
     * 
     * @param calle calle de la unidad receptora nuevo.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Retorna el número exterior de la unidad receptora.
     * 
     * @return número exterior de la unidad receptora
     */
    public String getNumExt() {
        return numExt;
    }

    /**
     * Establece el número exterior de la unidad receptora.
     * 
     * @param número exterior número exterior de la unidad receptora nuevo.
     */
    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    /**
     * Retorna la colonia de la unidad receptora.
     * 
     * @return colonia de la unidad receptora
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la unidad receptora.
     * 
     * @param colonia colonia de la unidad receptora nuevo.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Retorna el código postal de la unidad receptora.
     * 
     * @return código postal de la unidad receptora
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la unidad receptora.
     * 
     * @param codigoPostal código postal de la unidad receptora nuevo.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
}
