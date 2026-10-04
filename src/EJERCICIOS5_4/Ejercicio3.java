package EJERCICIOS5_4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio3 {

    public static void main(String[] args) {

        String nombreFichero = "producto.dat";

        // Creamos un producto
        Producto producto = new Producto("Teclado", 25.99, 10);

        // Guardamos el producto
        try {
            ObjectOutputStream salida = new ObjectOutputStream(
                    new FileOutputStream(nombreFichero));

            salida.writeObject(producto);

            salida.close();

            System.out.println("Producto guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el producto.");
        }

        // Recuperamos el producto
        try {
            ObjectInputStream entrada = new ObjectInputStream(
                    new FileInputStream(nombreFichero));

            Producto productoLeido = (Producto) entrada.readObject();

            entrada.close();

            System.out.println("\nProducto recuperado:");
            System.out.println(productoLeido);

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase Producto.");
        }
    }
}

/*
EXPLICACIÓN:

La clase Producto implementa Serializable. Esto permite que
un objeto Producto pueda guardarse directamente en un fichero
binario.

ObjectOutputStream se utiliza para guardar el objeto completo
con writeObject().

Después ObjectInputStream permite recuperar el objeto utilizando
readObject().

Al recuperar el objeto hacemos un casting a Producto porque
readObject() devuelve un Object.

También hemos utilizado toString() para poder mostrar fácilmente
la información del producto por pantalla.

El producto utilizado como ejemplo es un teclado, con un precio
de 25.99 euros y un stock de 10 unidades.
*/
