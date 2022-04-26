package myleetcode.amazon;

import java.util.*;

public class Q937ReorderDataInLogFiles {
    public String[] reorderLogFiles0(String[] logs) {
        LinkedList<String> digitList = new LinkedList<>();
        LinkedList<String> wordList = new LinkedList<>();

        // 队列存放 {标识符， 字符内容}
        PriorityQueue<String[]> queue = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1].compareTo(b[1]) == 0) {
                        return a[0].compareTo(b[0]);
                    } else {
                        return a[1].compareTo(b[1]);
                    }
                }
        );

        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            int indexOfSpace = log.indexOf(" ");
            String identifier = log.substring(0, indexOfSpace);
            String content = log.substring(indexOfSpace + 1);

            // 检查是不是数字
            boolean isDigit = check(content.charAt(0));
            if (isDigit) {
                // 按数字处理
                digitList.addLast(log);
                continue;
            }

            // 按字符处理
            queue.add(new String[]{identifier, content});
        }

        fillWordList(wordList, queue);

        int n = wordList.size();
        int m = digitList.size();
        String[] res = new String[n + m];

        int curIndex = 0;
        while (curIndex < n) {
            res[curIndex] = wordList.pollFirst();
            curIndex++;
        }
        while (curIndex < n + m) {
            res[curIndex] = digitList.pollFirst();
            curIndex++;
        }
        return res;
    }

    private void fillWordList(LinkedList<String> wordList, PriorityQueue<String[]> queue) {
        String[] pre = queue.poll();
        String[] cur = null;
        while(!queue.isEmpty()) {
            cur = queue.poll();

            // 当前的标识符和之前一个标识符相同
            if (cur[1].compareTo(pre[1]) == 0) {
                if (cur[0].compareTo(pre[0]) < 0) {
                    // cur 的标识符比 pre 的小，放前面
                    wordList.addLast(cur[0] + cur[1]);
                } else {
                    wordList.addLast(pre[0] + pre[1]);
                    pre = cur;
                }
            } else {
                // 标识符不同的话，正常处理前一位

            }
        }
        if (cur == null) {
            wordList.addLast(pre[1]);
            return;
        }

    }

    private boolean check(char c) {
        return c >= '0' && c <= '9';
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] s1 = log1.split(" ", 2);
            String[] s2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = s1[1].compareTo(s2[1]);
                if (cmp == 0) return s1[0].compareTo(s2[0]);
                return s1[1].compareTo(s2[1]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
