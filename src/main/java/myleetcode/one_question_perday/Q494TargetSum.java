package myleetcode.one_question_perday;

import java.util.HashMap;

public class Q494TargetSum {
class c1{
    /**
     * 全局变量维护的爆搜
     */
    private int n;
    private int target;
    private int res;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        this.target = target;
        res = 0;
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int index, int curSum) {
        if (index == n) {
            if (curSum == target) {
                res++;
            }
            return;
        }
        dfs(nums, index + 1, curSum + nums[index]);
        dfs(nums, index + 1, curSum - nums[index]);
    }
}

class c2 {
    /**
     * 带返回值的爆搜
     */
    private int n;
    public int findTargetSumWays(int[] nums, int t) {
        n = nums.length;
        return dfs(nums, 0, 0, t);
    }

    private int dfs(int[] nums, int index, int curSum, int t) {
        if (index == n) {
            return curSum == t ? 1 : 0;
        }
        int left = dfs(nums, index + 1, curSum + nums[index], t);
        int right = dfs(nums, index + 1, curSum - nums[index], t);
        return left + right;
    }
}

class c3 {
    /**
     * 记忆化搜索
     */
    private int n;
    private HashMap<String, Integer> cache;
    public int findTargetSumWays(int[] nums, int t) {
        n = nums.length;
        cache = new HashMap<>();
        return dfs(nums, 0, 0, t);
    }

    private int dfs(int[] nums, int index, int curSum, int t) {
        if (index == n) {
            return curSum == t ? 1 : 0;
        }
        String key = index + "_" + curSum;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int left = dfs(nums, index + 1, curSum + nums[index], t);
        int right = dfs(nums, index + 1, curSum - nums[index], t);
        cache.put(key, left + right);
        return left + right;
    }
}
}
