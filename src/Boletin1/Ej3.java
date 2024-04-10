package Boletin1;

import java.io.*;

public class Ej3 {
    public static void main(String[] args) {
        //Con Java IO
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter(".\\src\\Boletin1\\salidaEj3.txt",true))){
            String linea;
            while (!(linea = br.readLine()).equalsIgnoreCase("fin")){
                pw.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
