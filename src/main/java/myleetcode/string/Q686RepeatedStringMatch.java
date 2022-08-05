package myleetcode.string;

public class Q686RepeatedStringMatch {

    /**
     * 关于最终答案，一定至少是第一个 n 满足， a.length * n >= b.length；最多是 n + 1 次。
     * （b匹配的起始点一定在 a 的 [0 ~ a.length - 1] 内）
     */
    public int repeatedStringMatch0(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length()) {
            ++ans;
            sb.append(a);
        }
        sb.append(a);
        int index = sb.indexOf(b);
        if (index == -1) {
            return -1;
        }
        return index + b.length() > ans * a.length() ? ans + 1 : ans;
    }


    /**
     * 字符串哈希
     */
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length()) {
            ans++;
            sb.append(a);
        }
        sb.append(a);
        int index = strHash(sb.toString(), b);
        if (index == -1) {
            return -1;
        }
        return index + b.length() > ans * a.length() ? ans + 1 : ans;
    }

    private int strHash(String ss, String b) {
        // 大于任意字符的一个素数
        int P = 131;
        int n = ss.length();
        int m = b.length();

        String str = ss + b;
        char[] cs = str.toCharArray();
        int len = str.length();
        int[] h = new int[len + 10];
        int[] p = new int[len + 10];
        p[0] = 1;
        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + cs[i];
        }
        int r = len, l = r - m + 1;

        // b 的哈希值计算时，参与运算的 p 数组的下标永远是字符串长度
        int target = h[r] - h[l - 1] * p[r - l + 1];
        for (int i = 1; i <= n; i++) {
            int j = i + m - 1;

            // 子串哈希值计算时，参与运算的 p 数组的下标是字符串长度，这道题是定长 b.length()
            int cur = h[j] - h[i - 1] * p[j - i + 1];
            if (cur == target) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Q686RepeatedStringMatch().repeatedStringMatch("abcd", "cdabcdab");
//        int i = new Q686RepeatedStringMatch().repeatedStringMatch("a", "aa");
        System.out.println(i);
//        System.out.println(i1);
    }
}
