package enterGameNameHere;

import java.util.ArrayList;
import java.util.Scanner;

import enterGameNameHere.Races.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        DataManagement test = new DataManagement();
        
        test.addGame(scan);
        try {
            test.getGames().get(0).gameHandling(scan);
        } catch (Exception e) {
            //TODO: handle exception
        }
        






        scan.close();
    }
}

