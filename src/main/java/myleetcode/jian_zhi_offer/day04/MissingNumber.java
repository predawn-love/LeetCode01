package myleetcode.jian_zhi_offer.day04;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] == mid) {
                l = mid + 1;
            } else if (nums[mid] > mid) {
                r = mid;
            }
        }
        return l;
    }
}
