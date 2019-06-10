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

/**
 * ResponsableProyecto es la clase que contiene la información de un responsable
 * de un proyecto registrado.
 *
 * @author Mauricio Cruz Portilla
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/06/08
 */
public class ResponsableProyecto {

    private int id;
    private String nombre;
    private String paterno;
    private String materno = null;
    private String correo;
    private String telefono;
    
    /**
     * 
     * @param id
     * @param nombre
     * @param paterno
     * @param materno
     * @param correo
     * @param telefono 
     */

    public ResponsableProyecto(
        int id, String nombre, String paterno, String materno, String correo, String telefono
    ) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.correo = correo;
        this.telefono = telefono;
    }
    /**
     * Establece un id de responsable de proyecto
     * @param id id de responsable de proyecto
     */

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Regresa el id del responsable del proyecto
     * @return id de responsable del proyecto
     */

    public int getId() {
        return id;
    }
    
    /**
     * Regresa el nombre del responsable del proyecto
     * @return nombre del responsable del proyecto
     */

    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece un nombre a responsable del proyecto
     * @param nombre nombre del responsable del proyecto
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Regresa el paterno de responsable del proyecto
     * @return paterno de responsable del proyecto
     */

    public String getPaterno() {
        return paterno;
    }
    
    /**
     * Establece un paterno para el responsable del proyecto
     * @param paterno paterno de responsable de proyecto
     */

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    
    /**
     * Regresa el materno de responsable del proyecto
     * @return materno de responsable del proyecto
     */

    public String getMaterno() {
        return materno;
    }
    
    /**
     * Establece el materno de responsable del proyecto
     * @param materno materno de responsable del proyecto
     */

    public void setMaterno(String materno) {
        this.materno = materno;
    }
    
    /**
     * Regresa el correo de responsable del proyecto
     * @return correo de responsable del proyecto
     */

    public String getCorreo() {
        return correo;
    }
    
    /**
     * Establece un correo para responsable del proyecto
     * @param correo correo de responsable de proyecto
     */

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Regresa el telefino de responsable del proyecto
     * @return telefono de responsable del proyecto
     */

    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Establece un telefono para el responsable del proyecto
     * @param telefono telefono de responsable de proyecto
     */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
