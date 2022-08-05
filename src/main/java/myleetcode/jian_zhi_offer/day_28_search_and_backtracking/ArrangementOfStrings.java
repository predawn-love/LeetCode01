package myleetcode.jian_zhi_offer.day_28_search_and_backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ArrangementOfStrings {
    char[] c;
    List<String> res = new LinkedList<>();

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            // 添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x); // 交换，将c[i]固定在第x位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 复原现场，恢复交换
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
