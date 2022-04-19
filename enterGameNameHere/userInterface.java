package enterGameNameHere;

import java.util.Scanner;

public class UserInterface {

    /**
     * 
     * @param scan
     * @return
     */
    public static String selectMove(Scanner scan) {
        System.out.println("Choose a direction to move to (up/down/right/left)");
        System.out.print(">>>");
        return scan.nextLine();
    }

    /**
     * 
     * @param scan
     * @return
     */
    public static String chooseRace(Scanner scan) {
        System.out.println("Choose a race to play (human/elf)");
        System.out.print(">>>");
        return scan.nextLine();
    }

    /**
     * Clears the screen
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}

/*
STATIC MENU
New game
Play a saved game
Load games
Save games
Exit
------------------------------
display games in ArrayList
--> when exiting current game (0 / 1 / 2 / 3)
--> when choosing a game to play (1 / 2 / 3)
--------------------------------
implement exit in-game
*/