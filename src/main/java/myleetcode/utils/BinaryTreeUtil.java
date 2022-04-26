package myleetcode.utils;

import myleetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {
    public static TreeNode getTreeNode(Object[] objects) {
        if (objects == null || objects.length == 0) {
            return null;
        }
        TreeNode root = getTreeNode(objects[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 指向队列中末尾的元素所在的 Object[] 数组的索引
        int curIndex = 1;
        loop1:  while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                TreeNode curNode = queue.poll();
                if (curIndex < objects.length) {
                    TreeNode node = getTreeNode(objects[curIndex++]);
                    curNode.left = node;
                    queue.offer(node);
                } else {
                    break loop1;
                }
                if (curIndex < objects.length) {
                    TreeNode node = getTreeNode(objects[curIndex++]);
                    curNode.right = node;
                    queue.offer(node);
                } else {
                    break loop1;
                }
            }
        }
        return root;
    }

    private static TreeNode getTreeNode(Object object) {
        return object == null ? null : new TreeNode((int)object);
    }
}
