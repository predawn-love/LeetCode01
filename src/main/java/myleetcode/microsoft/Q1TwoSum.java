package myleetcode.microsoft;

import java.util.HashMap;
import java.util.Map;

public class Q1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> numVsIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numVsIndices.containsKey(target - nums[i])) {
                return new int[]{i, numVsIndices.get(target - nums[i])};
            } else {
                numVsIndices.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = new Q1TwoSum().twoSum(nums, target);
        System.out.println("---");
    }
}
