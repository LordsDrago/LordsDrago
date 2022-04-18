package enterGameNameHere;

import java.util.ArrayList;
import java.util.Scanner;

import enterGameNameHere.Races.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Game> games = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        
        games.add(new Game(scan));
        games.get(0).gameHandling(scan);







        scan.close();
    }
}

