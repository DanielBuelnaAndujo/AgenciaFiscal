package Entidades;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public abstract class Tramite {
    
    private Integer id;
    private LocalDate fecha;
    private Double costo;
    private Integer idPersona;

    public Tramite() {
    }

    public Tramite(Integer id, LocalDate fecha, Double costo, Integer idPersona) {
        this.id = id;
        this.fecha = fecha;
        this.costo = costo;
        this.idPersona = idPersona;
    }

    public Tramite(LocalDate fecha, Double costo, Integer idPersona) {
        this.fecha = fecha;
        this.costo = costo;
        this.idPersona = idPersona;
    }

    public Tramite(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Tramites{" + "id=" + id + ", fecha=" + fecha + ", costo=" + costo + ", idPersona=" + idPersona + '}';
    }
    
}
