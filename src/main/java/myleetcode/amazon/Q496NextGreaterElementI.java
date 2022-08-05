package myleetcode.amazon;

import java.util.*;

public class Q496NextGreaterElementI {
    /**
     * 单调栈 —— 模板题 AcWing 830. 单调栈
     * 常见模型：找出每个数左边离它最近的比它大/小的数
     * int tt = 0;
     * for (int i = 1; i <= n; i ++ )
     * {
     *     while (tt && check(stk[tt], i)) tt -- ;
     *     stk[ ++ tt] = i;
     * }
     */

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums1.length, m = nums2.length;
            Deque<Integer> d = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = m - 1; i >= 0; i--) {
                int x = nums2[i];
                while (!d.isEmpty() && d.peekLast() <= x) d.pollLast();
                map.put(x, d.isEmpty() ? -1 : d.peekLast());
                d.addLast(x);
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) ans[i] = map.get(nums1[i]);
            return ans;
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int x = nums2[i];
            while (!d.isEmpty() && d.peekLast() <= x) {
                d.pollLast();
            }
            map.put(x, d.isEmpty() ? -1 : d.peekLast());
            d.addLast(x);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }












}
