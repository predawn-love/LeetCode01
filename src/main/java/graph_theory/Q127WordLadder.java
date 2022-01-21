package graph_theory;

import java.util.*;

public class Q127WordLadder {
    String curBeginWord;
    String curEndWord;
    Set<String> wordListSet = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String s : wordList) {
            wordListSet.add(s);
        }
        if (!wordListSet.contains(endWord)) {
            return 0;
        }
        curBeginWord = beginWord;
        curEndWord = endWord;
        int ans = bfs();
        return ans == -1 ? 0 : ans + 1;
    }

    private int bfs() {
        // deque0 代表从起点开始正向搜索，deque1 代表从结尾开始反向搜索。
        Deque<String> deque0 = new ArrayDeque<String>(){{addLast(curBeginWord);}};
        Deque<String> deque1 = new ArrayDeque<String>(){{addLast(curEndWord);}};

        /*
         * 两个 map 分别记录两个方向出现的单词是经过多少次转换而来
         * e.g.
         * m1 = {"abc":1} 代表 abc 由 beginWord 替换 1 次字符而来
         * m2 = {"xyz":3} 代表 xyz 由 endWord 替换 3 次字符而来
         */
        Map<String, Integer> stringVsStepMap0 = new HashMap<String, Integer>(){{put(curBeginWord, 0);}};
        Map<String, Integer> stringVsStepMap1 = new HashMap<String, Integer>(){{put(curEndWord, 0);}};

        /*
         * 只有两个队列都不空，才有必要继续往下搜索
         * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
         * e.g.
         * 例如，如果 deque1 为空了，说明从 beginWord 搜索到底都搜索不到 endWord，反向搜索也没必要进行了
         */
        while (!deque0.isEmpty() && !deque1.isEmpty()) {
            int t;

            // 为了让两个方向的搜索尽可能平均，优先拓展队列内元素少的方向
            if (deque0.size() <= deque1.size()) {
                t = update(deque0, stringVsStepMap0, stringVsStepMap1);
            } else {
                t = update(deque1, stringVsStepMap1, stringVsStepMap0);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    /**
     * update 代表从 deque 中取出一个单词进行扩展。
     *
     *
     * @param deque 当前扩展方向的队列
     * @param curMap    curMap 为当前方向的距离字典；
     * @param otherMap  otherMap 为另外一个方向的距离字典
     * @return  -1 代表没找到， 非 -1 代表找到了
     */
    private int update(Deque<String> deque, Map<String, Integer> curMap, Map<String, Integer> otherMap) {
        int m = deque.size();
        while (m-- > 0) {
            String curStringNeededToExpand = deque.pollFirst();
            int curStep = curMap.get(curStringNeededToExpand);

            // 枚举替换原字符串的哪个字符 i
            for (int i = 0; i < curStringNeededToExpand.length(); i++) {
                // 枚举将 i 替换成 26 个小写字母的任意一个。
                for (int j = 0; j < 26; j++) {
                    // 替换后的字符串
                    String sub = curStringNeededToExpand.substring(0, i) + (char)('a' + j) + curStringNeededToExpand.substring(i + 1);
                    // 当前方向的 map 里已有该字符串 || 字典里没有该字符串 则继续循环，不再加入
                    if (curMap.containsKey(sub) || !wordListSet.contains(sub)) {
                        continue;
                    }

                    // 如果该字符串在【另一方向】出现过，说明找到了联通两个方向的最短路。
                    if (otherMap.containsKey(sub)) {
                        return curStep + 1 + otherMap.get(sub);
                    } else {
                        // 否则加入 deque 队列
                        deque.addLast(sub);
                        curMap.put(sub, curStep + 1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{add("ac");}};
        int i = new Q127WordLadder().ladderLength("ab", "ac", list);
        System.out.println(i);
    }
}
