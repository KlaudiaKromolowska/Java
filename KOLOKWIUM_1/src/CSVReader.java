package kolokwium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    List<String> columnLabels = new ArrayList<>();
    Map<String, Integer> columnLabelsToInt = new HashMap<>();
    String[] current;

    void parseHeader() throws IOException {
        String line = reader.readLine();  // wczytaj wiersz
        if (line == null) {
            return;
        }
        String[] header = line.split(delimiter); // podziel na pola
        for (int i = 0; i < header.length; i++) { // przetwarzaj dane w wierszu
            columnLabels.add(header[i]); // dodaj nazwy kolumn do columnLabels i numery do columnLabelsToInt
            columnLabelsToInt.put(columnLabels.get(i), i);
        }
    }

    boolean next() throws IOException {
        String line = reader.readLine();  // czyta następny wiersz, dzieli na elementy i przypisuje do current
        if (line == null) {
            return false;
        }
        current = line.split(delimiter + "(?=([^\"]*\"[^\"]*\")*[^\"]*$)", columnLabels.size());
        return true;
    }

    public CSVReader(String filename, String delimiter, boolean hasHeader) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if (hasHeader)
            parseHeader();
    }


    String get(int columnIndex) {
        if (current[columnIndex].equals("")) {
            return "";
        } else {
            return current[columnIndex];
        }
    }

    String get(String columnLabel) {
        int i = columnLabelsToInt.get(columnLabel);
        if (current[i].equals("")) {
            return "";
        } else {
            return current[i];
        }
    }

    public int getInt(int columnIndex) {
        return Integer.parseInt(current[columnIndex]);
    }

    public int getInt(String columnLabel) {
        int i = columnLabelsToInt.get(columnLabel);
        return Integer.parseInt(current[i]);
    }

    public long getLong(int columnIndex) {
        return Long.parseLong(current[columnIndex]);
    }

    public long getLong(String columnLabel) {
        int i = columnLabelsToInt.get(columnLabel);
        return Long.parseLong(current[i]);
    }

    public double getDouble(int columnIndex) {
        return Double.parseDouble(current[columnIndex]);
    }

    public double getDouble(String columnLabel) {
        int i = columnLabelsToInt.get(columnLabel);
        return Double.parseDouble(current[i]);
    }

    List<String> getColumnLabels() {
        return columnLabels;
    }

    int getRecordLength() {
        int size = 0;
        for (String string : current) {
            if (string.equals("")) {
            } else size++;
        }
        return size;
    }

    void obliczSrednia(CSVReader reader) throws IOException{
        int sum1 = 0, licznik1 = 1, sum2 = 0, licznik2 = 1;
        String str = new String();
        while (reader.next()) {
            if (str.contains("Oct")) {
                sum1 += getInt("Open");
                licznik1++;
            }
            if (str.contains("Sep")) {
                sum2 += getInt("Open");
                licznik2++;
            }
        }
        System.out.println(licznik1-1 + " : avg : " + sum1 / licznik1-1);
        System.out.println(licznik2-1 + " : avg : " + sum2 / licznik2-1);
    }
}
