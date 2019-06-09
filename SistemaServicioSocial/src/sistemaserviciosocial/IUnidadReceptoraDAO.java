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
 *
 * @author Mauricio
 */
public interface IUnidadReceptoraDAO {
    
    /**
     * Retorna una unidad receptora con base en su identificador.
     * 
     * @param idUnidadReceptora identificador de la unidad receptora
     * @return la unidad receptora
     */
    public UnidadReceptora getUnidadReceptora(int idUnidadReceptora);
}
