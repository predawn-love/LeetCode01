package myleetcode.jian_zhi_offer.day04;

public class Search {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        if (r == -1) {
            return 0;
        }

        // 先找左边界，小于和 大于等于
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] != target) {
            return 0;
        }
        int left = l;
        l = 0;
        r = nums.length - 1;

        // 找右边界， 小于等于 和 大于
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int right = l;
        return right - left + 1;
    }
}
