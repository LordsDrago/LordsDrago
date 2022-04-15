package enterGameNameHere.Races;

public class Human extends Good {
    protected String name;


    public Human(String specie , int strength , String name){
        super(specie ,strength);
        this.name = name;
    }

}
