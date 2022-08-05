package myleetcode.amazon;

import java.util.HashMap;

public class Q387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> charVsFrequency = new HashMap<>();
        for (char c : chars) {
            charVsFrequency.put(c, charVsFrequency.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (charVsFrequency.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
