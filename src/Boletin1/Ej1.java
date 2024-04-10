package Boletin1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class Ej1 {

    public static void main(String[] args)  {
    /* Con Java IO
        File archivoNuevo = new File(".\\src\\Boletin1\\FicheroNuevo.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(archivoNuevo))){
            int cont = 0;
            while ((br.readLine()) != null){
                cont++;
            }
            System.out.println("El fichero tiene " + cont + " lineas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Con Java NIO*/

        Path path = Paths.get(".\\src\\Boletin1\\FicheroNuevo.txt");
        try (Stream<String> lines = Files.lines(path)) {
            System.out.println("Numero de lines: " + lines.count());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

