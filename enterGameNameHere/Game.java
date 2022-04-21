package enterGameNameHere;

import java.io.Serializable;
import java.util.Scanner;

import enterGameNameHere.Races.*;
import enterGameNameHere.Terrain.Floor;

public class Game implements Serializable{
    protected Floor curFloor;
    protected int floorsLeft = 3;
    protected Good player;

    /**
     * Base constructor for a game
     */
    public Game(Scanner scan){
        boolean playerNotCreated = true;
        while(playerNotCreated)
            try {
                if(UserInterface.chooseRace(scan).equals("human"))
                    this.player = new Human(scan);
                else
                    this.player = new Elf(scan);
                playerNotCreated = false;
                } catch (ErrorGame wrongRaceInput) {
                    UserInterface.printException(wrongRaceInput.getMessage());
                }
        
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
        } catch (ErrorGame cannotMoveToWall) {
            UserInterface.printException(cannotMoveToWall.getMessage());
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
     * @throws ErrorGame if the player loses, to signify the end of the game
     */
    public void checkBattle(Scanner scan) throws ErrorGame, ExitGame {
        if(this.curFloor.checkIsMonster()){
            Evil curMonster;
            for(Evil monster: this.curFloor.getMonsters())
                if(monster.getPoint().getY() == this.player.getPoint().getY() && monster.getPoint().getX() == this.player.getPoint().getX()){
                    curMonster = monster;
                    try {
                        new Battle(this.player, curMonster, scan);
                        this.curFloor.removeMonster(this.player.getPoint().getY(), this.player.getPoint().getX());
                    } catch (ErrorGame playerLost) {
                        System.out.println(playerLost.getMessage());
                        throw new ErrorGame("gameEnd");
                    } catch (ExitGame gameExit) {
                        throw new ExitGame();
                    }
                    
                }
        }       
    }

    /**
     * The main body of the game, which specifies what happens in which order
     * @param scan the System.in scanner
     */
    public void gameHandling(Scanner scan) throws ExitGame {
        while(this.getFloorsLeft() != 0){
            try {
                this.checkBattle(scan);
            } catch (ErrorGame playerLost) {
                break;
            } catch (ExitGame gameExit) {
                throw new ExitGame();
            }

            UserInterface.clearScreen();
            this.displayCurrentFloor();

            try {
                movePlayer(UserInterface.selectMove(scan));
            } catch (ErrorGame wrongMoveInput) {
                UserInterface.printException(wrongMoveInput.getMessage());
            } catch (ExitGame playerExitsGame) {
                throw new ExitGame();
            }
            this.checkAdvanceFloor();
        }
        if(this.getFloorsLeft() == 0)
            UserInterface.winScreen(this.player.getName());
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
