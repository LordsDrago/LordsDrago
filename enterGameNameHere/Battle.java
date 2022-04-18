package enterGameNameHere;
import java.util.Random;
import java.util.Scanner;
import enterGameNameHere.Races.*;
 
public class Battle {
   /**
    * Allow 2 entities to fight
    * @param player
    * @param ennemy
    * @param scan
    */ 
    public Battle(Good player , Evil ennemy , Scanner sc ){
        Random rd = new Random();
        int pspell = 0 , espell = 0 , faster = 0;
        System.out.println("You are actually fighting a "+ennemy.getSpecieName()+" !");
        while ((player.getHp() > 0) && (ennemy.getHp() > 0)){
            espell = rd.nextInt(3);
            System.out.println("You still have : " + player.getHp() + " HP | Your ennemy has still : " + ennemy.getHp() +" HP");
            pspell = player.spellChoice(sc);
            if (player instanceof Human)
                faster = whoPfaster((Entity)player, (Entity)ennemy, pspell, espell);
            else
                faster = whoMfaster((Entity)player, (Entity)ennemy, pspell, espell);

            if (faster == 1){
                player.attack(ennemy , addDamage((Entity)player, pspell));
                ennemy.attack(player, addDamage((Entity)ennemy, espell));
            }
            else{
                ennemy.attack(player, addDamage((Entity)ennemy, espell));
                player.attack(ennemy ,addDamage((Entity)player, pspell));
            }
            
        }
        if (player.getHp() > ennemy.getHp())
            printf("You won ! ");
        else
            printf("Too bad ! You lost !");
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
                if (elementE == "fire" || elementE == "physical"  ) return 1;
                if (elementE == "grass" ) return 2;
            case "water":
                if (elementE == "grass" ) return 0;
                if (elementE == "water" || elementE == "physical" ) return 1;
                if (elementE == "fire"  ) return 2;
            case "grass":
                if (elementE == "fire"  ) return 0;
                if (elementE == "grass" || elementE == "physical" ) return 1;
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
            if ( ((Human)player).spellHum[pspell].getSpeed() > ((Goblin)ennemy).spellGob[espell].getSpeed() )
                return 1;
            else
                return 2;
        }
    }

    public int whoMfaster(Entity player , Entity ennemy , int pspell , int espell){
        if (ennemy instanceof Orc){
            if (((Elf)player).spellElf[pspell].getSpeed() > ((Orc)ennemy).spellOrc[espell].getSpeed() ) 
                return 1;
            else 
                return 2;
        }
        else{
            if ( ((Elf)player).spellElf[pspell].getSpeed() > ((Elf)ennemy).spellElf[espell].getSpeed() )
                return 1;
            else
                return 2;
        }
    }   

    public int addDamage(Entity character , int spell){
        int damage =  0 ;
        if (character instanceof Elf)
            damage = character.getStrength() + ((Elf)character).spellElf[spell].getAp();
        else if (character instanceof Goblin)
            damage = character.getStrength() + ((Goblin)character).spellGob[spell].getAp();
        else if (character instanceof Human)
            damage = character.getStrength() + ((Human)character).spellHum[spell].getAp();
        else if (character instanceof Orc)
            damage = character.getStrength() + ((Orc)character).spellOrc[spell].getAp();
        return damage;    
    }

    /**
     * Easier to write than System.out.println, do the same thing but faster
     * @param string
     */
    public void printf(String string){
        System.out.println(string);
    }
}
