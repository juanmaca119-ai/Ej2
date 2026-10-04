package EJERCICIOS5_4;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio2 {

    public static void main(String[] args) {

        String nombreFichero = "alumnos.dat";

        // Datos de los cinco alumnos
        String[] nombres = {
                "Juan",
                "Laura",
                "Carlos",
                "Ana",
                "Miguel"
        };

        double[] notas = {
                7.5,
                8.2,
                6.7,
                9.1,
                7.8
        };

        // Escribir los alumnos en el fichero
        try {
            DataOutputStream salida = new DataOutputStream(
                    new FileOutputStream(nombreFichero));

            for (int i = 0; i < nombres.length; i++) {
                salida.writeUTF(nombres[i]);
                salida.writeDouble(notas[i]);
            }

            salida.close();

            System.out.println("Alumnos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }

        // Leer los alumnos
        try {
            DataInputStream entrada = new DataInputStream(
                    new FileInputStream(nombreFichero));

            System.out.println("\nDatos de los alumnos:");

            for (int i = 0; i < 5; i++) {

                String nombre = entrada.readUTF();
                double nota = entrada.readDouble();

                System.out.println("Nombre: " + nombre);
                System.out.println("Nota media: " + nota);
                System.out.println("--------------------");
            }

            entrada.close();

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }
}

/*
EXPLICACIÓN:

En este ejercicio guardamos cinco alumnos en un fichero binario.

Para cada alumno guardamos primero su nombre con writeUTF()
y después su nota media con writeDouble().

Al leer el fichero debemos hacerlo en el mismo orden:
primero leemos el nombre con readUTF() y después la nota
con readDouble().

Los alumnos se muestran en el mismo orden en el que fueron
guardados en el fichero.

He utilizado arrays porque permiten guardar fácilmente los
nombres y las notas de los cinco alumnos sin hacer el código
demasiado complicado.
*/