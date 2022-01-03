package jian_zhi_offer.day17_sort;

import java.util.Arrays;

public class GetLeastNumbers {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        return Arrays.copyOf(arr, k);
//    }

    /**
     * 基于快速排序的数组划分,这个方法妙极了
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int l) {
        int tmp = arr[i];
        arr[i] = arr[l];
        arr[l] = tmp;
    }
}
