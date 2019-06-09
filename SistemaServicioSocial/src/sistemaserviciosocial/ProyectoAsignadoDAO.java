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

import sistemaserviciosocial.engine.SQL;

/**
 * ProyectoAsignadoDAO es la clase que maneja la información de los
 * Proyectos asignados en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/09
 */
public class ProyectoAsignadoDAO implements IProyectoAsignadoDAO {

    @Override
    public boolean insertProyectoAsignado(HistorialAlumnoSS historial, Proyecto proyecto) {
        if (SQL.executeUpdate("INSERT INTO proyectoAsignado VALUES (?, ?)", 
            new ArrayList<Object>() {
                {
                    add(historial.getId());
                    add(proyecto.getId());
                }
            }
        ) == 1) { // 1 fila afectada
            return true;
        }
        return false;
    }
    
}
