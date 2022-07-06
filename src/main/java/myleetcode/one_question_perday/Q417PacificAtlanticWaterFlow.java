package myleetcode.one_question_perday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q417PacificAtlanticWaterFlow {
    private int n, m;
    private int[][] g;
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        g = heights;
        m = g.length;
        n = g[0].length;
        Deque<int[]> d1 = new ArrayDeque<>();
        Deque<int[]> d2 = new ArrayDeque<>();
        boolean[][] res1 = new boolean[m][n];
        boolean[][] res2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    res1[i][j] = true;
                    d1.addLast(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    res2[i][j] = true;
                    d2.addLast(new int[]{i, j});
                }
            }
        }
        bfs(d1, res1);
        bfs(d2, res2);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private void bfs(Deque<int[]> d, boolean[][] res) {
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1], t = g[x][y];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (res[nx][ny] || g[nx][ny] < t) {
                    continue;
                }
                d.addLast(new int[]{nx, ny});
                res[nx][ny] = true;
            }
        }
    }

    class Solution {
        int N = 200 * 200 + 10;
        int[] p1 = new int[N];
        int[] p2 = new int[N];
        int n, m, tot, S, T;
        int[][] g;
        private void union(int[] p, int a, int b) {
            p[find(p, a)] = p[find(p, b)];
        }
        int find(int[] p, int x) {
            if (p[x] != x) {
                p[x] = find(p, p[x]);
            }
            return p[x];
        }

        boolean query(int[] p, int a, int b) {
            return find(p, a) == find(p, b);
        }

        int getIdx (int x, int y) {
            return x * n + y;
        }

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        public List<List<Integer>> pacificAtlantic(int[][] _g) {
            g = _g;
            m = g.length; n = g[0].length; tot = n * m; S = tot + 1; T = tot + 2;
            List<List<Integer>> ans = new ArrayList<>();
            return ans;
        }

        void dfs(int[] p, int ori, int x, int y) {
            union(p, ori, getIdx(x, y));
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (query(p, ori, getIdx(nx, ny)) || g[nx][ny] < g[x][y]) {
                    continue;
                }
                dfs(p, ori, nx, ny);
            }
        }



    }

}
