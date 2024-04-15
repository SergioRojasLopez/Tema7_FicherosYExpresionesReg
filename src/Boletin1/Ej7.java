package Boletin1;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ej7 {

    static File directorio = new File(".\\src\\Boletin1\\pruebaej5");

    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalida.leerEnteroDeRango("Elije una opcion", 1, 5);
            switch (opcion) {
                case 1:
                    listarDirectorio(directorio);
                    break;
                case 2:
                    listarArchBuscarFicherosQueComienzePorLetras(directorio);
                    break;
                case 3:
                    listarPorExtension();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

            }
        } while (opcion != 6);
    }

    public static void menu() {
        System.out.println("1. Listar Directorio");
        System.out.println("2. Listar directorio y buscar ficheros que comiencen por una palabra");
        System.out.println("3. Listar archivos con cierta extensión de un directorio");
        System.out.println("4. Buscar un archivo en un directorio");
        System.out.println("5. Buscar recursivamente un archivo en un directorio");
        System.out.println("6. Salir");
    }

    public static void listarDirectorio(File directorio) {

        File[] archivos = directorio.listFiles();

        if (archivos == null || archivos.length == 0) {
            System.out.println("El directorio esta vacio");
        } else {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    System.out.println(archivo.getName() + "directorio");
                } else {
                    System.out.println(archivo.getName() + " - " + archivo.length() / 1024 + " Kb");
                }
            }
        }
    }

    public static void listarArchBuscarFicherosQueComienzePorLetras(File directorio) {

        String cadenaFiltrar = MiEntradaSalida.solicitarCadenaMinus("Escribe las letras por las que empiece tu fichero");
        File[] files = directorio.listFiles(((dir, name) -> name.startsWith(cadenaFiltrar)));

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getName() + " [Directorio] ");
            } else {
                System.out.println(file.getName() + "-" + file.length() / 1024 + " Kb");

            }
        }
    }

    public static void listarPorExtension() {

        String cadenaFiltrar = MiEntradaSalida.solicitarCadenaMinus("Escribe la extension para buscar el fichero");
        Path directorioNuevo = Paths.get(".\\src\\Boletin1\\pruebaej5");

        try (Stream<Path> ficheros = Files.list(directorioNuevo)) {
            ficheros.filter(Files::isRegularFile)
                    .filter(a -> a.toString().endsWith("." + cadenaFiltrar))
                    .forEach(a -> {
                        try {
                            System.out.println(a.getFileName().toString() + "-" + Files.size(a) / 1024 + "Kb");

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("Ocurrio un error al cerrar el fichero");
        }
    }
}
