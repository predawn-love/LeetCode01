package myleetcode.amazon;

public class Q80RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int cur = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[cur - 2]) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
