package myleetcode.jian_zhi_offer.day10DynamicProgramming;

public class TranslateNum {
    /**
     * 我自己想出来的方法1：
     */
//    public int translateNum(int num) {
//        char[] chars = String.valueOf(num).toCharArray();
//        // dp[i] 表示截止第 i 位数字（包括chars[i]），目前已有的翻译种类
//        // dp长度多1位， dp[i] 则对应 以 chars[i - 1] 结尾为止的数字
//        int[] dp = new int[chars.length + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//
//        // dp长度多了1位，所以 chars[chars.length - 1] 要在 dp[chars.length] 的时候才会完成计算
//        for (int i = 1; i <= chars.length; i++) {
//            // 情况1：chars[i] 和 chars[i - 1]不能组合翻译 dp[i] = dp[i - 1];
//            // 情况2：chars[i] 和 chars[i - 1]能组合翻译 dp[i] = dp[i - 2] + dp[i - 1];
//            if (check(i, chars)) {
//                dp[i] = dp[i - 2] + dp[i - 1];
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[dp.length - 1];
//    }
//
//    private boolean check(int i, char[] chars) {
//        i--;
//        if (i < 1) {
//            return false;
//        }
//        int a = chars[i - 1] - '0';
//        int b = chars[i] - '0';
//        if (a > 0 && a * 10 + b <= 25) {
//            return true;
//        }
//        return false;
//    }

//    /**
//     * 记数字 num 第 i 位数字为 xi， 数字 num 的位数为 n 例：num=12258， x1 = 1， n = 5.
//     * dp[i]表示以 xi 为结尾的数字的翻译方案数量。
//     */
//    public int translateNum(int num) {
//        String s = String.valueOf(num);
//        int a = 1, b = 1;   // 初始状态 dp[0] = 1; dp[1] = 1;
//        for(int i = 2; i <= s.length(); i++) {
//            // i 表示第 i 位数字，而程序语言第 i 位下标为 i - 1.
//            String tmp = s.substring(i - 2, i);
//            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
//            b = a;
//            a = c;
//        }
//        return a;
//    }

    /**
     * 此题的动态规划计算是对称的，即从左向右遍历（从dp[2]计算至dp[n]）
     * ，和从右向左遍历（从dp[n - 2]计算至dp[0]），所得方案数一致。从右向左遍历的代码如下所示。
     */
//    public int translateNum(int num) {
//        String s = String.valueOf(num);
//        int a = 1, b = 1;   // 初始状态 dp[0] = 1; dp[1] = 1;
//        for(int i = s.length() - 2; i >= 0; i--) {
//            // i 表示第 i 位数字，而程序语言第 i 位下标为 i - 1.
//            String tmp = s.substring(i, i + 2);
//            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
//            b = a;
//            a = c;
//        }
//        return a;
//    }

    /**
     * 从上面的方法可以看出，我们可以通过求余和求整运算实现从右向左的遍历计算。以把空间复杂度降至 O(1)
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;   // 初始状态 dp[0] = 1; dp[1] = 1;
        int x,y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = tmp >= 10 && tmp <= 25 ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    public static void main(String[] args) {
        int i = new TranslateNum().translateNum(25);
    }
}
