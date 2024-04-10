package Boletin1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ej5 {
    public static void main(String[] args) throws IOException {
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEnteroDeRango("Elije una opcion", 5, 1);
            switch (opcion) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:
                    crearFichero();
                    break;
                case 3:
                    borrarFichero();
                    break;
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

    public static void crearDirectorio() {
        String nombre = MiEntradaSalida.solicitarCadenaMinus("Elija el nombre del directorio");
        File directorio = new File("/src/Boletin1/" + nombre);

        if (directorio.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            if (directorio.mkdir()) {
                System.out.println("El directorio se ha creado correctamente");
            } else {
                System.out.println("El directorio no ha podido ser creado");
            }
        }
    }

    public static void crearFichero() {

        String nombre = MiEntradaSalida.solicitarCadenaMinus("Elija el nombre del fichero");
        boolean append = true;
        File ficheroTexto = new File("/src/Boletin1/" + nombre);
        if (ficheroTexto.exists()) {
            if (ficheroTexto.isFile()) {
                append = (MiEntradaSalida.leerCaracterSN("Quiere annadir el contenido al final del fichero?") == 'S');
            }
            else {
                System.out.println("El fichero no ha podido crearse, ya existe un directorio con ese nombre");
                return;
            }
        }
        String cadena = MiEntradaSalida.solicitarCadenaMinus("Escriba la cadena que estara en el fichero");

        try (PrintWriter pw = new PrintWriter(new FileWriter(ficheroTexto,append))){
            pw.println(cadena);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void borrarFichero(){

        String nombre = MiEntradaSalida.solicitarCadenaMinus("Elija el nombre del fichero");
        File fichero = new File(nombre);
        if (!fichero.exists()){
            System.out.println("El nombre del fichero no existe");
        }else {
            fichero.delete();
            System.out.println("Se ha borrado el fichero correctamente " + nombre);
        }

    }
}
