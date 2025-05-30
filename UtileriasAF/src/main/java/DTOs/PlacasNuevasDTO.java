package DTOs;

/**
 *
 * @author daniel
 */
public class PlacasNuevasDTO {
    
    private String idVehiculo;
    private String idPersona;

    public PlacasNuevasDTO() {
    }

    public PlacasNuevasDTO(String idVehiculo, String idPersona) {
        this.idVehiculo = idVehiculo;
        this.idPersona = idPersona;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "PlacasNuevasDTO{" + "idVehiculo=" + idVehiculo + ", idPersona=" + idPersona + '}';
    }
    
}
