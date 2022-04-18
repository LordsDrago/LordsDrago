package enterGameNameHere.Races;

import java.util.Scanner;

public abstract class Evil extends Entity {

    public Evil(String specie , int strength , String element){
      super(specie, strength , element);
    }

  @Override
  public int spellChoice(Scanner scan){
       return 1;
  }

}
