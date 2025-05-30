package Entidades;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class Tarjeta {
    
    private String id;
    private String numero;
    private String nombreTitular;
    private LocalDate fechaExpiracion;
    private Integer CVV;

    public Tarjeta() {
    }

    public Tarjeta(String id, String numero, String nombreTitular, LocalDate fechaExpiracion, Integer CVV) {
        this.id = id;
        this.numero = numero;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
        this.CVV = CVV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Tarjeta{" + "id=" + id + ", numero=" + numero + ", nombreTitular=" + nombreTitular + ", fechaExpiracion=" + fechaExpiracion + ", CVV=" + CVV + '}';
    }
    
}
