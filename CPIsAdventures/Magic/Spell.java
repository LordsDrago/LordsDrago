package CPIsAdventures.Magic;

public enum Spell{
    FIRE_1("Bomb",25,100,"fire"), FIRE_2("Infernale Rush",35,80,"fire"), FIRE_3("Blazing Arrow",45,70,"fire"),
    FIRE_4("Flamme Torrent",55,60,"fire"), FIRE_5("Fire surge",60,55,"fire"), FIRE_6("Fire Wave",65,50,"fire"),
    FIRE_7("Meteorite",75,40,"fire"), FIRE_8("Inferno",85,25,"fire"), FIRE_9("Explosion",95,10,"fire"),
    WATER_1("Water Spike",25,100,"water"), WATER_2("Aqua Slash",35,80,"water"), WATER_3("Water Beam",45,70,"water"),
    WATER_4("Water Vortex",55,60,"water"), WATER_5("Sea Serpents",60,55,"water"), WATER_6("Surging Waves",65,50,"water"),
    WATER_7("Water Burst",75,40,"water"), WATER_8("Acid Beam",85,25,"water"), WATER_9("Typhoon",95,10,"water"),
    GRASS_1("Bullet Seed",25,100,"grass"), GRASS_2("Leafage",35,80,"grass"), GRASS_3("Branch Poke",45,70,"grass"),
    GRASS_4("Razor Leaf",55,60,"grass"), GRASS_5("Needle Arm",60,55,"grass"), GRASS_6("Horn Leech",65,50,"grass"),
    GRASS_7("Wood Hammer",75,40,"grass"), GRASS_8("Power Whip",85,25,"grass"), GRASS_9("Solar Blade",95,10,"grass"); 

    private final String spellName;
    private final int attackPower;
    private final int speed;
    private final String element;

    /**
     * Constructor for the spell
     * @param spellName
     * @param attackPower
     * @param speed
     * @param element
     */
    private Spell(String spellName, int attackPower , int speed , String element){
        this.spellName = spellName;
        this.attackPower = attackPower;
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
     * @return An int attackPower
     */
    public int getAp(){
        return this.attackPower;
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
