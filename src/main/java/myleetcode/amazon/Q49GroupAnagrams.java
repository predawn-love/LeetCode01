package myleetcode.amazon;

import java.util.*;

public class Q49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> scoreVsList = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            List<String> list = scoreVsList.getOrDefault(key, new ArrayList<>());
            list.add(s);
            scoreVsList.put(key, list);
        }
        return new ArrayList<>(scoreVsList.values());
    }

    private String getKey(String s) {
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letters[i] == 0) {
                continue;
            }
            sb.append((char)(i + 'a')).append(letters[i]);
        }
        return sb.toString();
    }
}
