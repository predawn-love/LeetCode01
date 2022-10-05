package myleetcode.jian_zhi_offer.day_31_math;

public class CuttingRope {

    /**
     * 循环取余
     */
    //    private static int P = 1000000007;
//    public int cuttingRope(int n) {
//        if (n <= 3) {
//            return n - 1;
//        }
//        int count = 0;
//        while (n >= 5) {
//            n -= 3;
//            count++;
//        }
//        long res = 1;   // 用 int 的话，越界后会有错误结果
//        while (count > 0) {
//            res = (3 * res) % P;
//            count--;
//        }
//        res = (res * n) % P;
//        return (int)res;
//    }

    /**
     * 快速幂
     */
    private static int P = 1000000007;
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        long res = 1;
        long x = 3;
        // 因为如果余1的话，最后4单位长度的绳子应该分成 2 * 2 而不是 3 * 1，所以要提前少算一截。
        n = n / 3 - 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = (res * x) % P;
            }
            x = (x * x) % P;
            n >>= 1;
        }

        if (b == 0) {
            return (int) (res * 3 % P);
        }
        if (b == 1) {
            return (int) (res * 4 % P);
        }
        return (int) (res * 6 % P);
    }

    public static void main(String[] args) {
        new CuttingRope().cuttingRope(120);
        System.out.println(510817737 * 3 % P);
    }
}
