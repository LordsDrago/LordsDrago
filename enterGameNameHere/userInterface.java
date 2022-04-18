package enterGameNameHere;

import java.util.Scanner;

public class userInterface {
    public static String selectMove(Scanner scan) {
        System.out.println("Choose a direction to move to (up/down/right/left)");
        System.out.print(">>>");
        return scan.nextLine();
    }

    public static String chooseRace(Scanner scan) {
        System.out.println("Choose a race to play (human/elf)");
        System.out.print(">>>");
        return scan.nextLine();
    }
}
