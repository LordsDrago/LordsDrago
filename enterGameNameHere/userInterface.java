package enterGameNameHere;

import java.util.Scanner;

public class UserInterface {

    /**
     * 
     * @param scan
     * @return
     */
    public static String selectMove(Scanner scan) throws ErrorGame, ExitGame {
        System.out.println("Choose a direction to move to (up = z/down = s/right = d/left = q)");
        System.out.print(">>>");
        String input = scan.nextLine();

        if(input.equals("exit"))
            throw new ExitGame();

        if(!input.equals("z") && !input.equals("q") && !input.equals("s") && !input.equals("d"))
            throw new ErrorGame("Please enter a correct input to move !");
        

        return input;
    }

    /**
     * 
     * @param scan
     * @return
     */
    public static String chooseRace(Scanner scan) throws ErrorGame{
        UserInterface.clearScreen();
        System.out.println("Choose a race to play (human/elf)");
        System.out.print(">>>");
        String input = scan.nextLine().toLowerCase();

        if(!input.equals("human") && !input.equals("elf"))
            throw new ErrorGame("Please select a correct race to play !");

        return input;
    }

    /**
     * Clears the screen
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    } 

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {}
    }

    public static void printException(String exceptionMessage) {
        UserInterface.clearScreen();
        System.out.println(exceptionMessage);
        UserInterface.wait(3);
    }

    public static void winScreen(String playerName) {
        UserInterface.clearScreen();

        int innerLength = playerName.length() + 39;

        UserInterface.winScreenBorderLine(innerLength);
        UserInterface.winScreenMiddleLine(innerLength);
        
        System.out.println("|     Congratulations, " + playerName + ", you won !      |");
        
        UserInterface.winScreenMiddleLine(innerLength);
        UserInterface.winScreenBorderLine(innerLength);
    }

    private static void winScreenBorderLine(int length) {
        System.out.print("+");
        for(int i=0; i<length; i++)
            System.out.print("-");
        System.out.println("+");
    }

    private static void winScreenMiddleLine(int length) {
        System.out.print("|");
        for(int i=0; i<length; i++)
            System.out.print(" ");
        System.out.println("|");
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
*/