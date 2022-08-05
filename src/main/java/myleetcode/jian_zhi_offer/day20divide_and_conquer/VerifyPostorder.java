package myleetcode.jian_zhi_offer.day20divide_and_conquer;

import java.util.Stack;

public class VerifyPostorder {
    /**
     *  递归分治
     */
//    public boolean verifyPostorder(int[] postorder) {
//        return recur(postorder, 0, postorder.length - 1);
//    }
//
//    boolean recur(int[] postorder, int l, int r) {
//        if (l >= r) {
//            return true;
//        }
//        int p = l;
//        while (postorder[p] < postorder[r]) {
//            p++;
//        }
//        int m = p;
//        while (postorder[p] > postorder[r]) {
//            p++;
//        }
//        return p == r && recur(postorder, l, m - 1) && recur(postorder, m, r - 1);
//    }

    /**
     * 单调栈
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 后序遍历的倒序就是 [根节点| 右子树| 左子树]
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
