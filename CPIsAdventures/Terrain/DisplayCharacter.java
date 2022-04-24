package CPIsAdventures.Terrain;

public enum DisplayCharacter {
    CORNER('+'), WALL_VERTICAL('|'), WALL_HORIZONTAL('-'), PLAYER('O'), EMPTY(' '), EXIT('@'), MONSTER('X');

    private final char characterPoint;

    /**
     * Private constructor for the enum DisplayCharacter
     * @param symbol the character associated to the enum object 
     */
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
