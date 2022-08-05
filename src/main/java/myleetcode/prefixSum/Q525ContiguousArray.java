package myleetcode.prefixSum;

import java.util.HashMap;

public class Q525ContiguousArray {
    public int findMaxLength(int[] nums) {
        int res = 0;
        // hs中存储的是前缀和和该前缀和第一次出现时的下标
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0, -1);
        for (int i = 0, prefixSum = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                prefixSum -= 1;
            } else {
                prefixSum += 1;
            }
            if (hs.containsKey(prefixSum)) {
                int length = i - hs.get(prefixSum);
                res = Math.max(res, length);
            } else {
                hs.put(prefixSum, i);
            }
        }
        return res;
    }
}
