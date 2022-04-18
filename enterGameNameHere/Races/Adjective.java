package enterGameNameHere.Races;

public enum Adjective {
    FABULOUS("fabulous") , COURAGEOUS("courageous") , TERRIFIC("terrific"),
    HORRIBLE("horrible") , INSANE("insane") , BRAVE("brave"),
    DRUNK("drunk") , BLOODTHIRSTY("bloodthirsty") , FLATEARTHER("flat-earther"),
    HIDEOUS("hideous") , FAYAD("fayad") , SHAMEFUL("shameful");

    private final String adjective;

    private Adjective(String adjective){
        this.adjective = adjective;
    }

    public String getAdjective(){
        return this.adjective;
    }
}
