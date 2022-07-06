package myleetcode.one_question_perday;

import java.util.HashMap;
import java.util.Map;

public class Q523ContinuousSubarraySum {
    /**
     * 思路： (prefixSum[i] - prefixSum[j]) % k == 0
     * 相当于： prefixSum[i] % k == prefixSum[j] % k
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> remainderVsIndex = new HashMap<>();
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i <= n; i++) {
            int remainder = prefixSum[i] % k;
            if (remainderVsIndex.containsKey(remainder)) {
                if (i - remainderVsIndex.get(remainder) >= 2) {
                    return true;
                }
            } else {
                remainderVsIndex.put(remainder, i);
            }
        }
        return false;
    }

    /**
     * 思路： (prefixSum[i] - prefixSum[j]) % k == 0
     * 相当于： prefixSum[i] % k == prefixSum[j] % k
     *
     * 优化：不用辅助数组
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderVsIndex = new HashMap<>();
        int n = nums.length;

        int remainder = 0;
        remainderVsIndex.put(0, -1);
        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if (remainderVsIndex.containsKey(remainder)) {
                if (i - remainderVsIndex.get(remainder) >= 2) {
                    return true;
                }
            } else {
                remainderVsIndex.put(remainder, i);
            }
        }
        return false;
    }
}
