package Entidades;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class Licencia extends Tramite {
    
    private String numero;
    private LocalDate fechaVigencia;

    public Licencia() {
    }

    public Licencia(String numero, LocalDate fechaVigencia, Integer id, LocalDate fecha, Double costo, Integer idPersona) {
        super(id, fecha, costo, idPersona);
        this.numero = numero;
        this.fechaVigencia = fechaVigencia;
    }

    public Licencia(String numero, LocalDate fechaVigencia, LocalDate fecha, Double costo, Integer idPersona) {
        super(fecha, costo, idPersona);
        this.numero = numero;
        this.fechaVigencia = fechaVigencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    @Override
    public String toString() {
        return "Licencia{" + "numero=" + numero + ", fechaVigencia=" + fechaVigencia + '}';
    }
    
}
