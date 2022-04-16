package enterGameNameHere;

import enterGameNameHere.Races.Elf;
import enterGameNameHere.Races.Human;

public class Main {
    public static void main(String[] args){
        Human humain = new Human("human" , "olivier" ,200 );
        Human humain2 = new Human("human" , "allan",200 );
        Elf elf1 = new Elf("Elf","Arius",150);
        humain2.setHp(3000);
        humain2.setStrength(9000);
        humain.setHp(2000);
        humain.setStrength(2000);
        elf1.setHp(2000);
        System.out.println("Hp1 is : " + humain.getHp() + " And Hp2 is :" + humain2.getHp() + " His strength is :" + humain2.getStrength());
        elf1.attack(humain, 0, 0, 300);
        System.out.println("Hp1 is : " + humain.getHp());

        System.out.println("Hello world");
    }
}
