package enterGameNameHere.Races;

import java.util.Scanner;

public abstract class Good extends Entity {
    
    public Good(String specie , int strength , String element){
        super(specie , strength , element);
    }

    abstract public void spellDisplay();

    public void moveTo(){

    }

    @Override
    public int spellChoice(Scanner scan){
        this.spellDisplay();
        System.out.println("Which spell do you want to use ?");
        return scan.nextInt() - 1; // Exception à faire !!!
        
    }

}
