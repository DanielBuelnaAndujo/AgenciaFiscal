package Control;

import Entidades.Tarjeta;
import java.time.LocalDate;
import java.time.Month;
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
            LocalDate.of(2026, Month.MARCH, 0), 
            123));

    @Override
    public boolean validarTarjeta(Tarjeta t) {
        return false;
    }
}
