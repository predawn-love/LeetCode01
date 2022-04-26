package myleetcode.jian_zhi_offer_special_assaults.day03;

import java.util.*;

public class TreeSum {
    /**
     * 暴力 N^3，去重方式：排序后 Set
     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums == null || nums.length < 3) {
//            return new ArrayList<>();
//        }
//        int n = nums.length;
//        Arrays.sort(nums);
//        Set<List<Integer>> res = new HashSet<>();
//        for (int i = 0; i < n - 2; i++) {
//            for (int j = i + 1; j < n - 1; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }


    /**
     * N^2，双指针找 -nums[i] == nums[j] + nums[k]
     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums == null || nums.length < 3) {
//            return new ArrayList<>();
//        }
//        int n = nums.length;
//        Arrays.sort(nums);
//        Set<List<Integer>> res = new HashSet<>();
//        for (int i = 0; i < n - 2; i++) {
//            int target = -nums[i];
//            int l = i + 1;
//            int r = n - 1;
//            int sum;
//            while (l < r) {
//                sum = nums[l] + nums[r];
//                if (sum < target) {
//                    l++;
//                } else if (sum > target) {
//                    r--;
//                } else {
//                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }


    /**
     * 再次优化，去重小技巧
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = n - 1;
            int sum;
            while (l < r) {
                sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // 只有符合条件需要加入的时候，才可能有重复的三元组。
                    // 不符合条件的，连加入结果集都做不到，更不用提重复。
                    while (l < r && nums[r] == nums[--r]);
                    while (l < r && nums[l] == nums[++l]);
                }
            }
        }
        return res;
    }
}
