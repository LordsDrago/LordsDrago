package enterGameNameHere;

import java.util.ArrayList;
import java.util.Scanner;

import enterGameNameHere.Races.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        DataManagement test = new DataManagement();
        
        test.addGame(scan);
        test.getGames().get(0).gameHandling(scan);






        scan.close();
    }
}

