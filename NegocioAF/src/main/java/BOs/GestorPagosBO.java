package BOs;

import Control.IGestorPagos;
import DTOs.TarjetaDTO;
import Exception.NegocioException;
import Interfaces.IGestorPagosBO;

/**
 *
 * @author daniel
 */
public class GestorPagosBO implements IGestorPagosBO {
    
    private IGestorPagos gestorPagos;

    public GestorPagosBO(IGestorPagos gestorPagos) {
        this.gestorPagos = gestorPagos;
    }
    
    @Override
    public boolean validarTarjeta(TarjetaDTO t) throws NegocioException {
        if (t.getNombreTitular().isBlank()) {
            throw new NegocioException("El número no puede estar vacio.");
        }
        if (t.getNombreTitular().isBlank()) {
            throw new NegocioException("El Nombre no puede estar vacio.");
        }
        if (t.getFechaExpiracion() == null) {
            throw new NegocioException("La Fecha no puede estar vacia");
        }
        if (t.getCVV() == null) {
            throw new NegocioException("El CVV es invalido.");
        }
        
        boolean exito = gestorPagos.validarTarjeta(t);
        if (exito) {
            return true;
        } else {
            return false;
        }
    }
}
