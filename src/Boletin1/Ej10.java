package Boletin1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ej10 {
    public static void main(String[] args) {

        Path ficheroOrigen = Paths.get(".\\src\\Boletin1\\ficheroEj10Origen");
        Path direcDestino = Paths.get(".\\src\\Boletin1");
        Pattern patron = Pattern.compile("^F\\s(\\p{L}{3,}\\.\\p{L}{3})$");
        AtomicBoolean correcto = new AtomicBoolean(true);

        try (Stream<String> lineas = Files.lines(ficheroOrigen, StandardCharsets.UTF_8)) {
            lineas.forEach(linea -> {
                Matcher matcher = patron.matcher(linea);
                if (matcher.matches()) {
                    try {
                        Files.createFile(direcDestino.resolve(matcher.group(1)));
                        System.out.println("Se ha creado el fichero " + matcher.group(1));
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("Ya existe el fichero " + matcher.group(1));
                    } catch (IOException e) {
                        System.out.println("No se pudo crear el fichero " + matcher.group(1));
                    }
                }
                else {
                    correcto.set(false);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (correcto.get()){
            System.out.println("El fichero era correcto");
        }else {
            System.out.println("Al menos una linea del fichero no es correcta");
        }
    }
}
