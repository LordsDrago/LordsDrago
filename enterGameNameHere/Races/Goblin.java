package enterGameNameHere.Races;

public class Goblin extends Evil {
    public Goblin(String specie , int strength){
        super(specie , strength);
    }

    public void setSpecieName(String specie){
        this.specie = specie;
    }

    public String getSpecieName(){
        return this.specie;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getHp(){
        return hp;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getStrength(){
        return this.strength;
    }
}
