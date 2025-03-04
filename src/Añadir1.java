import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Añadir1 {
    public static void main(String[] args) {
        añadir();

    }
    private static NodeList printearXML() {
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        Document document=null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File("GOTini.xml"));
            document.getDocumentElement().normalize();
            Node nodoRaiz = document.getFirstChild();
            NodeList lista=nodoRaiz.getChildNodes();
            return lista;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    private  static void añadir(){

        try {
            DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
            DocumentBuilder builder= factory.newDocumentBuilder();
            Document document= builder.parse("GOTini.xml");
            document.getDocumentElement().normalize();
            Node raiz=document.getFirstChild();
            Element elementC = document.createElement("character");
            raiz.appendChild(elementC);
            Element elementI = document.createElement("Id");
            Text text = document.createTextNode("583");
            elementI.appendChild(text);
            elementC.appendChild(elementI);
            Element elementN = document.createElement("name");
            Text text1 = document.createTextNode("Jon Snow");
            elementN.appendChild(text1);
            elementC.appendChild(elementN);
            Element elementN2 = document.createElement("born");
            Text text2 = document.createTextNode("In 283 AC, at Winterfell");
            elementN2.appendChild(text2);
            elementC.appendChild(elementN2);
            Element elementV = document.createElement("live");
            Text text3 = document.createTextNode("FALSE");
            elementV.appendChild(text3);
            elementC.appendChild(elementV);
            Element elementT = document.createElement("titles");
            elementC.appendChild(elementT);
            Element elementT1 = document.createElement("title");
            Text text4 = document.createTextNode("Lord Commander of the Night's Watch");
            elementT1.appendChild(text4);
            Element elementT2 = document.createElement("title");
            Text text5 = document.createTextNode("King in the North");
            elementT2.appendChild(text5);
            elementT.appendChild(elementT1);
            elementT.appendChild(elementT2);
            Element elementA = document.createElement("aliases");
            elementC.appendChild(elementA);
            ArrayList<Text> alias=new ArrayList<>();
            alias.add(document.createTextNode("Lord Snow"));
            alias.add(document.createTextNode("Ned Stark's Bastard"));
            alias.add(document.createTextNode("The Snow of Winterfell"));
            alias.add(document.createTextNode("The Crow-Come-Over"));
            alias.add(document.createTextNode("The 998th Lord"));
            alias.add(document.createTextNode("Commander of the Night's Watch"));
            alias.add(document.createTextNode("The Bastard of Winterfell"));
            alias.add(document.createTextNode("The Black Bastard of the Wall"));
            alias.add(document.createTextNode("Lord Crow"));
            for (int i = 0; i < alias.size(); i++) {
                Element element=document.createElement("alias");
                element.appendChild(alias.get(i));
                elementA.appendChild(element);
            }
            NodeList nodeListR=document.getDocumentElement().getChildNodes();
            ArrayList<Text> lista = new ArrayList<>();
            lista.add(document.createTextNode("Alfie Allen"));
            lista.add(document.createTextNode("Isaac Hempstead-Wright"));
            lista.add(document.createTextNode("Art Parkinson"));
            lista.add(document.createTextNode("Richard Madden"));
            lista.add(document.createTextNode("Sophie Turner"));
            lista.add(document.createTextNode("Kit Harington"));
            int j =0;
            for (int i = 0; i < nodeListR.getLength(); i++) {
                Node nodoR=nodeListR.item(i);
                if(nodoR.getNodeType()==Node.ELEMENT_NODE) {
                    Element element = document.createElement("playedBy");
                    element.appendChild(lista.get(j));
                    j++;
                    nodoR.appendChild(element);

                }
            }
            TransformerFactory fT= TransformerFactory.newInstance();
            Transformer transformer=fT.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            Source origen = new DOMSource(document);
            Result destino=new StreamResult("GOTini.xml");
            transformer.transform(origen,destino);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }
}
