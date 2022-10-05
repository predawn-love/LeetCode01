package myleetcode.jian_zhi_offer.day07SearchAndBacktrackingAlgorithm;

public class IsSymmetric {
//    public boolean isSymmetric(myleetcode.TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        LinkedList<myleetcode.TreeNode> linkedList = new LinkedList<>();
//        LinkedList<myleetcode.TreeNode> linkedList2 = new LinkedList<>();
//        LinkedList<myleetcode.TreeNode> linkedList3 = new LinkedList<>();
//        linkedList.add(root.left);
//        linkedList.add(root.right);
//        while (!linkedList.isEmpty()) {
//            while (!linkedList.isEmpty()) {
//                myleetcode.TreeNode node = linkedList.pollFirst();
//                myleetcode.TreeNode node2 = linkedList.pollLast();
//                if ((node != null && node2 != null && node.val == node2.val) ) {
//                    linkedList2.add(node.left);
//                    linkedList2.add(node.right);
//                    linkedList3.addFirst(node2.right);
//                    linkedList3.addFirst(node2.left);
//                } else if (node == null && node2 == null) {
//
//                } else {
//                    return false;
//                }
//            }
//            linkedList.addAll(new LinkedList<>(linkedList2));
//            linkedList.addAll(new LinkedList<>(linkedList3));
//            linkedList2.clear();
//            linkedList3.clear();
//        }
//        return true;
//    }


    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return l.val == r.val && recur(l.left, r.right) && recur(l.right, r.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        IsSymmetric isSymmetric = new IsSymmetric();
        boolean symmetric = isSymmetric.isSymmetric(root);
        System.out.println(symmetric);
    }
}
