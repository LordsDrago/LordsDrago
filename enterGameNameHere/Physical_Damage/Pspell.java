package enterGameNameHere.Physical_Damage;

public enum Pspell {
    PHYS_1("Slam",45,100,"physical"),PHYS_2("Swift Strike",50,85,"physical"),PHYS_3("Slash",60,70,"physical"),
    PHYS_4("Slant",68,65,"physical"),PHYS_5("Slashing ray",75,50,"physical"),PHYS_6("Whiriwind", 85,40,"physical"),
    PHYS_7("Nova Ascension",150,5,"physical");

    private final String PspellName;
    private final int attackPower;
    private final int speed;
    private final String element;

    /**
     * Constructor for a physical spell
     * @param PspellName
     * @param attackPower
     * @param speed
     * @param element
     */
    private Pspell(String PspellName , int attackPower , int speed , String element){
        this.PspellName = PspellName;
        this.attackPower = attackPower;
        this.speed = speed;
        this.element = element;
    }

    /**
     * Getting the name of the physical spell
     * @return A string PspellName
     */
    public String getPspellName(){
        return this.PspellName;
    }

    /**
     * Getting the attack power of the physical spell
     * @return An int attackPower
     */
    public int getAp(){
        return this.attackPower;
    }

    /**
     * Getting the speed of the physical spell
     * @return An int speed
     */
    public int getSpeed(){
        return this.speed;
    }

    /**
     * Getting the element of the physical spell
     * @return A string element
     */
    public String getElement(){
        return this.element;
    }
    
}
