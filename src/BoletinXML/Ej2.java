package BoletinXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Ej2 {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/BoletinXML/web1.html");
            Element raiz = doc.getDocumentElement();
            Element titulo = (Element) raiz.getElementsByTagName("title").item(0);

            System.out.println("El titulo de la pagina se llama" + titulo.getTextContent());

            System.out.printf("En la pagina hay %d divisores \n",raiz.getElementsByTagName("div").getLength());

            NodeList divValores = doc.getElementsByTagName("div");
            int contDivVal = 0;
            for (int i = 0; i < divValores.getLength(); i++){
                Element elemento = (Element) divValores.item(i);
                if (!elemento.getAttribute("id").isBlank()){
                    contDivVal++;
                }
            }
            System.out.printf("En la página hay %d divisores con valor",contDivVal);

            NodeList imgValor = doc.getElementsByTagName("img");
            for (int i = 0; i < imgValor.getLength(); i++) {
                Element elemento = (Element) imgValor.item(i);
                if (!elemento.getAttribute("alt").isBlank()) {
                    System.out.println("Texto de la imagen : " + elemento.getAttribute("alt"));
                }
            }
            NodeList todosLosDivisores = doc.getElementsByTagName("div");
            for (int i = 0; i < todosLosDivisores.getLength(); i++) {
                Element elemento = (Element) todosLosDivisores.item(i);
                if (elemento.getAttribute("class").equals("noticia")) {
                    String titular = elemento.getElementsByTagName("h2").item(0).getTextContent();
                    System.out.println("Titular: " + titular);
                    String textoAlter = ((Element) elemento.getElementsByTagName("img").item(0)).getAttribute("alt");
                    System.out.println("Texto de imagen alternativo : " + textoAlter);
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }
}
