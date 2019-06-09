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
 * Clase DAO de archivo
 *
 * @author María Saarayim González Hernández
 * @version 1.0
 * @since 2019/05/30
 */
public class ArchivoDAO implements IArchivoDAO {

    public ArchivoDAO() {
    }

    @Override
    public Archivo getArchivo(int id) {
        try {
            Archivo archivo = new Archivo();
            SQL.executeQuery("SELECT * FROM archivo WHERE idarchivo = ?", new ArrayList<Object>() {
                {
                    add(id);
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                archivo.setId(id);
                archivo.setTitulo(row.getColumnData("titulo").toString());
                archivo.setRutaUbicacion(row.getColumnData("rutaUbicacion").toString());
                archivo.setEstado(row.getColumnData("estado").toString());
                archivo.setHistorial(new HistorialAlumnoSS((int) row.getColumnData("idhistorial")));
                archivo.setMotivoInvalidez((row.getColumnData("motivoInvalidez") == null) ? null :
                    row.getColumnData("motivoInvalidez").toString()
                );
                return true;
            }, () -> {
                return false;
            });
            return archivo;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getArchivo Exception -> " + e.getMessage());
            return null;
        }
    }

    @Override
    public Archivo getArchivo(String titulo, HistorialAlumnoSS historial) {
        try {
            Archivo archivo = new Archivo();
            SQL.executeQuery("SELECT * FROM archivo WHERE titulo = ? AND idhistorial = ?", 
                new ArrayList<Object>() {
                {
                    add(titulo);
                    add(historial.getId());
                }
            }, (result) -> {
                SQLRow row = result.get(0);
                archivo.setId((int) row.getColumnData("idarchivo"));
                archivo.setTitulo(titulo);
                archivo.setRutaUbicacion(row.getColumnData("rutaUbicacion").toString());
                archivo.setEstado(row.getColumnData("estado").toString());
                archivo.setHistorial(historial);
                archivo.setMotivoInvalidez(row.getColumnData("motivoInvalidez").toString());
                return true;
            }, () -> {
                return false;
            });
            return archivo;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getArchivo Exception -> " + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Archivo> getArchivos(HistorialAlumnoSS historial) {
        try {
            ArrayList<Archivo> archivos = new ArrayList<>();
            SQL.executeQuery("SELECT * FROM archivo WHERE idhistorial = ?", 
                new ArrayList<Object>() {
                {
                    add(historial.getId());
                }
            }, (result) -> {
                for (SQLRow row : result) {
                    archivos.add(new Archivo(
                        (int) row.getColumnData("idarchivo"), 
                        historial, row.getColumnData("titulo").toString(), 
                        row.getColumnData("rutaUbicacion").toString(), 
                        row.getColumnData("estado").toString(), 
                        (row.getColumnData("motivoInvalidez") == null) ? null : 
                            row.getColumnData("motivoInvalidez").toString()
                    ));
                }
                return true;
            }, () -> {
                return false;
            });
            return archivos;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("getArchivos Exception -> " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertArchivo(Archivo archivo) {
        if (SQL.executeUpdate(
            "INSERT INTO archivo VALUES (NULL, ?, ?, ?, ?, ?)",
            new ArrayList<Object>() {
            {
                add(archivo.getHistorial().getId());
                add(archivo.getTitulo());
                add(archivo.getRutaUbicacion());
                add(archivo.getEstado());
                add(archivo.getMotivoInvalidez());
            }
        }) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

    @Override
    public boolean updateArchivo(Archivo archivo) {
        if (SQL.executeUpdate(
            "UPDATE archivo SET titulo = ?, rutaUbicacion = ?, estado= ?, motivoInvalidez = ? " +
            "WHERE idarchivo = ?",
            new ArrayList<Object>() {
            {
                add(archivo.getHistorial().getId());
                add(archivo.getTitulo());
                add(archivo.getRutaUbicacion());
                add(archivo.getEstado());
                add(archivo.getMotivoInvalidez());

            }
        }) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteArchivo(Archivo archivo) {
        if (SQL.executeUpdate(
            "DELETE FROM archivo WHERE idarchivo = ?",
            new ArrayList<Object>() {
            {
                add(archivo.getId());
            }
        }) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

}
