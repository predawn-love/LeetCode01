package myleetcode.jian_zhi_offer.day_30_divide_and_conquer_algorithm;

public class ReversePairs {
    /**
     * 暴力法，会超时
     */
//    public int reversePairs(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }

    /**
     * 分治算法，归并排序，交换的时候记录逆序数
     */
//    private int reversePairsNum;
//    public int reversePairs(int[] nums) {
//        reversePairsNum = 0;
//        int[] newNums = nums;
//        sortArray(newNums);
//        return reversePairsNum;
//    }
//
//    public int[] sortArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new int[]{};
//        }
//        mergeSort(nums, 0, nums.length - 1);
//        return nums;
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
//            if (nums[curL] <= nums[curR]) {
//                tmp[curIndex] = nums[curL++];
//            } else {
//                tmp[curIndex] = nums[curR++];
//                reversePairsNum = reversePairsNum + mid - curL + 1;
//            }
//            curIndex++;
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


    /**
     * K神的归并算逆序
     */
    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }

}
