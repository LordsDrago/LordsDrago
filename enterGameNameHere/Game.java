package enterGameNameHere;

import enterGameNameHere.Races.*;
import enterGameNameHere.Terrain.Floor;

public class Game {
    protected Floor curFloor;
    protected int floorsLeft = 3;
    protected Good player = new Human("Pute", "Allan", 0, "Sexe");

    /**
     * Base constructor for a game
     */
    public Game(){
        this.curFloor = new Floor(player);
    }

    /**
     * Displays the current floor of the game
     */
    public void displayCurrentFloor() {
        this.curFloor.displayFloor();
    }

    /**
     * Advances the game to the next floor, cannot exceed a value of 2, as there are only 3 floors
     */
    public void advanceFloor() {
        this.floorsLeft--;
        if(this.floorsLeft > 0)
            this.curFloor = new Floor(player);
    }

    public void movePlayer(String direction) {
        try {
            this.curFloor.movePlayer(direction);
        } catch (Errors e) {
            System.out.println(e.getMessage());
        }
            
    }
}
