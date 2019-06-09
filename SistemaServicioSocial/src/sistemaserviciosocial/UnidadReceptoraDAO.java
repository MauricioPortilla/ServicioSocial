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
import sistemaserviciosocial.engine.SQLRow;

/**
 * UnidadReceptoraDAO es la clase que maneja la información de las unidades
 * receptoras registrados en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/06/08
 */
public class UnidadReceptoraDAO implements IUnidadReceptoraDAO {

    @Override
    public UnidadReceptora getUnidadReceptora(int idUnidadReceptora) {
        try {
            UnidadReceptora unidadReceptora = new UnidadReceptora();
            SQL.executeQuery(
                "SELECT * FROM unidadReceptora WHERE idunidadreceptora = ?", 
                new ArrayList<Object>() {
                    {
                        add(idUnidadReceptora);
                    }
                }, (result) -> {
                    SQLRow row  = result.get(0);
                    unidadReceptora.setNombre(row.getColumnData("nombre").toString());
                    unidadReceptora.setCorreo(row.getColumnData("correo").toString());
                    unidadReceptora.setTelefono(row.getColumnData("telefono").toString());
                    unidadReceptora.setCalle(row.getColumnData("calle").toString());
                    unidadReceptora.setNumExt(row.getColumnData("numExt").toString());
                    unidadReceptora.setColonia(row.getColumnData("colonia").toString());
                    unidadReceptora.setCodigoPostal(row.getColumnData("codigoPostal").toString());
                    return true;
                }, () -> {
                    return false;
                }
            );
            return unidadReceptora;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("getUnidadReceptora Exception -> " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
}
