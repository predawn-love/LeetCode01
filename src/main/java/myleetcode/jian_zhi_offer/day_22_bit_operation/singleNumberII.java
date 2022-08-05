package myleetcode.jian_zhi_offer.day_22_bit_operation;

public class singleNumberII {
    /**
     *
     * K神的思路，下面的链接给了 two 怎么计算更详细的解释
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/ji-yu-krahetsda-lao-gei-chu-de-you-xian-67dkc/
     */
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = ((ones ^ num) & (~twos));
            twos = ((twos ^ num) & (~ones));
        }
        return ones;
    }
}
