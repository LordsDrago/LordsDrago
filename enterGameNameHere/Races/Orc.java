package enterGameNameHere.Races;

import java.util.ArrayList;
import java.util.Random;

import enterGameNameHere.Physcial_Damage.Physical;
import enterGameNameHere.Physcial_Damage.Pspell;

public class Orc extends Evil implements Physical {
    public final Pspell spellOrc[] = new Pspell[3];

    /**
     * Constructor, allow to create an Orc and giving randomly spells
     */
    public Orc(){
        super();
        this.getPspell();
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
        this.element = "physical";
    }

    @Override
    public void getPspell(){
        Random rd = new Random();
        ArrayList<Integer> tempA = new ArrayList<>();
        int temp;
        for (int i = 0 ; i < 3 ; i++){
            temp = rd.nextInt(7);
            while(tempA.contains(temp)){
                temp = rd.nextInt(7);
            }
            tempA.add(temp);
            spellOrc[i] = Physical.pspell[temp];
        }
    }

    @Override
    public int getSpellDamageAtPosition(int position){
        return this.spellOrc[position].getAp() + getStrength();
    }

    @Override
    public int getSpellSpeedAtPosition(int position){
        return this.spellOrc[position].getSpeed();
    }

    @Override
    public String getSpellElementAtPosition(int position){
        return this.spellOrc[position].getElement();
    }
}

