package enterGameNameHere.Races;

import java.util.Random;
import java.util.Scanner;

public abstract class Evil extends Entity {

    public Evil(){
      super();
    }

  @Override
  public int spellChoice(Scanner scan){
    Random rd = new Random();
    return rd.nextInt(3);
  }
}
