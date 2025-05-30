package DTOs;

/**
 *
 * @author daniel
 */
public class PlacasNuevasDTO {
    
    private String idVehiculo;

    public PlacasNuevasDTO() {
    }

    public PlacasNuevasDTO(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public String toString() {
        return "PlacasNuevasDTO{" + "idVehiculo=" + idVehiculo + '}';
    }
    
}
