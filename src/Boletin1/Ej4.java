package Boletin1;

import java.io.*;

public class Ej4 {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter(archivo))){
            String linea;
            while (!(linea = br.readLine()).equalsIgnoreCase("fin")){
                pw.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
}
