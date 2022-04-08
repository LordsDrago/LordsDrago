package enterGameNameHere;

public enum DisplayCharacter {
    CORNER('+'), WALL_VERTICAL('|'), WALL_HORIZONTAL('-'), PLAYER('O'), MONSTER(' '), EMPTY(' ');

    private final char characterPoint;

    private DisplayCharacter(char symbol){
        this.characterPoint = symbol;
    }

    public char getCharacter(){
        return this.characterPoint;
    }
}
