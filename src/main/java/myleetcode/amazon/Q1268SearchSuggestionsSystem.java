package myleetcode.amazon;

import java.util.*;

public class Q1268SearchSuggestionsSystem {
    class Trie {
        Trie[] tries;
        String str;
        public Trie() {
            tries = new Trie[26];
        }

        public void add(String s) {
            Trie p = this;
            for (char c : s.toCharArray()) {
                if (p.tries[c - 'a'] == null) {
                    p.tries[c - 'a'] = new Trie();
                }
                p = p.tries[c - 'a'];
            }
            p.str = s;
        }
    }

    private Trie root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        root = new Trie();

        // 构建字典树
        for (String str : products) {
            root.add(str);
        }

        // 遍历 searchWord，构建结果集
        Trie p = root;
        for (char c : searchWord.toCharArray()) {
            if (p.tries[c - 'a'] == null) {
                res.add(new ArrayList<>(0));
                break;
            }
            p = p.tries[c - 'a'];

            // 现在 p 已成为字典树中和 searchWord 当前 char 匹配的节点
            // 下一步应获取至多 3 个推荐单词 （dfs暴搜）
            List<String> arrayList = new ArrayList<>(3);
            getThreeSuggested(arrayList, p);
            res.add(arrayList);
        }
        while (res.size() < searchWord.length()) {
            res.add(new ArrayList<>(0));
        }
        return res;
    }


    private void getThreeSuggested(List<String> list, Trie p) {
        if (p == null || list.size() == 3) {
            return;
        }
        if (p.str != null) {
            list.add(p.str);
        }
        for (Trie t : p.tries) {
            getThreeSuggested(list, t);
        }
        return;
    }

    public static void main(String[] args) {
        String[] strings = {"mobile","mouse","moneypot","monitor","mousepad"};
        String s = "mouse";
        List<List<String>> lists = new Q1268SearchSuggestionsSystem().suggestedProducts(strings, s);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
