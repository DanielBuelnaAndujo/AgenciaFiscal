package Control;

import DTOs.TarjetaDTO;
import Entidades.Tarjeta;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author daniel
 */
public class GestorPagos implements IGestorPagos {
    
    private List<Tarjeta> tarjetas = Arrays.asList(new Tarjeta(
            "1", 
            "1111222233334444", 
            "DANIEL BUELNA ANDUJO", 
            LocalDate.of(2025, 1, 1), 
            123));

    @Override
    public boolean validarTarjeta(TarjetaDTO t) {
        for (Tarjeta tarjeta : tarjetas) {
            if (tarjeta.getNombreTitular().equals(t.getNombreTitular()) &&
                    tarjeta.getNumero().equals(t.getNumero()) &&
                    tarjeta.getFechaExpiracion().equals(t.getFechaExpiracion()) &&
                    tarjeta.getCVV().equals(t.getCVV())) {
                
                return true;
            }
        }
        return false;
    }
}
