package enterGameNameHere.Races;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import enterGameNameHere.Magic.Magic;
import enterGameNameHere.Magic.Spell;

public class Elf extends Good implements Magic {
    public final static String elementList[] = {"fire","water","grass"};
    private Spell spellElf[] = new Spell[3];

    /**
     * Constructor that creates an elf and attributes spells randomly
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
        ArrayList<Integer> tempArray = new ArrayList<>();
        int temp;
        for (int i = 0 ; i < 3 ; i++){
            temp = rd.nextInt(27);
            while(tempArray.contains(temp)){
                temp = rd.nextInt(27);
            }
            tempArray.add(temp);
            spellElf[i] = Magic.spell[temp];
        }
    }

    @Override
    public void spellDisplay(){
        System.out.println("Your current spells are :\n");
        for (int i = 0 ; i < 3 ; i++){
            System.out.println((i+1) + ": " + this.spellElf[i].getSpellName() + " [Attack power: " + this.spellElf[i].getAp() + " | " + "Speed: " + this.spellElf[i].getSpeed() + " | " + "Element: " + this.spellElf[i].getElement() + "]");
        }
        System.out.println("");
    }

    @Override
    public String getSpellElementAtPosition(int position){
        return this.spellElf[position].getElement();
    }
}
