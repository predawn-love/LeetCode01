package myleetcode.one_question_perday;

import java.util.HashMap;
import java.util.Map;

public class Q525ContinuousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        Map<Integer, Integer> prefixSumVsIndex = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = (nums[i] == 1 ? 1 : -1) + prefixSum[i];
            if (prefixSumVsIndex.containsKey(prefixSum[i + 1])) {
                maxLength = Math.max(maxLength, i + 1 - prefixSumVsIndex.get(prefixSum[i + 1]));
            } else if (prefixSum[i + 1] == 0){
                maxLength = i + 1;
            } else {
                prefixSumVsIndex.put(prefixSum[i + 1], i + 1);
            }
        }
        return maxLength;
    }
}
