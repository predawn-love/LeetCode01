package myleetcode.interview.zi_jie_tiao_dong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q300LongestIncreasingSubsequence {
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//
//        // dp[i] 表示 nums 数组中，
//        // 以 i 下标元素为结尾元素能构成的最长递增子序列的长度是 dp[i];
//        int[] dp = new int[n];
//
//        // 初始化 dp 数组
//        Arrays.fill(dp, 1); // {1,1,1,1,1,1}
//
//        // 记录当前计算过的最长递增子序列有多长
//        int maxLen = 1;
//
//        // 注：先遍历的是当前物品，针对当前物品进行状态转移
//        for (int i = 1; i < n; i++) {
//            // 把 0 和 i 比较， 1 和 i 比较，....，i-1和i比较。
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    // dp[j] 表示 0,1, ... ,j - 1, j
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                }
//            }
//            maxLen = Math.max(maxLen, dp[i]);
//        }
//        return maxLen;
//    }

//    /**
//     * 暴力构建所有的子序列，记录子序列最长长度.
//     * 宝宝的思路。
//     */
//    private int maxLen;
//    private int n;
//    public int lengthOfLIS(int[] nums) {
//        n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        maxLen = 1;
//        // [2, 6, 8, 5, 7]
//        for (int i = 0; i < n; i++) {
//            LinkedList<Integer> ll = new LinkedList<>(); // {}
//            int a = 2;
//            ll.add(nums[i]); // {2}
//            dfs(nums, i, ll);
//        }
//        return maxLen;
//    }

    /**
     * Deep(深度) Firstly(优先) Search(搜索)  深度优先搜索
     *
     * @param nums  nums 数组
     * @param index int 类型，用于记录当前需要处理的元素在 nums 数组是什么下标。(nums[index])
     * @param list  用于记录当前已构建的子序列
     */
    private void dfs(int[] nums, int index, LinkedList<Integer> list) {
        if (index == n) {
            return;
        }
        for (int i = index + 1; i < n; i++) {
            boolean hasInserted = false;
            if (nums[i] > list.peekLast()) {
                list.addLast(nums[i]);
                hasInserted = true;
                maxLen = Math.max(list.size(), maxLen);
            } else {
                continue;
            }
            dfs(nums, i, list);
            if (hasInserted) {
                list.pollLast();
            }
        }
    }

    /**
     * 暴力构建所有的子序列，记录子序列最长长度.
     * 宝宝的思路。
     */
    private int maxLen;
    private int n;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        if (n == 0) {
            return 0;
        }
        maxLen = 1;
        // [2, 6, 8, 5, 7]
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> ll = new LinkedList<>(); // {}
            ll.add(nums[i]); // {2}
            dfs(nums, i, ll);
        }
        return maxLen;
    }


    public static void main(String[] args) {
//        int result = new Q300LongestIncreasingSubsequence().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
//        int result = new Q300LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        int result = new Q300LongestIncreasingSubsequence().lengthOfLIS(new int[]{0,1,0,3,2,3});
        System.out.println(result);
    }
}
