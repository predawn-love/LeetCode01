package myleetcode.amazon;

import java.util.*;

public class Q18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            for (int b = a + 1; b < n - 2; b++) {
                for (int c = b + 1, d = n - 1; c < d;) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        res.add(list);
                        while (d - 1 > c && nums[d - 1] == nums[d]) {
                            d--;
                        }
                        d--;
                        while (c + 1 < d && nums[c + 1] == nums[c]) {
                            c++;
                        }
                        c++;
                    } else if (sum > target) {
                        while (d - 1 > c && nums[d - 1] == nums[d]) {
                            d--;
                        }
                        d--;
                    } else {
                        while (c + 1 < d && nums[c + 1] == nums[c]) {
                            c++;
                        }
                        c++;
                    }
                }
                while (b < n - 2 && nums[b + 1] == nums[b]) {
                    b++;
                }
            }
            while (a < n - 3 && nums[a + 1] == nums[a]) {
                a++;
            }
        }
        return res;
    }
}
