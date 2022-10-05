package myleetcode.jian_zhi_offer.day18SearchAndBacktrackingAlgorithms;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class MaxDepth {
    /**
     * 自己的解法：深度优先遍历的时候记录深度
     */
//    int depth;
//    public int maxDepth(myleetcode.TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        depth = 1;
//        dfs(root, 1);
//        return depth;
//    }
//
//    private void dfs(myleetcode.TreeNode root, int depth) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left, depth + 1);
//        this.depth = Math.max(this.depth, depth);
//        dfs(root.right, depth + 1);
//    }

    /**
     * Krahets 的后序遍历解法
     */
//    public int maxDepth(myleetcode.TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

    /**
     * Krahets 的层序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        List<TreeNode> tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res++;
        }
        return res;
    }







}
