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
        if(userInterface.chooseRace(scan).equals("human"))
            this.player = new Human(scan);
        else
            this.player = new Elf(scan);
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
        if(this.floorsLeft > 0){
            this.player.putMaxHp();
            this.curFloor = new Floor(player);
        }
    }

    /**
     * Gets the number of floors left
     * @return the int with the number of floors left
     */
    private int getFloorsLeft(){
        return this.floorsLeft;
    }

    /**
     * Executes the movePlayer method of the current floor
     * @param direction the String with the direction wanted by the player
     */
    public void movePlayer(String direction) {
        try {
            this.curFloor.movePlayer(direction);
        } catch (Errors e) {
            System.out.println(e.getMessage());
        }
            
    }

    /**
     * Checks if the end of the floor is reached
     */
    public void checkAdvanceFloor() {
        if(this.curFloor.checkIsEnd())
            this.advanceFloor();
    }

    /**
     * Handles the case where a monster is present on the current point, by retrieving it and starting a Battle
     * @param scan the System.in scanner
     * @throws Errors if the player loses, to signify the end of the game
     */
    public void checkBattle(Scanner scan) throws Errors {
        if(this.curFloor.checkIsMonster()){
            Evil curMonster;
            for(Evil monster: this.curFloor.getMonsters())
                if(monster.getPoint().getY() == this.player.getPoint().getY() && monster.getPoint().getX() == this.player.getPoint().getX()){
                    curMonster = monster;
                    try {
                        new Battle(this.player, curMonster, scan);
                    } catch (Errors e) {
                        System.out.println(e.getMessage());
                        throw new Errors("gameEnd");
                    }
                    
                }
        }       
    }

    /**
     * The main body of the game, which specifies what happens in which order
     * @param scan the System.in scanner
     */
    public void gameHandling(Scanner scan) {
        while(this.getFloorsLeft() != 0){
            this.displayCurrentFloor();
            movePlayer(userInterface.selectMove(scan));
            try {
                this.checkBattle(scan);
            } catch (Exception e) {
                break;
            }
            this.checkAdvanceFloor();
        }
    }

    /**
     * Prints the info of the given game
     */
    public void printGameInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Floors left : " + this.floorsLeft + " / Race : " + this.player.getClass().getSimpleName() + " / Name : " + this.player.getName() + " / HP : " + this.player.getHp() + " / Element : " + this.player.getElement();
    }
}
