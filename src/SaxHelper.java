import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHelper extends DefaultHandler {
    boolean id=false;
    boolean name=false;
    boolean gender=false;
    boolean culture=false;
    boolean born=false;
    boolean died=false;
    boolean alive=false;
    boolean titles=false;
    boolean title=false;
    boolean aliases=false;
    boolean alias=false;
    boolean father=false;
    boolean mother=false;
    boolean spouse=false;
    boolean allegiances=false;
    boolean books=false;
    boolean book=false;
    boolean tvSeries= false;
    boolean season=false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        switch (qName){
            case "id":
                id=true;
                break;
            case "name":
                name=true;
                break;
            case "gender":
                gender=true;
                break;
            case "culture":
                culture=true;
                break;
            case "born":
                born=true;
                break;
            case "died":
                died=true;
                break;
            case "alive":
                alive=true;
                break;
            case "titles":
                titles=true;
                break;
            case "title":
                title=true;
                break;
            case "aliases":
                aliases=true;
                break;
            case "alias":
                alias=true;
                break;
            case "father":
                father=true;
                break;
            case "mother":
                mother=true;
                break;
            case "spouse":
                spouse=true;
                break;
            case "allegiances":
                allegiances=true;
                break;
            case "books":
                books=true;
                break;
            case "book":
                book=true;
                break;
            case "tvSeries":
                tvSeries=true;
                break;
            case "season":
                season=true;
                break;

        }
    }
    public void endElement(String uri, String localName, String qName) {

    }
    public void characters(char ch[], int inicio, int length){
        if (id){
            System.out.println("--------------------------------------------------------------");
            System.out.println("id: "+new String(ch,inicio,length));
            id=false;
        }
        if (name){
            System.out.println("name: "+new String(ch,inicio,length));
            name=false;
        }
        if (gender){
            System.out.println("gender: "+new String(ch,inicio,length));
            gender=false;
        }
        if (culture){
            System.out.println("culture: "+new String(ch,inicio,length));
            culture=false;
        }
        if (born){
            System.out.println("born: "+new String(ch,inicio,length));
            born=false;
        }
        if (alive){
            System.out.println("alive: "+new String(ch,inicio,length));
            alive=false;
        }
        if (titles){
            System.out.println("titles: ");
            titles=false;
        }
        if (title){
            System.out.println("title: "+new String(ch,inicio,length));
            title=false;
        }
        if (aliases){
            System.out.println("aliases: ");
            aliases=false;
        }
        if (alias){
            System.out.println("alias: "+new String(ch,inicio,length));
            alias=false;
        }
        if (father){
            System.out.println("father: "+new String(ch,inicio,length));
            father=false;
        }
        if (mother){
            System.out.println("mother: "+new String(ch,inicio,length));
            mother=false;
        }
        if (spouse){
            System.out.println("spouse: "+new String(ch,inicio,length));
            spouse=false;
        }
        if (allegiances){
            System.out.println("allegiances: "+new String(ch,inicio,length));
            allegiances=false;
        }
        if (books){
            System.out.println("books: ");
            books=false;
        }
        if (book){
            System.out.println("book: "+new String(ch,inicio,length));
            book=false;
        }
        if (tvSeries){
            System.out.println("tvSeries: ");
            tvSeries=false;
        }
        if (season){
            System.out.println("season: "+new String(ch,inicio,length));
            season=false;
        }

    }
}
