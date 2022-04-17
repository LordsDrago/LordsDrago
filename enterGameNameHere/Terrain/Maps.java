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
        }), 
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
        }),
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
        }), 
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
        }), 
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
        }), 
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
        }), 
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
        }), 
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
        }), 
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
        }), 
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
        });

    private final String[] map;

    private Maps(String[] map){
        this.map = map;
    }

    /**
     * Returns the array of String used to create the map
     */
    public String[] getMap() {
        return this.map;
    }
}
