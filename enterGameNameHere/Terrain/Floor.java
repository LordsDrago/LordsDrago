package enterGameNameHere.Terrain;

import enterGameNameHere.ErrorGame;
import enterGameNameHere.Races.*;

import java.io.Serializable;
import java.util.Random;

public class Floor implements Serializable {
    protected static final Maps[] mapList = {Maps.MAP1, Maps.MAP2, Maps.MAP3, Maps.MAP4, Maps.MAP5, Maps.MAP6, Maps.MAP7, Maps.MAP8, Maps.MAP9, Maps.MAP10};
    protected Maps mapString;
    protected Point[][] map;
    protected Evil[] monsters;
    protected Good player;

    /**
     * The default floor constructor, builds a 15*15 map as a 2D array of points
     * @param player the player that will be playing the game
     */
    public Floor(Good player){
        this.player = player;
        this.map = new Point[17][17];
        initFloor(17);
    }

    /**
     * The initialization method of the floor, which defines the 2D array which will represent the map
     * @param size the size of the map (size*size, it is a square)
     */
    private void initFloor(int size) {
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++){
                this.map[i][j] = new Point(j, i); // instanciates points for the whole map
            }
        this.initExtWalls();
        this.initIntWalls();
        this.initStartEnd();
        this.setMonsters(0.1);
        this.placeMonsters();
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

    /**
     * Reads the map chosen for the floor (defined in the enum Maps) and translates the 'X's to walls
     */
    private void initIntWalls() {
        this.initMapString();
        for(int i=1; i<=this.map.length - 2; i++)
            for(int j=1; j<=this.map.length - 2; j++){
                if(this.mapString.getMap()[i-1].charAt(j-1) == 'X')
                    this.map[i][j].toggleIsWall();
            }
    }

    /**
     * Chooses a random map among the 10 available in the array mapList
     */
    private void initMapString() {
        Random rd = new Random();
        this.mapString = mapList[rd.nextInt(10)];
    }

    /**
     * Initializes the points properties for the starting and ending point of the floor
     */
    private void initStartEnd() {
        Point start = this.mapString.getPlayerStart();
        Point end = this.mapString.getMapEnd();
        this.map[start.getY()][start.getX()].toggleIsPlayer();
        this.map[end.getY()][end.getX()].toggleIsEnd();
        this.player.setPoint(map[start.getY()][start.getX()]);
    }

    /**
     * Goes over the whole map to define the character which will be shown for every point
     */   
    private void setDisplayCharacters() {
        int mapLength = this.map.length;
        for(int i=0; i<mapLength; i++)
            for(int j=0; j<mapLength; j++){
                if(this.map[i][j].getIsWall()){
                    if(i==0 && j==0 || i==0 && j==mapLength-1 || i==mapLength-1 && j==0 || i==mapLength-1 && j==mapLength-1) // checks for the corners
                        Floor.check3Neighbors(this.map, i, j);
                    else if(i==0 || j==0 || i==mapLength-1 || j==mapLength-1) // checks for the borders
                        Floor.check5Neighbors(this.map, i, j);
                    else // checks for the rest
                        Floor.check8Neighbors(this.map, i, j);
                }
                else if(this.map[i][j].getIsPlayer())
                    this.map[i][j].setDisplayCharacter(DisplayCharacter.PLAYER);
                else if(this.map[i][j].getIsEnd())
                    this.map[i][j].setDisplayCharacter(DisplayCharacter.EXIT);
                else 
                    this.map[i][j].setDisplayCharacter(DisplayCharacter.EMPTY);
            }
    }

    /**
     * Interprets the 8 neighbors surrounding a point so as to determine the character that will represent it on-screen
     * @param map the map of the current floor, represented as a 2D array of Points
     * @param curY the Y index of the selected point
     * @param curX the X index of the selected point
     */
    private static void check8Neighbors(Point[][] map, int curY, int curX) {
        int cornerMissing = 0, verticalMissing = 0, horizontalMissing = 0;
        Point temp;
        for(int i=-1; i<=1; i++) // Goes over all the 9 points in a 3 * 3 square around the current point and checks which points are not walls
            for(int j=-1; j<=1; j++){
                temp = map[curY + i][curX + j];
                if(!temp.getIsWall()){
                    if((i+j) % 2 == 0)
                        cornerMissing++;
                    else if(i == 0)
                        horizontalMissing++;
                    else 
                        verticalMissing++;
                }
            }
        
        if(horizontalMissing >= 1 && verticalMissing >= 1) // Checks the number of missing walls to determine the symbol the current wall should be reprented by
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

    /**
     * Interprets the 5 neighbors surrounding a point on the border of the map so as to determine the character that will represent it on-screen
     * @param map the map of the current floor, represented as a 2D array of Points
     * @param curY the Y index of the selected point
     * @param curX the X index of the selected point
     */
    private static void check5Neighbors(Point[][] map, int curY, int curX) {
        int cornerMissing = 0, sideMissing = 0;
        Point temp;

        for(int i=-1; i<=1; i++){ // Goes over all the surrounding points around the current wall. As we are on a border, we have to adapt in which direction they are checked to not raise an error
            if(curY == 0)
                temp = map[curY + 1][curX + i];
            else if(curY == map.length - 1)
                temp = map[curY - 1][curX + i];
            else if(curX == 0)
                temp = map[curY + i][curX + 1];
            else
                temp = map[curY + i][curX - 1];

            if(i%2 != 0 && !temp.getIsWall())
                cornerMissing++;
            else if(i%2 == 0 && !temp.getIsWall())
                sideMissing++;
        }

    
        if(sideMissing != 0 && (curX == 0 || curX == map.length - 1)) // Checks the number of missing walls to determine the symbol the current wall should be reprented by
            map[curY][curX].setDisplayCharacter(DisplayCharacter.WALL_VERTICAL);
        else if(sideMissing != 0 && (curY == 0 || curY == map.length - 1))
            map[curY][curX].setDisplayCharacter(DisplayCharacter.WALL_HORIZONTAL);
        else if(cornerMissing != 0)
            map[curY][curX].setDisplayCharacter(DisplayCharacter.CORNER);
        else 
            map[curY][curX].setDisplayCharacter(DisplayCharacter.EMPTY);
    }

    /**
     * Interprets the 3 neighbors surrounding a point on a corner of the map so as to determine the character that will represent it on-screen
     * @param map the map of the current floor, represented as a 2D array of Points
     * @param curY the Y index of the selected point
     * @param curX the X index of the selected point
     */
    private static void check3Neighbors(Point[][] map, int curY, int curX) { // As we are on a corner and we have set exterior walls all around the map, we only check the state of the point on the corner of the inside map
        if((curY == 0 && curX == 0 && !map[curY + 1][curX + 1].getIsWall()) || 
        (curY == 0 && curX == map.length - 1 && !map[curY + 1][curX - 1].getIsWall()) || 
        (curY == map.length - 1 && curX == 0 && !map[curY - 1][curX + 1].getIsWall()) || 
        (curY == map.length - 1 && curX == map.length - 1 && !map[curY - 1][curX - 1].getIsWall()))
            map[curY][curX].setDisplayCharacter(DisplayCharacter.CORNER);
        
        else
            map[curY][curX].setDisplayCharacter(DisplayCharacter.EMPTY);
    }

    /**
     * Method that displays the current floor, by iterating over every point of the map and displaying its associated character
     */
    public void displayFloor() {
        for(int i=0; i<this.map.length; i++){
            for(int j=0; j<this.map.length; j++)
                System.out.print(this.map[i][j].getDisplayCharacter().getCharacter());
            System.out.print("\n");
        }
    }

    /**
     * Gets the array of monsters contained in the floor
     * @return the array of monsters contained in the floor
     */
    public Evil[] getMonsters() {
        return this.monsters;
    }

    /**
     * Creates a point that will be used to determine the new position of the player after a move
     * @param direction the direction in a String
     * @return a Point that adjusts the position of the player
     */
    private static Point transformDirection(String direction) {
        Point transform = new Point(0, 0);

        switch (direction) {
            case "z":
                transform.setY(transform.getY()-1);
                break;
            case "s":
                transform.setY(transform.getY()+1);
                break;
            case "d":
                transform.setX(transform.getX()+1);
                break;
            case "q":
                transform.setX(transform.getX()-1);
                break;
        }

        return transform;
    }

    /**
     * Method that handles the movement of the player
     * @param direction the String of the wanted direction to move to
     * @throws ErrorGame if the direction goes in a wall
     */
    public void movePlayer(String direction) throws ErrorGame {
        Point curPoint = player.getPoint();
        Point change = Floor.transformDirection(direction);
        int nextY = curPoint.getY() + change.getY(); 
        int nextX = curPoint.getX() + change.getX();

        if(map[nextY][nextX].getIsWall())
            throw new ErrorGame("The player cannot move in an incorrect place !");

        this.map[curPoint.getY()][curPoint.getX()].toggleIsPlayer();
        this.map[curPoint.getY()][curPoint.getX()].setDisplayCharacter(DisplayCharacter.EMPTY);

        player.setPoint(map[nextY][nextX]);
        map[nextY][nextX].toggleIsPlayer();
        map[nextY][nextX].setDisplayCharacter(DisplayCharacter.PLAYER);
    }

    /**
     * Counts the number of points unoccupied on the floor
     * @return an int with the number of points unoccupied on the floor
     */
    private int getFreePoints() {
        int counter = 0;
        for(int i=1; i<=this.map.length - 2; i++)
            for(int j=1; j<=this.map.length - 2; j++)
                if(!this.map[j][i].getIsWall() && !this.map[j][i].getIsPlayer() && !this.map[j][i].getIsEnd())
                    counter++;
        return counter;
    }

    /**
     * Method which generates all the monsters to be contained on one floor
     * @param ratio the percentage of free points that will contain a monster
     */
    private void setMonsters(double ratio) { // ratio --> between 0 and 1
        Random rd = new Random();
        double approachedMonsterNumber = this.getFreePoints() * ratio;
        int monsterNumber = (int) approachedMonsterNumber;
        this.monsters = new Evil[monsterNumber];
        for(int i=0; i<monsterNumber; i++)
            if(rd.nextInt(2) == 1)
                this.monsters[i] = new Orc();
            else 
                this.monsters[i] = new Goblin();
    }

    /**
     * Takes the array of monsters and places them on the floor, by toggling the isMonster property of the point and setting the position of the monster
     */
    private void placeMonsters() {
        Random rd = new Random();
        Point temp;
        for(Evil monster: this.monsters){
            do {
                temp = this.map[rd.nextInt(15)+1][rd.nextInt(15)+1];
            } while (temp.getIsPlayer() || temp.getIsWall() || temp.getIsMonster() || temp.getIsEnd());
            this.map[temp.getY()][temp.getX()].toggleIsMonster();
            monster.setPoint(temp);
        }
    }

    /**
     * Removes the isMonster tag at the specified coordinates
     * @param y the y coordinate of the monster to be removed
     * @param x the x coordinate of the monster to be removed
     */
    public void removeMonster(int y, int x) {
        this.map[y][x].toggleIsMonster();
    }

    /**
     * Checks if a monster is on the current point
     * @return true if there is a monster, else, false
     */
    public boolean checkIsMonster() {
        return this.map[this.player.getPoint().getY()][this.player.getPoint().getX()].getIsMonster();
    }

    /**
     * Checks if the end is on the current point
     * @return true if there is the end, else, false
     */
    public boolean checkIsEnd() {
        return this.map[this.player.getPoint().getY()][this.player.getPoint().getX()].getIsEnd();
    }
}
