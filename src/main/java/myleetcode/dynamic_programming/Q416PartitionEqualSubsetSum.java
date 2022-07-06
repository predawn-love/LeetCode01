package myleetcode.dynamic_programming;

public class Q416PartitionEqualSubsetSum {
    public boolean canPartition0(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum >> 1;
        int n = nums.length;

        // dp[i][j] 表示考虑到第 i 个数为止，凑出总和最接近 target 的集合，其总和是多少
        int[][] dp = new int[n][target + 1];

        // 先处理考虑第 1 件物品的情况
        for (int j = 0; j <= target; j++) {
            dp[0][j] = j >= nums[0] ? nums[0] : 0;
        }

        // 再处理考虑其余物品的情况
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j <= target; j++) {
                // 不选第 i 件物品
                int no = dp[i - 1][j];
                // 选第 i 件物品
                int yes = j >= t ? dp[i - 1][j - t] + t : 0;
                dp[i][j] = Math.max(no, yes);
            }
        }

        // 如果最大价值等于 target，说明可以拆分成两个
        return dp[n - 1][target] == target;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum >> 1;
        int n = nums.length;

        // dp[i][j] 表示考虑到第 i 个数为止，凑出总和最接近 target 的集合，其总和是多少
        int[][] dp = new int[2][target + 1];

        // 先处理考虑第 1 件物品的情况
        for (int j = 0; j <= target; j++) {
            dp[0][j] = j >= nums[0] ? nums[0] : 0;
        }

        // 再处理考虑其余物品的情况
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j <= target; j++) {
                // 不选第 i 件物品
                int no = dp[(i - 1) & 1][j];
                // 选第 i 件物品
                int yes = j >= t ? dp[(i - 1) & 1][j - t] + t : 0;
                dp[i & 1][j] = Math.max(no, yes);
            }
        }

        // 如果最大价值等于 target，说明可以拆分成两个
        return dp[(n - 1) & 1][target] == target;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum >> 1;
        int n = nums.length;

        // dp[i][j] 表示考虑到第 i 个数为止，凑出总和最接近 target 的集合，其总和是多少
        int[] dp = new int[target + 1];

        // 先处理考虑第 1 件物品的情况
        for (int j = 0; j <= target; j++) {
            dp[j] = j >= nums[0] ? nums[0] : 0;
        }

        // 再处理考虑其余物品的情况
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = target; j >= 0; j--) {
                // 不选第 i 件物品
                int no = dp[j];
                // 选第 i 件物品
                int yes = j >= t ? dp[j - t] + t : 0;
                dp[j] = Math.max(no, yes);
            }
        }

        // 如果最大价值等于 target，说明可以拆分成两个
        return dp[target] == target;
    }
}







