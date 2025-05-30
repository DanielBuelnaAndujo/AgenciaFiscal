package Entidades;

/**
 *
 * @author daniel
 */
public class Vehiculo {
    
    private Integer id;
    private String numSerie;
    private String marca;
    private String linea;
    private String color;
    private String modelo;
    private String tipo;
    private Integer idPersona;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String numSerie, String marca, String linea, String color, String modelo, String tipo, Integer idPersona) {
        this.id = id;
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
        this.idPersona = idPersona;
    }

    public Vehiculo(String numSerie, String marca, String linea, String color, String modelo, String tipo, Integer idPersona) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
        this.idPersona = idPersona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", numSerie=" + numSerie + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", tipo=" + tipo + ", idPersona=" + idPersona + '}';
    }
    
}
