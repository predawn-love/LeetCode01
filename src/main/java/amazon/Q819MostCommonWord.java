package amazon;

import java.util.*;

public class Q819MostCommonWord {
    /**
     * 思路：遍历 paragraph 遇到不是字母的就将之前的作为单词
     * (所以最后要加一个句号，不然就不拼了)
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        HashMap<String, Integer> wordVsFrequency = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s);
        }

        String ans = "";
        int maxFrequency = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() > 0){
                String word = sb.toString();
                if (bannedSet.contains(word)) {
                    sb = new StringBuilder();
                    continue;
                }
                int curFrequency = wordVsFrequency.getOrDefault(word, 0) + 1;
                wordVsFrequency.put(word, curFrequency);
                if (curFrequency > maxFrequency) {
                    ans = word;
                    maxFrequency = curFrequency;
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = new Q819MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"});
        System.out.println(s);
    }
}
