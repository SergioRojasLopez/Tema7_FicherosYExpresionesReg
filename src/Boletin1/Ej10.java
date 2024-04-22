package Boletin1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ej10 {
    public static void main(String[] args) {

        Path ficheroOrigen = Paths.get(".\\src\\Boletin1\\pruebaEj10\\ficheroEj10Origen.txt");
        Path direcDestino = Paths.get(".\\src\\Boletin1\\pruebaEj10\\ficheroEj10Destino.txt");
        Pattern patron = Pattern.compile("^F\\s(\\p{L}{3,}\\.\\p{L}{3})");

        try (Stream<String> lineas = Files.lines(ficheroOrigen, StandardCharsets.UTF_8)) {
            lineas.map(patron::matcher)
                    .filter(Matcher::matches)
                    .forEach(matcher -> {
                        try {
                            Files.createFile(direcDestino.resolve(matcher.group(1)));
                        } catch (FileAlreadyExistsException e) {
                            System.out.println("Ya existe el fichero " + matcher.group(1));
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
