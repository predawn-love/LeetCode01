package myleetcode.microsoft;

public class Q10IsMatch {
//    public boolean isMatch(String ss, String pp) {
//        // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
//        int n = ss.length(), m = pp.length();
//        ss = " " + ss;
//        pp = " " + pp;
//        char[] s = ss.toCharArray();
//        char[] p = pp.toCharArray();
//        // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
//        boolean[][] f = new boolean[n + 1][m + 1];
//        f[0][0] = true;
//        for (int i = 0; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
//                if (j + 1 <= m && p[j + 1] == '*') continue;
//
//                // 对应了 p[j] 为普通字符和 '.' 的两种情况
//                if (i - 1 >= 0 && p[j] != '*') {
//                    f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
//                }
//
//                // 对应了 p[j] 为 '*' 的情况
//                else if (p[j] == '*') {
//                    f[i][j] = (j - 2 >= 0 && f[i][j - 2]) || (i - 1 >= 0 && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
//                }
//            }
//        }
//        return f[n][m];
//    }

    public boolean isMatch(String ss, String pp) {
        // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                if (j + 1 <= m && p[j + 1] == '*') {
                    continue;
                }

                // 对应 p[j] 为普通字符和 '.' 的两种情况
                if (i - 1 >= 0 && p[j] != '*') {
                    f[i][j] = f[i - 1][j - 1]
                            && (s[i] == p[j] || p[j] == '.');
                } else if (p[j] == '*') {
                    // 题目已经确保了不会出现单独一个 "*"，对应了 p[j] 为 '*' 的情况
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2])
                            || (i - 1 >= 0 && f[i - 1][j]
                            && (s[i] == p[j - 1] || p[j - 1] == '.'));
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        boolean res = new Q10IsMatch().isMatch("aaaaaaaaa", "a*");
        System.out.println(res);
    }
}
