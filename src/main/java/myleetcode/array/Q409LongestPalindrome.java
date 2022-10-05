package myleetcode.array;

public class Q409LongestPalindrome {
    /**
     * 在对char数组遍历的时候 只能出现一个个数为奇数的字符 所以我们直接记录有多少个字符出现次数为奇数就可以了,不用额外判断
     */
    public int longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int[] frequency = new int[128];
        for (char c : cs) {
            frequency[c]++;
        }
        boolean hasOld = false;
        int oldCount = 0;
        for (int i : frequency) {
            if ((i & 1) == 1) {
                oldCount++;
            }
        }
        return oldCount == 0 ? s.length() : s.length() - oldCount + 1;
    }
}
