package enterGameNameHere.Races;

import java.util.Scanner;

public abstract class Good extends Entity {
    protected String name;
    public Good(Scanner scan){
        super();
        setName(scan);
    }

    abstract public void spellDisplay();

    public void setName(Scanner scan){
        System.out.println("Please enter your name");
        System.out.print(">>>");
        this.name = scan.nextLine();
    }

    public void moveTo(){

    }
    
    @Override
    public int spellChoice(Scanner scan){
        this.spellDisplay();
        System.out.println("Which spell do you want to use ?");
        return scan.nextInt() - 1; // Exception à faire !!!
        
    }

}
