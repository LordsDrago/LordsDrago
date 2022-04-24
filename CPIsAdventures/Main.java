package CPIsAdventures;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        DataManagement game = new DataManagement();
        
        game.menu(scan);
        
        scan.close();
    }
}

