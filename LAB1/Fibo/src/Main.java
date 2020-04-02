import java.util.Scanner;
import java.util.Locale;

public class Main {
    static int Fibb(int n){
        if (n == 0)
            return 0;
        if (n < 2)
            return 1;
        return Fibb(n - 1) + Fibb(n - 2);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n >= 1 && n<= 45) {
            int[] tab = new int[n];
            int i = 0;
            while (i < n) {
                System.out.println(tab[i] = Fibb(i));
                i++;
            }
        }
    }
}
