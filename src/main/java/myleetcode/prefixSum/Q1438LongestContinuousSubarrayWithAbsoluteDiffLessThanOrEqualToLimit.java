package myleetcode.prefixSum;

public class Q1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int[][] diffs = new int[n][n];
        int ans = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = Math.abs(nums[i] - nums[j]);
                diffs[i][j] = Math.max(diff, diffs[i][j  + 1]);
                if (diffs[i][j] <= limit && i - j + 1 > ans) {
                    ans = i - j + 1;
                    if (ans == 3) {
                        System.out.println("...");
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int i = new Q1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().longestSubarray(
                new int[]{8, 2, 4, 7}, 4
        );
        System.out.println(i);
    }
}
