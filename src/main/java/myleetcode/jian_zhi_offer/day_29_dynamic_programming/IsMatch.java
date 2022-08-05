package myleetcode.jian_zhi_offer.day_29_dynamic_programming;

public class IsMatch {

    /**
     * dp法， 时间复杂度 O(m * n)
     */
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();

        // dp[i][j] 表示 charsS[0 ~ i - 1] 可以和 charsP[0 ~ j - 1] 相匹配
        boolean[][] dp = new boolean[m][n];

        // 初始化 dp[0][...]
        dp[0][0] = true;
        for (int i = 2; i < n; i += 2) {
            if (!dp[0][i - 2]) {
                break;
            }
            dp[0][i] = charsP[i - 1] == '*';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = charsP[j - 1] == '*' ?
                        // 当 charsP[j - 1]是'*'时,要让 dp[i][j] 为 true:
                        //      若 charsP[j - 2]只出现0次，对应 dp[i][j - 2] （这个是charsP[j - 3]结尾）
                        //      若 dp[i - 1][j] 为true, 则有 charsS[i - 1] 和 * 号前的字符能匹配，即本身就相同或是'.'号
                        dp[i][j - 2] || (dp[i - 1][j] && (charsS[i - 1] == charsP[j - 2] || charsP[j - 2] == '.'))
                        // 当 charsP[j - 1] 不是'*'时,要让 dp[i][j] 为true:
                        //      dp[i - 1][j - 1] 为 true 且 charsS[i - 1] 和 charsP[j - 1]能匹配，即本身就相同或'.'号
                        : dp[i - 1][j - 1] && (charsS[i - 1] == charsP[j - 1] || charsP[j - 1] == '.');
            }
        }

        return dp[m - 1][n - 1];
    }
}
