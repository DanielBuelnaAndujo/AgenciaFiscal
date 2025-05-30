package Interfaces;

import DTOs.HistorialPlacasDTO;
import Entidades.Placas;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IPlacasDAO {
    
    public List<HistorialPlacasDTO> obtenerHistorialPlacas() throws PersistenciaException;
    public boolean registrarPlacas(Placas placas) throws PersistenciaException;
}
