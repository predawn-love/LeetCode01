package myleetcode.amazon;

import java.util.Arrays;

public class MissingNumber {
//    public int missingNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int missingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }
        for (int i : nums) ans ^= i;
        return ans;
    }
}
