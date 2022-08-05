package myleetcode.jian_zhi_offer.day07SearchAndBacktrackingAlgorithm;

import java.util.Stack;

public class MirrorTree {

//    public myleetcode.TreeNode mirrorTree(myleetcode.TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        Stack<myleetcode.TreeNode> stack = new Stack<myleetcode.TreeNode>() {{ add(root); }};
//        while (!stack.isEmpty()) {
//            myleetcode.TreeNode node = stack.pop();
//            if (node.left != null) {
//                stack.add(node.left);
//            }
//            if (node.right != null) {
//                stack.add(node.right);
//            }
//            myleetcode.TreeNode tmp = node.left;
//            node.left = node.right;
//            node.right = tmp;
//        }
//        return root;
//    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        MirrorTree mirrorTree = new MirrorTree();
        TreeNode treeNode = mirrorTree.mirrorTree(root);
        System.out.println("-0------------");

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(1);
        System.out.println(stack.pop());
        stack.add(2);
        stack.add(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("-------------");
        stack.push(0);
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
