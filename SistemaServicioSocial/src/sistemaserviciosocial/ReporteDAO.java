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
 * Clase DAO de Reporte
 *
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/30
 */
import java.util.ArrayList;
import sistemaserviciosocial.engine.SQL;

public class ReporteDAO implements IReporteDAO {

    public ReporteDAO() {
    }

    @Override
    public Reporte getReporte(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean insertReporte(Reporte reporte) {
        if (SQL.executeUpdate(
            "INSERT INTO reporte VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)",
            new ArrayList<Object>() {
            {
                add(reporte.getNumero());
                add(reporte.getHorasReportadas());
                add(reporte.getMes());
                add(reporte.getFechaEntrega());
                add(reporte.getEstado());
                add(reporte.getMotivoInvalidez());
                add(reporte.getIdHistorial());
                add(reporte.getIdEntrega());
            }
        }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReporte(Reporte reporte) {
        if (SQL.executeUpdate(
            "UPDATE reporte SET numero = ?, horasReportadas = ?, mes = ?, fechaEntrega = ?, "
            + "estado = ?, motivoInvalidez = ? WHERE idReporte = ?",
            new ArrayList<Object>() {
            {
                add(reporte.getNumero());
                add(reporte.getHorasReportadas());
                add(reporte.getMes());
                add(reporte.getFechaEntrega());
                add(reporte.getEstado());
                add(reporte.getMotivoInvalidez());
                add(reporte.getIdHistorial());
                add(reporte.getIdEntrega());

            }
        }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

}
