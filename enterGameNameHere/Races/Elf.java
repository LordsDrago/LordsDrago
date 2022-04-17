package enterGameNameHere.Races;
import java.util.Random;
import java.util.random.*;
import enterGameNameHere.Magic.Magic;
import enterGameNameHere.Magic.Spell;

public class Elf extends Good implements Magic {
    protected String name;
    protected Spell spellelf[] = new Spell[3];

    public Elf( String specie , String name , int strength , String element ){
        super(specie ,strength , element);
        this.name = name;
    }

    @Override
    public void castSpell(){
        
    }

    @Override
    public void getSpell(){
        Random rd = new Random();
        for (int i = 0 ; i < 3 ; i++){
            spellelf[i] = Magic.spell[rd.nextInt(27)];
        }
    }

    public void spellDisplay(){
        System.out.println("Your actual spell are :");
        for (int i = 0 ; i < 3 ; i++){
            System.out.println(this.spellelf[i]);
        }
    }
}
