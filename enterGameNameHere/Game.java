package enterGameNameHere;

import java.util.Scanner;

import enterGameNameHere.Races.*;
import enterGameNameHere.Terrain.Floor;

public class Game {
    protected Floor curFloor;
    protected int floorsLeft = 3;
    protected Good player;

    /**
     * Base constructor for a game
     */
    public Game(Scanner scan){
        this.curFloor = new Floor(player);
        this.player = new Human(scan);
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

    public void checkAdvanceFloor() {
        if(this.curFloor.checkIsEnd())
            this.advanceFloor();
    }

    public void checkBattle(Scanner scan) {
        if(this.curFloor.checkIsMonster()){
            Evil curMonster;
            for(Evil monster: this.curFloor.getMonsters())
                if(monster.getPoint().getY() == this.player.getPoint().getY() && monster.getPoint().getX() == this.player.getPoint().getX()){
                    curMonster = monster;
                    new Battle(this.player, curMonster, scan);
                }
        }       
    }
}
