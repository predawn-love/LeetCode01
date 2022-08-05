package myleetcode.jian_zhi_offer.day08DynamicProgramming;

public class Fib {
    public int fib(int n) {
        int[] ans = new int[]{0, 1};
        int temp = -1;
        for (int i = 2; i <= n; i++) {
            temp = ans[1];
            ans[1] = (ans[0] + ans[1]) % 1000000007;
            ans[0] = temp;
        }
        if (n == 0) {
            return ans[0];
        } else {
            return ans[1];
        }
    }
}
