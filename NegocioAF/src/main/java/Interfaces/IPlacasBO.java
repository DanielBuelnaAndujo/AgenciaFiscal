package Interfaces;

import DTOs.HistorialPlacasDTO;
import DTOs.PlacasNuevasDTO;
import DTOs.TarjetaDTO;
import Exception.NegocioException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IPlacasBO {
    
    public List<HistorialPlacasDTO> obtenerHistorialPlacas(String idVehiculo, LocalDate fechaTramite) throws NegocioException;
    public boolean registrarPlacas(PlacasNuevasDTO placas) throws NegocioException;
    
}
