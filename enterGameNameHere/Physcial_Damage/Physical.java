package enterGameNameHere.Physcial_Damage;

public interface Physical {
    public final Pspell[] pspell = {Pspell.phys_1,Pspell.phys_2,Pspell.phys_3,Pspell.phys_4,Pspell.phys_5,Pspell.phys_6,Pspell.phys_7,};
    /** 
     * Method to get physical spell for human and orc
     */
    abstract public void getPspell();
}
