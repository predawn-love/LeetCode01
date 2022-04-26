package myleetcode.two_pointer;

public class Q125ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        // 'A'~'Z'==65~90  'a'==97
        while (l < r) {
            char lChar = chars[l];

            char rChar = chars[r];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println('a'-'A');
        System.out.println((char)('A' + 32));
    }
}
