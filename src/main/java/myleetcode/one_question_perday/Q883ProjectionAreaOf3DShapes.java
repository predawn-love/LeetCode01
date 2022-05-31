package myleetcode.one_question_perday;

public class Q883ProjectionAreaOf3DShapes {
    /**
     * 暴力模拟
     */
    public static final int N = 50;
    public int projectionArea(int[][] grid) {
        int res = 0;
        boolean[][] yz = new boolean[N][N];
        boolean[][] xz = new boolean[N][N];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                int z = grid[x][y];
                if (z == 0) {
                    continue;
                }
                res++;
                for (int k = 0; k < z; k++) {
                    if (xz[x][k]) {
                        continue;
                    }
                    xz[x][k] = true;
                    res++;
                }
                for (int k = 0; k < z; k++) {
                    if (yz[y][k]) {
                        continue;
                    }
                    yz[y][k] = true;
                    res++;
                }
            }
        }
        return  res;
    }
}
