package enterGameNameHere;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

import enterGameNameHere.Races.*;
 
public class Battle {
   /**
    * Allow 2 entities to fight
    * @param player
    * @param ennemy
    * @param scan
    */ 
    public Battle(Good player , Evil ennemy , Scanner sc ){
        int pSpell = 0 , eSpell = 0 ;
        boolean faster;
        System.out.println("You are actually fighting a "+ennemy.getSpecieName()+" !");
        while (!this.checkEnd(player.getHp(), ennemy.getHp())){
            ennemy.spellChoice(sc);
            System.out.println("You still have : " + player.getHp() + " HP | Your ennemy has still : " + ennemy.getHp() +" HP");
            pSpell = player.spellChoice(sc);
            faster = isPlayerFaster(player, ennemy, pSpell, eSpell);
            try {
                round(player, ennemy, pSpell, eSpell, faster);
            } catch (Errors e) {
                //TODO: handle exception
            } ;
        }
        this.battleEnd(player.getHp(), ennemy.getHp());
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

    public boolean checkEnd(int playerHp , int ennemyHp){
        return playerHp <= 0 || ennemyHp <= 0 ;
    }

    public void battleEnd(int playerHp , int ennemyHp){
        if (playerHp > ennemyHp) System.out.println("You won");
        else System.out.println("You lost");
    }

    public void round (Good player , Evil ennemy , int pSpell , int eSpell , boolean faster) throws Errors{
        if (faster){
            player.attack(ennemy , addDamage((Entity)player, pSpell));
            System.out.println("Ennemy has lost : "+ addDamage((Entity)player, pSpell));
            if (this.checkEnd(player.getHp(), ennemy.getHp()))
                throw new Errors("Battle ended");
            ennemy.attack(player, addDamage((Entity)ennemy, eSpell));
            System.out.println("You lost : "+ addDamage((Entity)ennemy, eSpell));
        }
        else{
            ennemy.attack(player, addDamage((Entity)ennemy, eSpell));
            System.out.println("You lost : "+ addDamage((Entity)ennemy, eSpell));
            if (this.checkEnd(player.getHp(), ennemy.getHp()))
                throw new Errors("Battle ended");
            player.attack(ennemy ,addDamage((Entity)player, pSpell));
            System.out.println("Ennemy has lost : "+ addDamage((Entity)player, pSpell));
        }
    }
    public boolean isPlayerFaster(Good player , Evil ennemy , int pSpell , int eSpell) {
        int pSpeed = player.getSpellSpeedAtPosition(pSpell);
        int eSpeed = ennemy.getSpellSpeedAtPosition(eSpell);
        
        if (pSpeed > eSpeed) return true;
        else return false;
    }

    public int addDamage(Entity character , int spell){
          return character.getDamageAtPosition(spell);
    }

    /**
     * Easier to write than System.out.println, do the same thing but faster
     * @param string
     */
    public void printf(String string){
        System.out.println(string);
    }
}
