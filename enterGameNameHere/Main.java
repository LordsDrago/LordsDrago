package enterGameNameHere;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        DataManagement test = new DataManagement();
        
        test.menu(scan);
        






        scan.close();
    }
}

