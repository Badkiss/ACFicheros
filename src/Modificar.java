import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class Modificar {
    public static void main(String[] args) {
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        Document document=null;

        try {
            DocumentBuilder documentBuilder= factory.newDocumentBuilder();
            document=documentBuilder.parse("GOTini.xml");
            document.getDocumentElement().normalize();
            Node raiz = document.getDocumentElement();
            NodeList listado= raiz.getChildNodes();
           for(int i=0; i<listado.getLength(); i++){
               Node nodo=listado.item(i);
               if(nodo.getNodeType()==Node.ELEMENT_NODE){
                   Element e=(Element)nodo;
                   Element element= document.createElement("Creation");
                   Text text= document.createTextNode("creation");
                   element.appendChild(text);
                   e.appendChild(element);

               }
           }
            TransformerFactory fT= TransformerFactory.newInstance();
            Transformer transformer=fT.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            Source origen = new DOMSource(document);
            Result destino=new StreamResult("GOTini.xml");
            transformer.transform(origen,destino);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

}
