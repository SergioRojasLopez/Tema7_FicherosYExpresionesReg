package Examen2021_2022;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Aeropuerto1 {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Path path = Paths.get(".\\src\\Examen2021_2022\\apartado1");

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(".\\src\\Examen2021_2022\\aeropuerto.xml");

            NodeList vuelo = doc.getElementsByTagName("vuelo");

            for (int i = 0; i < vuelo.getLength(); i++) {
                Element vuelos = (Element) vuelo.item(i);
                String id = vuelos.getElementsByTagName("id")
                        .item(0)
                        .getTextContent();
                String codigo = vuelos.getElementsByTagName("codigo")
                        .item(0)
                        .getTextContent();
                String compañia = vuelos.getElementsByTagName("compania")
                        .item(0)
                        .getTextContent();
                String horaSalida = vuelos.getElementsByTagName("hora_salida")
                        .item(0)
                        .getTextContent();
                String destino = vuelos.getElementsByTagName("destino")
                        .item(0)
                        .getTextContent();
                String concatenar = id + ":" + codigo + ":" + compañia + ":" + horaSalida + ":" + destino;
                bw.write(concatenar);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
