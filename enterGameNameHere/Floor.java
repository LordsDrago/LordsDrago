package enterGameNameHere;

import java.util.ArrayList;

public class Floor {
    protected Point[][] map;
    protected ArrayList<Entity> entities;


    /**
     * Floor constructor, creates a 2D array of Points which represents the map
     * @param size the size of the map
     */
    public Floor(int size){
        this.map = new Point[size + 2][size + 2];
        initFloor(size + 2);
    }

    /**
     * The default floor constructor, builds a 15*15 map as a 2D array of points
     */
    public Floor(){
        this(15);
    }

    /**
     * The initialization method of the floor, which defines the 2D array which will represent the map
     * @param size the size of the map (size*size, it is a square)
     */
    private void initFloor(int size) {
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++){
                this.map[i][j] = new Point(i, j);
            }
        this.initExtWalls();
    }

    /**
     * Method which sets the exterior points as walls, such as to make sure that there will always be an exterior boundary to the map
     */
    private void initExtWalls() {
        for(int i=0; i<this.map.length; i++) //sets upper exterior walls
            this.map[0][i].toggleIsWall();
        for(int i=1; i<this.map.length; i++) //sets left exterior walls 
            this.map[i][0].toggleIsWall();
        for(int i=1; i<this.map.length; i++) //sets right exterior walls
            this.map[i][this.map.length - 1].toggleIsWall();
        for(int i=1; i<this.map.length - 1; i++) //sets lower exterior walls
            this.map[this.map.length - 1][i].toggleIsWall();
    }
}
