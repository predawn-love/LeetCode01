package myleetcode.amazon;

import myleetcode.bean.TreeNode;
import myleetcode.utils.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q235LowestCommonAnccestorOfABST {
    /**
     * 思路：两次遍历获得路径后，对路径进行匹配
     * 不能用原生 dfs 模板获取路径，取到的不一致。这个是 BST，考虑利用 BST 的性质。
     */
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = getPath(root, p);
        List<TreeNode> l2 = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < l1.size() && i < l2.size(); i++) {
            if (l1.get(i) == l2.get(i)) {
                ancestor = l1.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode t) {
        List<TreeNode> res = new ArrayList<>();
        while (root.val != t.val) {
            res.add(root);
            if (root.val < t.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        res.add(root);
        return res;
    }

    /**
     * 利用 BST 的性质，根据大小判断在左右子树的哪一棵。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = null;
        while (true) {
            if (root.val < p.val && root.val < q.val) {
                ancestor = root;
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                ancestor = root;
                root = root.left;
            } else {
                ancestor = root;
                break;
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        Object[] objects = new Object[]{6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = BinaryTreeUtil.getTreeNode(objects);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(8);
        TreeNode treeNode = new Q235LowestCommonAnccestorOfABST().lowestCommonAncestor(root, a, b);
        System.out.println(treeNode.val);
    }

}
