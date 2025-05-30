package BOs;

import DTOs.VehiculoNuevoDTO;
import DTOs.VehiculoViejoDTO;
import Entidades.Vehiculo;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IVehiculoBO;
import Interfaces.IVehiculoDAO;
import Mappers.VehiculoMapper;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author daniel
 */
public class VehiculoBO implements IVehiculoBO {

    private IVehiculoDAO vehiculoDAO;

    public VehiculoBO(IVehiculoDAO vehiculoDAO) {
        this.vehiculoDAO = vehiculoDAO;
    }
    
    @Override
    public List<VehiculoViejoDTO> obtenerVehiculos() throws NegocioException {
        try {
            List<Vehiculo> vehiculos = vehiculoDAO.obtenerVehiculos();
            
            return vehiculos.stream()
                            .map(VehiculoMapper::toViejoDTO)
                            .collect(Collectors.toList());
        } catch(PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public boolean registrarVehiculo(VehiculoNuevoDTO vehiculo) throws NegocioException {
        if (vehiculo.getNumSerie().isBlank() || vehiculo.getNumSerie() == null) {
            throw new NegocioException("El Número de Serie no puede estar vacio.");
        }
        if (vehiculo.getMarca().isBlank() || vehiculo.getMarca() == null) {
            throw new NegocioException("La Marca no puede estar vacia.");
        }
        if (vehiculo.getLinea().isBlank() || vehiculo.getLinea() == null) {
            throw new NegocioException("La Linea no puede estar vacia.");
        }
        if (vehiculo.getColor().isBlank() || vehiculo.getColor() == null) {
            throw new NegocioException("El Color no puede estar vacio.");
        }
        if (vehiculo.getModelo().isBlank() || vehiculo.getModelo() == null) {
            throw new NegocioException("El Modelo no puede estar vacio.");
        }
        if (vehiculo.getTipo().isBlank() || vehiculo.getTipo() == null) {
            throw new NegocioException("El Tipo no puede estar vacio.");
        }
        
        Vehiculo v = VehiculoMapper.toEntity(vehiculo);
        
        try {
            boolean exito = vehiculoDAO.registrarVehiculo(v);
            if (exito) {
                return true;
            }
            
            return false;
        } catch(PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
