package myleetcode.depth_first_search;

public class Q256PaintHouse {
class c1{
    /**
     * 暴力递归
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, recursion(costs, 0, i));
        }
        return res;
    }

    /**
     *
     * @param costs
     * @param index 当前位置
     * @param paintIndex    当前粉刷颜色位置
     * @return
     */
    private int recursion(int[][] costs, int index, int paintIndex) {
        if (index == costs.length) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != paintIndex) {
                res = Math.min(res, recursion(costs, index + 1, i));
            }
        }
        return res + costs[index][paintIndex];
    }
}

class c2{
    private int n;

    public int minCost(int[][] costs) {
        n = costs.length;
        int[][] cache = new int[n][3];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            res = Math.min(res, memorySearch(costs, cache, 0, j));
        }
        return res;
    }

    private int memorySearch(int[][] costs, int[][] cache, int index, int paintIndex) {
        if (index == n) {
            return 0;
        }

        int temp = Integer.MAX_VALUE;
        if (cache[index][paintIndex] != 0) {
            return cache[index][paintIndex];
        }
        for (int i = 0; i < 3; i++) {
            if (i == paintIndex) {
                continue;
            }
            temp = Math.min(temp, costs[index][paintIndex] + memorySearch(costs, cache, index + 1, i));
        }
        cache[index][paintIndex] = temp;
        return temp;
    }
}

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = Math.min(dp[i + 1][1], dp[i + 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i + 1][0], dp[i + 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i + 1][0], dp[i + 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }
}
