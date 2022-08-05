package myleetcode.jian_zhi_offer.day10DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /**
     * 自己的写法：
     */
//    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        Set<Character> hs = new HashSet<>();
//        int res = 0;
//        int l = 0;
//        int r = 0;
//        while (r < chars.length) {
//            char c = chars[r];
//            if (!hs.contains(c)) {
//                hs.add(c);
//                res = Math.max(res, hs.size());
//            } else {
//                hs.remove(chars[l++]);
//                continue;
//            }
//            r++;
//        }
//        return res;
//    }


    /**
     * 用双指针+哈希表，表里的 value 存 key 最后一次出现的索引下标，这样的话，更新 res 的时候用 r - l + 1；
     * 优化了最坏时间复杂度
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> hs = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < chars.length; r++) {
            char c = chars[r];
            if (hs.containsKey(c)) {
                l = Math.max(hs.get(c) + 1, l);
            }
            hs.put(c, r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abba");
    }
}
