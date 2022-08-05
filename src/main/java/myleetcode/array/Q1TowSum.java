package myleetcode.array;

import java.util.HashMap;

public class Q1TowSum {
//    public int[] TwoSum(int[] nums, int target) {
//        int l = 0;
//        if (nums.length < 2) {
//            return null;
//        }
//        int length = nums.length;
//        for (; l < length - 1; l++) {
//            for (int r = l + 1; r < length; r++) {
//                if (nums[l] + nums[r] == target) {
//                    return new int[]{l, r};
//                }
//            }
//        }
//        return null;
//    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.containsKey(target - nums[i])) {
                return new int[]{i, hs.get(target - nums[i])};
            }
            hs.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] res = new Q1TowSum().twoSum(nums, 6);
        if (res == null) {
            System.out.println("null");
        } else {
            for (int i : res) {
                System.out.print(i + ", ");
            }
        }

    }
}
