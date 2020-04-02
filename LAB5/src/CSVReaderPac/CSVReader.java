package CSVReaderPac;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    String[] current;
    // nazwy kolumn w takiej kolejności, jak w pliku
    List<String> columnLabels = new ArrayList<>();
    // odwzorowanie: nazwa kolumny -> numer kolumny
    Map<String,Integer> columnLabelsToInt = new HashMap<>();


    /**
     *
     * @param filename - nazwa pliku
     * @param delimiter - separator pól
     * @param hasHeader - czy plik ma wiersz nagłówkowy
     */
    public CSVReader(String filename, String delimiter) throws IOException{
        reader= new BufferedReader(new FileReader(filename));
        this.delimiter=delimiter;
        this.hasHeader=false;
    }
    public CSVReader(String filename) throws IOException{
        reader= new BufferedReader(new FileReader(filename));
        this.delimiter=";";
        this.hasHeader=false;
    }

    public CSVReader(String filename,String delimiter,boolean hasHeader) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if(hasHeader)parseHeader();
    }

    public CSVReader(Reader reader, String delimiter, boolean hasHeader){
        this.reader = new BufferedReader(reader);
        this.delimiter=delimiter;
        this.hasHeader=hasHeader;
    }

    void parseHeader() throws IOException{
        // wczytaj wiersz
        String line  = reader.readLine();
        if(line==null) {
            return;
        }
        // podziel na pola
        String[]header = line.split(delimiter);
        // przetwarzaj dane w wierszu
        for(int i=0;i<header.length;i++){
            columnLabels.add(header[i]);
            columnLabelsToInt.put(header[i], i);
            // dodaj nazwy kolumn do columnLabels i numery do columnLabelsToInt
        }
    }
        boolean next() throws IOException{
            // czyta następny wiersz, dzieli na elementy i przypisuje do current
            String line  = reader.readLine();
            if(line==null) {
                return false;
            }
            current = line.split(delimiter+"(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            return true;
        }
    List<String> getColumnLabels(){
        return columnLabels;
    }
    int getRecordLength() {
        return current.length;
    }
    boolean isMissing(int columnIndex){
        if(current.length<columnIndex) return true;
        if(this.current[columnIndex].isEmpty()) return true;
        return false;
    }
    boolean isMissing(String columnLabel){

        return isMissing(this.columnLabelsToInt.get(columnLabel));
    }
    String get(int columnIndex){
        if(isMissing(columnIndex)) return "Missing";
        return current[columnIndex];
    }
    String get(String columnLabel){
        if(isMissing(columnLabel)) return "Missing";
        return current[this.columnLabelsToInt.get(columnLabel)];
    }
    int getInt(int columnIndex){
        if(isMissing(columnIndex)) return -1;
        return Integer.parseInt(current[columnIndex]);
    }
    int getInt(String columnLabel){
        if(isMissing(columnLabel)) return -1;
        return Integer.parseInt(current[columnLabelsToInt.get(columnLabel)]);
    }
    long getLong(int columnIndex){
        if(isMissing(columnIndex)) return -1;
        return Long.parseLong(current[columnIndex]);
    }
    long getLong(String columnLabel){
        if(isMissing(columnLabel)) return -1;
        return Long.parseLong(current[columnLabelsToInt.get(columnLabel)]);
    }
    double getDouble(int columnIndex){
        if(isMissing(columnIndex)) return -1;
        return Double.parseDouble(current[columnIndex]);
    }
    double getDouble(String columnLabel){
        if(isMissing(columnLabel)) return -1;
        return Double.parseDouble(current[columnLabelsToInt.get(columnLabel)]);

    }
    void getDate(int columnIndex, String format){
        LocalDate date = LocalDate.parse(current[columnIndex], DateTimeFormatter.ofPattern(format));
        System.out.println(date);
    }

    void getTime(int columnIndex, String format){
        LocalTime time = LocalTime.parse(current[columnIndex],DateTimeFormatter.ofPattern(format));
        System.out.println(time);
    }
}
