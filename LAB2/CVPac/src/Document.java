package CVPac;
import CVPac.Photo;
import CVPac.Section;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Document {
    String title;
    Photo photo;
    List<Section> sections = new ArrayList<>();

    Document(){}

    Document(String title){
        this.title = title;
    }

    Document setTitle(String title){
        this.title = title;
        return this;
    }

    Document setPhoto(String photoUrl){
        photo = new Photo(photoUrl);
        return this;
    }

    Section addSection(String sectionTitle){
        // utwórz sekcję o danym tytule i dodaj do sections
        Section tmp = new Section(sectionTitle);
        sections.add(tmp);
        return tmp;
    }
    Document addSection(Section s){
        sections.add(s);
        return this;
    }

    void writeHTML(PrintStream out){
        out.printf("<html><body>\n");
        out.printf("<h1>%s</h1>",title);
        photo.writeHTML(out);
        for(Section section : sections ){
            section.writeHTML(out);
        }
        out.printf("</body></html>");
        // zapisz niezbędne znaczniki HTML
        // dodaj tytuł i obrazek
        // dla każdej sekcji wywołaj section.writeHTML(out)
    }



}