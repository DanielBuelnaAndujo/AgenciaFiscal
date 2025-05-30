package Interfaces;

import DTOs.SeleccionarVehiculoDTO;
import DTOs.VehiculoNuevoDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IVehiculoBO {
    
    public List<SeleccionarVehiculoDTO> obtenerVehiculos(String idPersona, String numPlacas) throws NegocioException;
    public boolean registrarVehiculo(VehiculoNuevoDTO vehiculo) throws NegocioException;
    
}
