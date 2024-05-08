package Examen2021_2022;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Aeropuerto2 {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try  {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(".\\src\\Examen2021_2022\\aeropuerto.xml");
            NodeList vuelo = doc.getElementsByTagName("vuelo");

            Pattern patron = Pattern.compile("(\\d)(\\d{2})(\\d{2})(\\d{3})");
            for (int i = 0; i < vuelo.getLength(); i++) {
                Element vuelos = (Element) vuelo.item(i);
                String id = vuelos.getElementsByTagName("id")
                        .item(0)
                        .getTextContent();
                Matcher m = patron.matcher(id);

                if (m.matches()) {
                    String continente = m.group(1);
                    String pais = m.group(2);
                    String aerolinea = m.group(3);
                    String codiVuelo = m.group(4);
                    String nuevoId = aerolinea + codiVuelo + pais + continente;
                    vuelos.getElementsByTagName("id").item(0).setTextContent(nuevoId);
                    vuelos.removeChild(vuelos.getElementsByTagName("compania").item(0));
                }
            }

            File f = new File(".\\src\\Examen2021_2022\\aeropuerto2.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);




        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            throw new RuntimeException(e);
        }

    }
}
