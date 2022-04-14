package Terrain;

import java.util.ArrayList;
import enterGameNameHere.Races.*;

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

    /**
     * Goes over the whole map to define the character which will be shown for every point
     */
    private void setDisplayCharacters() {
        int mapLength = this.map.length;
        for(int i=0; i<mapLength; i++)
            for(int j=0; j<mapLength; i++){
                if(this.map[i][j].getIsWall()){
                    if(i==0 && j==0 || i==0 && j==mapLength-1 || i==mapLength-1 && j==0 || i==mapLength-1 && j==mapLength-1)
                        Floor.check3Neighbors(map, i, j);
                    else if(i==0 || j==0 || i==mapLength-1 || j==mapLength-1)
                        Floor.check5Neighbors(map, i, j);
                    else 
                        Floor.check8Neighbors(map, i, j);
                }
                else 
                    this.map[i][j].setDisplayCharacter(DisplayCharacter.EMPTY);
            }
    }

    private static void check8Neighbors(Point[][] map, int curY, int curX) {
        int cornerMissing = 0, verticalMissing = 0, horizontalMissing = 0;
        Point temp;
        for(int i=-1; i<=1; i++)
            for(int j=-1; j<=1; j++){
                temp = map[curY + i][curX + j];
                if(temp.getIsWall() == false){
                    if((i+j) % 2 == 0)
                        cornerMissing++;
                    else if(i == -1)
                        horizontalMissing++;
                    else 
                        verticalMissing++;
                }
            }
        
        if(horizontalMissing >= 1 && verticalMissing >= 1)
            map[curY][curX].setDisplayCharacter(DisplayCharacter.CORNER);
        else if(horizontalMissing >= 1)
            map[curY][curX].setDisplayCharacter(DisplayCharacter.WALL_VERTICAL);
        else if(verticalMissing >= 1)
            map[curY][curX].setDisplayCharacter(DisplayCharacter.WALL_HORIZONTAL);
        else if(cornerMissing >= 1)
            map[curY][curX].setDisplayCharacter(DisplayCharacter.CORNER);
        else 
            map[curY][curX].setDisplayCharacter(DisplayCharacter.EMPTY);
    }

    private static void check5Neighbors(Point[][] map, int curX, int curY) {
        
    }

    private static void check3Neighbors(Point[][] map, int curX, int curY) {
        
    }
}
