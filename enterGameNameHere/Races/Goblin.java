package enterGameNameHere.Races;
import java.util.Random;
import enterGameNameHere.Magic.Magic;
import enterGameNameHere.Magic.Spell;

public class Goblin extends Evil implements Magic {
    protected Spell spellgob[] = new Spell[3];
    public Goblin(String specie , int strength , String element){
        super(specie , strength , element);
    }
    
    @Override
    public void castSpell(Entity ennemy){
        
    }
    
    @Override
    public void getSpell(){
        Random rd = new Random();
        for (int i = 0 ; i < 3 ; i++){
            spellgob[i] = Magic.spell[rd.nextInt(27)];
        }
    }
}
