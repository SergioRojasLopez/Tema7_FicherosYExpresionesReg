package Boletin1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ej8 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\src\\Boletin1\\pruebaEj8");
        Pattern pt = Pattern.compile("((?:\\p{L}{2,}\\s){3})(([1-9][0-9]?)|0[1-9])");

        try (Stream<String> stream = Files.lines(path)) {
            if (stream.map(pt::matcher).allMatch(Matcher::matches)) {
                System.out.println("El fichero es valido");
            } else {
                System.out.println("El fichero no es valido");
            }
        } catch (IOException e) {
            throw new RuntimeException("El fichero no se ha podido abrir");
        }
    }
}

