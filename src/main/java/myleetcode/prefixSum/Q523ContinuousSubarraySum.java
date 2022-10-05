package myleetcode.prefixSum;

import java.util.HashMap;

public class Q523ContinuousSubarraySum {
    /**
     * 思路： (prefixSum[i] - prefixSum[j]) % k == 0
     *      相当于： prefixSum[i] % k == prefixSum[j] % k
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int[] prefixSum = new int[nums.length + 1];
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int reminder = 0;

        /**
         * 从 prefixSum 的第零位开始遍历，可以包含刚好长度为 2，且总和满足条件的数组。
         */
        for (int i = 0; i < prefixSum.length; i++) {
            reminder = prefixSum[i] % k;
            if (hs.containsKey(reminder)) {
                if (i - hs.get(reminder) >= 2) {
                    return true;
                }
            } else {
                hs.put(reminder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        boolean b = new Q523ContinuousSubarraySum().checkSubarraySum(new int[]{2, 2}, 2);
        boolean b = new Q523ContinuousSubarraySum().checkSubarraySum(new int[]{1,0,1,0,1,1}, 5);
        System.out.println(b);
    }


    /**
     * 优化实现思路：不用辅助数组
     */
//    public boolean checkSubarraySum(int[] nums, int k) {
//        if (nums.length < 2) {
//            return false;
//        }
//        HashMap<Integer, Integer> hs = new HashMap<>();
//        hs.put(0, -1);
//        int reminder = 0;
//        for (int i = 0; i < nums.length; i++) {
//            reminder = (reminder + nums[i]) % k;
//            if (hs.containsKey(reminder)) {
//                if (i - hs.get(reminder) >= 2) {
//                    return true;
//                }
//            } else {
//                hs.put(reminder, i);
//            }
//        }
//        return false;
//    }
}
