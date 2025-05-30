package Entidades;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class Placas extends Tramite {
    
    private String numero;
    private String estado;
    private LocalDate fechaRecepcion;
    private Integer idVehiculo;

    public Placas() {
    }

    public Placas(String numero, String estado, LocalDate fechaRecepcion, Integer idVehiculo, Integer id, LocalDate fecha, Double costo, Integer idPersona) {
        super(id, fecha, costo, idPersona);
        this.numero = numero;
        this.estado = estado;
        this.fechaRecepcion = fechaRecepcion;
        this.idVehiculo = idVehiculo;
    }

    public Placas(String numero, String estado, LocalDate fechaRecepcion, Integer idVehiculo, LocalDate fecha, Double costo, Integer idPersona) {
        super(fecha, costo, idPersona);
        this.numero = numero;
        this.estado = estado;
        this.fechaRecepcion = fechaRecepcion;
        this.idVehiculo = idVehiculo;
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

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public String toString() {
        return "Placas{" + "numero=" + numero + ", estado=" + estado + ", fechaRecepcion=" + fechaRecepcion + ", idVehiculo=" + idVehiculo + '}';
    }

}
