package enterGameNameHere.Terrain;

public class Point{
    private int x;
    private int y;
    private boolean isWall;
    private DisplayCharacter displayCharacter;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.isWall = false;
    }

    /**
     * Sets the value of x
     * @param x the new coordinate x of the point
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the value of y
     * @param y the new coordinate y of the point
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the character displayed representing the point
     * @param character the new character from the DisplayCharacter enum
     */
    public void setDisplayCharacter(DisplayCharacter character) {
        this.displayCharacter = character;
    }

    /**
     * Gets the value of x
     * @return the current value of the coordinate x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the value of y
     * @return the current value of the coordinate y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets the character displayed representing the point
     * @return the character from the DisplayCharacter enum
     */
    public DisplayCharacter getDisplayCharacter() {
        return this.displayCharacter;
    }

    /**
     * Changes the wall property of the point
     */
    public void toggleIsWall() {
        this.isWall = this.isWall == false;
    }

    public boolean getIsWall() {
        return this.isWall;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [isWall=" + isWall + ", x=" + x + ", y=" + y + "]";
    }
}
