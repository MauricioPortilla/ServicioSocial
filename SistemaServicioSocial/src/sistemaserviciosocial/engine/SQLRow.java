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
package sistemaserviciosocial.engine;
import java.util.ArrayList;

/**
 * SQLRow es la clase que simula ser una fila de una
 * tabla de la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/02/22
 */
public class SQLRow {
    private final ArrayList<SQLColumn<String, Object>> columnsData;

    /**
     * Simula una fila de una tabla SQL.
     */
    public SQLRow() {
        columnsData = new ArrayList<>();
    }

    /**
     * Retorna los datos de cada columna en
     * una lista.
     * @return lista de columnas
     */
    public ArrayList<SQLColumn<String, Object>> getColumnsData() {
        return columnsData;
    }

    /**
     * Asigna el nombre y el valor de una columna.
     * @param name nombre de la columna
     * @param value valor de la columna
     */
    public void setColumnData(String name, Object value) {
        columnsData.add(new SQLColumn<>(name, value));
    }

    /**
     * Obtiene el valor de una columna.
     * @param column nombre de la columna
     * @return si existe, retorna el valor; si no, <code>null</code>
     */
    public Object getColumnData(String column) {
        for (int i = 0; i < columnsData.size(); i++) {
            if (columnsData.get(i).getName().equals(column)) {
                return columnsData.get(i).getValue();
            }
        }
        return null;
    }
}
