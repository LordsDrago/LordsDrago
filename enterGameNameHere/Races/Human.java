package enterGameNameHere.Races;

import java.util.Random;
import java.util.Scanner;

import enterGameNameHere.Physcial_Damage.Physical;
import enterGameNameHere.Physcial_Damage.Pspell;

public class Human extends Good implements Physical {
    public final Pspell spellHum[] = new Pspell[3];
    

    /**
     * Construcor , to create an human
     * @param specie
     * @param name
     * @param strength
     * @param element
     */
    public Human(Scanner scan){
        super(scan);
    }

    @Override
    public void setStrength(){
        Random rd = new Random();
        this.strength = rd.nextInt(15);
    }

    @Override
    public void setHp(){
        Random rd = new Random();
        this.hp = rd.nextInt(50)+300; 
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
        for (int i = 0 ; i < 3 ; i++){
            spellHum[i+1] = Physical.pspell[rd.nextInt(7)];
        }
    }

    @Override
    public String getSpellElementAtPosition(int position){
        return this.spellHum[position].getElement();
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
