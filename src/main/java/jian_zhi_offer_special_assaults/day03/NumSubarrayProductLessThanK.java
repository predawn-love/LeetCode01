package jian_zhi_offer_special_assaults.day03;

public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int res = 0;
        int n = nums.length;
        int product = 1;
        while (r < n) {
            product *= nums[r++];
            while (l < r && product >= k) {
                product /= nums[l++];
            }
            if (l <= r) {
                //  右指针每往前移动一格，左指针不动的情况下，
                //  product *= nums[r];执行后 product 符合条件的情况下
                //  会增加 r - l + 1 种搭配的子数组。
                //  而我们在上面的代码使用了 product *= nums[r++];
                //  所以这里 res += r - l; 不 +1 是因为 r 自增了一次。
                res += r - l;
            }
        }
        return res;
    }
}
