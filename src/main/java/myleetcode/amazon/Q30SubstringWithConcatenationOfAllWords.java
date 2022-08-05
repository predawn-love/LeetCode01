package myleetcode.amazon;

import java.util.*;

public class Q30SubstringWithConcatenationOfAllWords {
    /**
     * 暴力模拟，双哈希表辅助
     */
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> res = new ArrayList<>();
//        int wordNum = words.length;
//        if (wordNum == 0) {
//            return res;
//        }
//        int wordLen = words[0].length();
//
//        HashMap<String, Integer> allWords = new HashMap<>();
//        for (String w : words) {
//            allWords.put(w, allWords.getOrDefault(w, 0) + 1);
//        }
//
//        // 遍历所有子串
//        for (int i = 0; i <= s.length() - wordNum * wordLen; i++) {
//            int num = 0;
//            HashMap<String, Integer> hasWords = new HashMap<>();
//            while (num < wordNum) {
//                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
//
//                // 判断该单词在 allWords 中
//                if (!allWords.containsKey(word)) {
//                    break;
//                }
//                int targetFrequency = allWords.get(word);
//                int nowFrequency = hasWords.getOrDefault(word, 0);
//                if (nowFrequency >= targetFrequency) {
//                    break;
//                }
//                hasWords.put(word, nowFrequency + 1);
//                num++;
//            }
//
//            // 判断是否所有的单词都已匹配上
//            if (num == wordNum) {
//                res.add(i);
//            }
//        }
//        return res;
//    }

    /**
     * 滑动窗口
     * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-6/
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }

        // 将所有移动分为 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            int num = 0;
            HashMap<String, Integer> hasWords = new HashMap<>();

            // 每次移动一个单词的长度
            for (int i = j; i <= s.length() - wordLen * wordNum; i += wordLen) {
                //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        if (hasWords.get(word) > allWords.get(word)) {
                            int removeNum = 0;

                            // 一直移除单词，直到次数符合
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                hasWords.put(firstWord, hasWords.get(firstWord) - 1);
                                removeNum++;
                            }

                            // 加 1 是因为我们把当前单词加入到了 HashMap2 中
                            num = num - removeNum + 1;

                            // 这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            i = i + (removeNum - 1) * wordLen;
                            break;
                        }
                    //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                    //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                    //然后刚好就移动到了单词后边）
                    } else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num--;
                }
            }
        }
        return res;
    }
}
