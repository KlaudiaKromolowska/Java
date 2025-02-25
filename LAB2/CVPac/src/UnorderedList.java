package CVPac;
import CVPac.Photo;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    List<ListItem> listItems = new ArrayList<>();
    String content;

    public UnorderedList(){};
    public UnorderedList(String content_){
        content=content_;
    }


    UnorderedList addListItem(ListItem item){
        listItems.add(item);
        return this;
    }

    UnorderedList addListItem(String item){
        ListItem tmp = new ListItem(item);
        listItems.add(tmp);
        return this;
    }

    public void writeHTML(PrintStream out){
        out.printf("<ol>\n");
        for(ListItem item : listItems){
            item.writeHTML(out);
        }
        out.printf("</ol>\n");
    }
}
