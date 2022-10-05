package myleetcode.jian_zhi_offer.day19SearchAndBacktrackingAlgorithms;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class LowestCommonAncestor {
//    public myleetcode.TreeNode lowestCommonAncestor(myleetcode.TreeNode root, myleetcode.TreeNode p, myleetcode.TreeNode q) {
//        while (root != null) {
//            if (root.val < p.val && root.val < q.val) {
//                // p、q都在root的右子树上
//                root = root.right;
//            } else if (root.val > p.val && root.val > q.val) {
//                // p、q都在root的左子树上
//                root = root.left;
//            } else {
//                // 上面都不是，说明root就是p和q的最近公共祖先
//                break;
//            }
//        }
//        return root;
//    }


    /**
     * 优化：若可以保证 p.val < q.val，则在循环中可以减少判断条件
     */
//    public myleetcode.TreeNode lowestCommonAncestor(myleetcode.TreeNode root, myleetcode.TreeNode p, myleetcode.TreeNode q) {
//        if (p.val > q.val) {
//            myleetcode.TreeNode tmp = p;
//            p = q;
//            q = tmp;
//        }
//        while (root != null) {
//            if (root.val < p.val) {
//                root = root.right;
//            } else if (root.val > q.val) {
//                root = root.left;
//            } else {
//                break;
//            }
//        }
//        return root;
//    }

    /**
     * 递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
