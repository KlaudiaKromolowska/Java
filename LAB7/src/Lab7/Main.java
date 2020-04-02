package Lab7;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AdminUnitList adminlist = new AdminUnitList();
        try {
            adminlist.read("admin-units.csv");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("\nVersion 1\n");
        adminlist.list(System.out,1,100);
        System.out.println("\nVersion 2\n");
        adminlist.selectByName("Sz.*",true).list(System.out);
    }
}
