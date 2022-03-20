package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int l = j + 1;
                int r = n - 1;

            }
        }
        return res;
    }
}


