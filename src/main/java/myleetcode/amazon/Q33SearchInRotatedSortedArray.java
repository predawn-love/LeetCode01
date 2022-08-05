package myleetcode.amazon;

public class Q33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        // 第一次【二分】：找到满足 >= nums[0] 的分割点（旋转点）
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (int)((long) l + r >> 1);
            if (nums[0] > nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        // 第二次【二分】：通过和 nums[0] 比较，得知 target 是在旋转点的左边还是右边
        if (nums[0] > target) {
            // 在旋转点右
            r = nums.length - 1;
        } else {
            l = 0;
        }
        while (l < r) {
            int m = (int) ((long) l + r >> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
