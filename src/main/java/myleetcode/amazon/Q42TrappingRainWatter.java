package myleetcode.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution42 {
    public int trap(int[] height) {
        int n = height.length;
        // 单调栈维护的是已遍历域中第一个原始数组中大于当前元素的元素的下标值。
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 记录上一个横切层的高度上限是多少。
            int last = 0;
            // 维护单调栈的同时计算每一个横切层
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int t = stack.pop();
                // 此横切层以栈顶元素为高度上限
                res += (i - t - 1) * (height[t] - last);
                last = height[t];
            }
            // 假设有一个当前元素大的在已遍历域中，那么要再计算一个横切面，此横切层以当前元素为高度上限
            if (!stack.isEmpty()) {
                res += (i - stack.peek() - 1) * (height[i] - last);
            }
            // 当前元素入栈
            stack.push(i);
        }
        return res;
    }
}
public class Q42TrappingRainWatter {
    public int trap(int[] height) {

        return 0;
    }
}
