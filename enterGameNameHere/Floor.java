package enterGameNameHere;

import java.util.ArrayList;

public class Floor {
    protected Point[][] map;
    protected ArrayList<Entity> entities;

    public Floor(int size){
        this.map = new Point[size][size];
        initFloor(size);
    }

    public Floor(){
        this(15);
    }

    private void initFloor(int size) {
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++){
                this.map[i][j] = new Point(i, j);
            }
    }
}
