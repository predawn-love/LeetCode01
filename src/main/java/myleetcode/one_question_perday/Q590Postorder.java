package myleetcode.one_question_perday;

import java.util.ArrayList;
import java.util.List;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Q590Postorder {
    List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        dfs(root);
        return list;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        for (Node n : root.children) {
            dfs(n);
        }
        list.add(root.val);
    }
}
