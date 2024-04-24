package Boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ej11 {
    public static void main(String[] args) {
        Path fichero = Paths.get(".\\src\\Boletin1\\FicheroEj11.txt");
        Pattern patron = Pattern.compile("(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s([^\\\\/:\"*?|<>]{2,})");
        String directorio = ".\\src\\Boletin1\\pruebaEj11";
        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.map(patron::matcher)
                    .filter(Matcher::matches)
                    .forEach(matcher -> {
                        String nombreAlum = matcher.group(2) + matcher.group(3) + matcher.group(1);
                        try {
                            Files.createDirectories(Path.of(directorio, matcher.group(4), nombreAlum));
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("Fichero no encotrado");
        }
    }
}
