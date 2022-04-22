package enterGameNameHere.Physical_Damage;

public interface Physical {
    public static final Pspell[] pSpell = {Pspell.PHYS_1,Pspell.PHYS_2,Pspell.PHYS_3,Pspell.PHYS_4,Pspell.PHYS_5,Pspell.PHYS_6,Pspell.PHYS_7,};
    /** 
     * Method to get physical spell for human and orc
     */
    abstract public void getPspell();
}
