package myleetcode.sort;

import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;

public class Q215KthLargestElementInAnArray {
    /**
     * 解法1：我自己的堆排序。
     */
//    public int findKthLargest(int[] nums, int k) {
//        heapSort(nums);
//        return nums[nums.length - k];
//    }
//
//    private void heapSort(int[] nums) {
//        int n = nums.length - 1;
//
//        // 从倒数第二层开始建堆。堆无序的大顶堆。
//        for (int i = (n - 1) / 2; i >= 0; i--) {
//            sink(nums, i, n);
//        }
//
//        // 建完堆后，要让堆有序。从下往上恢复堆有序，从最后一位开始。
//        while (n > 0) {
//            // 最大的已经放到最末尾了，完成了排序，所以交换后，最大的就不动了，移出需要排序的域。
//            exch(nums, 0, n--);
//            sink(nums, 0, n);
//        }
//    }
//
//    private void exch(int[] nums, int a, int b) {
//        int temp = nums[b];
//        nums[b] = nums[a];
//        nums[a] = temp;
//    }
//
//    private void sink(int[] nums, int i, int n) {
//        while (true) {
//            // j是在找自己的左叶子节点
//            int j = 2 * i + 1;
//            if (j > n) {
//                break;
//            }
//
//            // 要和左右叶子节点中大的那个进行交换。
//            if (j < n && less(nums, j, j + 1)) {
//                j++;
//            }
//
//            // 当前值比最大的叶子节点都要大，就不用下沉了
//            if (!less(nums, i, j)) {
//                break;
//            }
//
//            // 下沉的话，就要交换
//            exch(nums, i, j);
//            i = j;
//        }
//    }
//
//    private boolean less(int[] nums, int a, int b) {
//        return nums[a] < nums[b];
//    }

    /**
     * 解法2：修改后的快速排序
     */
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        int left = 0;
//        int right = len - 1;
//
//        // 转换一下，第k大元素的索引是 len - k;
//        int target = len - k;
//
//        while (true) {
//            int index = partition(nums, left, right);
//            if (index == target) {
//                return nums[index];
//            } else if (index < target) {
//                left = index + 1;
//            } else {
//                right = index - 1;
//            }
//        }
//    }
//
//    /**
//     * 在数组nums的子区间[left, right]执行partition操作，返回nums[left]排序后应该在的位置
//     */
//    private int partition(int[] nums, int left, int right) {
//        int pivot = nums[left];
//        int j = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                // 小于pivot的元素都被交换到前面
//                j++;
//                swap(nums, j, i);
//            }
//        }
//        // 在之前遍历的过程中，满足 [left + 1, j] < pivot, 并且 (j, i] >= pivot
//        swap(nums, j, left);
//        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
//        return j;
//    }
//
//    private void swap(int[] nums, int index1, int index2) {
//        int temp = nums[index1];
//        nums[index1] = nums[index2];
//        nums[index2] = temp;
//    }

    /**
     * 解法2.2：随机选partition的改进快排。(用了安全随机性能较差，用普通随机的话性能巨好)
     */
    SecureRandom random = new SecureRandom();
//    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        // 返回一个 [0, 指定值)的伪随机数
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (nums[j] < pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
