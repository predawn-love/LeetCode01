package myleetcode.sort;

import myleetcode.utils.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;

public class Q912_20250115 {

    public static void main(String[] args) {
        int[] nums = {1,2,11,4,5,6,7,8,9};
        Q912_20250115 c = new Q912_20250115();
        c.sortArray(nums);
        System.out.printf(ArrayUtils.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }

        Sort sortClass = new MergeSort();
        res = sortClass.sortArray(nums);
        return res;
    }

    interface Sort {
        public int[] sortArray(int[] nums);
    }
    class MergeSort implements Sort {

        public int[] mergeSort(int[] nums, int left, int right) {
            if (left < right - 1) {
                int mid = (left + right) / 2;
                mergeSort(nums, 0, mid);
                mergeSort(nums, mid, right);
            } else {
                if (nums[left] > nums[right]) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
            }
            return nums;
        }

        public int[] sortArray(int[] nums) {
            int length = nums.length;
            return mergeSort(nums, 0, length - 1);
        }
    }
}
