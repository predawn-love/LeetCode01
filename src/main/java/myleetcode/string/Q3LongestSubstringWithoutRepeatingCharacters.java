package myleetcode.string;

import java.util.HashSet;

public class Q3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        char[] ch = s.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0, j = i; i < ch.length && j < ch.length; i++) {
            while (j < ch.length && !hs.contains(ch[j])) {
                hs.add(ch[j]);
                j++;
            }
            if (hs.size() > res) {
                res = hs.size();
            }
            hs.remove(ch[i]);
        }
        return res;
    }
}
