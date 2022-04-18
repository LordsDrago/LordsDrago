package enterGameNameHere;

import java.util.Scanner;

import enterGameNameHere.Races.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Elf elf1 = new Elf("elf", "olivier", 20, "fire");
        elf1.setHp(200);
        Goblin goblin = new Goblin("goblin", 20, "fire");
        goblin.setHp(200);
        goblin.getSpell();
        elf1.getSpell();
        Battle battle = new Battle(elf1, goblin, sc);
        
    }
}

