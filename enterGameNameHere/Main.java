package enterGameNameHere;

import java.util.Scanner;

import enterGameNameHere.Races.*;

public class Main {
    public static void main(String[] args){
        Elf elf1 = new Elf("elf", "olivier", 200, "fire");
        Human human = new Human("human", "Allan", 300, "physical");
        human.getPspell();
        human.PspellDisplay();
        elf1.getSpell();
        elf1.spellDisplay();
    }
}

