package myleetcode.jian_zhi_offer_special_assault.day04;

import java.util.Arrays;

public class PivotIndex {
    /**
     * 前缀和+后缀和
     */
//    public int pivotIndex(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        int n = nums.length;
//        // prefixSums[i] 表示 0 ~ i - 1 的前缀和，不含 nums[i];
//        int[] prefixSums = new int[n + 2];
//        int[] suffixSums = new int[n + 2];
//        for (int i = 2; i < n + 2; i++) {
//            prefixSums[i] = prefixSums[i - 1] + nums[i - 2];
//            suffixSums[n + 2 - i - 1] = suffixSums[n + 2 - i] + nums[n + 2 - i - 1];
//        }
//        for (int i = 1; i < n + 1; i++) {
//            if (prefixSums[i] == suffixSums[i]) {
//                return i - 1;
//            }
//        }
//        return -1;
//    }

    /**
     * 单前缀和
     */
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int total = Arrays.stream(nums).sum();
        int n = nums.length;
        int sum = 0;
        // prefixSums[i] 表示 0 ~ i - 1 的前缀和，不含 nums[i];
        for (int i = 0; i < n; i++) {
            if (sum == total - sum - nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int[] nums = {-1, -1, 0, 1, 1, 0};
        int index = pivotIndex.pivotIndex(nums);
        System.out.println(index);
    }
}
