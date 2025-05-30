package Interfaces;

import DTOs.TarjetaDTO;
import Exception.NegocioException;

/**
 *
 * @author daniel
 */
public interface IGestorPagosBO {
    
    public boolean validarTarjeta(TarjetaDTO t) throws NegocioException;
    
}
