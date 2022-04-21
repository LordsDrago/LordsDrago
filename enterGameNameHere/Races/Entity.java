package enterGameNameHere.Races;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import enterGameNameHere.ErrorGame;
import enterGameNameHere.ExitGame;
import enterGameNameHere.NotUserInterface;
import enterGameNameHere.Terrain.*;


public abstract class Entity implements Serializable {
    protected String adjective;
    protected int strength;
    protected int maxHp;
    protected int curHp;
    protected Point position;
    protected String element; // Ceci est un humain de type FEU allez sur le lien : https://github.com/LordsDrago/Projet-Advanced-Prog
    private final static Adjective[] adjectiveList = {Adjective.BLOODTHIRSTY, Adjective.BRAVE, Adjective.COURAGEOUS, Adjective.DRUNK, Adjective.FABULOUS, Adjective.FAYAD, Adjective.FLATEARTHER, Adjective.HIDEOUS, Adjective.HORRIBLE, Adjective.INSANE, Adjective.SHAMEFUL, Adjective.TERRIFIC};

    /**
    * Allow to get the speed of the chosen spell
    * @param position
    * @return The speed of the spell
    */
    abstract public int getSpellSpeedAtPosition(int position);

    /**
    * Allow to see the total damage given to the ennemy
    * @param position
    * @return The total damage with the entity stat
    */
    abstract public int getSpellDamageAtPosition(int position);

    /**
     * Allow to get the element of the spell at the given position
     * @param position
     * @return
     */
    abstract public String getSpellElementAtPosition(int position);

    /**
    * Allow to choose the spell
    * @param scan
    * @return The index of the chosen spell
    */
    public abstract int spellChoice(Scanner scan) throws ErrorGame, ExitGame;

    /**
    * Setting the entity Strength
    * @param strength
    */
    abstract public void setStrength();

    /**
    * Setting the entity HP
    * @param hp
    */
    abstract public void setHp();

    /**
    * Setting elements for the current entity
    * @param element
    */
    abstract public void setElement();

    /**
     * Sets all the entities attributes
     */
    public Entity(){
        setAdjective();
        setHp();
        setStrength();
        setElement();
    }

    /**
     * Sets the entities adjective randomly
     */
    public void setAdjective(){
        Random rd = new Random();
        this.adjective = adjectiveList[rd.nextInt(12)].getAdjective();
    }

    /**
    * Give the current species name
    * @return The current species name
    */
    public String getAdjective(){
        return this.adjective;
    }

    /**
    * Give the HP of the entity
    * @return The current HP
    */
    public int getHp(){
      return this.curHp;
    }

    /**
     * Give back the full HP to the entity
     */
    public void putMaxHp() {
      System.out.println("You have been healed and gained back all of your HP !");
      this.curHp = this.maxHp;
      NotUserInterface.wait(3);
    }

    /**
    * Give the strength of the entity
    * @return The current strength
    */
    public int getStrength(){
        return this.strength;
    }

    /**
    * Setting a position
    * @param newPosition
    */
    public void setPoint(Point newPosition){
        this.position = newPosition;
    }

    /**
    * Getting the position of the new
    * @return
    */
    public Point getPoint(){
        return this.position;
    }


    /**
    * Getting the element of the current entity
    * @return The element of the character
    */
    public String getElement(){
        return this.element;
    }

    /**
     * Allow to attack another entity
     * @param ennemy
     * @param damage
     */
    public void attack(Entity ennemy , int damage){
        ennemy.curHp -= damage;  
    }

}
