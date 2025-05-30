package DTOs;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class TarjetaDTO {
    
    private String numero;
    private String nombreTitular;
    private LocalDate fechaExpiracion;
    private Integer CVV;

    public TarjetaDTO() {
    }

    public TarjetaDTO(String numero, String nombreTitular, LocalDate fechaExpiracion, Integer CVV) {
        this.numero = numero;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
        this.CVV = CVV;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Integer getCVV() {
        return CVV;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }

    @Override
    public String toString() {
        return "TarjetaDTO{" + "numero=" + numero + ", nombreTitular=" + nombreTitular + ", fechaExpiracion=" + fechaExpiracion + ", CVV=" + CVV + '}';
    }
    
}
