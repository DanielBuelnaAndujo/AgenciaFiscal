package DTOs;

/**
 *
 * @author daniel
 */
public class SeleccionarVehiculoDTO {
    
    private String id;
    private String numPlacas;
    private String numSerie;
    private String marca;
    private String linea;
    private String color;
    private String modelo;
    private String tipo;

    public SeleccionarVehiculoDTO() {
    }

    public SeleccionarVehiculoDTO(String id, String numPlacas, String numSerie, String marca, String linea, String color, String modelo, String tipo) {
        this.id = id;
        this.numPlacas = numPlacas;
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumPlacas() {
        return numPlacas;
    }

    public void setNumPlacas(String numPlacas) {
        this.numPlacas = numPlacas;
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

    @Override
    public String toString() {
        return "SeleccionarVehiculoDTO{" + "id=" + id + ", numPlacas=" + numPlacas + ", numSerie=" + numSerie + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", tipo=" + tipo + '}';
    }

}
