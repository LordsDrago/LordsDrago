package enterGameNameHere.Races;

public class Human extends Good {
    protected String name;


    public Human( String specie , String name , int strength , String element ){
        super(specie ,strength,element);
        this.name = name;
    }

}
