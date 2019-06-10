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
     * Crea una instancia con base en datos predefinidos.
     * 
     * @param id identificador del responsable
     * @param nombre nombre del responsable
     * @param paterno apellido paterno del responsable
     * @param materno apellido materno del responsable
     * @param correo correo del responsable
     * @param telefono telefono del responsable
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
     * Crea una instancia con base en su identificador de la base de datos.
     * 
     * @param id identificador del responsable
     */
    public ResponsableProyecto(int id) {
        this.id = id;
    }

    /**
     * Establece un identificador.
     * 
     * @param id identificador del responsable
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el identificador del responsable.
     * 
     * @return el identificador del responsable
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna el nombre del responsable.
     * 
     * @return el nombre del responsable
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nombre.
     * 
     * @param nombre nombre del responsable
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el apellido paterno del responsable.
     * 
     * @return el apellido paterno del responsable
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * Establece un apellido paterno.
     * 
     * @param paterno apellido paterno del responsable
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /**
     * Retorna el apellido materno del responsable.
     * 
     * @return el apellido materno del responsable
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * Establece un apellido materno.
     * 
     * @param materno apellido materno del responsable
     */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /**
     * Retorna el correo del responsable.
     * 
     * @return el correo del responsable
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece un correo.
     * 
     * @param correo correo del responsable
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Retorna el telefono del responsable.
     * 
     * @return el telefono del responsable
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece un telefono.
     * 
     * @param telefono telefono del responsable
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
