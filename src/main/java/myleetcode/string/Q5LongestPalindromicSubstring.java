package myleetcode.string;

public class Q5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i, k = i; j >= 0 && k < ch.length && ch[j] == ch[k]; j--, k++) {
                if (res.length() < k - j + 1) {
                    res = s.substring(j, k + 1);
                }
            }
            for (int j = i, k = i + 1; j >= 0 && k < ch.length && ch[j] == ch[k]; j--, k++) {
                if (res.length() < k - j + 1) {
                    res = s.substring(j, k + 1);
                }
            }
        }
        return res;
    }
}
