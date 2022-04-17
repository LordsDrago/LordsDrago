package enterGameNameHere;
import java.util.Scanner;
import enterGameNameHere.Races.Entity;
 
public class Battle {
   /**
    * Allow 2 entities to fight
    * @param player
    * @param ennemy
    * @param scan
    */
    public void battle(Entity player , Entity ennemy , Scanner scan ){
        int a = 0;
        while ((player.getHp() > 0) && (ennemy.getHp() > 0)){
            System.out.println("You're actually fighting "+ennemy.getSpecieName() +"!");
            

        }
    }
    /**
     * Allow to see which entity is faster
     * @param speed1
     * @param speed2
     * @return True if the first is faster and false if not
     */
    public boolean isFaster(int speed1 , int speed2){
        if (speed1 > speed2) return true;
        else return false;
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
                if (elementE == "fire"  ) return 1;
                if (elementE == "grass" ) return 2;
            case "water":
                if (elementE == "grass" ) return 0;
                if (elementE == "water" ) return 1;
                if (elementE == "fire"  ) return 2;
            case "grass":
                if (elementE == "fire"  ) return 0;
                if (elementE == "grass" ) return 1;
                if (elementE == "water" ) return 2;
        }
        return -1;
    }
    /**
     * Easier to write than System.out.println, do the same thing but faster
     * @param string
     */
    public void printf(String string){
        System.out.println(string);
    }
}
