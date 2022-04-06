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
        this.map = new Point[size][size];
        initFloor(size);
    }

    /**
     * The default floor constructor, builds a 15*15 map as a 2D array of points
     */
    public Floor(){
        this(15);
    }

    /**
     * The initialization function of the floor, which defines the 2D array which will represent the map
     * @param size the size of the map (size*size, it is a square)
     */
    private void initFloor(int size) {
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++){
                this.map[i][j] = new Point(i, j);
            }
    }
}
