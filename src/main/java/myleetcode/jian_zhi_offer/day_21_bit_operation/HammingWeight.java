package myleetcode.jian_zhi_offer.day_21_bit_operation;

public class HammingWeight {
    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//            res += (n & 1);
//            n >>>= 1;
//        }
//        return res;
//    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res ++;
            // 每这样做一次相当于消去最右边的一个1
            n &= (n - 1);
        }
        return res;
    }
}
