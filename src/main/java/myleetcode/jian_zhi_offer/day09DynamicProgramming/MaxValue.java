package myleetcode.jian_zhi_offer.day09DynamicProgramming;

public class MaxValue {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // dp[i][j] 表示到 grid[i][j] 最多能拿多少价值的礼物
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        // 初始化第一列
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 初始化第一行
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
