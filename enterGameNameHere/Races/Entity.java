package enterGameNameHere.Races;

import enterGameNameHere.Point;

public abstract class Entity {
    protected String specie;
    protected int strength;
    protected double hp;
    protected Point position;

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

  public double getHp(){
      return this.hp;
  }

  public void setStrength(int strength){
      this.strength = strength;
  }

  public int getStrength(){
      return this.strength;
  }

  public abstract void moveTo();

  public double pourcentage(int number , int damage){
      number = ((damage*number)/100);
      return number;
  }

  public void attack(Entity ennemy , int speed, int strength , int damage){
      ennemy.hp -= damage;  
  }

}
