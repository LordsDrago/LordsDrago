package enterGameNameHere.Magic;

public enum Spell{
    Fire_1("Bomb",25,100,"fire"), Fire_2("Infernale Rush",35,80,"fire"), Fire_3("Blazing Arrow",45,70,"fire"),
    Fire_4("Flamme Torrent",55,60,"fire"), Fire_5("Fire surge",60,55,"fire"), Fire_6("Fire Wave",65,50,"fire"),
    Fire_7("Meteorite",75,40,"fire"), Fire_8("Inferno",85,25,"fire"), Fire_9("Explosion",95,10,"fire"),
    Water_1("Water Spike",25,100,"water"), Water_2("Aqua Slash",35,80,"water"), Water_3("Water Beam",45,70,"water"),
    Water_4("Water Vortex",55,60,"water"), Water_5("Sea Serpents",60,55,"water"), Water_6("Surging Waves",65,50,"water"),
    Water_7("Water Burst",75,40,"water"), Water_8("Acid Beam",85,25,"water"), Water_9("Typhoon",95,10,"water"),
    Grass_1("Bullet Seed",25,100,"grass"), Grass_2("Leafage",35,80,"grass"), Grass_3("Branch Poke",45,70,"grass"),
    Grass_4("Razor Leaf",55,60,"grass"), Grass_5("Needle Arm",60,55,"grass"), Grass_6("Horn Leech",65,50,"grass"),
    Grass_7("Wood Hammer",75,40,"grass"), Grass_8("Power Whip",85,25,"grass"), Grass_9("Solar Blade",95,10,"grass"); 

    private final String spellName;
    private final int ap;
    private final int speed;
    private final String element;

    /**
     * Constructor for the spell
     * @param spellName
     * @param ap
     * @param speed
     * @param element
     */
    private Spell(String spellName, int ap , int speed , String element){
        this.spellName = spellName;
        this.ap = ap;
        this.speed = speed;
        this.element = element;
    }

    /**
     * Getting the spell name
     * @return A string spellName
     */
    public String getSpellName(){
        return this.spellName;
    }

    /**
     * Getting the attack power of the spell
     * @return An int ap
     */
    public int getAp(){
        return this.ap;
    }

    /**
     * Getting the speed of the spell
     * @return An int speed
     */
    public int getSpeed(){
        return this.speed;
    }

    /**
     * Getting the element of the spell
     * @return A string element
     */
    public String getElement(){
        return this.element;
    }
}
