package enterGameNameHere;

import enterGameNameHere.Terrain.Floor;

public class Game {
    protected Floor[] gameMap;
    protected int curFloor = 0;

    /**
     * Base constructor for a game
     */
    public Game(){
        this.gameMap = new Floor[] {new Floor(), new Floor(), new Floor()};
    }

    /**
     * Displays the current floor of the game
     */
    public void displayCurrentFloor() {
        this.gameMap[this.curFloor].displayFloor();
    }

    /**
     * Advances the game to the next floor, cannot exceed a value of 2, as there are only 3 floors
     */
    public void advanceFloor() {
        if(this.curFloor + 1 < 3)
            this.curFloor++;
    }
}
