package myleetcode.jian_zhi_offer.day18SearchAndBacktrackingAlgorithms;

public class IsBalanced {
    /**
     * 自己的思路： 遍历二叉树全节点，对每一个节点判断左子树深度和右子树深度差是否大于1，
     *              大于的话更新 balanced 变量为 false，全遍历结束得到答案。没有剪枝
     */
//    boolean balanced = true;
//    public boolean isBalanced(myleetcode.TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        dfs(root);
//        return balanced;
//    }
//
//    private void dfs(myleetcode.TreeNode root) {
//        if (root == null || !balanced) {
//            return;
//        }
//        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
//            balanced = false;
//        }
//        dfs(root.left);
//        dfs(root.right);
//    }
//
//    public int maxDepth(myleetcode.TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

    /**
     * 先序遍历+判断深度（从顶至底）
     */
//    public boolean isBalanced(myleetcode.TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int depth(myleetcode.TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(depth(root.left), depth(root.right)) + 1;
//    }

    /**
     * 后序遍历+剪枝（从底至顶）
     */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
