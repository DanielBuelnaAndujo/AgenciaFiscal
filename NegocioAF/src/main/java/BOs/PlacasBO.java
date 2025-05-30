package BOs;

import DTOs.HistorialPlacasDTO;
import DTOs.PlacasNuevasDTO;
import Entidades.Placas;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IPlacasBO;
import Interfaces.IPlacasDAO;
import Mappers.PlacasMapper;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author daniel
 */
public class PlacasBO implements IPlacasBO {

    private IPlacasDAO placasDAO;

    public PlacasBO(IPlacasDAO placasDAO) {
        this.placasDAO = placasDAO;
    }
    
    @Override
    public List<HistorialPlacasDTO> obtenerHistorialPlacas(String idVehiculo, LocalDate fechaTramite) throws NegocioException {
        try {
            List<HistorialPlacasDTO> placasDTO = placasDAO.obtenerHistorialPlacas(idVehiculo, fechaTramite);
            
            return placasDTO;
        } catch(PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public boolean registrarPlacas(PlacasNuevasDTO placas) throws NegocioException {
        if (placas.getIdVehiculo() == null || placas.getIdVehiculo().isBlank()) {
            throw new NegocioException("El id del Vehiculo no puede estar vacio.");
        }
        
        Placas p = PlacasMapper.toEntity(placas);
        
        try {
            boolean exito = placasDAO.registrarPlacas(p);
            if (exito) {
                return true;
            }
            
            return false;
        } catch(PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
