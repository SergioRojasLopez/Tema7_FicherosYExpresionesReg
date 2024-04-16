package Boletin1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej8 {
    public static void main(String[] args) {

        String nombreFichero = MiEntradaSalida.solicitarCadenaMinus("Introduce el nombre del fichero");
        try {
            List<String> lineas = Files.readAllLines(Paths.get(".\\src\\Boletin1\\" + nombreFichero));
            for (String linea : lineas) {
                String[] palabras = linea.split(" ");
                int cantidadPalabras = palabras.length;
                for (String pala : palabras) {
                    Pattern pattern = Pattern.compile("\\b([1-9]|[1-9][0-9])\\b");
                    Matcher matcher = pattern.matcher(pala);
                    if (matcher.find()) {
                        System.out.println(cantidadPalabras);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

