package myleetcode.amazon;

import java.util.*;

public class Q127WordLadder {
    String curBeginWord;
    String curEndWord;
    Set<String> set;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = new HashSet<>();
        curBeginWord = beginWord;
        curEndWord = endWord;
        for (String s : wordList) {
            set.add(s);
        }
        int ans = bfs();
        return ans == 0 ? -1 : ans + 1;
    }

    private int bfs() {
        if (!set.contains(curEndWord)) {
            return 0;
        }
        Map<String, Integer> stringVsStepMap0 = new HashMap<>();
        Map<String, Integer> stringVsStepMap1 = new HashMap<>();
        stringVsStepMap0.put(curBeginWord, 0);
        stringVsStepMap1.put(curEndWord, 0);

        Queue<String> queue0 = new ArrayDeque<String>(){{add(curBeginWord);}};
        Queue<String> queue1 = new ArrayDeque<String>(){{add(curEndWord);}};

        while (!queue0.isEmpty() && !queue1.isEmpty()) {
            int t;
            if (queue0.size() <= queue1.size()) {
                t = update(queue0, stringVsStepMap0, stringVsStepMap1);
            } else {
                t = update(queue1, stringVsStepMap1, stringVsStepMap0);
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
     * @param curQueue  当前要扩展的队列
     * @param curMap    当前搜索方向对应的 Map
     * @param otherMap  与当前搜索方向相反的方向对应的 Map
     * @return 没找到就返回 -1，找到了返回对应次数，记得 beginWord 也要参与接龙，所以返回出去在外面要 + 1.
     */
    private int update(Queue<String> curQueue, Map<String, Integer> curMap, Map<String, Integer> otherMap) {
        int m = curQueue.size();
        while (m-- > 0) {
            String poll = curQueue.poll();
            for (int i = 0; i < poll.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String newString = poll.substring(0, i) + j + poll.substring(i + 1);
                    // TODO:待补充
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "111".substring(3);
        System.out.println(s.equals(""));
        System.out.println(s);
    }
}
