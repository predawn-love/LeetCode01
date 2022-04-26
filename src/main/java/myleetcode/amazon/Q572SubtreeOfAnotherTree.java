package myleetcode.amazon;

import myleetcode.bean.TreeNode;

public class Q572SubtreeOfAnotherTree {
    /**
     * 暴力 dfs，搜索到 root 里面的 subRoot，然后同步 check 是否相等。
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }


    /**
     * 这样做不对，因为没有说树中节点值唯一
     */
//    private boolean flag;
//    private TreeNode subNode;
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        flag = false;
//        subNode = null;
//        dfs(root, subRoot);
//        if (subNode == null) {
//            return false;
//        }
//        return check(subNode, subRoot);
//    }
//
//    private boolean check(TreeNode s, TreeNode t) {
//        if (s == null && t == null) {
//            return true;
//        }
//        if (s == null || t == null || s.val != t.val) {
//            return false;
//        }
//        return check(s.left, t.left) && check(s.right, t.right);
//    }
//
//    private void dfs(TreeNode root, TreeNode subRoot) {
//        if (root == null || flag) return;
//        if (root.val == subRoot.val) {
//            flag = true;
//            subNode = root;
//            return;
//        }
//        dfs(root.left, subRoot);
//        dfs(root.right, subRoot);
//    }

//    public boolean check(TreeNode s, TreeNode t) {
//        if (s == null && t == null) {
//            return true;
//        }
//        if (s == null || t == null || s.val != t.val) {
//            return false;
//        }
//        return check(s.left, t.left) && check(s.right, t.right);
//    }
}
