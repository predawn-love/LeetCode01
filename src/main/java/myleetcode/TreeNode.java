package myleetcode;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        System.out.println(new TreeNode() == null);
        System.out.println(treeNode == null);

        TreeNode root = new TreeNode(2);
        root.right = new TreeNode();
        System.out.println(root.right == null);
    }
}
