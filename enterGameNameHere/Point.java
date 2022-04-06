package enterGameNameHere;

public class Point {
    protected int x;
    protected int y;
    protected boolean isWall;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void toggleIsWall() {
        this.isWall = this.isWall == false;
    }
}
