package myleetcode.microsoft;

public class Q9isPalindrome {
    public boolean isPalindrome(int x) {
        char[] cs = String.valueOf(x).toCharArray();
        for (int l = 0, r = cs.length - 1; l < r; l++, r--) {
            if (cs[l] != cs[r]) {
                return false;
            }
        }
        return true;
    }
}
