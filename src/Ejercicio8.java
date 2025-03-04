import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
            Document document=null;

            DocumentBuilder builder= factory.newDocumentBuilder();
            document= builder.parse(new File("GOTini.xml"));
            document.getDocumentElement().normalize();
            Node nodoRaiz=document.getFirstChild();
            NodeList nodos=nodoRaiz.getChildNodes();
            for(int i=0; i<nodos.getLength(); i++){
                Node nodo=nodos.item(i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    System.out.println(nodo.getNodeName()+" :");
                    Element e=(Element)nodo;
                    System.out.println(e.getElementsByTagName("name").item(0).getNodeName()+" : "+e.getElementsByTagName("name").item(0).getTextContent());
                    NodeList node2=e.getElementsByTagName("aliases");
                    if (!(node2.getLength()==0)){
                        for (int j = 0; j < node2.getLength(); j++) {
                           Node node=node2.item(j);
                           if (node.getNodeType()==Node.ELEMENT_NODE){
                               System.out.println(node.getNodeName()+" :"+node.getTextContent());
                           }
                        }

                    }

                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
