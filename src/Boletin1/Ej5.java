package Boletin1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ej5 {
    public static void main(String[] args) throws IOException {
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEnteroDeRango("Elije una opcion", 1, 5);
            switch (opcion) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:
            }
        } while (opcion != 5);
    }

    public static void menu() {

        System.out.println("1. Crear un directorio");
        System.out.println("2. Crear un fichero de texto");
        System.out.println("3. Borrar fichero");
        System.out.println("4. Mostrar ficheros de una carpeta");
        System.out.println("5. Salir");

    }

    public static void crearDirectorio() throws IOException {
        String nombre = MiEntradaSalida.solicitarCadenaMinus("Elija el nombre del directorio");
        File directorio = new File("/src/Boletin1/" + nombre);

        if (directorio.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            if (directorio.mkdir()) {
                System.out.println("El directorio se ha creado correctamente");
            }else {
                System.out.println("El directorio no ha podido ser creado");
            }
        }
    }
}
