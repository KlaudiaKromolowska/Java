package CVPac;

import java.io.PrintStream;

public class ListItem {

    String content_;

    public ListItem(){}

    public ListItem(String content){
        content_=content;
    }

    public void writeHTML(PrintStream out){
        out.printf("<li>%s</li>\n", content_);
    }
}