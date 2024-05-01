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
        Path fichero = Paths.get(".\\src\\Boletin1\\FicheroEj11.txt"); //Le señalamos el fichero que queremos trabajar
        Pattern patron = Pattern.compile("(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s([^\\\\/:\"*?|<>]{2,})");
        //Patron -> Apellido1 (2 letras min),Apellido2 (2 letras min),Nombre (2 letras min), cualq. carac. de 2 let min menos los señalados en el patrón
        String directorio = ".\\src\\Boletin1\\pruebaEj11";
        try (Stream<String> lineas = Files.lines(fichero)) {
            //Flujo para leer las lineas de un fichero
            lineas.map(patron::matcher)
                    //Devuelve un flujo basado en los resultados de haber aplicado la funcion a los elementos del flujo
                    .filter(Matcher::matches)
                    //Filtra los valores que han podido ser matcheados
                    .forEach(matcher -> {
                        String nombreAlum = matcher.group(2) + matcher.group(3) + matcher.group(1);
                        //Por cada uno de los elementos que han hecho match los agrupamos en grupos, en este caso: Ap1 Ap2 Nombre
                        try {
                            Files.createDirectories(Path.of(directorio, matcher.group(4), nombreAlum));
                            //Crea los directorios con la variable dada y los agrupa con el 4 elemento, en este caso la clase y su nombre completo
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("Fichero no encotrado");
        }
    }
}
