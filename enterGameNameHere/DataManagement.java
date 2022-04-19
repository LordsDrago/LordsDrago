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
    public void saveGames() throws ErrorGame{
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

        } catch (FileNotFoundException e) {
            throw new ErrorGame("File 'gameData.txt' not found !");
        } catch (IOException e) {
            throw new ErrorGame("Games data could not be saved to the file 'gameData.txt' !");
        }

        System.out.println("Games saved successfully !");
    }

    /**
     * Loads the games from a predefined .txt file
     * @return the games load in an ArrayList
     * @throws ErrorGame if the load is not successful, for various reasons
     */
    public void loadGames() throws ErrorGame{
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
    }

    public ArrayList<Game> getGames() {
        return this.allGames;
    }

    public void addGame(Scanner scan) {
        this.allGames.add(new Game(scan));
    }

    // TODO Launch selected game (with index)
    // TODO when game ends, see if game is added to saved data
}
