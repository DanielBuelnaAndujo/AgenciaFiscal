package Control;

import DTOs.TarjetaDTO;

/**
 *
 * @author daniel
 */
public interface IGestorPagos {
    
    public boolean validarTarjeta(TarjetaDTO t);
    
}
