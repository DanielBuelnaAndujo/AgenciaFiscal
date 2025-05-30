package Mappers;

import DTOs.PlacasNuevasDTO;
import Entidades.Placas;

/**
 *
 * @author daniel
 */
public class PlacasMapper {
    
    public static Placas toEntity(PlacasNuevasDTO p) {
        if (p == null) {
            return null;
        }
        return new Placas(
                Integer.valueOf(p.getIdVehiculo())
        );
    }
}
