package enterGameNameHere.Races;

import java.util.Scanner;

import enterGameNameHere.ErrorGame;
import enterGameNameHere.ExitGame;

public abstract class Good extends Entity {
    protected String name;

    /** 
     * Display the spell of the character
     */
    abstract public void spellDisplay();

    /**
     * Create a good entity and letting the user to set the name
     * @param scan
     */
    public Good(Scanner scan){
        super();
        setName(scan);
    }

    /**
     * Allow the user to set the name of the choosen character manually
     * @param scan
     */
    public void setName(Scanner scan){
        System.out.println("Please enter your name");
        System.out.print(">>>");
        this.name = scan.nextLine();
    }

    public String getName(){
        return this.name;
    }
    
    @Override
    public int spellChoice(Scanner scan) throws ErrorGame, ExitGame{
        this.spellDisplay();
        System.out.println("Which spell do you want to use ?");
        String input = scan.nextLine(); 
        if(input.equals("exit"))
            throw new ExitGame();
        else if(!input.equals("1") && !input.equals("2") && !input.equals("3"))
            throw new ErrorGame("Please enter a correct spell to cast !");
        return Integer.parseInt(input) - 1;
    }
}
