package Boletin1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Ej4 {
    public static void main(String[] args) {
        //Con Java NIO
        Path path = Paths.get(".\\src\\Boletin1\\salidaEj3.txt");
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String datos;
            while (!(datos = bf.readLine()).equalsIgnoreCase("fin")) {
                Files.writeString(path, datos, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
