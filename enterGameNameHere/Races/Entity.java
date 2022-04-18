package enterGameNameHere.Races;
import enterGameNameHere.Terrain.*;


public abstract class Entity {
    protected String specie;
    protected int strength;
    protected double hp;
    protected Point position;
    protected String element; // Ceci est un humain de type FEU allez sur le lien : https://github.com/LordsDrago/Projet-Advanced-Prog

  public Entity(String specie , int strength , String element){
      this.specie = specie;
      this.strength = strength;
      this.element = element;
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

  public void setPoint(Point newPosition){
      this.position = newPosition;
  }

  public Point getPoint(){
      return this.position;
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
     * Allow to attack another entity
     * @param ennemy
     * @param damage
     */
  public void attack(Entity ennemy , int damage){
      ennemy.hp -= damage;  
  }

}
