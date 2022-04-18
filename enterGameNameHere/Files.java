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

public class Files implements Serializable {
    public void saveGames(ArrayList<Game> games) throws Errors{
        File dataFile = new File(".\\gameData.txt");

        try {
            dataFile.createNewFile();
        } catch (IOException e) {
            throw new Errors("File 'gameData.txt' could not be created !");
        } 

        try (
            FileOutputStream outputStream = new FileOutputStream(dataFile);
            ObjectOutputStream dataSavingStream = new ObjectOutputStream(outputStream);
        ) {
            
            for(int i=0; i<games.size() && i<3; i++)
                dataSavingStream.writeObject(games.get(i));

        } catch (FileNotFoundException e) {
            throw new Errors("File 'gameData.txt' not found !");
        } catch (IOException e) {
            throw new Errors("Games data could not be saved to the file 'gameData.txt' !");
        }

        System.out.println("Games saved successfully !");
    }

    public ArrayList<Game> loadGames() throws Errors{
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
            throw new Errors("File 'gameData.txt' not found !");
        } catch (EOFException f) {
            while (games.size() > 3) {
                games.remove(games.size() - 1);
            }
        } catch (IOException g) {
            throw new Errors("Games data could not be loaded from the file 'gameData.txt' !");
        } catch (ClassNotFoundException h) {
            throw new Errors("File 'gameData.txt' corrupted ! Please delete it or overwrite the contents with a new save !");
        }
        
        return games;
    }
}
