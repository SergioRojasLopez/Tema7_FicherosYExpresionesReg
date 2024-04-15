package Boletin1;

import java.io.File;

public class Ej6 {
    public static void main(String[] args) {

        File directorio = new File(".\\src\\Boletin1\\pruebaej5");

        if (directorio.exists() && directorio.isDirectory()) {
            listarArchivosDirectorio(directorio);
        } else {
            System.out.println("El directorio no existe");
        }
    }
    public static void listarArchivosDirectorio(File directorio) {
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
}
