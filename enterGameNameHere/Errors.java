package enterGameNameHere;

public class Errors extends Exception {
    
    public Errors (String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "Unexpected event happened : " + super.getMessage();
    }
}
