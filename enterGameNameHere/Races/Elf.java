package enterGameNameHere.Races;
import java.util.Random;
import java.util.Scanner;
import enterGameNameHere.Magic.Magic;
import enterGameNameHere.Magic.Spell;

public class Elf extends Good implements Magic {
    public final static String elementList[] = {"fire","water","grass"};
    public final Spell spellElf[] = new Spell[3];

    /**
     * Constructor for an elf, it create an entity elf and attribute spells randomly
     * @param scan
     */
    public Elf(Scanner scan){
        super(scan);
        this.getSpell();
    }

    @Override
    public void setStrength(){
        Random rd = new Random();
        this.strength = rd.nextInt(15);
    }

    @Override
    public void setHp(){
        Random rd = new Random();
        this.maxHp = rd.nextInt(50)+500; 
        this.curHp = this.maxHp;
    }

    @Override
    public void setElement(){
        Random rd = new Random();
        this.element = elementList[rd.nextInt(3)];
    }

    @Override
    public int getSpellDamageAtPosition(int position){
        return this.spellElf[position].getAp() + getStrength();
    }

    @Override
    public int getSpellSpeedAtPosition(int position){
        return this.spellElf[position].getSpeed();
    }

    @Override
    public void getSpell(){
        Random rd = new Random();
        for (int i = 0 ; i < 3 ; i++){
            spellElf[i] = Magic.spell[rd.nextInt(27)];
        }
    }

    @Override
    public void spellDisplay(){
        System.out.println("Your actual spell are :");
        for (int i = 0 ; i < 3 ; i++){
            System.out.println((i+1) + " : " + this.spellElf[i]);
        }
    }

    @Override
    public String getSpellElementAtPosition(int position){
        return this.spellElf[position].getElement();
    }
}
