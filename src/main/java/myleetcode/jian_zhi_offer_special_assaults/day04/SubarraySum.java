package myleetcode.jian_zhi_offer_special_assault.day04;

import java.util.HashMap;

public class SubarraySum {
    /**
     * 不能简单地滑动窗口往前，因为可能有负数在数组里面。
     * 因此考虑前缀和
     */
//    public int subarraySum(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int n = nums.length;
//        int[] sums = new int[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        int res = 0;
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = i + 1; j < n + 1; j++) {
//                if (sums[j] - sums[i] == k) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }

    /**
     * 前缀和，不想双重循环，考虑哈希表进行优化
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixSumVsNums = new HashMap<>();
        prefixSumVsNums.put(0, 1);  //  对应以前的 sums[0];
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            prefixSum = prefixSum + nums[i - 1];
            res += prefixSumVsNums.getOrDefault( prefixSum - k, 0);
            prefixSumVsNums.put(prefixSum, prefixSumVsNums.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        new SubarraySum().subarraySum(new int[]{1,-1,0}, 0);
    }
}
