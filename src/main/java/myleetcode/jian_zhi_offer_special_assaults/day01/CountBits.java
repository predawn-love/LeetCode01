package myleetcode.jian_zhi_offer_special_assaults.day01;

public class CountBits {
    /**
     *  N^2
     */
//    public int[] countBits(int n) {
//        int[] res = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            int cur = i;
//            while (cur > 0) {
//                res[i] += (cur & 1) == 1 ? 1 : 0;
//                cur >>= 1;
//            }
//        }
//        return res;
//    }


    /**
     *  N*logN
     */
//    public int[] countBits(int n) {
//        int[] res = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            res[i] = countOnes(i);
//        }
//        return res;
//    }
//
//    private int countOnes(int i) {
//        int res = 0;
//        while (i != 0) {
//            i &= i - 1;
//            res++;
//        }
//        return res;
//    }


    /**
     * dp-最高有效位
     */
//    public int[] countBits(int n) {
//        int[] res = new int[n + 1];
//        int highBit = 0;
//        for (int i = 1; i <= n; i++) {
//            // 当前位 是 10000...00 这种的，更新 highBit。
//            if ((i & (i - 1)) == 0) {
//                highBit = i;
//            }
//
//            //  11100 - 1000 = 10100，10100 的 1 个数 + 1 肯定是 11100 的 1 个数。
//            res[i] = res[i - highBit] + 1;
//        }
//        return res;
//    }

    /**
     * dp-最低有效位
     */
//    public int[] countBits(int n) {
//        int[] res = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            res[i] = res[i >> 1] + (i & 1);
//        }
//        return res;
//    }

    /**
     * dp-最低设置位
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
