package enterGameNameHere.Races;
import java.util.Random;
import enterGameNameHere.Magic.Magic;
import enterGameNameHere.Magic.Spell;

public class Goblin extends Evil implements Magic {
    public final Spell spellGob[] = new Spell[3];
    public Goblin(String specie , int strength , String element){
        super(specie , strength , element);
    }
    
    @Override
    public void getSpell(){
        Random rd = new Random();
        for (int i = 0 ; i < 3 ; i++){
            spellGob[i] = Magic.spell[rd.nextInt(27)];
        }
    }

    
    @Override
    public int getSpellDamageAtPosition(int position){
        return this.spellGob[position].getAp() + getStrength();
    }

    @Override
    public int getSpellSpeedAtPosition(int position){
        return this.spellGob[position].getSpeed();
    }

    @Override
    public String getSpellElementAtPosition(int position){
        return this.spellGob[position].getElement();
    }
}
