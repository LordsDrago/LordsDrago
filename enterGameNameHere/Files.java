package enterGameNameHere;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Files {
    public void saveGames(Game[] games) {
        Game temp;

        FileOutputStream outputStream = new FileOutputStream("./gameData.txt");

    }

    public Game[] loadGames() {
        Game temp;
        Game[] games;

        FileInputStream outputStream = new FileInputStream("./gameData.txt");

        return games;
    }
}
