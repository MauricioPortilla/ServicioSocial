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

import javafx.collections.ObservableList;

/**
 * IFechaEntregaReporteDAO es la interfaz que maneja la información de las FechaEntregaReporte
 * en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public interface IFechaEntregaReporteDAO {
    
    /**
     * Retorna una lista de fecha de entrega de reportes de la base de datos.
     * 
     * @return lista de fecha de entrega
     */
    public ObservableList<FechaEntregaReporte> getFechaEntregas();

    /**
     * Retorna una fecha de entrega con base en un identificador de la base de datos.
     * 
     * @param id identificador de la fecha de entrega
     * @return fecha de entrega
     */
    public FechaEntregaReporte getFechaEntrega(int id);
}
