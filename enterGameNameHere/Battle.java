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
    public Battle(Good player , Evil ennemy , Scanner sc ) throws Errors{
        int pSpell = 0 , eSpell = 0 ;
        boolean faster;
        System.out.println("You are currently fighting a "+ennemy.getAdjective()+" !");
        while (!this.checkEnd(player.getHp(), ennemy.getHp())){
            eSpell = ennemy.spellChoice(sc);
            System.out.println("You still have : " + player.getHp() + " HP | Your ennemy has still : " + ennemy.getHp() +" HP");
            pSpell = player.spellChoice(sc);
            sc.nextLine();
            faster = isPlayerFaster(player, ennemy, pSpell, eSpell);
            try {
                round(player, ennemy, pSpell, eSpell, faster , isElement(player.getSpellElementAtPosition(pSpell), ennemy.getElement()) , isElement(ennemy.getSpellElementAtPosition(eSpell), player.getElement()));
            } catch (Errors e) {} ;
        }
        this.battleEnd(player.getHp(), ennemy.getHp());
        if(player.getHp() <= 0)
            throw new Errors("Game finished !");
    }

    /**
     * Allow to see how much damage the element do to the ennemy
     * @param elementP
     * @param elementE
     * @return 0 , 1 or 2
     */
    public static int isElement(String elementP , String elementE){
        if (elementP.equals(elementE) || elementP.equals("physical") || elementE.equals("physical")) 
            return 1;
        switch(elementP){
            case "fire":
                if (elementE.equals("water")) return 0;
                if (elementE.equals("grass")) return 2;
            case "water":
                if (elementE == "grass" ) return 0;
                if (elementE == "fire"  ) return 2;
            case "grass":
                if (elementE == "fire"  ) return 0;
                if (elementE == "water" ) return 2;
        }
        return -1;
    }

    /**
     * Check if neither the player or ennemy has under 0 hp
     * @param playerHp
     * @param ennemyHp
     * @return True if either of them has under 0 hp
     */
    public boolean checkEnd(int playerHp , int ennemyHp){
        return playerHp <= 0 || ennemyHp <= 0 ;
    }

    /**
     * Display if the player won or loose (comparing the player and ennemy hp)
     * @param playerHp
     * @param ennemyHp
     */
    public void battleEnd(int playerHp , int ennemyHp){
        if (playerHp > ennemyHp) System.out.println("You won");
        else System.out.println("You lost");
    }

    /**
     * A method that handles a round
     * @param player
     * @param ennemy
     * @param pSpell
     * @param eSpell
     * @param faster
     * @param pDamage
     * @param eDamage
     * @throws Errors
     */
    public void round (Good player , Evil ennemy , int pSpell , int eSpell , boolean faster , int pDamage , int eDamage) throws Errors{
        if (faster){
            player.attack(ennemy , addDamage((Entity)player, pSpell) * pDamage);
            System.out.println("Ennemy has lost : "+ addDamage((Entity)player, pSpell) * pDamage);
            if (this.checkEnd(player.getHp(), ennemy.getHp()))
                throw new Errors("Battle ended !");
            ennemy.attack(player, addDamage((Entity)ennemy, eSpell) * eDamage);
            System.out.println("You lost : "+ addDamage((Entity)ennemy, eSpell) * eDamage);
        }
        else{
            ennemy.attack(player, addDamage((Entity)ennemy, eSpell) * eDamage);
            System.out.println("You lost : "+ addDamage((Entity)ennemy, eSpell) * eDamage);
            if (this.checkEnd(player.getHp(), ennemy.getHp()))
                throw new Errors("Battle ended !");
            player.attack(ennemy ,addDamage((Entity)player, pSpell) * pDamage);
            System.out.println("Ennemy has lost : "+ addDamage((Entity)player, pSpell) * pDamage);
        }
    }

    /**
     * A methods that see who is faster
     * @param player
     * @param ennemy
     * @param pSpell
     * @param eSpell
     * @return True if the player is faster and false if the ennemy is
     */
    public boolean isPlayerFaster(Good player , Evil ennemy , int pSpell , int eSpell) {
        int pSpeed = player.getSpellSpeedAtPosition(pSpell);
        int eSpeed = ennemy.getSpellSpeedAtPosition(eSpell);
        
        if (pSpeed > eSpeed) return true;
        else return false;
    }

    /**
     * A methods that gives the damage of the chosen spell 
     * @param character
     * @param spell
     * @return The value of the spell damage
     */
    public int addDamage(Entity character , int spell){
          return character.getSpellDamageAtPosition(spell);
    }
}
