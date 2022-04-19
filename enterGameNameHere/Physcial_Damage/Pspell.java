package enterGameNameHere.Physcial_Damage;

public enum Pspell {
    phys_1("Slam",45,100,"physical"),phys_2("Swift Strike",50,85,"physical"),phys_3("Slash",60,70,"physical"),
    phys_4("Slant",68,65,"physical"),phys_5("Slashing ray",75,50,"physical"),phys_6("Whiriwind", 78,40,"physical"),
    phys_7("Nova Ascension",120,5,"physical");

    private final String PspellName;
    private final int ap;
    private final int speed;
    private final String element;

    /**
     * Constructor for a physical spell
     * @param PspellName
     * @param ap
     * @param speed
     * @param element
     */
    private Pspell(String PspellName , int ap , int speed , String element){
        this.PspellName = PspellName;
        this.ap = ap;
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
     * @return An int ap
     */
    public int getAp(){
        return this.ap;
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
