package myleetcode.amazon;

public class Q200NumberOfIslands {
    public static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int count;
    private int rows, cols;
    private boolean[][] visited;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        count = 0;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                dfs(grid, i, j);
                count++;
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int[] dir : DIRS) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            dfs(grid, nextX, nextY);
        }
    }
}
