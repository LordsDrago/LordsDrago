package enterGameNameHere.Races;

public abstract class Entity {
    protected String specie;
    protected int strength;
    protected int hp;

    public Entity(String specie , int strength){
      super();
      this.specie = specie;
      this.strength = strength;
    }

    public void say(){
        System.out.println("I am a "+specie+" and I will kill you !");
    }
    public abstract void moveTo();
}
