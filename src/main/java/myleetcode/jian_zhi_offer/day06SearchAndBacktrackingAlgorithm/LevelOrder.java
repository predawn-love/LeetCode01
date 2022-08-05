package myleetcode.jian_zhi_offer.day06SearchAndBacktrackingAlgorithm;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            resList.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        int[] ans = new int[resList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = resList.get(i);
        }
        return ans;
    }



}
