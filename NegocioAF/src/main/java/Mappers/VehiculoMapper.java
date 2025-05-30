package Mappers;

import DTOs.SeleccionarVehiculoDTO;
import DTOs.SeleccionarVehiculoSalidaDTO;
import DTOs.VehiculoNuevoDTO;
import DTOs.VehiculoViejoDTO;
import Entidades.Vehiculo;

/**
 *
 * @author daniel
 */
public class VehiculoMapper {
    
    public static VehiculoViejoDTO toViejoDTO(Vehiculo v) {
        if (v == null) {
            return null;
        }
        return new VehiculoViejoDTO(
                String.valueOf(v.getId()), 
                v.getNumSerie(), 
                v.getMarca(), 
                v.getLinea(), 
                v.getColor(), 
                v.getModelo(), 
                v.getTipo(), 
                String.valueOf(v.getIdPersona())
        );
    }
    
    public static Vehiculo toEntity(VehiculoNuevoDTO v) {
        if (v == null) {
            return null;
        }
        return new Vehiculo(
                v.getNumSerie(), 
                v.getMarca(), 
                v.getLinea(), 
                v.getColor(), 
                v.getModelo(), 
                v.getTipo(), 
                Integer.valueOf(v.getIdPersona())
        );
    }
    
    public static SeleccionarVehiculoDTO toDTO(SeleccionarVehiculoSalidaDTO v) {
        if (v == null) {
            return null;
        }
        return new SeleccionarVehiculoDTO(
                String.valueOf(v.getId()), 
                v.getNumPlacas(), 
                v.getNumSerie(), 
                v.getMarca(), 
                v.getLinea(), 
                v.getColor(), 
                v.getModelo(), 
                v.getTipo()
        );
    }
}
