package enterGameNameHere.Terrain;

import java.util.ArrayList;
import enterGameNameHere.Races.*;
import java.util.Random;

public class Floor {
    protected static Maps[] mapList = {Maps.MAP1, Maps.MAP2, Maps.MAP3, Maps.MAP4, Maps.MAP5, Maps.MAP6, Maps.MAP7, Maps.MAP8, Maps.MAP9, Maps.MAP10};
    protected Maps mapString;
    protected Point[][] map;
    protected ArrayList<Entity> entities;


    /**
     * Floor constructor, creates a 2D array of Points which represents the map
     * @param size the size of the map
     */
    private Floor(int size){
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
        this.initIntWalls();
        this.setDisplayCharacters();
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

    private void initIntWalls() {
        this.initMapString();
        for(int i=1; i<=this.map.length - 2; i++)
            for(int j=1; j<=this.map.length - 2; j++){
                if(this.mapString.getMap()[i-1].charAt(j-1) == 'X')
                    this.map[i][j].toggleIsWall();
            }
    }

    private void initMapString() {
        Random rd = new Random();
        this.mapString = mapList[rd.nextInt(10)];
    }

    /**
     * Goes over the whole map to define the character which will be shown for every point
     */
    private void setDisplayCharacters() {
        int mapLength = this.map.length;
        for(int i=0; i<mapLength; i++)
            for(int j=0; j<mapLength; j++){
                if(this.map[i][j].getIsWall()){
                    if(i==0 && j==0 || i==0 && j==mapLength-1 || i==mapLength-1 && j==0 || i==mapLength-1 && j==mapLength-1)
                        Floor.check3Neighbors(this.map, i, j);
                    else if(i==0 || j==0 || i==mapLength-1 || j==mapLength-1)
                        Floor.check5Neighbors(this.map, i, j);
                    else 
                        Floor.check8Neighbors(this.map, i, j);
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
                    else if(i == 0)
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

    private static void check5Neighbors(Point[][] map, int curY, int curX) {
        int cornerMissing = 0, sideMissing = 0;
        Point temp;

        for(int i=-1; i<=1; i++){
            if(curY == 0)
                temp = map[curY + 1][curX + i];
            else if(curY == map.length - 1)
                temp = map[curY - 1][curX + i];
            else if(curX == 0)
                temp = map[curY + i][curX + 1];
            else
                temp = map[curY + i][curX - 1];

            if(i%2 != 0 && temp.getIsWall() == false)
                cornerMissing++;
            else if(i%2 == 0 && temp.getIsWall() == false)
                sideMissing++;
        }

    
        if(sideMissing != 0 && (curX == 0 || curX == map.length - 1))
            map[curY][curX].setDisplayCharacter(DisplayCharacter.WALL_VERTICAL);
        else if(sideMissing != 0 && (curY == 0 || curY == map.length - 1))
            map[curY][curX].setDisplayCharacter(DisplayCharacter.WALL_HORIZONTAL);
        else if(cornerMissing != 0)
            map[curY][curX].setDisplayCharacter(DisplayCharacter.CORNER);
        else 
            map[curY][curX].setDisplayCharacter(DisplayCharacter.EMPTY);
    }

    private static void check3Neighbors(Point[][] map, int curY, int curX) {
        if((curY == 0 && curX == 0 && map[curY + 1][curX + 1].getIsWall() == false) || 
        (curY == 0 && curX == map.length - 1 && map[curY + 1][curX - 1].getIsWall() == false) || 
        (curY == map.length - 1 && curX == 0 && map[curY - 1][curX + 1].getIsWall() == false) || 
        (curY == map.length - 1 && curX == map.length - 1 && map[curY - 1][curX - 1].getIsWall() == false))
            map[curY][curX].setDisplayCharacter(DisplayCharacter.CORNER);
        
        else
            map[curY][curX].setDisplayCharacter(DisplayCharacter.EMPTY);
    }

    public void displayFloor() {
        for(int i=0; i<this.map.length; i++){
            for(int j=0; j<this.map.length; j++)
                System.out.print(this.map[i][j].getDisplayCharacter().getCharacter());
            System.out.print("\n");
        }
    }
}
