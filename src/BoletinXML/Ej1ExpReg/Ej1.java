package BoletinXML.Ej1ExpReg;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej1 {
    public static void main(String[] args) {
        File fichero = new File("./src/BoletinXML/Ej1ExpReg/quijote.txt");

        try (BufferedReader bf = new BufferedReader(new FileReader(fichero))) {
            String linea;
            String patronRazon = "\\braz[oó]n\\b";
            Pattern patron = Pattern.compile(patronRazon, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            int cont = 0;
            while ((linea = bf.readLine()) != null) {
                Matcher matronazo = patron.matcher(linea);
                while (matronazo.find()) {
                    cont++;
                }
            }
            System.out.println("La palabra razón se ha encontrado " + cont);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
