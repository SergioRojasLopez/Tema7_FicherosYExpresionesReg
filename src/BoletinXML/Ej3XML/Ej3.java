package BoletinXML.Ej3XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Ej3 {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/BoletinXML/Ej3XML/desayuno.html");
            NodeList platosBaratos = doc.getElementsByTagName("food");
            for (int i = 0; i < platosBaratos.getLength(); i++) {
                Element elemento = (Element) platosBaratos.item(i);
                int precioBase = 5;
                if (){
                    int precio = Integer.parseInt(elemento.getElementsByTagName("price").toString());
                    System.out.println(precio);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
