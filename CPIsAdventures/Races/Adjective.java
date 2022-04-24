package CPIsAdventures.Races;

public enum Adjective {
    FABULOUS("fabulous") , COURAGEOUS("courageous") , TERRIFIC("terrific"),
    HORRIBLE("horrible") , INSANE("insane") , BRAVE("brave"),
    DRUNK("drunk") , BLOODTHIRSTY("bloodthirsty") , FLATEARTHER("flat-earther"),
    HIDEOUS("hideous") , FAYAD("fayad") , SHAMEFUL("shameful");

    private final String adjective;

    /**
     * Constructor for adjective
     * @param adjective
     */
    private Adjective(String adjective){
        this.adjective = adjective;
    }

    /**
     * Getting the adjective
     * @return A string adjective
     */
    public String getAdjective(){
        return this.adjective;
    }
}
