package myleetcode.jian_zhi_offer_special_assaults.day03;

import java.util.Arrays;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;  //  j 指向下一个要增加的位
        int res = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= target) {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


//    public int minSubArrayLen(int s, int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int ans = Integer.MAX_VALUE;
//        int[] sums = new int[n + 1];
//        // 为了方便计算，令 size = n + 1
//        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
//        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
//        // 以此类推
//        for (int i = 1; i <= n; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        for (int i = 1; i <= n; i++) {
//            int target = s + sums[i - 1];
//            int bound = Arrays.binarySearch(sums, target);
//            if (bound < 0) {
//                // Arrays.binarySearch(sums, target);
//                // 该方法在数组中无查找值，但有比该值更大的元素时会返回 (-插入点索引 - 1)
//                // 插入点索引为数组中第一个比查找值大的元素的索引
//                // 所以 -bound - 1 可得到这个第一个比查找值大的元素的索引
//                bound = -bound - 1;
//            }
//            if (bound <= n) {
//                // 当数组中没有任何元素比查找值大时，会返回 nums.length
//                // 而我们定义的 sums 数组长度为 n + 1，
//                // 所以 bound <= n 表示存在元素>=查找值。
//                ans = Math.min(ans, bound - (i - 1));
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }

    public static void main(String[] args) {
        int[] ints = {2,3,1,2,4,3};
        Arrays.sort(ints);
//        System.out.println("------------------------------------");
//        int sum = 0;
//        int times = 0;
//        for (int i = ints.length - 1; i >= ints.length - 7; i--) {
//            sum += ints[i];
//            times++;
//        }
//        System.out.println("sum = " + sum + "   times = " + times);
//        System.out.println("-----------");
        int i = new MinSubArrayLen()
                .minSubArrayLen(7, ints);
        System.out.println(i);
    }
}
