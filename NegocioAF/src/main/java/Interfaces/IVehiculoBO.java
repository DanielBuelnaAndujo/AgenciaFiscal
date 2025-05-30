package Interfaces;

import DTOs.VehiculoNuevoDTO;
import DTOs.VehiculoViejoDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IVehiculoBO {
    
    public List<VehiculoViejoDTO> obtenerVehiculos(String idPersona, String numPlacas) throws NegocioException;
    public boolean registrarVehiculo(VehiculoNuevoDTO vehiculo) throws NegocioException;
    
}
