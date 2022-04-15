package enterGameNameHere;

import enterGameNameHere.Races.Human;

public class Main {
    public static void main(String[] args){
        Human humain = new Human("human" , 200 , "olivier");
        Human humain2 = new Human("human" , 200 , "allan");
        humain2.setHp(3000);
        humain2.setStrength(9000);
        humain.setHp(2000);
        humain.setStrength(2000);
        System.out.println("Hp1 is : " + humain.getHp() + " And Hp2 is :" + humain2.getHp() + " His strength is :" + humain2.getStrength());
        

        System.out.println("Hello world");
    }
}
