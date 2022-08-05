package myleetcode.jian_zhi_offer.day13DoublePointer;

public class TwoSum {
//    public int[] twoSum(int[] nums, int target) {
//        Set<Integer> hs = new HashSet<>();
//        for (int i : nums) {
//            if (hs.contains(target - i)) {
//                return new int[]{i, target - i};
//            }
//            hs.add(i);
//        }
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int sum;
        while (l < r) {
            sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return null;
    }
}
