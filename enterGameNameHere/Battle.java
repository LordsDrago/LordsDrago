package enterGameNameHere;
import java.util.Scanner;
import enterGameNameHere.Races.*;
 
public class Battle {
   /**
    * Allow 2 entities to fight
    * @param player
    * @param ennemy
    * @param scan
    */
    public void battle(Entity player , Entity ennemy , Scanner scan ){
        int pspell = 0 , espell = 0 , faster = 0;
        System.out.println("You are actually fighting a "+ennemy.getSpecieName()+" !");
        while ((player.getHp() > 0) && (ennemy.getHp() > 0)){
            if (player instanceof Human){
                ((Human)player).PspellDisplay();
                faster = whoPfaster(player, ennemy, pspell, espell);
                if (faster == 1){
                    player.attack(ennemy , 20);
                }
            }
            else{


            }
        }
    }

    /**
     * Allow to see how much damage the element do to the ennemy
     * @param elementP
     * @param elementE
     * @return 0 , 1 or 2
     */
    public static int isElement(String elementP , String elementE){
        switch(elementP){
            case "fire":
                if (elementE == "water" ) return 0;
                if (elementE == "fire" || elementE == "physcial"  ) return 1;
                if (elementE == "grass" ) return 2;
            case "water":
                if (elementE == "grass" ) return 0;
                if (elementE == "water" || elementE == "physcial" ) return 1;
                if (elementE == "fire"  ) return 2;
            case "grass":
                if (elementE == "fire"  ) return 0;
                if (elementE == "grass" || elementE == "physcial" ) return 1;
                if (elementE == "water" ) return 2;
        }
        return -1;
    }

    /**
     * Allow to see which entity's spell is faster
     * @param player
     * @param ennemy
     * @param pspell
     * @param espell
     * @return "1" if the player is faster and "2" if the monster is faster
     */
    public int whoPfaster(Entity player , Entity ennemy , int pspell , int espell ){
        if (ennemy instanceof Orc){
            if ( ((Human)player).spellHum[pspell].getSpeed() > ((Orc)ennemy).spellOrc[espell].getSpeed() ) 
                return 1;
            else 
                return 2;
        }
        else{
            if ( ((Human)player).spellHum[pspell].getSpeed() > ((Elf)ennemy).spellElf[espell].getSpeed() )
                return 1;
            else
                return 2;
        }
    }

    public int addDamage(Entity character , int spell){
        int test =  0 ;
        if (character instanceof Elf)
            test = character.getStrength();
        return test;
         
    }

    /**
     * Easier to write than System.out.println, do the same thing but faster
     * @param string
     */
    public void printf(String string){
        System.out.println(string);
    }
}
