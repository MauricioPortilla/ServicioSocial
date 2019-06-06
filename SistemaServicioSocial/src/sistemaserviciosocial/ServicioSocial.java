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
 * ServicioSocial es la clase que lleva la información de un Servicio Social
 * registrado en el sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class ServicioSocial {
    private int id;
    private int bloque;
    private int seccion;
    private int nrc;
    private String periodo;

    /**
     * Crea una instancia vacía.
     */
    public ServicioSocial() {
    }

    /**
     * Crea una instancia con base en datos predefinidos.
     * 
     * @param id identificador del servicio social
     * @param bloque bloque del servicio social
     * @param seccion seccion del servicio social
     * @param nrc nrc del servicio social
     * @param periodo periodo del servicio social
     */
    public ServicioSocial(int id, int bloque, int seccion, int nrc, String periodo) {
        this.id = id;
        this.bloque = bloque;
        this.seccion = seccion;
        this.nrc = nrc;
        this.periodo = periodo;
    }

    /**
     * Crea una instancia con base en el identificador de la base de datos.
     * 
     * @param id identificador del servicio social
     */
    public ServicioSocial(int id) {
        IServicioSocialDAO servicioSocialDAO = new ServicioSocialDAO();
        ServicioSocial servicioSocialAux = servicioSocialDAO.getServicioSocial(id);
        this.id = id;
        this.bloque = servicioSocialAux.bloque;
        this.seccion = servicioSocialAux.seccion;
        this.nrc = servicioSocialAux.nrc;
        this.periodo = servicioSocialAux.periodo;
    }

    /**
     * Retorna el identificador del servicio social.
     * 
     * @return identificador del servicio social.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del servicio social.
     * 
     * @param id identificador del servicio social nuevo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el bloque del servicio social.
     * 
     * @return bloque del servicio social.
     */
    public int getBloque() {
        return bloque;
    }

    /**
     * Establece el bloque del servicio social.
     * 
     * @param bloque bloque del servicio social nuevo
     */
    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    /**
     * Retorna la seccion del servicio social.
     * 
     * @return seccion del servicio social.
     */
    public int getSeccion() {
        return seccion;
    }

    /**
     * Establece la seccion del servicio social.
     * 
     * @param seccion seccion del servicio social nueva
     */
    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    /**
     * Retorna el nrc del servicio social.
     * 
     * @return nrc del servicio social.
     */
    public int getNrc() {
        return nrc;
    }

    /**
     * Establece el nrc del servicio social.
     * 
     * @param nrc nrc del servicio social nuevo
     */
    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    /**
     * Retorna el periodo del servicio social.
     * 
     * @return periodo del servicio social.
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Establece el periodo del servicio social.
     * 
     * @param periodo periodo del servicio social nuevo
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
}
