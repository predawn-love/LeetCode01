package myleetcode.dynamic_programming;

public class Q10RegularExpressionMatching {
    /**
     * 我们设 f(i, j) 代表 s0~si 和 p0~pj-2 匹配。分情况讨论如下：
     * <p>
     * 情况1、如果不考虑星号，状态转移方程为: f(i, j) = f(i-1, j-1) && (ss[i]==pp[j] || pp[j]=='.') 就是字符直接匹配或点号
     * <p>
     * 也就是：f(i, j) = f(i-1, j-1) && (ss[i]匹配p[j])
     * <p>
     * <p>
     * 情况2、考虑星号出现的话状态转移方程如下([a:b]表示:从a到b)：
     * <pre>
     * f(i, j) = f(i, j - 2)   s0~si 和 p0~pj-2匹配， pj-1为一个字符，pj为星号，使用零次
     *      || (f(i - 1, j - 2) && ss[i]匹配p[j - 1])  ------ a s0~si-1 和 p0~pj-2匹配， pj-1为一个字符，pj为星号，使用1次
     *      || (f(i - 2, j - 2) && ss[i - 1:i]匹配p[j - 1])  ------ b s0~si-2 和 p0~pj-2匹配， pj-1为一个字符，pj为星号，使用2次
     *      || (f(i - 3, j - 2) && ss[i - 2:i]匹配p[j - 1])  ------ c s0~si-3 和 p0~pj-2匹配， pj-1为一个字符，pj为星号，使用3次
     *      || (f(i - 4, j - 2) && ss[i - 3:i]匹配p[j - 1])  ------ d
     *      || (f(i - 5, j - 2) && ss[i - 4:i]匹配p[j - 1])  ------ e
     *
     * 我们将 i = i - 1 代入表达式可得：
     * f(i - 1, j) = f(i - 1, j - 2)  ------ a s0~si-1 和 p0~pj-2匹配， pj-1为一个字符，pj为星号，使用零次
     *      || (f(i - 2, j - 2) && ss[i - 1]匹配p[j - 1])  ------ b s0~si-2 和 p0~pj-2匹配， pj-1为一个字符，pj为星号，使用1次
     *      || (f(i - 3, j - 2) && ss[i - 2: i - 1]匹配p[j - 1])  ------ c s0~si-3 和 p0~pj-2匹配， pj-1为一个字符，pj为星号，使用2次
     *      || (f(i - 4, j - 2) && ss[i - 3: i - 1]匹配p[j - 1])  ------ d
     *      || (f(i - 5, j - 2) && ss[i - 4: i - 1]匹配p[j - 1])  ------ e
     * 可以看到，对于相同小写英文字母标记的 item，每一项都差了 ss[i]匹配p[j - 1])。
     * 单纯考虑星号的递推公式为： f(i, j) = f(i, j - 2) || (f(i - 1, j) && ss[i]匹配p[j - 1])
     * </pre>
     *
     * @param ss 待匹配字符串
     * @param pp 用于匹配的 pattern
     * @return 是否能够匹配
     */
    public boolean isMatch(String ss, String pp) {
        // 技巧：在头部插入空格后，可以偏移为从1开始，并且f(0,0)为true，方便状态滚动。
        int n = ss.length();
        int m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // f[i][j] 表示 s 中的 1~i 和 p 中的 1~j 是否匹配。
        boolean[][] f = new boolean[n + 1][m + 1];

        // 初始化初始状态
        f[0][0] = true;

        // 开始构建 f
        for (int i = 0; i <= n; i++) {
            // p 直接从 1 开始遍历就好
            for (int j = 1; j <= m; j++) {
                // 如果下个字符是 * 号，当前字符先不做判断
                if (j < m && p[j + 1] == '*') {
                    continue;
                }

                // 对应当前的 p[j] 是普通字符或‘.’的情况
                if (i - 1 >= 0 && p[j] != '*') {
                    f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                } else if (p[j] == '*') {
                    // 题目已经确保了不会出现单独一个 "*"，对应了 p[j] 为 '*' 的情况：匹配 0 次 或 匹配多次
                    // 不在 if 里面写边界判断是为了写在状态转移内。
                    f[i][j] = (j >= 2 && f[i][j - 2]) || (i >= 1 && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
                }
            }
        }

        return f[n][m];
    }
}
