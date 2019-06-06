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
 * IServicioSocialDAO es la interfaz que maneja la información de los ServicioSocial
 * en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public interface IServicioSocialDAO {

    /**
     * Retorna un servicio social de la base de datos que coincida con el identificador
     * ingresado.
     * 
     * @param id identificador del servicio social
     * @return servicio social
     */
    public ServicioSocial getServicioSocial(int id);

    /**
     * Retorna el último servicio social registrado en la base de datos.
     * 
     * @return último servicio social registrado
     */
    public ServicioSocial getLatestServicioSocial();
}
