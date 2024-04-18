package Boletin1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ej9 {
    public static void main(String[] args) {

        Path path = Paths.get(".\\src\\Boletin1\\pruebaEj9\\matriculas");
        Path path2 = Paths.get(".\\src\\Boletin1\\pruebaEj9\\matriculasNuevas");
        Pattern pt = Pattern.compile("\\p{L}+\\s(\\d{4}-[A-Z&&[^AEIOU]]{3})");

        try (BufferedWriter writer = Files.newBufferedWriter(path2, StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.CREATE);
             Stream<String> lineas = Files.lines(path)) {
            lineas.map(pt::matcher)
                    .filter(Matcher::matches)
                    .forEach(matcher -> {
                        try {
                            writer.write(matcher.group(1));
                            writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException("Ha ocurrido un error");
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException("Ha ocurrido un error");
        }
    }
}
