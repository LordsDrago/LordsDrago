package enterGameNameHere.Terrain;

import java.io.Serializable;

public class Point implements Serializable{
    private int x;
    private int y;
    private boolean isWall = false;
    private boolean isPlayer = false;
    private boolean isMonster = false;
    private boolean isEnd = false;
    private DisplayCharacter displayCharacter;

    /**
     * Constructor to create a point
     * @param x the X coordinate of the point
     * @param y the Y coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
        this.isWall = !this.isWall;
    }

    /**
     * Changes the player property of the point
     */
    public void toggleIsPlayer() {
        this.isPlayer = !this.isPlayer;
    }

    /**
     * Changes the monster property of the point
     */
    public void toggleIsMonster() {
        this.isMonster = !this.isMonster;
    }

    /**
     * Changes the end property of the point
     */
    public void toggleIsEnd() {
        this.isEnd = !this.isEnd;
    }

    /**
     * Gets the isWall property of a point
     * @return a boolean representing the isWall property
     */
    public boolean getIsWall() {
        return this.isWall;
    }

    /**
     * Gets the isPlayer property of a point
     * @return a boolean representing the isPlayer property
     */
    public boolean getIsPlayer() {
        return this.isPlayer;
    }

    /**
     * Gets the isMonster property of a point
     * @return a boolean representing the isMonster property
     */
    public boolean getIsMonster() {
        return this.isMonster;
    }

    /**
     * Gets the isEnd property of a point
     * @return a boolean representing the isEnd property
     */
    public boolean getIsEnd() {
        return this.isEnd;
    }
}
