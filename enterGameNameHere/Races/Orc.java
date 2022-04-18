package enterGameNameHere.Races;

import java.util.Random;

import enterGameNameHere.Physcial_Damage.Physical;
import enterGameNameHere.Physcial_Damage.Pspell;

public class Orc extends Evil implements Physical {
    public final Pspell spellOrc[] = new Pspell[3];
    public Orc(String specie , int strength, String element){
        super(specie, strength ,element);
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

