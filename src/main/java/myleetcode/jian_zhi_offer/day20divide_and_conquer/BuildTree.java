package myleetcode.jian_zhi_offer.day20divide_and_conquer;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class BuildTree {
    /**
     * 递归，仅适用于节点没有重复的二叉树
     */
//    int[] preorder;
//    HashMap<Integer, Integer> dic = new HashMap<>();
//
//    public myleetcode.TreeNode buildTree(int[] preorder, int[] inorder) {
//        this.preorder = preorder;
//        for (int i = 0; i < inorder.length; i++) {
//            dic.put(inorder[i], i);
//        }
//        return recur(0, 0, inorder.length - 1);
//    }
//
//    private myleetcode.TreeNode recur(int root, int left, int right) {
//        if (left > right) {
//            return null;    // 递归终止
//        }
//        myleetcode.TreeNode node = new myleetcode.TreeNode(preorder[root]);   // 建立根节点
//        int i = dic.get(preorder[root]);    // 划分根节点、左子树、右子树
//        node.left = recur(root + 1, left, i - 1);    // 开启左子树递归
//        node.right = recur(root + i - left + 1, i + 1, right); // 回溯返回根节点
//        return node;
//    }

    /**
     * 迭代
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        int inorderIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        // 每次遍历的意义是，将前序遍历对应的当前遍历到的节点，构建到树中应在的层级处。
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                // 一路往左子树构建
                node.left = new TreeNode(preorderVal);
                // 把当前遍历的元素放入栈里
                stack.push(node.left);
            } else {
                // 没有左子树了，构建右子树
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                // 这里的node不是目前栈顶的元素，而是栈顶之前的一个元素（已从栈里弹出）
                node.right = new TreeNode(preorderVal);
                // 把当前遍历的元素放入栈里
                stack.push(node.right);
            }
        }
        return root;
    }







}
