package myleetcode.amazon;

public class Q28ImplementStrStr {
    public int strStr0(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        char[] sourceCS = haystack.toCharArray();
        char[] targetCS = needle.toCharArray();
        int n = sourceCS.length;
        int m = targetCS.length;
        for (int i = 0; i <= n - m; i++) {
            int index = 0, j = i;
            while (index < m && sourceCS[j] == targetCS[index]) {
                index++;
                j++;
            }
            if (index == targetCS.length) {
                return i;
            }
        }
        return -1;
    }

    public int strStr(String ss, String pp) {

        return 0;
    }
}
