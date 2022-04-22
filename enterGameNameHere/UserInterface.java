package enterGameNameHere;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    /**
     * Prints the prompt to select a move to the user
     * @param scan the System.in scanner
     * @return the move selected by the user in a String ("z"/"q"/"s"/"d")
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
     * Prints the prompt to select a race to the user
     * @param scan the System.in scanner
     * @return the race chosen in a String ("elf"/"human")
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

    /**
     * Waits for the time given as parameter
     * @param seconds the number of seconds to wait
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {}
    }

    /**
     * Formats the way an exception is printed on the screen
     * @param exceptionMessage the error message to be printed on the screen
     */
    public static void printException(String exceptionMessage) {
        UserInterface.clearScreen();
        System.out.println(exceptionMessage);
        UserInterface.wait(3);
    }

    /**
     * Prints the winning screen
     * @param playerName the name given to the player
     */
    public static void winScreen(String playerName) {
        UserInterface.clearScreen();

        int innerLength = playerName.length() + 39;

        UserInterface.winScreenBorderLine(innerLength);
        UserInterface.winScreenMiddleLine(innerLength);
        
        System.out.println("|     Congratulations, " + playerName + ", you won !      |");
        
        UserInterface.winScreenMiddleLine(innerLength);
        UserInterface.winScreenBorderLine(innerLength);

        UserInterface.wait(3);
    }

    /**
     * Formats the first and last layers of the winning screen
     * @param length the length of the message that will be inside the borders
     */
    private static void winScreenBorderLine(int length) {
        System.out.print("+");
        for(int i=0; i<length; i++)
            System.out.print("-");
        System.out.println("+");
    }

    /**
     * Formats the second and second to last layers of the winning screen
     * @param length the length of the message that will be inside the borders
     */
    private static void winScreenMiddleLine(int length) {
        System.out.print("|");
        for(int i=0; i<length; i++)
            System.out.print(" ");
        System.out.println("|");
    }
    
    /**
     * Prints the main menu of the game
     */
    public static void gameMenu(){
        UserInterface.clearScreen();
        System.out.println("+-----------------------------+");
        System.out.println("|                             |");
        System.out.println("|         1.New game	      |");
        System.out.println("|     2.Play a saved game     |");
        System.out.println("|         3.Load games        |");
        System.out.println("|         4.Save games        |");
        System.out.println("|           5.Exit            |");
        System.out.println("|                             |");
        System.out.println("+-----------------------------+");
    }

    /**
     * Displays all the current games and prompts the user to choose a game to delete from them
     * @param allGames the ArrayList of games
     * @param scan the System.in scanner
     * @return the choice of the user for the game to be deleted
     */
    public static int displayCurrentGame(ArrayList<Game> allGames, Scanner scan){
        UserInterface.clearScreen();
        int temp = 0;
        for (int i = 0 ; i < allGames.size() ; i++){
            if (allGames.get(i).toString().length() > temp)
                temp = allGames.get(i).toString().length();
        }
        winScreenBorderLine(temp+24);
        System.out.print(">>> Your current game : ");
        allGames.get(allGames.size()-1).printGameInfo();
        displaySavedGame(allGames);
        winScreenBorderLine(temp+24);

        boolean choiceNotMade = true;
        int choice = 0;
        while(choiceNotMade){
            try {
                choice = UserInterface.menuChoice(scan, allGames.size()-1, "Which game do you want to erase ? (to erase current game, write 0)", "Enter a valid choice", true);
                choiceNotMade = false;
            } catch (ErrorGame wrongChoice) {}
        }
        return choice;
    }

    /**
     * Displays the first three games contained in the given ArrayList of Games
     * @param allGames the ArrayList of Games stored in the temporary memory
     */
    public static void displaySavedGame(ArrayList<Game> allGames){
        int temp = allGames.size();
        if (temp == 4) temp = 3;
        for (int i = 0 ; i < temp ; i++){
            System.out.print(">>> Save "+(i+1)+" : ");
            allGames.get(i).printGameInfo();
        }
    }

    /**
     * Asks the user to input a one-digit number to answer to the given prompt
     * @param scan the System.in scanner
     * @param upperLimit the upper limit of the choices available (cannot exceed 9)
     * @param prompt the String that will be displayed to ask the user to input a value
     * @param errorMsg the String that will be returned in the error when the input is wrong
     * @param includeZero a boolean, true if zero is a valid possibility, false if not
     * @return the int entered by the user
     * @throws ErrorGame if the input is wrong
     */
    public static int menuChoice(Scanner scan, int upperLimit, String prompt, String errorMsg, boolean includeZero) throws ErrorGame {
        String bottomLimit = "1";
        if (includeZero)
            bottomLimit = "0";
        String lengthString = String.valueOf(upperLimit);
        System.out.print("\n" + prompt + " \n>>> ");
        String input = scan.nextLine();
        if(input.compareTo(bottomLimit) < 0 || input.compareTo(lengthString) > 0 || input.length() > 1)
            throw new ErrorGame(errorMsg);
        return Integer.parseInt(input);
    }

}