package enterGameNameHere;

import java.util.Scanner;

import enterGameNameHere.Races.Entity;

public class Battle {
    public void battle(Entity player , Entity ennemy ){
        int a = 0;
        Scanner scan = new Scanner(System.in);
        while ((player.getHp() > 0) && (ennemy.getHp() > 0)){
            System.out.println("The actual Player hp is :"+player.getHp()+" | The actual monster hp is : "+ennemy.getHp());
            System.out.println("Please choose the attack :");
            a = scan.nextInt();
            if (a == 1) {
                player.attack(ennemy, 0, player.getStrength(), 200);
                ennemy.attack(player, 0, ennemy.getStrength(), 5);
            }
            else
                System.out.println("Na!");
            
        }
        System.out.println("And the winner is : ");
        if (player.getHp() > ennemy.getHp()){
            System.out.println(player.getSpecieName());
            System.out.println("He left his ennemy with :"+ennemy.getHp());
        }
        else{
            System.out.println(ennemy.getSpecieName());
            System.out.println("He left his ennemy with :"+player.getHp());
        }
        scan.close();
    }
}
