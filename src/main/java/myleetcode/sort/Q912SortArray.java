package myleetcode.sort;

import java.security.SecureRandom;
import java.util.Arrays;

public class Q912SortArray {
    /**
     *  安全随机的快速排序
     */
    SecureRandom secureRandom = new SecureRandom();
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
//        mergeSort(nums, 0, nums.length - 1);
//        heapSort(nums, 0, nums.length - 1);
//        standardQuickSort(nums, 0, nums.length - 1);
        randomQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void randomQuickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = randomPartition(nums, lo, hi);
        randomQuickSort(nums, lo, j - 1);
        randomQuickSort(nums, j + 1, hi);
    }

    private int randomPartition(int[] nums, int lo, int hi) {
        int j = secureRandom.nextInt(hi - lo + 1) + lo;
        swap(nums, lo, j);
        return partition(nums, lo, hi);
    }

    private int partition(int[] nums, int l, int r) {
        int lo = l, hi = r + 1;
        int pivot = nums[l];
        while (true) {
            while (nums[++lo] < pivot) {
                if (lo == r) break;
            }
            while (nums[--hi] > pivot) {
                if (hi == l) break;
            }
            if (lo >= hi) {
                break;
            }
            swap(nums, lo, hi);
        }
        swap(nums, l, hi);
        return hi;
    }

//    private void randomQuickSort(int[] nums, int lo, int hi) {
//        if (lo >= hi) {
//            return;
//        }
//        int j = randomPartition(nums, lo, hi);
//        randomQuickSort(nums, lo, j - 1);
//        randomQuickSort(nums, j + 1, hi);
//    }

//    private int randomPartition(int[] nums, int lo, int hi) {
//        int i = secureRandom.nextInt(hi - lo + 1) + lo;
//        swap(nums, i, lo);
//        return partition(nums, lo, hi);
//    }
//
//    private int partition(int[] nums, int lo, int hi) {
//        // 将数组切分为a[lo,...,j-1],a[j],a[j+1,...hi]
//        // 左右扫描指针, 此处 hi+1是因为，下面算法中从右访问用的是a[--j],
//        // 虽然，从左访问同样是a[++i]，但因为我们的标志元素v用的是a[lo]，所以没有必要从最左边起自己和自己比一遍。
//        int i = lo, j = hi + 1;
//        int pivot = nums[lo];
//
//        while (true) {
//            // 如果 a[lo+1,....,hi] 全比 v小 ，即 全比 a[lo]小， 就会触发 里面的break条件
//            // 这个循环的作用是 让 i（左指针），移动到 >= pivot（即 >= a[lo]） 的地方
//            while (nums[++i] < pivot) {
//                // 这里的跳出条件是跟边界匹配的，应对极端的直接移动到边界的情况
//                // 为了不写更复杂的逻辑，所以直接写成匹配边界
//                // 后面的稍微注意一下，就很省事
//                if (i == hi) break;
//            }
//
//            // 同理，这个循环的作用是让右指针j，移动到 a[j] <= pivot 的地方
//            while (pivot < nums[--j]) {
//                if (j == lo) break;
//            }
//
//            // 判断结束条件，如果 左指针 移动到了 右指针 重合甚至更右的地方，就结束本轮
//            if (i >= j) {
//                break;
//            }
//            swap(nums, i, j);
//        }
//
//        swap(nums, lo, j);
//        return j;
//    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

//    private void mergeSort(int[] nums, int begin, int end) {
//        if (begin >= end) {
//            return;
//        }
//        int mid = begin + end >> 1;
//        mergeSort(nums, begin, mid);
//        mergeSort(nums, mid + 1, end);
//        int curL = begin;
//        int curR = mid + 1;
//        int curIndex = 0;
//        int[] tmp = new int[end - begin + 1];
//        while (curL <= mid && curR <= end) {
//            tmp[curIndex++] = nums[curL] <= nums[curR] ? nums[curL++] : nums[curR++];
//        }
//        while (curL <= mid) {
//            tmp[curIndex++] = nums[curL++];
//        }
//        while (curR <= end) {
//            tmp[curIndex++] = nums[curR++];
//        }
//        System.arraycopy(tmp, 0, nums, begin, end - begin + 1);
//    }

//    private void standardQuickSort(int[] nums, int begin, int end) {
//        if (begin >= end) {
//            return;
//        }
//        int j = partition(nums, begin, end);
//        standardQuickSort(nums, begin, j - 1);
//        standardQuickSort(nums, j + 1, end);
//    }
//
//    private int partition(int[] nums, int lo, int hi) {
//        // 将数组切分为a[lo,...,j-1],a[j],a[j+1,...hi]
//        // 左右扫描指针, 此处 hi+1是因为，下面算法中从右访问用的是a[--j],
//        // 虽然，从左访问同样是a[++i]，但因为我们的标志元素v用的是a[lo]，所以没有必要从最左边起自己和自己比一遍。
//        int i = lo, j = hi + 1;
//        int pivot = nums[lo];
//
//        while (true) {
//            // 如果 a[lo+1,....,hi] 全比 v小 ，即 全比 a[lo]小， 就会触发 里面的break条件
//            // 这个循环的作用是 让 i（左指针），移动到 >= pivot（即 >= a[lo]） 的地方
//            while (nums[++i] < pivot) {
//                // 这里的跳出条件是跟边界匹配的，应对极端的直接移动到边界的情况
//                // 为了不写更复杂的逻辑，所以直接写成匹配边界
//                // 后面的稍微注意一下，就很省事
//                if (i == hi) break;
//            }
//
//            // 同理，这个循环的作用是让右指针j，移动到 a[j] <= pivot 的地方
//            while (pivot < nums[--j]) {
//                if (j == lo) break;
//            }
//
//            // 同理，这个循环的作用是让右指针j，移动到 a[j] <= pivot 的地方
//            if (i >= j) {
//                break;
//            }
//
//            // 用异或做交换只能在确定两个数绝对不相等的时候使用
//            nums[j] ^= nums[i];
//            nums[i] ^= nums[j];
//            nums[j] ^= nums[i];
//        }
//
//        swap(nums, lo, j);
//
//        return j;
//    }
//
//    private void swap(int[] nums, int a, int b) {
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }


//    private void heapSort(int[] nums, int begin, int end) {
//        //  1、建无序堆
//        for (int i = (end - 1) / 2; i >= begin; i--) {
//            sink(nums, i, end);
//        }
//
//        //  2、交换并恢复堆
//        for (int i = end; i > begin;) {
//            swap(nums, begin, i);
//            sink(nums, begin, --i);
//        }
//    }
//
//    private void sink(int[] nums, int targetIndex, int end) {
//        while (true) {
//            int j = targetIndex * 2 + 1;    // 左子节点
//            if (j > end) {
//                return;
//            }
//            if (j + 1 <= end && nums[j] <= nums[j + 1]) {
//                j++;
//            }
//            if (nums[targetIndex] < nums[j]) {
//                swap(nums, targetIndex, j);
//                targetIndex = j;
//            } else {
//                return;
//            }
//        }
//    }
//


//    private void mergeSort(int[] nums, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//        int mid = l + r >> 1;
//        mergeSort(nums, l, mid);
//        mergeSort(nums, mid + 1, r);
//        int curL = l;
//        int curR = mid + 1;
//        int curIndex = 0;
//        int[] tmp = new int[r - l + 1];
//        while (curL <= mid && curR <= r) {
//            tmp[curIndex++] = nums[curL] <= nums[curR] ? nums[curL++] : nums[curR++];
//        }
//        while (curL <= mid) {
//            tmp[curIndex++] = nums[curL++];
//        }
//        while (curR <= r) {
//            tmp[curIndex++] = nums[curR++];
//        }
//        System.arraycopy(tmp, 0, nums, l, r - l + 1);
//        return;
//    }

    public static void main(String[] args) {
        int[] ints = new Q912SortArray().sortArray(new int[]{5, 2, 3, 1});
        System.out.println(Arrays.toString(ints));
    }
}
