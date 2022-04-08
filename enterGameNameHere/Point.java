package enterGameNameHere;

public class Point{
    protected int x;
    protected int y;
    protected boolean isWall;
    protected DisplayCharacter displayCharacter;

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
     * Changes the wall property of the point
     */
    public void toggleIsWall() {
        this.isWall = this.isWall == false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [isWall=" + isWall + ", x=" + x + ", y=" + y + "]";
    }
}
