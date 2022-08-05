package myleetcode.jian_zhi_offer.day06SearchAndBacktrackingAlgorithm;

import java.util.*;

public class LevelOrderIII {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                    TreeNode curNode = queue.poll();
                    if (resList.size() % 2 == 0) {
                        list.add(curNode.val);
                    } else {
                        list.addFirst(curNode.val);
                    }
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
            }
            resList.add(list);
        }
        return resList;
    }
}
