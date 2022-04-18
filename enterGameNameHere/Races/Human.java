package enterGameNameHere.Races;

import java.util.Random;

import enterGameNameHere.Physcial_Damage.Physical;
import enterGameNameHere.Physcial_Damage.Pspell;

public class Human extends Good implements Physical {
    public final Pspell spellHum[] = new Pspell[3];
    protected String name;

    /**
     * Construcor , to create an human
     * @param specie
     * @param name
     * @param strength
     * @param element
     */
    public Human( String specie , String name , int strength , String element ){
        super(specie ,strength,element);
        this.name = name;
    }

    @Override
    public int getSpellSpeedAtPosition(int position){
        return this.spellHum[position].getSpeed();
    }

    @Override
    public int getDamageAtPosition(int position){
        return this.spellHum[position].getAp() + getStrength();
    }

    @Override
    public void getPspell(){
        Random rd = new Random();
        for (int i = 0 ; i < 3 ; i++){
            spellHum[i+1] = Physical.pspell[rd.nextInt(7)];
        }
    }


    /**
     * Display the spell of this human
     */
    @Override
    public void spellDisplay(){
        System.out.println("Your actual spell are :");
        for (int i = 0 ; i < 3 ; i++){
            System.out.println((i+1) + " : " + this.spellHum[i]);
        }
    }



}
