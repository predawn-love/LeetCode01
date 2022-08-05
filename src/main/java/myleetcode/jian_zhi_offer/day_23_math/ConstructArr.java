package myleetcode.jian_zhi_offer.day_23_math;

public class ConstructArr {
    /**
     * 双循环：超时
     */
//    public int[] constructArr(int[] a) {
//        int[] res = new int[a.length];
//        Arrays.fill(res, 1);
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length; j++) {
//                if (i == j) {
//                    continue;
//                }
//                res[i] *= a[j];
//            }
//        }
//        return res;
//    }

    /**
     * 改进：每次记录下i之前的元素的乘积，依然超时
     */
//    public int[] constructArr(int[] a) {
//        int[] res = new int[a.length];
//        Arrays.fill(res, 1);
//        int p = 1;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                res[i] *= a[j];
//            }
//            res[i] *= p;
//            p *= a[i];
//        }
//        return res;
//    }

    /**
     * 进一步优化：分别记录 i 之前和 i 之后元素的乘积
     */
//    public int[] constructArr(int[] a) {
//        int n = a.length;
//        int[] res = new int[n];
//        if (n == 0) {
//            return res;
//        }
//        // 分别记录 i 之前 和 i 之后的乘积
//        int[] before = new int[n];
//        int[] after = new int[n];
//        before[0] = 1;
//        after[n - 1] = 1;
//        for (int i = 1; i < n; i++) {
//            before[i] = before[i - 1] * a[i - 1];
//        }
//        for (int i = n - 2; i >= 0; i--) {
//            after[i] = after[i + 1] * a[i + 1];
//        }
//        for (int i = 0; i < n; i++) {
//            res[i] = before[i] * after[i];
//        }
//        return res;
//    }

    /**
     * 最终优化：删去两个辅助数组
     */
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        if (n == 0) {
            return res;
        }
        res[0] = 1;
        // 求出前缀积
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct *= a[i + 1];
            res[i] *= suffixProduct;
        }
        return res;
    }
}
