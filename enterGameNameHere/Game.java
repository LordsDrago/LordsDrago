package enterGameNameHere;

import enterGameNameHere.Terrain.Floor;

public class Game {
    protected Floor[] gameMap;
    protected int curFloor = 0;

    public Game(){
        this.gameMap = new Floor[] {new Floor(), new Floor(), new Floor()};
    }

    public void displayCurrentFloor() {
        this.gameMap[this.curFloor].displayFloor();
    }

    public void advanceFloor() {
        this.curFloor++;
    }
}
