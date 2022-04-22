package enterGameNameHere;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManagement implements Serializable {

    protected ArrayList<Game> allGames = new ArrayList<>();

    /**
     * Saves the games in a predefined .txt file
     * @param games the ArrayList of games to be saved, in a limit of 3 games
     * @throws ErrorGame if the save is not successful, for various reasons
     */
    private void saveGames() throws ErrorGame{
        File dataFile = new File(".\\gameData.txt");

        try {
            dataFile.createNewFile();
        } catch (IOException e) {
            throw new ErrorGame("File 'gameData.txt' could not be created !");
        } 

        try (
            FileOutputStream outputStream = new FileOutputStream(dataFile);
            ObjectOutputStream dataSavingStream = new ObjectOutputStream(outputStream);
        ) {
            
            for(int i=0; i<this.allGames.size(); i++)
                dataSavingStream.writeObject(this.allGames.get(i));

            dataSavingStream.flush();
        } catch (FileNotFoundException e) {
            throw new ErrorGame("File 'gameData.txt' not found !");
        } catch (IOException e) {
            throw new ErrorGame("Games data could not be saved to the file 'gameData.txt' !");
        }

        System.out.println("Games saved successfully !");
        UserInterface.wait(3);
    }

    /**
     * Loads the games from a predefined .txt file
     * @return the games load in an ArrayList
     * @throws ErrorGame if the load is not successful, for various reasons
     */
    private void loadGames() throws ErrorGame{
        ArrayList<Game> games = new ArrayList<>();
        File dataFile = new File(".\\gameData.txt");

        try (
            FileInputStream inputStream = new FileInputStream(dataFile);
            ObjectInputStream dataLoadingStream = new ObjectInputStream(inputStream);
        ){
            while (true) {
                games.add((Game)dataLoadingStream.readObject());
            }
        } catch (FileNotFoundException e) {
            throw new ErrorGame("File 'gameData.txt' not found !");
        } catch (EOFException f) {
            while (games.size() > 3) {
                games.remove(games.size() - 1);
            }
        } catch (IOException g) {
            throw new ErrorGame("Games data could not be loaded from the file 'gameData.txt' !");
        } catch (ClassNotFoundException h) {
            throw new ErrorGame("File 'gameData.txt' corrupted ! Please delete it or overwrite the contents with a new save !");
        }
        
        this.allGames = games;
        System.out.println("Games loaded successfully !");
        UserInterface.wait(3);
    }

    /**
     * Adds a game the ArrayList of Games
     * @param scan the System.in scanner
     */
    private void addGame(Scanner scan) {
        this.allGames.add(new Game(scan));
    }

    /**
     * Launches a game and handles the event that happens at either the end or the exit of the game
     * @param index the position of the game in the temporary memory (ArrayList of Games)
     * @param scan the System.in scanner
     */
    private void launchGame(int index, Scanner scan) {
        try {
            this.allGames.get(index).gameHandling(scan);
            this.allGames.remove(index);
        } catch (ExitGame gameExit) {
            int gameToRemove;
            if(this.allGames.size() > 3){
                gameToRemove = UserInterface.displayCurrentGame(this.allGames, scan);
                if (gameToRemove==0) gameToRemove = 4;
                gameToRemove--;
                this.allGames.remove(gameToRemove);
            }
                
        }
    }

    /**
     * Creates a new game and launches it
     * @param scan the System.in scanner
     */
    private void newGame(Scanner scan) {
        addGame(scan);
        launchGame(this.allGames.size() - 1, scan);
    }

    /**
     * Takes an index to play the selected saved game from the temporary memory
     * @param scan the System.in scanner
     * @throws ErrorGame if the game selected is wrong
     */
    private void playSavedGame(Scanner scan) throws ErrorGame{
        if (this.allGames.size() == 0)
            throw new ErrorGame("No game in memory !");
            
        UserInterface.clearScreen();
        UserInterface.displaySavedGame(this.allGames);
        int choice; 
        try {
            choice = UserInterface.menuChoice(scan, this.allGames.size(), "Select a game to play", "Please select a valid game !", false)-1;
            launchGame(choice, scan);
        } catch (ErrorGame wrongInput) {
            UserInterface.printException(wrongInput.getMessage());
        }
        
    }

    /**
     * The game menu, which allows every feature to be accessed from there
     * @param scan the System.in scanner
     */
    public void menu(Scanner scan) {
        boolean notExit = true;
        while(notExit){
            UserInterface.gameMenu();
            try {
                int choice = UserInterface.menuChoice(scan, 5, "Select an action to do", "Please select a valid option !", false);
                switch (choice) {
                    case 1:
                        this.newGame(scan);
                        break;
                    case 2:
                        this.playSavedGame(scan);
                        break;
                    case 3:
                        this.loadGames();
                        break;
                    case 4:
                        this.saveGames();
                        break;
                    case 5:
                        notExit = false;
                        break;
                }
            } catch (Exception wrongInput) {
                UserInterface.printException(wrongInput.getMessage());
            }
        }
    }
}
