package myleetcode.amazon;

public class Q5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 回文串为奇数，该点为中心点
            int l = i - 1, r = i + 1;
            String sub = getString(s, l, r);
            if (sub.length() > ans.length()) {
                ans = sub;
            }
            // 回文串为偶数，该点为左或右都可以
            l = i;
            r = i + 1;
            sub = getString(s, l, r);
            if (sub.length() > ans.length()) {
                ans = sub;
            }
        }
        return ans;
    }

    private String getString(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
