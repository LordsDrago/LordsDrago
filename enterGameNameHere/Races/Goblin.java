package enterGameNameHere.Races;
import java.util.Random;
import enterGameNameHere.Magic.Magic;
import enterGameNameHere.Magic.Spell;

public class Goblin extends Evil implements Magic {
    public final static String elementList[] = {"fire","water","grass"};
    public final Spell spellGob[] = new Spell[3];

    /** 
     * Constructor, create a goblin and attribute spells randomly
     */
    public Goblin(){
        super();
        this.getSpell();
    }
    
    @Override
    public void setStrength(){
        Random rd = new Random();
        this.strength = rd.nextInt(10);
    }

    @Override
    public void setHp(){
        Random rd = new Random();
        this.maxHp = rd.nextInt(20)+150; 
        this.curHp = this.maxHp;
    }

    @Override
    public void setElement(){
        Random rd = new Random();
        this.element = elementList[rd.nextInt(3)];
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
