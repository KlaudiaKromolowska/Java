package CVPac;

import java.io.PrintStream;


public class Paragraph {
    String content_;

    Paragraph(){
        content_="";
    }

    Paragraph(String content){
        content_=content;
    }

    Paragraph setContent(String content){
        content_=content;
        return this;
    }
    void writeHTML(PrintStream out){
        out.printf("<p>%s</p>\n",content_);
    }


}