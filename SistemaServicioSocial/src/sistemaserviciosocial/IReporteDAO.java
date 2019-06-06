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
 * IReporteDAO es la clase que contiene la interfaz de Reporte.
 *
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/30
 */
public interface IReporteDAO {

    /**
     * Regresa un reporte de la base de datos
     *
     * @param id identificador del reporte
     * @return
     */
    public Reporte getReporte(int id);

    /**
     * Ingresa un nuevo reporte en la base de datos
     *
     * @param reporte reporte a guardar
     * @return
     */
    public boolean insertReporte(Reporte reporte);

    /**
     * Modifica un reporte de la base de datos.
     *
     * @param reporte reporte a modificar
     * @return
     */
    public boolean updateReporte(Reporte reporte);

}
