import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxHelper saxHelper = new SaxHelper();
            saxParser.parse("GOTini.xml", saxHelper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
