package DTOs;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class HistorialPlacasDTO {
    
    private String numero;
    private String estado;
    private LocalDate fechaTramite;
    private Double costo;
    private LocalDate fechaRecepcion;

    public HistorialPlacasDTO() {
    }

    public HistorialPlacasDTO(String numero, String estado, LocalDate fechaTramite, Double costo, LocalDate fechaRecepcion) {
        this.numero = numero;
        this.estado = estado;
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(LocalDate fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Override
    public String toString() {
        return "HistorialPlacasDTO{" + "numero=" + numero + ", estado=" + estado + ", fechaTramite=" + fechaTramite + ", costo=" + costo + ", fechaRecepcion=" + fechaRecepcion + '}';
    }
    
}
