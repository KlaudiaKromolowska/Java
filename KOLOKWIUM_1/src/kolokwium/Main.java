package kolokwium;

import kolokwium.CSVReader;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader("NIFTY_200.csv",",",true);
        reader.obliczSrednia(reader);
        int max=0;
        while(reader.next()){
            if (reader.getInt("Close")-reader.getInt("Open")>max){
                max = reader.getInt("Close")-reader.getInt("Open");
            }
        }
        System.out.println("Maksymalna wartosc: " +max);
    }
}