package Strategy;

import Control.ControlNavegacion;
import DTOs.PlacasNuevasDTO;
import Exception.NegocioException;
import Factory.FabricaObjetosBO;
import Interfaces.IPlacasBO;

/**
 *
 * @author daniel
 */
public class PlacasVehiculoVeijo implements IPagoPlacas {

    private PlacasNuevasDTO placasNuevas = ControlNavegacion.getInstancia().getPlacasNuevas();
    private final Double costo = 1000.0;
    private IPlacasBO placasBO = FabricaObjetosBO.obtenerPlacasBO();
    
    @Override
    public boolean pagoEfectivo() throws NegocioException {
        return true;
    }

    @Override
    public Double getCostoPlacas() {
        return costo;
    }
    
}
