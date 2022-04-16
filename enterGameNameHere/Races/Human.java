package enterGameNameHere.Races;

public class Human extends Good {
    protected String name;


    public Human( String specie , String name , int strength ){
        super(specie ,strength);
        this.name = name;
    }

}
