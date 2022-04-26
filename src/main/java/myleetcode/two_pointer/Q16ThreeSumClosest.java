package myleetcode.two_pointer;

import java.util.Arrays;

public class Q16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sumTemp = nums[i] + nums[l] + nums[r];
                int abs = Math.abs(sumTemp - target);
                if (abs < difference) {
                    ans = sumTemp;
                    difference = abs;
                }
                if (sumTemp < target) {
                    l++;
                } else if (sumTemp > target) {
                    r--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
}
