package enterGameNameHere.Races;

public abstract class Entity {
    protected String specie;
    protected int strength;
    protected int hp;

    public Entity(String specie , int strength){
      this.specie = specie;
      this.strength = strength;
    }

    public void say(){
        System.out.println("I am a "+specie+" and I will kill you !");
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
      return this.hp;
  }

  public void setStrength(int strength){
      this.strength = strength;
  }

  public int getStrength(){
      return this.strength;
  }

  public abstract void moveTo();

  public void takeDamage(int damage){
      this.hp -= damage; 
  }

}
