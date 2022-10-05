package myleetcode.amazon;

import java.util.*;

class MaximumMinimumPath {
    /**
     * 思路：贪心 + BFS (有点像带选择策略的 DFS，但是每次无法贪心地前进的时候，要从后备队列取值)
     * 因为全路径都是通的，我们只需要知道路径的最大得分即可返回。(不会全节点入队)
     * 所以我们贪心地每次都主动搜索下一个格子值 >= 目前已搜索过的最小值的方向
     * （即最理想的情况我们只出队了一条路径的节点数就找到了终点，一路从头跑到位）
     */
    public static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maximumMinimumPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // row, col, val
        PriorityQueue<int[]> backQueue = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        int score = grid[0][0];
        while (!backQueue.isEmpty() || !queue.isEmpty()) {
            // 已经通过贪心的入队策略，分开了 queue 和 backQueue 里面的节点
            // 我们要优先出队 queue，以避免全路径搜索，有点像在符合选择策略时 dfs 到底然后直接得到答案。
            if (queue.isEmpty()) { // get one from back queue
                int[] info = backQueue.poll();
                score = Math.min(score, info[2]);
                queue.add(info);
            }
            int[] info = queue.poll();

            // visit around, take the biggest one and put others to queue
            for (int[] dir : DIRS) {
                int nextX = info[0] + dir[0];
                int nextY = info[1] + dir[1];
                if (nextX >= rows || nextX < 0 || nextY >= cols || nextY < 0 || visited[nextX][nextY]) {
                    continue;
                }

                // FIXME:一定要在这里就设置为 true 不然会超时，具体逻辑还没有想明白
                visited[nextX][nextY] = true;

                // 直接结束所以不会全节点出队
                if (nextX == rows - 1 && nextY == cols - 1) {
                    return Math.min(grid[rows - 1][cols - 1], score);
                }

                // 贪心地只往 queue 中入队 大于等于 当前分数的节点，以尽量保证分数不下降
                if (grid[nextX][nextY] >= score) {
                    queue.add(new int[]{nextX, nextY, grid[nextX][nextY]});
                } else {
                    // 对于分数小于当前分数的节点，入队至后备队列中，若有用到该队列，则取最大分数的出队
                    // 因为任意路径都能通到最后节点，所以不用做全路径搜索也一定是通的。
                    backQueue.add(new int[]{nextX, nextY, grid[nextX][nextY]});
                }
            }
        }
        return score;
    }

}

public class Q1102PathWithMaximumMinimumValue {

    public static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maximumMinimumPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // row, col, val
        PriorityQueue<int[]> backQueue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        int score = grid[0][0];

        while (!queue.isEmpty() || !backQueue.isEmpty()) {
            if (queue.isEmpty()) {
                queue.add(backQueue.poll());
            }
            int[] poll = queue.poll();

            score = Math.min(score, poll[2]);
            int x = poll[0];
            int y = poll[1];

            for (int[] dir : DIRS) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 || nextY < 0 || nextY >= cols || nextX >= rows) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                // FIXME:一定要在这里就设置为 true 不然会超时，具体逻辑还没有想明白
                visited[nextX][nextY] = true;
                if (nextX == rows - 1 && nextY == cols - 1) {
                    return Math.min(grid[rows - 1][cols - 1], score);
                }

                if (grid[nextX][nextY] >= score) {
                    queue.add(new int[]{nextX, nextY, grid[nextX][nextY]});
                } else {
                    backQueue.add(new int[]{nextX, nextY, grid[nextX][nextY]});
                }
            }
        }
        return score;
    }


    public static void main(String[] args) {
        int i = new Q1102PathWithMaximumMinimumValue().maximumMinimumPath(new int[][]{{5, 4, 5}, {1, 2, 6}, {7, 4, 6}});
//        int i = new Q1102PathWithMaximumMinimumValue().maximumMinimumPath(new int[][]{{2,2,1,2,2,2},{1,2,2,2,1,2}});
        System.out.println(i);
    }


}
