package enterGameNameHere.Races;

import enterGameNameHere.Magic.Magic;

public class Elf extends Good implements Magic {
    protected String name;
    public Elf( String specie , String name , int strength ){
        super(specie ,strength);
        this.name = name;
    }
    
    public void castSpell(){
        
    }
}
