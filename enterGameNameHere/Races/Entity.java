package enterGameNameHere.Races;
import enterGameNameHere.Terrain.*;


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
  /**
   * Give the current species name
   * @return The current species name
   */
  public String getSpecieName(){
      return this.specie;
  }
  /**
   * Setting the entity HP
   * @param hp
   */
  public void setHp(int hp){
      this.hp = hp;
  }
  /**
   * Give the HP of the entity
   * @return The current HP
   */
  public double getHp(){
      return this.hp;
  }
  /**
   * Setting the entity Strength
   * @param strength
   */
  public void setStrength(int strength){
      this.strength = strength;
  }
  /**
   * Give the strength of the entity
   * @return The current strength
   */
  public int getStrength(){
      return this.strength;
  }

  public abstract void moveTo();
  /**
   * Give the pourcentage in function of the number and damage entered
   * @param number
   * @param damage
   * @return The pourcatage value
   */
  public double pourcentage(int number , int damage){
      number = ((damage*number)/100);
      return number;
  }
  /**
   * Allow to attack an another entity
   * @param ennemy
   * @param speed
   * @param strength
   * @param damage
   */
  public void attack(Entity ennemy , int speed, int strength , int damage){
      ennemy.hp -= damage;  
  }

}
