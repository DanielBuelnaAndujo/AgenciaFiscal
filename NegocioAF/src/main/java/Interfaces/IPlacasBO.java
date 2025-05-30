package Interfaces;

import DTOs.HistorialPlacasDTO;
import DTOs.PlacasNuevasDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IPlacasBO {
    
    public List<HistorialPlacasDTO> obtenerHistorialPlacas() throws NegocioException;
    public boolean registrarPlacas(PlacasNuevasDTO placas) throws NegocioException;
    
}
