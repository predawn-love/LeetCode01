package myleetcode.sort;

import java.security.SecureRandom;

public class Q912 {
//    /**
//     * 解法1：快速排序
//     */
//    public int[] sortArray(int[] nums) {
//        quickSort(nums);
//        return nums;
//    }
//
//    private void quickSort(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
//    }
//
//    private void quickSort(int[] nums, int lo, int hi) {
//        if (lo >= hi) {
//            return;
//        }
//        int j = partition(nums, lo, hi);
//        quickSort(nums, lo, j - 1);
//        quickSort(nums, j + 1, hi);
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
//            while (less(nums[++i], pivot)) {
//                // 这里的跳出条件是跟边界匹配的，应对极端的直接移动到边界的情况
//                // 为了不写更复杂的逻辑，所以直接写成匹配边界
//                // 后面的稍微注意一下，就很省事
//                if (i == hi) break;
//            }
//
//            // 同理，这个循环的作用是让右指针j，移动到 a[j] <= pivot 的地方
//            while (less(pivot, nums[--j])) {
//                if (j == lo) break;
//            }
//
//            // 判断结束条件，如果 左指针 移动到了 右指针 重合甚至更右的地方，就结束本轮
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
//
//    /**
//     * 交换
//     */
//    private void swap(int[] nums, int index1, int index2) {
//        int temp = nums[index1];
//        nums[index1] = nums[index2];
//        nums[index2] = temp;
//    }
//
//    /**
//     * 判断a是否小于v
//     */
//    public boolean less(int a, int v) {
//        return a < v;
//    }

    /**
     * 解法1.2：带随机的快速排序
     */
    SecureRandom secureRandom = new SecureRandom();
    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }

    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int j = randomPartition(nums, lo, hi);
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
    }

    private int randomPartition(int[] nums, int lo, int hi) {
        int i = secureRandom.nextInt(hi - lo + 1) + lo;
        swap(nums, i, lo);
        return partition(nums, lo, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        // 将数组切分为a[lo,...,j-1],a[j],a[j+1,...hi]
        // 左右扫描指针, 此处 hi+1是因为，下面算法中从右访问用的是a[--j],
        // 虽然，从左访问同样是a[++i]，但因为我们的标志元素v用的是a[lo]，所以没有必要从最左边起自己和自己比一遍。
        int i = lo, j = hi + 1;
        int pivot = nums[lo];

        while (true) {
            // 如果 a[lo+1,....,hi] 全比 v小 ，即 全比 a[lo]小， 就会触发 里面的break条件
            // 这个循环的作用是 让 i（左指针），移动到 >= pivot（即 >= a[lo]） 的地方
            while (less(nums[++i], pivot)) {
                // 这里的跳出条件是跟边界匹配的，应对极端的直接移动到边界的情况
                // 为了不写更复杂的逻辑，所以直接写成匹配边界
                // 后面的稍微注意一下，就很省事
                if (i == hi) break;
            }

            // 同理，这个循环的作用是让右指针j，移动到 a[j] <= pivot 的地方
            while (less(pivot, nums[--j])) {
                if (j == lo) break;
            }

            // 判断结束条件，如果 左指针 移动到了 右指针 重合甚至更右的地方，就结束本轮
            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }

        swap(nums, lo, j);

        return j;
    }


    /**
     * 交换
     */
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 判断a是否小于v
     */
    public boolean less(int a, int v) {
        return a < v;
    }


    /**
     * 解法2：归并排序
     */
//    public int[] sortArray(int[] nums) {
//        mergeSort(nums);
//        return nums;
//    }

//    private void mergeSort(int[] nums) {
//        mergeSort(nums, 0, nums.length - 1);
//    }

//    private void mergeSort(int[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = (left + right) / 2;
//
//        mergeSort(nums, left, mid);
//        mergeSort(nums, mid + 1, right);
//
//        int[] temp = new int[right - left +1];
//        int i = left, j = mid + 1;
//        int cur = 0;
//
//        while (i <= mid && j <= right) {
//            if (nums[i] <= nums[j]) {
//                temp[cur] = nums[i++];
//            } else {
//                temp[cur] = nums[j++];
//            }
//            cur++;
//        }
//
//        while (i <= mid) {
//            temp[cur++] = nums[i++];
//        }
//        while (j <= right) {
//            temp[cur++] = nums[j++];
//        }
//
//        // 把临时数组挨个填进目标数组的应有位置
//        for (int k = 0; k < temp.length; k++) {
//            nums[left + k] = temp[k];
//        }
//    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int curL = l;
        int curR = mid + 1;
        int curIndex = 0;
        int[] tmp = new int[r - l + 1];
        while (curL <= mid && curR <= r) {
            tmp[curIndex++] = nums[curL] <= nums[curR] ? nums[curL++] : nums[curR++];
        }
        while (curL <= mid) {
            tmp[curIndex++] = nums[curL++];
        }
        while (curR <= r) {
            tmp[curIndex++] = nums[curR++];
        }
        System.arraycopy(tmp, 0, nums, l, r - l + 1);
        return;
    }

}
