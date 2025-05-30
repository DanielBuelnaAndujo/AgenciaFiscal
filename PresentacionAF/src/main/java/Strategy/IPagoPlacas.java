package Strategy;

import Exception.NegocioException;

/**
 *
 * @author daniel
 */
public interface IPagoPlacas {
    
    public boolean pagoEfectivo() throws NegocioException;
    public Double getCostoPlacas();
}
