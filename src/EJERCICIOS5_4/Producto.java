package EJERCICIOS5_4;


import java.io.Serializable;

public class Producto implements Serializable {

    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre
                + " | Precio: " + precio + " €"
                + " | Stock: " + stock;
    }
}