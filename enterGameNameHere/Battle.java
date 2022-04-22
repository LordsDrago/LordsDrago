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
    public Battle(Good player , Evil ennemy , Scanner sc ) throws ErrorGame, ExitGame{
        int pSpell = 0 , eSpell = 0 ;
        boolean faster;

        UserInterface.printException("You are currently fighting a "+ennemy.getAdjective()+" "+ennemy.getClass().getSimpleName().toLowerCase()+" !"+"\n");
        
        while (!this.checkEnd(player.getHp(), ennemy.getHp())){
            UserInterface.clearScreen();

            try {
                eSpell = ennemy.spellChoice(sc);
                System.out.println("You still have : " + player.getHp() + " HP | Your ennemy has still : " + ennemy.getHp() +" HP\n");
                pSpell = player.spellChoice(sc);

                faster = isPlayerFaster(player, ennemy, pSpell, eSpell);

                try {
                    round(player, ennemy, pSpell, eSpell, faster , isElement(player.getSpellElementAtPosition(pSpell), ennemy.getElement()) , isElement(ennemy.getSpellElementAtPosition(eSpell), player.getElement()));
                } catch (ErrorGame battleEndedInMiddleOfRound) {} ;
                UserInterface.wait(3);
            } catch (ErrorGame wrongSpellInput) {
                UserInterface.printException(wrongSpellInput.getMessage());
            } catch (ExitGame gameExit) {
                throw new ExitGame();
            }
            
        }

        this.battleEnd(player.getHp(), ennemy.getHp());

        if(player.getHp() <= 0)
            throw new ErrorGame("Game finished !");
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
                if (elementE.equals("grass")) return 0;
                if (elementE.equals("fire")) return 2;
            case "grass":
                if (elementE.equals("fire")) return 0;
                if (elementE.equals("water")) return 2;
        }
        return -1;
    }

    /**
     * Check if either the player or ennemy has under 0 hp
     * @param playerHp
     * @param ennemyHp
     * @return True if either of them has under 0 hp
     */
    public boolean checkEnd(int playerHp , int ennemyHp){
        return playerHp <= 0 || ennemyHp <= 0 ;
    }

    /**
     * Display if the player won or lost (comparing the player and ennemy hp)
     * @param playerHp
     * @param ennemyHp
     */
    public void battleEnd(int playerHp , int ennemyHp){
        if (playerHp > ennemyHp) System.out.println("You won");
        else System.out.println("You lost");
        UserInterface.wait(2);
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
     * @throws ErrorGame
     */
    public void round (Good player , Evil ennemy , int pSpell , int eSpell , boolean faster , int pDamage , int eDamage) throws ErrorGame{
        if (faster){
            player.attack(ennemy , addDamage((Entity)player, pSpell) * pDamage);
            System.out.println("Ennemy has lost "+ addDamage((Entity)player, pSpell) * pDamage + " hp");
            if (this.checkEnd(player.getHp(), ennemy.getHp()))
                throw new ErrorGame("Battle ended !");
            ennemy.attack(player, addDamage((Entity)ennemy, eSpell) * eDamage);
            System.out.println("You lost "+ addDamage((Entity)ennemy, eSpell) * eDamage + " hp");
        }
        else{
            ennemy.attack(player, addDamage((Entity)ennemy, eSpell) * eDamage);
            System.out.println("You lost "+ addDamage((Entity)ennemy, eSpell) * eDamage + " hp");
            if (this.checkEnd(player.getHp(), ennemy.getHp()))
                throw new ErrorGame("Battle ended !");
            player.attack(ennemy ,addDamage((Entity)player, pSpell) * pDamage);
            System.out.println("Ennemy has lost "+ addDamage((Entity)player, pSpell) * pDamage + " hp");
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
        return player.getSpellSpeedAtPosition(pSpell) > ennemy.getSpellSpeedAtPosition(eSpell);
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
