package Examen2022_2023.parte2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Ej2 {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(".\\src\\Examen2022_2023\\parte2\\simpsons.xml");

            NodeList fechas = doc.getElementsByTagName("fecha_emision");

            for (int i = 0; i < fechas.getLength(); i++) {
                Element fecha = (Element) fechas.item(i);
                int anho = Integer.parseInt(fecha.getTextContent().substring(fecha.getTextContent().length() - 4));
                if (anho > 1992) {
                    System.out.println(((Element) fecha.getParentNode()).getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println(fecha.getTextContent());
                }
            }

            NodeList capitulos = doc.getElementsByTagName("capitulo");

            for (int i = 0; i < capitulos.getLength(); i++) {
                Element capitulo = (Element) capitulos.item(i);
                Element sinopsis = (Element)capitulo.getElementsByTagName("sinopsis").item(0);

                if (sinopsis != null && !sinopsis.getTextContent().trim().isEmpty()) {
                    String[] sinopSplit = sinopsis.getTextContent().trim().split(" ");
                    if (sinopSplit.length < 30) {
                        capitulo.removeChild(sinopsis);
                        i--; // Ajustar el índice para revisar el siguiente elemento
                    }
                }
            }

            File f = new File(".\\src\\Examen2022_2023\\parte2\\simpsons2.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);


            NodeList simpsons = doc.getElementsByTagName("capitulo");
            for (int i = 0; i < simpsons.getLength();i++){
                Element capitulo = (Element) simpsons.item(i);
                Element sinopsis = (Element)capitulo.getElementsByTagName("sinopsis").item(0);
                if (sinopsis != null && !sinopsis.getTextContent().isEmpty()){
                    String sinopText = sinopsis.getTextContent();
                    sinopText = sinopText.replaceAll("(Lisa|Bart)", "**$1**");
                    sinopsis.setTextContent(sinopText);
                }

                File f2 = new File(".\\src\\Examen2022_2023\\parte2\\simpsons3.xml");
                Transformer transformer2 = TransformerFactory.newInstance().newTransformer();
                transformer2.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer2.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                StreamResult result2 = new StreamResult(f2);
                DOMSource source2 = new DOMSource(doc);
                transformer2.transform(source2, result2);
            }

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}