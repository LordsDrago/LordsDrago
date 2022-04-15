package enterGameNameHere.Magic;

public enum Spell {
    Fire_1("Bomb",25,100), Fire_2("Infernale Rush",35,80), Fire_3("Blazing Arrow",45,70),
    Fire_4("Flamme Torrent",55,60), Fire_5("Fire surge",60,55), Fire_6("Fire Wave",65,50),
    Fire_7("Meteorite",75,40), Fire_8("Inferno",85,25), Fire_9("Explosion",95,10),
    Water_1("Water Spike",25,100), Water_2("Aqua Slash",35,80), Water_3("Water Beam",45,70),
    Water_4("Water Vortex",55,60), Water_5("Sea Serpents",60,55), Water_6("Surging Waves",65,50),
    Water_7("Water Burst",75,40), Water_8("Acid Beam",85,25), Water_9("Typhoon",95,10),
    Grass_1("Bullet Seed",25,100), Grass_2("Leafage",35,80), Grass_3("Branch Poke",45,70),
    Grass_4("Razor Leaf",55,60), Grass_5("Needle Arm",60,55), Grass_6("Horn Leech",65,50),
    Grass_7("Wood Hammer",75,40), Grass_8("Power Whip",85,25), Grass_9("Solar Blade",95,10) 

    private final char spellName;
    private final int ap;
    private final int speed;

    private SpellName(char Name){
        this.speelName = Name;
    }

    private Ap(int Attack){
        this.ap = Attack;
    }

    private Speed(int Speed){
        this.speed = Speed;
    }

    public char getSpellName(){
        return this.spellName;
    }

    public int getAp(){
        return this.ap;
    }

    public int getSpeed(){
        return this.speed;
    }
}
