package CSVReaderPac;

import org.junit.Test;

import java.io.StringReader;
import java.util.Locale;

import static org.junit.Assert.*;

public class CSVReaderTest {
    @Test
    public void TestCSVReader() throws Exception{
        CSVReader reader = new CSVReader("with-header.csv",",",true);
        assertEquals(new String(","), reader.delimiter);
        assertEquals(true, reader.hasHeader);
    }
    @Test
        public void TestCSVReaderNoHeader() throws Exception {
        CSVReader reader = new CSVReader("with-header.csv", ";");
        assertEquals(false, reader.hasHeader);
    }

    @Test
    public void TestCSVReaderNoDelimiter() throws Exception {
        CSVReader reader = new CSVReader("with-header.csv");
        assertEquals(new String(";"), reader.delimiter);
    }
    @Test
    public void next() throws Exception{
        CSVReader reader = new CSVReader("with-header.csv",",",true);
        while( reader.next()) {

            int id = reader.getInt("id");
            String name = reader.get("imie");
            String adres = reader.get(2);
            int house = reader.getInt(3);
            int number = reader.getInt(4);
            System.out.printf(Locale.US,"%d %s %s %d %d",id, name, adres, house, number);
        }
    }
    public void getColumnLabels() throws Exception {
        CSVReader reader = new CSVReader("with-header.csv", ";", true);
        assertEquals("nrdomu", reader.columnLabels.get(4));
    }

    /**
     * BRAK TESTU: SPRAWDZ POPRAWNOSC FUNKCJI ZWRACAJACYCH WARTOSCI POSZCZEGOLYNCH TYPOW + ZŁY NEXT!
     */
    public void another() throws Exception{
        String text = "a,b,c\n123.4,567.8,91011.12";
        CSVReader reader = new CSVReader(new StringReader(text),",",true);
        assertEquals(new String(";"), reader.delimiter);
        assertEquals(true, reader.hasHeader);
        assertEquals("a", reader.columnLabels.get(1));
    }




}