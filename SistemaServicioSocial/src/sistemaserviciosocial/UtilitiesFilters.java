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
 * UtilitiesFilters es el enumerador de la clase Utilities para los filtros
 * en las listas.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public enum UtilitiesFilters {
    
    /**
     * Filtra alumnos que no posean una solicitud asignada en su historial.
     */
    FILTER_ALUMNOS_BY_NO_SOLICITUD_ASIGNADA,

    /**
     * Filtra alumnos que no posean un proyecto asignado.
     */
    FILTER_ALUMNOS_BY_NO_PROYECTO_ASIGNADO
}
