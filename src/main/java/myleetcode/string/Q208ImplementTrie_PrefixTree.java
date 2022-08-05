package myleetcode.string;

class Trie {
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie p = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                // 插入的意思就是让这里能往下再展开26个叶节点。
                p.children[index] = new Trie();
            }
            p = p.children[index];
        }
        p.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie p = searchFix(word);
        return p != null && p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchFix(prefix) != null;
    }

    private Trie searchFix(String prefix) {
        Trie p = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return null;
            }
            p = p.children[index];
        }
        return p;
    }
}

public class Q208ImplementTrie_PrefixTree {

}
