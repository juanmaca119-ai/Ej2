package EJERCICIOS5_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {

        String nombreFichero = "numeros.dat";

        // Escribir los números del 1 al 50
        try {
            DataOutputStream salida = new DataOutputStream(
                    new FileOutputStream(nombreFichero));

            for (int i = 1; i <= 50; i++) {
                salida.writeInt(i);
            }

            salida.close();

            System.out.println("Números escritos correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }

        // Leer los números del fichero
        try {
            DataInputStream entrada = new DataInputStream(
                    new FileInputStream(nombreFichero));

            System.out.println("Números guardados:");

            for (int i = 1; i <= 50; i++) {
                int numero = entrada.readInt();
                System.out.println(numero);
            }

            entrada.close();

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }
}

/*
EXPLICACIÓN:

DataOutputStream sirve para escribir datos de tipos básicos,
como int, directamente en un fichero binario.

En este ejercicio usamos writeInt() para guardar los números
del 1 al 50.

Después usamos DataInputStream para leer los datos del fichero.
Con readInt() recuperamos cada número y lo mostramos por pantalla.

El fichero se llama numeros.dat y se crea automáticamente
cuando ejecutamos el programa.
*/
