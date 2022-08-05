package myleetcode.string;

import java.util.*;
class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            // list 装载当前行的所有 word
            list.clear();
            list.add(words[i]);
            int cur = words[i++].length();
            while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                cur += 1 + words[i].length();
                list.add(words[i++]);
            }

            // 当前行为最后一行，特殊处理为左对齐
            if (i == n) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while (sb.length() < maxWidth) sb.append(" ");
                ans.add(sb.toString());
                break;
            }

            // 如果当前行只有一个 word，特殊处理为左对齐
            int cnt = list.size();
            if (cnt == 1) {
                String str = list.get(0);
                while (str.length() != maxWidth) str += " ";
                ans.add(str);
                continue;
            }

            /**
             * 其余为一般情况
             * wordWidth : 当前行单词总长度;
             * spaceWidth : 当前行空格总长度;
             * spaceItem : 往下取整后的单位空格长度
             */
            int wordWidth = cur - (cnt - 1);
            int spaceWidth = maxWidth - wordWidth;
            int spaceItemWidth = spaceWidth / (cnt - 1);
            String spaceItem = "";
            for (int k = 0; k < spaceItemWidth; k++) spaceItem += " ";
            StringBuilder sb = new StringBuilder();
            for (int k = 0, sum = 0; k < cnt; k++) {
                String item = list.get(k);
                sb.append(item);
                if (k == cnt - 1) break;
                sb.append(spaceItem);
                sum += spaceItemWidth;
                // 剩余的间隙数量（可填入空格的次数）
                int remain = cnt - k - 1 - 1;
                // 剩余间隙数量 * 最小单位空格长度 + 当前空格长度 < 单词总长度，则在当前间隙多补充一个空格
                if (remain * spaceItemWidth + sum < spaceWidth) {
                    sb.append(" ");
                    sum++;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }


}

public class Q68TextJustification {
    /**
     * 字符串大模拟，分情况讨论即可：
     *
     * 如果当前行只有一个单词，特殊处理为左对齐；
     * 如果当前行为最后一行，特殊处理为左对齐；
     * 其余为一般情况，分别计算「当前行单词总长度」、
     *       「当前行空格总长度」和「往下取整后的单位空格长度」，
     * 然后依次进行拼接。当空格无法均分时，每次往靠左的间隙多添加一个空格，
     * 直到剩余的空格能够被后面的间隙所均分。
     *
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n;) {
            // list 装载当前行的所有 word
            list.clear();
            list.add(words[i]);
            int cur = words[i++].length();

            // 确保 list 里面已经装了最大能放入一行的单词，并且 i 指向下一位
            while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                cur += 1 + words[i].length();
                list.add(words[i++]);
            }

            // 判断是否已经装完，最后一行需要特殊处理为左对齐
            if (i == n) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
                break;
            }

            int curListSize = list.size();

            // 如果当前行只有一个 word,特殊处理为左对齐
            if (curListSize == 1) {
                StringBuilder stringBuilder = new StringBuilder(list.get(0));
                while (stringBuilder.length() != maxWidth) {
                    stringBuilder.append(" ");
                }
                ans.add(stringBuilder.toString());
                continue;
            }

            /**
             * 其余为一般情况
             * wordWidth : 当前行单词总长度;
             * spaceWidth : 当前行空格总长度;
             * spaceItem : 往下取整后的单位空格长度
             */
            int wordWidth = cur - (curListSize - 1);
            int spaceWidth = maxWidth - wordWidth;
            int spaceItemWidth = spaceWidth / (curListSize - 1);
            String spaceItem = "";
            for (int k = 0; k < spaceItemWidth; k++) {
                spaceItem += " ";
            }

            StringBuilder sb = new StringBuilder();
            for (int k = 0, sum = 0; k < curListSize; k++) {
                String item = list.get(k);
                sb.append(item);
                if (k == curListSize - 1) break;
                sb.append(spaceItem);
                sum += spaceItemWidth;

                // 剩余的间隙数量（可填入空格的次数）
                int remain = curListSize - k - 1 - 1;

                // 剩余间隙数量 * 最小单位空格长度 + 当前空格长度 < 单词总长度
                // 则需要在当前间隙多补充一个空格
                if (remain * spaceItemWidth + sum < spaceWidth) {
                    sb.append(" ");
                    sum++;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }












}
