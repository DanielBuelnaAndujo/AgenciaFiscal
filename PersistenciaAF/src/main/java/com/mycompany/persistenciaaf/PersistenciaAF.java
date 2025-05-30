package com.mycompany.persistenciaaf;

import DAOs.VehiculoDAO;
import DTOs.SeleccionarVehiculoSalidaDTO;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public class PersistenciaAF {

    public static void main(String[] args) throws PersistenciaException {
        VehiculoDAO vDAO = new VehiculoDAO();
        List<SeleccionarVehiculoSalidaDTO> vehiculos = vDAO.obtenerVehiculos("1", "");
        System.out.println(vehiculos);
    }
}
