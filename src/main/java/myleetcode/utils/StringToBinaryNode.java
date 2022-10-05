package myleetcode.utils;


import myleetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringToBinaryNode {
    public static TreeNode stringArrayToBinaryNode(String[] strings) {
        TreeNode root = new TreeNode();
        if (strings == null || strings.length == 0) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int index = 0;
        root.val = Integer.parseInt(strings[index++]);
        queue.add(root);
        while (index < strings.length && !queue.isEmpty()) {
            int fatherNodeSize = queue.size();
            for (int i = 0; i < fatherNodeSize && index < strings.length; i++) {
                TreeNode fatherNode = queue.poll();
                String string = strings[index++];
                if ("null".equals(string)) {
                    queue.offer(new TreeNode());
                } else {
                    fatherNode.left = new TreeNode(Integer.parseInt(string));
                    queue.offer(fatherNode.left);
                }
                if (index < strings.length) {
                    string = strings[index++];
                    if ("null".equals(string)) {
                        queue.offer(new TreeNode());
                    } else {
                        fatherNode.right = new TreeNode(Integer.parseInt(string));
                        queue.offer(fatherNode.right);
                    }
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = stringArrayToBinaryNode(new String[]{"0", "null", "1", "null", "null", "2"});
        System.out.println(",,");
    }
}
