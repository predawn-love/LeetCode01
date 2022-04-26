package myleetcode.microsoft;

public class Q4MedianOfTwoSortedArrays {
    /**
     * 方法1：合并至一个数组内
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums;
//        int m = nums1.length;
//        int n = nums2.length;
//        nums = new int[m + n];
//        if (m == 0) {
//            if ((n & 1) == 0) {
//                return (nums2[(n >> 1) - 1] + nums2[n >> 1]) / 2.0;
//            }
//            return nums2[n >> 1];
//        }
//        if (n == 0) {
//            if ((m & 1) == 0) {
//                return (nums1[(m >> 1) - 1] + nums1[m >> 1]) / 2.0;
//            }
//            return nums1[m >> 1];
//        }
//
//        int count = 0;
//        int i = 0;
//        int j = 0;
//        while (count != m + n) {
//            if (i == m) {
//                while (j != n) {
//                    nums[count++] = nums2[j++];
//                }
//                break;
//            }
//            if (j == n) {
//                while (i != m) {
//                    nums[count++] = nums1[i++];
//                }
//                break;
//            }
//            if (nums1[i] < nums2[j]) {
//                nums[count++] = nums1[i++];
//            } else {
//                nums[count++] = nums2[j++];
//            }
//        }
//
//        if ((count & 1) == 0) {
//            return (nums[(count >> 1) - 1] + nums[count >> 1]) / 2.0;
//        } else {
//            return nums[count >> 1];
//        }
//    }

    /**
     * 方法2：写一个循环，找到中位数的位置并返回即可
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int len = m + n;
//        int left = -1;
//        int right = -1;
//
//        int curNums1 = 0;
//        int curNums2 = 0;
//        for (int i = 0; i <= (len >> 1); i++) {
//            left = right;
//            if (curNums1 < m && (curNums2 == n || nums1[curNums1] < nums2[curNums2])) {
//                right = nums1[curNums1++];
//            } else {
//                right = nums2[curNums2++];
//            }
//        }
//        if ((len & 1) == 0) {
//            return (left + right) / 2.0;
//        }
//        return right;
//    }


    /**
     * 方法3：二分查找
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        int left = (n + m + 1) >> 1;
//        int right = (n + m + 2) >> 1;
//
//        // 将奇数和偶数的情况合并，如果是奇数，会求两次同样的 k。
//        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left)
//                + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) / 2.0;
//    }
//
//    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        int len1 = end1 - start1 + 1;
//        int len2 = end2 - start2 + 1;
//
//        // 让 len1 的长度小于等于 len2，这样就能保证如果有数组空了，一定是 len1
//        if (len1 > len2) {
//            return getKth(nums2, start2, end2, nums1, start1, end1, k);
//        }
//        if (len1 == 0) {
//            return nums2[start2 + k - 1];
//        }
//
//        if (k == 1) {
//            return Math.min(nums1[start1], nums2[start2]);
//        }
//
//        int i = start1 + Math.min(len1, k / 2) - 1;
//        int j = start2 + Math.min(len2, k / 2) - 1;
//
//        if (nums1[i] > nums2[j]) {
//            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//        } else {
//            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//        }
//    }

    /**
     * 方法3：二分查找，代码来自官解
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length1 = nums1.length, length2 = nums2.length;
//        int totalLength = length1 + length2;
//        if ((totalLength & 1) == 1) {
//            int midLength = totalLength >> 1;
//            return getKthElement(nums1, nums2, midLength + 1);
//        } else {
//            int midLength = totalLength >> 1;
//            return (getKthElement(nums1, nums2, midLength + 1) + getKthElement(nums1, nums2, midLength)) / 2.0;
//        }
//    }
//
//    /** 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
//     * 这里的 "/" 表示整除
//     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
//     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
//     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
//     * 这样 pivot 本身最大也只能是第 k-1 小的元素
//     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
//     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
//     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
//     */
//    public int getKthElement(int[] nums1, int[] nums2, int k) {
//        //  index 是每一轮每个数组的首个有效比较位置
//        int index1 = 0, index2 = 0;
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        while (true) {
//            //  处理特殊情况
//            if (index1 == length1) {
//                return nums2[index2 + k - 1];
//            }
//            if (index2 == length2) {
//                return nums1[index1 + k - 1];
//            }
//            if (k == 1) {
//                return Math.min(nums1[index1], nums2[index2]);
//            }
//
//            // 处理一般情况
//            int half = k >> 1;
//            int newIndex1 = Math.min(index1 + half, length1) - 1;
//            int newIndex2 = Math.min(index2 + half, length2) - 1;
//            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
//            if (pivot1 <= pivot2) {
//                k -= (newIndex1 - index1 + 1);
//                index1 = newIndex1 + 1;
//            } else {
//                k -= (newIndex2 - index2 + 1);
//                index2 = newIndex2 + 1;
//            }
//        }
//    }

    /**
     * 方法4：划分数组
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;
        int median1 = 0;    // 前一部分的最小值
        int median2 = 0;    // 后一部分的最大值
        while (left <= right) {
            // 前一部分为 nums[0, 1, ..., i - 1] 和 nums2[0, 1, ..., j - 1]
            // 后一部分为 nums[i, i + 1, ..., m - 1] 和 nums2[j, j + 1, ..., n - 1]
            int i = left + right >> 1;
            int j = ((m + n + 1) >> 1) - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_i = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums_im1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums_j = j == n ? Integer.MAX_VALUE : nums2[j];
            int nums_jm1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];

            if (nums_im1 < nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (n + m & 1) == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
