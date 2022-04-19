package enterGameNameHere;

import java.util.Scanner;

public class userInterface {
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
