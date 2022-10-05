package myleetcode.jian_zhi_offer.day07SearchAndBacktrackingAlgorithm;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class IsSubStructure {

    // 1、先序遍历树A中的每个节点NodeA   isSubStructure(myleetcode.TreeNode A, myleetcode.TreeNode B)
    // 2、判断数A中 以NodeA为根节点的子树是否包含树B   recur(myleetcode.TreeNode A, myleetcode.TreeNode B)

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // B 树为空也得返回 false
        if (A == null || B == null) {
            return false;
        }

        // 这样提前返回的话，如果 A 树中有和B树根节点相同的重复节点，就会出错
//        if (A.val == B.val) {
//            return recur(A, B);
//        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return recur(A.right, B.right) && recur(A.left, B.left);
    }


}
