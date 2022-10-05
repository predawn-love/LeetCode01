package myleetcode.array;

public class Q674LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        for (int l = 0, r = 1; r < n; r++) {
            if (nums[r] <= nums[r - 1]) {
                l = r;
                continue;
            }
            if (r - l == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }
}
