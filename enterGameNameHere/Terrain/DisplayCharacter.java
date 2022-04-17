package enterGameNameHere.Terrain;

public enum DisplayCharacter {
    CORNER('+'), WALL_VERTICAL('|'), WALL_HORIZONTAL('-'), PLAYER('O'), MONSTER(' '), EMPTY(' ');

    private final char characterPoint;

    private DisplayCharacter(char symbol){
        this.characterPoint = symbol;
    }

    /**
     * Function to get the char assigned to the enum object
     * @return the character associated to the enum object
     */
    public char getCharacter(){
        return this.characterPoint;
    }
}
