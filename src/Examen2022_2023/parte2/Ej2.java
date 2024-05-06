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
            Document doc = db.parse("./src/Examen2022-2023/Ej2/simpsons.xml");

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
                String [] sinopSplit = sinopsis.getTextContent().split(" ");
                if (sinopSplit.length <= 30){

                }
            }

            File f = new File("./src/Examen2022-2023/Ej2/simpsons2.xml");

            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            }

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult result = new StreamResult(f);

            DOMSource source = new DOMSource(doc);

            try {
                try {
                    transformer.transform(source, result);
                } catch (TransformerException e) {
                    throw new RuntimeException(e);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}