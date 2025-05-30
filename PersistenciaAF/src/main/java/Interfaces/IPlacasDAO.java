package Interfaces;

import DTOs.HistorialPlacasDTO;
import Entidades.Placas;
import Exception.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IPlacasDAO {
    
    public List<HistorialPlacasDTO> obtenerHistorialPlacas(String idVehiculo, LocalDate fechaTramite) throws PersistenciaException;
    public boolean registrarPlacas(Placas placas) throws PersistenciaException;
}
