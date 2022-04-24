package CPIsAdventures.Physical_Damage;

public interface Physical {
    public static final PSpell[] spells = {PSpell.PHYS_1,PSpell.PHYS_2,PSpell.PHYS_3,PSpell.PHYS_4,PSpell.PHYS_5,PSpell.PHYS_6,PSpell.PHYS_7,};
    /** 
     * Method to get physical spell for human and orc
     */
    abstract public void getPspell();
}
