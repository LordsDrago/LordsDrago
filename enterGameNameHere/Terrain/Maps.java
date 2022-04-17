package enterGameNameHere.Terrain;

public enum Maps {
    MAP1(new String[] {
        "XXX.......XXXXX",
        "X............XX",
        "..............X",
        "....XXXXX......",
        ".....XXXX......",
        ".....XXXXXX....",
        "XX.............",
        "XXX............",
        "X.......XXXX...",
        ".....XXXXX.....",
        "......XXX......",
        "........XXXXXXX",
        "...............",
        "XXXXXXX........",
        "XXXXXXX........"
        },
        new Point(2, 2),
        new Point(15, 15)
        ), 
    MAP2(new String[] {
        "....XXXXX......",
        "......XXXXXX...",
        ".........XXXX..",
        ".........XXX...",
        ".....XXXXX.....",
        "XXX.XXX........",
        "...............",
        "XX.....XX......",
        "XXX...XX.......",
        ".....XX........",
        "..XXXX........X",
        "XXX.........XXX",
        "..........XXXXX",
        "...........XXXX",
        "...........XXXX"
        },
        new Point(1, 1),
        new Point(6, 15)
        ),
    MAP3(new String[] {
        "............XXX",
        "..............X",
        "XXX............",
        "XXXXX..........",
        "XXXXXX.........",
        "XXXXXXXXXX.....",
        "XXXXXX.........",
        "XX...........XX",
        ".........XXXXXX",
        "......XXXXXXXXX",
        "..........XXXXX",
        "..............X",
        "XX.............",
        "XXXXX..........",
        "XXXXXXXXX......"
        },
        new Point(1, 1),
        new Point(15, 15)
        ), 
    MAP4(new String[] {
        "XX.........XXXX",
        "X.............X",
        ".......XX......",
        "....XXXXXXX....",
        "...XXXXXXXXX...",
        "..XXXXXXXX.....",
        "...XXXXXXXX....",
        "....XXXXXXXXX..",
        "...XXX.....XX..",
        "....X....XXX...",
        "....X.....XX...",
        "....X..........",
        "....X.........X",
        "X............XX",
        "XXXXX.......XXX"
        },
        new Point(7, 1),
        new Point(8, 15)
        ), 
    MAP5(new String[] {
        ".....XXXXXXXXXX",
        ".......XXXXXXXX",
        "..........XXXXX",
        "............XXX",
        ".............XX",
        ".............XX",
        "..............X",
        "X.............X",
        "X..............",
        "XX.............",
        "XX.............",
        "XXX............",
        "XXXXX..........",
        "XXXXXXXX.......",
        "XXXXXXXXXX....."
        },
        new Point(1, 1),
        new Point(15, 15)
        ), 
    MAP6(new String[] {
        ".X.....XXX...X.",
        ".X.X.X...X.X.X.",
        ".X.X.XXX.X.X.X.",
        "...X.XXX...X.X.",
        ".X...XXXXXXX.X.",
        ".X.X.XXX.....X.",
        ".X.X...X.XXXXX.",
        "...XXX.X.....X.",
        ".X.X...X.XXX.X.",
        ".X.X.XXX...X...",
        ".X.XXXXXXX.XXXX",
        ".X.......X.XXXX",
        ".XXXXXXX.X.XXXX",
        "...X...X...XXXX",
        ".X...X...X.XXXX"
        },
        new Point(1, 1),
        new Point(15, 1)
        ), 
    MAP7(new String[] {
        "...............",
        "...............",
        "..XXX.....XXX..",
        "..XXX.....XXX..",
        "..XXX.....XXX..",
        "...............",
        "..X.........X..",
        "..XX.......XX..",
        "...XX.....XX...",
        "....XXX.XXX....",
        ".....XXXXX.....",
        "XX...........XX",
        "...............",
        ".....XXXXX.....",
        "...XXXXXXXXX..."
        },
        new Point(8, 1),
        new Point(8, 13)
        ), 
    MAP8(new String[] {
        "...............",
        "...............",
        "..X.....X..XX..",
        "..XX....X.X..X.",
        "..XX....X.X..X.",
        "..X.X...X.X..X.",
        "..X.X...X.X..X.",
        "..X..X..X.X..X.",
        "..X..X..X.X..X.",
        "..X...X.X.X..X.",
        "..X...X.X.X..X.",
        "..X....XX.X..X.",
        "..X....XX..XX..",
        "...............",
        "..............."
        },
        new Point(1, 1),
        new Point(15, 15)
        ), 
    MAP9(new String[] {
        ".....XXXXX.....",
        "..........XX...",
        "..X..XXXXX..X..",
        ".X..X.....X..X.",
        ".X.X..XXX..X.X.",
        "X....XXXXX..X.X",
        "X.X.XXXXXXX.X.X",
        "X.X.XXXXXXX.X.X",
        "X.X.XXXXXXX.X.X",
        "X.X..XXXXX....X",
        ".X.X..XXX..X.X.",
        ".X..X.....X..X.",
        "..X..XXXXX..X..",
        "...XX..........",
        ".....XXXXX....."
        },
        new Point(1, 1),
        new Point(15, 15)
        ), 
    MAP10(new String[] {
        "...X.X....X....",
        "..XXXXXXXXXXXXX",
        "...X.X....X....",
        ".....X....X....",
        "...X.X....X....",
        "XXXX.XXXXXXXXXX",
        ".....X.........",
        ".XXXXXXX.XXXX.X",
        "...X.X....X....",
        ".....X....X....",
        "...X.X....X....",
        "...X.X....X....",
        "XXXX.XXX.XXX.XX",
        "...X.X....X....",
        "...X......X...."
        },
        new Point(1, 1),
        new Point(15, 15)
        );

    private final String[] map;
    private final Point playerStart;
    private final Point mapEnd;


    private Maps(String[] map, Point start, Point end){
        this.map = map;
        this.playerStart = start;
        this.mapEnd = end;
    }

    /**
     * Returns the array of String used to create the map
     */
    public String[] getMap() {
        return this.map;
    }

    /**
     * Returns a point with the position of the player when starting the map
     * @return the point with the x and y coordinates of the player at the start of the map
     */
    public Point getPlayerStart(){
        return this.playerStart;
    }

    /**
     * Returns a point with the position of the exit of the map
     * @return the point with the x and y coordinates of the end of the map
     */
    public Point getMapEnd(){
        return this.mapEnd;
    }
}
