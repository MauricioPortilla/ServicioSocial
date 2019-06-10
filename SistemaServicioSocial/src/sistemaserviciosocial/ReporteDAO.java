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

import java.sql.Date;

import java.util.ArrayList;
import sistemaserviciosocial.engine.SQL;
import sistemaserviciosocial.engine.SQLRow;

/**
 * ReporteDAO es la clase que maneja los Reportes registrados en la base de datos.
 *
 * @author Maria Jose Hernandez Molinos
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/30
 */
public class ReporteDAO implements IReporteDAO {

    /**
     * Crea una instancia vacía.
     */
    public ReporteDAO() {
    }

    @Override
    public Reporte getReporte(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reporte getReporte(FechaEntregaReporte fechaEntregaReporte) {
        try {
            Reporte reporte = new Reporte();
            SQL.executeQuery("SELECT * FROM reporte WHERE identrega = ?", new ArrayList<Object>() {
                {
                    add(fechaEntregaReporte.getId());
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                reporte.setId((int) row.getColumnData("idreporte"));
                reporte.setHistorialAlumno(
                    new HistorialAlumnoSS((int) row.getColumnData("idhistorial"))
                );
                reporte.setFechaEntregaReporte(fechaEntregaReporte);
                reporte.setNumero((int) row.getColumnData("numero"));
                reporte.setHorasReportadas((int) row.getColumnData("horasReportadas"));
                reporte.setMes(row.getColumnData("mes").toString());
                reporte.setFechaEntrega(((Date) row.getColumnData("fechaEntrega")).toLocalDate());
                reporte.setEstado(row.getColumnData("estado").toString());
                reporte.setMotivoInvalidez((row.getColumnData("motivoInvalidez") == null) ? null : 
                    row.getColumnData("motivoInvalidez").toString()
                );
                reporte.setArchivoReporte(new Archivo((int) row.getColumnData("idarchivo")));
                return true;
            }, () -> {
                return false;
            });
            return reporte;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getReporte Exception -> " + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Reporte> getReportes(HistorialAlumnoSS historial) {
        try {
            ArrayList<Reporte> reportes = new ArrayList<>();
            SQL.executeQuery("SELECT * FROM reporte WHERE idhistorial = ?", 
                new ArrayList<Object>() {
                {
                    add(historial.getId());
                }
            }, (result) -> {
                for (SQLRow row : result) {
                    reportes.add(new Reporte(
                        (int) row.getColumnData("idreporte"),
                        (int) row.getColumnData("numero"),
                        (int) row.getColumnData("horasReportadas"),
                        row.getColumnData("mes").toString(),
                        ((Date) row.getColumnData("fechaEntrega")).toLocalDate(),
                        row.getColumnData("estado").toString(),
                        row.getColumnData("motivoInvalidez").toString(),
                        historial,
                        new FechaEntregaReporte((int) row.getColumnData("identrega")),
                        new Archivo((int) row.getColumnData("idarchivo"))
                    ));
                }
                return true;
            }, () -> {
                return false;
            });
            return reportes;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getReporte Exception -> " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertReporte(Reporte reporte) {
        if (SQL.executeUpdate(
            "INSERT INTO reporte VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            new ArrayList<Object>() {
            {
                add(reporte.getHistorialAlumno().getId());
                add(reporte.getFechaEntregaReporte().getId());
                add(reporte.getNumero());
                add(reporte.getHorasReportadas());
                add(reporte.getMes());
                add(reporte.getFechaEntrega());
                add(reporte.getEstado());
                add(reporte.getMotivoInvalidez());
                add(reporte.getArchivoReporte().getId());
            }
        }) == 1) { // 1 indica que hay 1 fila afectada
            reporte.getHistorialAlumno().setNumReportesEntregados(
                reporte.getHistorialAlumno().getNumReportesEntregados() + 1
            );
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReporte(Reporte reporte) {
        if (SQL.executeUpdate(
            "UPDATE reporte SET horasReportadas = ?, estado = ?, motivoInvalidez = ? "
            + "WHERE idReporte = ?",
            new ArrayList<Object>() {
            {
                add(reporte.getHorasReportadas());
                add(reporte.getEstado());
                add(reporte.getMotivoInvalidez());
                add(reporte.getId());
            }
        }) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

}
