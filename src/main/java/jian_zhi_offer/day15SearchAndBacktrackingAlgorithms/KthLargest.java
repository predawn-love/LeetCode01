package jian_zhi_offer.day15SearchAndBacktrackingAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class KthLargest {
//    public int kthLargest(TreeNode root, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((x, y) -> y - x);
//        dfs(root, priorityQueue);
//        int res = 0;
//        for (int i = 0; i < k; i++) {
//            res = priorityQueue.poll();
//        }
//        return res;
//    }
//
//    private void dfs(TreeNode root, PriorityQueue<Integer> priorityQueue) {
//        if (root == null) {
//            return;
//        }
//        priorityQueue.add(root.val);
//        dfs(root.left, priorityQueue);
//        dfs(root.right, priorityQueue);
//    }


    /**
     * 二叉搜索树的中序遍历是増序序列。
     */
//    public int kthLargest(TreeNode root, int k) {
//        List<Integer> arrayList = new ArrayList<>();
//        dfs(root, arrayList);
//        return arrayList.get(arrayList.size() - k);
//    }
//
//    private void dfs(TreeNode root, List<Integer> arrayList) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left, arrayList);
//        arrayList.add(root.val);
//        dfs(root.right, arrayList);
//    }

    /**
     * 二叉搜索树的中序遍历是増序序列，那中序遍历倒过来就是减序序列了。
     * 减序序列的话就可以和第 k 位进行匹配了
     */
    int res;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        k--;
        if (k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
