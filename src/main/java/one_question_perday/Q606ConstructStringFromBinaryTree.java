package one_question_perday;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Q606 {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length() - 1);
    }
    void dfs(TreeNode root) {
        sb.append("(");
        sb.append(root.val);
        if (root.left != null) dfs(root.left);
        else if (root.right != null) sb.append("()");
        if (root.right != null) dfs(root.right);
        sb.append(")");
    }

}
public class Q606ConstructStringFromBinaryTree {
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length() - 1);
    }

    private void dfs(TreeNode root) {
        sb.append("(");
        sb.append(root.val);
        if (root.left != null) {
            dfs(root.left);
        } else if (root.right != null) {
            sb.append("()");
        }

        if (root.right != null) {
            dfs(root.right);
        }
        sb.append(")");
    }
}
