package umg.progra2.DaseDatos.model;

public class Producto {
    private int idProducto;
    private String descripcion;
    private String origen;
    private int peso;
    private double precio;
    private int cantidad;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    // Constructor
    public Producto(int idProducto, String descripcion, String origen, double precio, int cantidad) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.origen = origen;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public Producto() {
    }

    // Getters y setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
