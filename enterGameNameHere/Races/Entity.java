package enterGameNameHere.Races;

public abstract class Entity {
    protected String specie;
    protected int strength;

    public Entity(String specie , int strength){
      this.specie = specie;
      this.strength = strength;
    }

    public void say(){
        System.out.println("I am a "+specie+" !");
    }
    public abstract void moveTo();
}
