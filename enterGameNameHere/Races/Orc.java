package enterGameNameHere.Races;

import java.util.Random;

import enterGameNameHere.Physcial_Damage.Physical;
import enterGameNameHere.Physcial_Damage.Pspell;

public class Orc extends Evil implements Physical {

    public final Pspell spellOrc[] = new Pspell[3];
    public Orc(){
        super();
    }    

    @Override
    public void setStrength(){
        Random rd = new Random();
        this.strength = rd.nextInt(10);
    }

    @Override
    public void setHp(){
        Random rd = new Random();
        this.hp = rd.nextInt(20)+150; 
    }

    @Override
    public void setElement(){
        this.element = "physical";
    }

    @Override
    public void getPspell(){
        Random rd = new Random();
        for (int i = 0 ; i < 3 ; i++)
            spellOrc[i] = Physical.pspell[rd.nextInt(7)];
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

