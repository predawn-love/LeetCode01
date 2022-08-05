package myleetcode.recursion;

public class Q50PowXN {

    /**
     * 方法1：递归实现快速幂：
     */
//    public double myPow(double x, int n) {
//        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
//    }
//
//    private double quickMul(double x, int n) {
//        if (n == 0) {
//            return 1.0;
//        }
//        double y = quickMul(x, n / 2);
//        return n % 2 == 0 ? y * y : y * y * x;
//    }

    /**
     * 方法2：迭代实现快速幂
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值是x
        double xContribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为1，那么需要计入贡献
                ans *= xContribute;
            }
            // 将贡献不断地平方
            xContribute *= xContribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
