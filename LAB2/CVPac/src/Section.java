package CVPac;
import CVPac.Paragraph;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section {
    String title_;
    List<Paragraph> paragraps = new ArrayList<>() ;

    Section(){}

    Section(String title){
        title_=title;
    }

    Section setTitle(String title){
        title_=title;
        return this;
    }
    Section addParagraph(String paragraphText){
        Paragraph paragraph = new Paragraph(paragraphText);
        paragraps.add(paragraph);
        return this;
    }
    Section addParagraph(Paragraph p){
        paragraps.add(p);
        return this;
    }
    void writeHTML(PrintStream out){
        out.printf("<h2>%s</h2>",this.title_);
        for(Paragraph paragraph : paragraps){
            paragraph.writeHTML(out);
        }
    }

    public void addListItem(String c) {
    }
}