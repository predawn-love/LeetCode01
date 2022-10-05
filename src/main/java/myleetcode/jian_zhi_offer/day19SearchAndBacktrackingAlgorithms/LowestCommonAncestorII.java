package myleetcode.jian_zhi_offer.day19SearchAndBacktrackingAlgorithms;

public class LowestCommonAncestorII {
//    public myleetcode.TreeNode lowestCommonAncestor(myleetcode.TreeNode root, myleetcode.TreeNode p, myleetcode.TreeNode q) {
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//        myleetcode.TreeNode left = lowestCommonAncestor(root.left, p, q);
//        myleetcode.TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left == null && right == null) {
//            return null;
//        }
//        if (left == null) {
//            return right;
//        }
//        if (right == null) {
//            return left;
//        }
//        return root;    // left != null && right != null
//    }


    /**
     * 合并一下重复的条件
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        return root;
    }
}



















