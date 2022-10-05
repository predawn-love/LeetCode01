package myleetcode.jian_zhi_offer_special_assaults.day05;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        int n = s.length();
        int m = p.length();
        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();
        int[] cnt = new int[26];
        for (char c : chars2) {
            cnt[c - 'a']--;
        }
        for (int l = 0, r = 0; r < n; r++) {
            int curIndex = chars1[r] - 'a';
            cnt[curIndex]++;
            while (cnt[curIndex] > 0) {
                --cnt[chars1[l] - 'a'];
                ++l;
            }
            if (r - l + 1 == m) {
                res.add(l);
            }
        }
        return res;
    }
}
