package Interfaces;

import DTOs.SeleccionarVehiculoSalidaDTO;
import Entidades.Vehiculo;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IVehiculoDAO {
    
    public List<SeleccionarVehiculoSalidaDTO> obtenerVehiculos(String idPersona, String numPlacas) throws PersistenciaException;
    public boolean registrarVehiculo(Vehiculo vehiculo) throws PersistenciaException;
    
}
