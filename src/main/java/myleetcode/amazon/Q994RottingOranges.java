package myleetcode.amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Q994RottingOranges {
    public static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int freshOrangesNums = 0;
        Queue<int[]> rottenOrangesQueue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rottenOrangesQueue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOrangesNums++;
                }
            }
        }

        if (freshOrangesNums == 0) {
            return 0;
        }

        int time = -1;
        while (!rottenOrangesQueue.isEmpty()) {
            int size = rottenOrangesQueue.size();
            time++;
            while (size-- > 0) {
                int[] rottenLoc = rottenOrangesQueue.poll();
                int x = rottenLoc[0];
                int y = rottenLoc[1];
                for (int[] dir : DIRS) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (nextX < 0 || nextX >= rows || nextY >= cols || nextY < 0) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        rottenOrangesQueue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        freshOrangesNums--;
                    }
                }
            }
        }

        return freshOrangesNums == 0 ? time : -1;
    }
}
