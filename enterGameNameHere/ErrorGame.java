package enterGameNameHere;

public class ErrorGame extends Exception {
    
    /**
     * Errors constructor, allows to define a customized message for the error raised
     * @param message the customized message
     */
    public ErrorGame (String message){
        super(message);
    }

    /**
     * Prints the error in a customized way
     */
    @Override
    public String getMessage() {
        return "Unexpected event happened : " + super.getMessage();
    }
}
