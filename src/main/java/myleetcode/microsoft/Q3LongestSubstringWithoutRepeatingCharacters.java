package myleetcode.microsoft;

import java.util.HashSet;
import java.util.Set;

public class Q3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0, j = 0; j < chars.length; j++) {
            // 如果含有 chars[j]，不断移动游标 i，直至不含 chars[j]
            while (characterSet.contains(chars[j])) {
                characterSet.remove(chars[i++]);
            }
            characterSet.add(chars[j]);
            res = Math.max(res, characterSet.size());
        }
        return res;
    }
}
