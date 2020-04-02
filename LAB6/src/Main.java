import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[][] macierz = new double[2][2];
	    macierz = czytaj_dane(macierz, 2);
	    przetworz_dane(macierz, 2);
	    wyswietl_wynik(macierz, 2);
    }


    public static double[][] czytaj_dane(double[][] macierz, int rozmiar){
        for(int i=0;i<rozmiar; i++){
            for(int j=0;j<rozmiar; j++){
                Scanner scan = new Scanner(System.in);
                macierz[i][j]=scan.nextDouble();
            }
        }
        return macierz;
    }

    public static void przetworz_dane(double[][] macierz, int rozmiar){
        int suma=0;
        for(int i=0;i<rozmiar; i++){
            suma +=macierz[i][i];
        }
        System.out.println(suma);
    }

    public static void wyswietl_wynik(double[][] macierz, int rozmiar){
        for(int i=0;i<rozmiar; i++){
            for(int j=0;j<rozmiar; j++){
                System.out.print(macierz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
