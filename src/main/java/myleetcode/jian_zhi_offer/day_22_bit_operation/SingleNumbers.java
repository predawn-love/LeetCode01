package myleetcode.jian_zhi_offer.day_22_bit_operation;

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        int m = 1;
        while ((m & x) == 0) {
            m <<= 1;
        }
        int a = 0,b = 0;
        for (int i : nums) {
            if ((i & m) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
