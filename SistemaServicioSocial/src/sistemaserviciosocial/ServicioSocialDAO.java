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

import java.util.ArrayList;

import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

/**
 * ServicioSocialDAO es la clase que maneja la información de los ServicioSocial
 * registrados en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/06
 */
public class ServicioSocialDAO implements IServicioSocialDAO {

    @Override
    public ServicioSocial getServicioSocial(int id) {
        try {
            ServicioSocial servicioSocial = new ServicioSocial();
            SQL.executeQuery(
                "SELECT * FROM servicioSocial WHERE idserviciosocial = ?", new ArrayList<Object>() {
                    {
                        add(id);
                    }
                }, (result) -> {
                    SQLRow row = result.get(0);
                    servicioSocial.setId((int) row.getColumnData("idserviciosocial"));
                    servicioSocial.setBloque((int) row.getColumnData("bloque"));
                    servicioSocial.setSeccion((int) row.getColumnData("seccion"));
                    servicioSocial.setNrc((int) row.getColumnData("nrc"));
                    servicioSocial.setPeriodo(row.getColumnData("periodo").toString());
                    return true;
                }, () -> {
                    return false;
                }
            );
            return servicioSocial;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ServicioSocial getLatestServicioSocial() {
        try {
            ServicioSocial servicioSocial = new ServicioSocial();
            SQL.executeQuery(
                "SELECT * FROM servicioSocial ORDER BY idserviciosocial DESC LIMIT 1", null, 
                (result) -> {
                    SQLRow row = result.get(0);
                    servicioSocial.setId((int) row.getColumnData("idserviciosocial"));
                    servicioSocial.setBloque((int) row.getColumnData("bloque"));
                    servicioSocial.setSeccion((int) row.getColumnData("seccion"));
                    servicioSocial.setNrc((int) row.getColumnData("nrc"));
                    servicioSocial.setPeriodo(row.getColumnData("periodo").toString());
                    return true;
                }, () -> {
                    return false;
                }
            );
            return servicioSocial;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
