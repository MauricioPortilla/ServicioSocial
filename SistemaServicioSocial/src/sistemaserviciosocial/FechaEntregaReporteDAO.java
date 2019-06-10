
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

import java.sql.Date;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

/**
 * FechaEntregaReporteDAO es la clase que maneja la información de los FechaEntregaReporte en la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public class FechaEntregaReporteDAO implements IFechaEntregaReporteDAO {

 
    @Override
    public ObservableList<FechaEntregaReporte> getFechaEntregas() {
        try {
            ObservableList<FechaEntregaReporte> fechasEntrega = FXCollections.observableArrayList();
            SQL.executeQuery("SELECT * FROM fechaEntregaReporte;", null, (result) -> {
                for (SQLRow row : result) {
                    fechasEntrega.add(new FechaEntregaReporte(
                        (int) row.getColumnData("identrega"), 
                        ((Date) row.getColumnData("fechaMinima")).toLocalDate(), 
                        ((Date) row.getColumnData("fechaLimite")).toLocalDate(),
                        row.getColumnData("mes").toString()
                    ));
                }
                return true;
            }, () -> {
                return false;
            });
            return fechasEntrega;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getFechaEntregas Exception -> " + e.getMessage());
            return null;
        }
    }

    @Override
    public FechaEntregaReporte getFechaEntrega(int id) {
        try {
            FechaEntregaReporte fechaEntregaReporte = new FechaEntregaReporte();
            SQL.executeQuery("SELECT * FROM fechaEntregaReporte WHERE identrega = ?", 
                new ArrayList<Object>() {
                {
                    add(id);
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                fechaEntregaReporte.setId((int) row.getColumnData("identrega"));
                fechaEntregaReporte.setFechaMinima(
                    ((Date) row.getColumnData("fechaMinima")).toLocalDate()
                );
                fechaEntregaReporte.setFechaLimite(
                    ((Date) row.getColumnData("fechaLimite")).toLocalDate()
                );
                fechaEntregaReporte.setMes(row.getColumnData("mes").toString());
                return true;
            }, () -> {
                return false;
            });
            return fechaEntregaReporte;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getFechaEntrega Exception -> " + e.getMessage());
            return null;
        }
    }
    
}
