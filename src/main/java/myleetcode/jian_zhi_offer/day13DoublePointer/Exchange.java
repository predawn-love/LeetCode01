package myleetcode.jian_zhi_offer.day13DoublePointer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Exchange {
    /**
     * 会有 O(N) 的空间复杂度
     */
//    public int[] exchange(int[] nums) {
////        int[] ans = nums; 这样是不行的，会有bug，估摸着是地址相同了
//        int[] ans = new int[nums.length];
//        int left = 0;
//        int right = nums.length - 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 != 0) {
//                ans[left++] = nums[i];
//            } else {
//                ans[right--] = nums[i];
//            }
//        }
//        return ans;
//    }

    /**
     *  O(1) 的空间复杂度
     */
    public int[] exchange(int[] nums) {
        int tmp;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
