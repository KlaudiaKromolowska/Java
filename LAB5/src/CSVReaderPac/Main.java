package CSVReaderPac;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        CSVReader reader = new CSVReader("with-header.csv",",",true);
       while( reader.next()) {
            int id = reader.getInt("id");
            String name = reader.get("imię");
            double fare = reader.getDouble("nrdomu");
            System.out.printf(Locale.US,"%d %s %d",id, name, fare);
        }





}
}
