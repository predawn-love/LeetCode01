package myleetcode.amazon;

import java.util.*;

public class Q22GenerateParentheses {
    List<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;
        dfs(0,0, new StringBuilder(""));
        return res;
    }

    private void dfs(int curLeft, int curRight, StringBuilder sb) {
        if (curRight == n) {
            res.add(sb.toString());
        }
        
    }
}
