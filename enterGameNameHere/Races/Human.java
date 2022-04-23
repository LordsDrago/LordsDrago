package enterGameNameHere.Races;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import enterGameNameHere.Physical_Damage.Physical;
import enterGameNameHere.Physical_Damage.PSpell;

public class Human extends Good implements Physical{
    public PSpell spellHum[] = new PSpell[3];
    
    /**
     * Constructor that creates a human and attributes spells randomly
     * @param scan
     */
    public Human(Scanner scan){
        super(scan);
        this.getPspell();
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
        this.element = "physical";
    }

    @Override
    public int getSpellSpeedAtPosition(int position){
        return this.spellHum[position].getSpeed();
    }

    @Override
    public int getSpellDamageAtPosition(int position){
        return this.spellHum[position].getAp() + getStrength();
    }

    @Override
    public void getPspell(){
        Random rd = new Random();
        ArrayList<Integer> tempArray = new ArrayList<>();
        int temp;
        for (int i = 0 ; i < 3 ; i++){
            temp = rd.nextInt(7);
            while(tempArray.contains(temp)){
                temp = rd.nextInt(7);
            }
            tempArray.add(temp);
            spellHum[i] = Physical.spells[temp];
        }
    }

    @Override
    public String getSpellElementAtPosition(int position){
        return this.spellHum[position].getElement();
    }

    @Override
    public void spellDisplay(){
        System.out.println("Your current spell are :\n");
        for (int i = 0 ; i < 3 ; i++){
            System.out.println((i+1) + ": " + this.spellHum[i].getPSpellName()+ " [Attack power: " + this.spellHum[i].getAp() + " | " + "Speed: " + this.spellHum[i].getSpeed() + " | " + "Element: " + this.spellHum[i].getElement() + "]");
        }
        System.out.println("");
    }
}
