import java.util.*;

class Robot {
    public int w, h;
    public int x, y;
    public int dir; // 0 = East, 1 = North, 2 = West, 3 = South
    public int perimeter;
    
    public int[][] directions = {
        {1, 0},   // East
        {0, 1},   // North
        {-1, 0},  // West
        {0, -1}   // South
    };
    public String[] dirNames = {"East", "North", "West", "South"};
    public Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dir = 0;
        perimeter = 2 * (w + h - 2);
    }
    public void step(int num) {
        if (perimeter == 0) return;
        num %= perimeter;
        if (num == 0) num = perimeter;
        while (num-- > 0) {
            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];
            if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                dir = (dir + 1) % 4;
                nx = x + directions[dir][0];
                ny = y + directions[dir][1];
            }
            x = nx;
            y = ny;
        }
    }
    public int[] getPos() {
        return new int[]{x, y};
    }
    public String getDir() {
        return dirNames[dir];
    }
}