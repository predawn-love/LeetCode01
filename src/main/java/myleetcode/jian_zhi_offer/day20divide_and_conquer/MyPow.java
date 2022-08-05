package myleetcode.jian_zhi_offer.day20divide_and_conquer;

public class MyPow {
    /**
     * 不仅内存不够，并且， -2147483648 的时候会因越界出错
     */
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n == 1) {
//            return x;
//        }
//        if (n < 0) {
//            return 1 / x * myPow(1 / x, 0 - n - 1);
//        }
//        return x * myPow(x, n - 1);
//    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            // 判断当前的 b 在二进制的最低位是不是1，也可以理解为对2取余看奇偶
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            // 右移一位为了下一轮循环判断二进制对应为是不是1，或者理解为b除以2
            b >>= 1;
        }
        return res;
    }
}
