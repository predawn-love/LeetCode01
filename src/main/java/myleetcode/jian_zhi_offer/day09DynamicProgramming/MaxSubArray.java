package myleetcode.jian_zhi_offer.day09DynamicProgramming;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // dp[i]表示以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        if (nums == null || nums.length < 1) {
            return 0;
        }
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        new MaxSubArray().maxSubArray(new int[]{0,1,2,1});
    }
}
