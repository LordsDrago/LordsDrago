package enterGameNameHere.Races;

import java.util.ArrayList;
import java.util.Random;

import enterGameNameHere.Physical_Damage.Physical;
import enterGameNameHere.Physical_Damage.Pspell;

public class Orc extends Evil implements Physical {
    public Pspell spellOrc[] = new Pspell[3];

    /**
     * Constructor, allow to create an Orc and give random spells
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
        ArrayList<Integer> tempArray = new ArrayList<>();
        int temp;
        for (int i = 0 ; i < 3 ; i++){
            temp = rd.nextInt(7);
            while(tempArray.contains(temp)){
                temp = rd.nextInt(7);
            }
            tempArray.add(temp);
            spellOrc[i] = Physical.pSpell[temp];
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

