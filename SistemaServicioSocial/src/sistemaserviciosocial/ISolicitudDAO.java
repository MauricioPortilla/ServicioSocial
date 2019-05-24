/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaserviciosocial;

import javafx.collections.ObservableList;

/**
 *
 * @author Mauricio CP
 */
public interface ISolicitudDAO {
    ObservableList<Solicitud> getSolicitudes();
    boolean insertSolicitud(Solicitud solicitud);
    boolean updateSolicitud(Solicitud solicitud);
    boolean deleteSolicitud(Solicitud solicitud);
}
