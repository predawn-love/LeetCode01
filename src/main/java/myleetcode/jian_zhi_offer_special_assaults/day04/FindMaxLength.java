package myleetcode.jian_zhi_offer_special_assaults.day04;

import java.util.HashMap;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixSumVsMinIndex = new HashMap<>();
        prefixSumVsMinIndex.put(0, 0);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum += nums[i - 1] == 0 ? - 1 : 1;
            if (prefixSumVsMinIndex.containsKey(prefixSum)) {
                res = Math.max(res, i - prefixSumVsMinIndex.get(prefixSum));
            } else {
                prefixSumVsMinIndex.put(prefixSum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
