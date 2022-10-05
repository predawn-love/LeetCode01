package myleetcode.jian_zhi_offer.day14SearchAndBacktracking;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {
    /**
     * 自己写的
     */
//    private int ans = 0;
//    private static int[][] DIRECTION = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//    public int movingCount(int m, int n, int k) {
//        int[][] map = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int a = i, b = j;
//                while (a != 0 || b != 0) {
//                    map[i][j] += (a % 10);
//                    map[i][j] += (b % 10);
//                    a /= 10;
//                    b /= 10;
//                }
//            }
//        }
//        dfs(0, 0, k, m, n, map);
//        return ans;
//    }
//
//    private void dfs(int i, int j, int k, int m, int n, int[][] map) {
//        if (i < 0 || i >= m || j < 0 || j >= n) {
//            return;
//        }
//        if (map[i][j] > k) {
//            return;
//        }
//        map[i][j] = Integer.MAX_VALUE;
//        ans++;
//        for (int[] ints : DIRECTION) {
//            dfs(i + ints[0], j + ints[1], k, m, n, map);
//        }
//    }

    public static void main(String[] args) {

        new MovingCount().movingCount(2, 2, 3);
    }

    /**
     * 深度优先搜索， 因为 1 <= n,m <= 100 所以计算数位和有公式成立： (x + 1) % 10 != 0 ? s_x + 1 : s_x - 8;
     * 设 x 的数位和为 s_x ， x+1 的数位和为 s_x+1
     * 当 (x + 1) % 10 == 0时, s_x+1 = s_x - 8;
     * 当 (x + 1) % 10 != 0时, s_x+1 = s_x + 1;
     */
//    int m,n,k;
//    boolean[][] visited;
//    public int movingCount(int m, int n, int k) {
//        this.m = m;
//        this.n = n;
//        this.k = k;
//        this.visited = new boolean[m][n];
//        return dfs(0, 0, 0, 0);
//    }
//
//    private int dfs(int i, int j, int si, int sj) {
//        if (j >= n || i >= m || k < si + sj || visited[i][j]) {
//            return 0;
//        }
//        visited[i][j] = true;
//        return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj) + dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1);
//    }

    /**
     * 广度优先搜索
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || si + sj > k || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1});
        }
        return res;
    }

}
