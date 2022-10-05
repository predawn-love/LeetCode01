package myleetcode.jian_zhi_offer.day08DynamicProgramming;

public class NumWays {
    public int numWays(int n) {
        int a = 1;
        int b = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = b;
            b = (a + b) % 1000000007;
            a = temp;
        }
        return b;
    }
}
