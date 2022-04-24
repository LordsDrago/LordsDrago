package CPIsAdventures;

public class ExitGame extends Exception {
    
    /**
     * Game exit constructor
     */
    public ExitGame (){
        super();
    }

    /**
     * Prints the game exit in a customized way
     */
    @Override
    public String getMessage() {
        return "Game exited";
    }
}
