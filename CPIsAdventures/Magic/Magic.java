package CPIsAdventures.Magic;


public interface Magic {
    public static final Spell[] spell = {Spell.FIRE_1,Spell.FIRE_2,Spell.FIRE_3,Spell.FIRE_4,Spell.FIRE_5,Spell.FIRE_6,Spell.FIRE_7,Spell.FIRE_8,Spell.FIRE_9,Spell.WATER_1,Spell.WATER_2,Spell.WATER_3,Spell.WATER_4,Spell.WATER_5,Spell.WATER_6,Spell.WATER_7,Spell.WATER_8,Spell.WATER_9,Spell.GRASS_1,Spell.GRASS_2,Spell.GRASS_3,Spell.GRASS_4,Spell.GRASS_5,Spell.GRASS_6,Spell.GRASS_7,Spell.GRASS_8,Spell.GRASS_9};
    /** 
     * Method to get spell for goblin and elf
     */
    abstract public void getSpell();
}
