package EJERCICIOS5_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio4 {

    public static void main(String[] args) {

        String nombreFichero = "productos.dat";

        // Creamos tres productos
        Producto producto1 = new Producto("Teclado", 25.99, 10);
        Producto producto2 = new Producto("Ratón", 15.50, 20);
        Producto producto3 = new Producto("Monitor", 149.99, 5);

        // Guardamos los tres productos
        try {
            ObjectOutputStream salida = new ObjectOutputStream(
                    new FileOutputStream(nombreFichero));

            salida.writeObject(producto1);
            salida.writeObject(producto2);
            salida.writeObject(producto3);

            salida.close();

            System.out.println("Los tres productos se han guardado.");

        } catch (IOException e) {
            System.out.println("Error al guardar los productos.");
        }

        // Leemos los tres productos
        try {
            ObjectInputStream entrada = new ObjectInputStream(
                    new FileInputStream(nombreFichero));

            Producto productoLeido1 = (Producto) entrada.readObject();
            Producto productoLeido2 = (Producto) entrada.readObject();
            Producto productoLeido3 = (Producto) entrada.readObject();

            entrada.close();

            System.out.println("\nProductos recuperados:");
            System.out.println(productoLeido1);
            System.out.println(productoLeido2);
            System.out.println(productoLeido3);

        } catch (IOException e) {
            System.out.println("Error al leer los productos.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase Producto.");
        }
    }
}

/*
EXPLICACIÓN:

Este ejercicio es una modificación del ejercicio 3.

En lugar de guardar un solo objeto Producto, guardamos tres
objetos en el mismo fichero binario utilizando writeObject().

Después los recuperamos en el mismo orden utilizando
readObject() tres veces.

Los tres productos utilizados son un teclado, un ratón y un
monitor, con diferentes precios y cantidades de stock.

La clase Producto sigue implementando Serializable porque
necesitamos poder guardar sus objetos directamente en el
fichero binario.

ObjectOutputStream sirve para escribir los objetos y
ObjectInputStream sirve para recuperarlos.
*/
