package myleetcode.prefixSum;

public class Q1749MaximumAbsoluteSumOfAnySubarray {

    public int maxAbsoluteSum1(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        int ans = 0;
        for (int i = 1, min = 0, max = 0; i <= n; i++) {
            ans = Math.max(ans, Math.abs(sum[i] - min));
            ans = Math.max(ans, Math.abs(sum[i] - max));
            max = Math.max(max, sum[i]);
            min = Math.min(min, sum[i]);
        }
        return ans;
    }


    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int prefixSum = 0;
        int prefixMin = 0;
        int prefixMax = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + nums[i];
            max = Math.max(max, Math.abs(prefixSum - prefixMin));
            prefixMax =  Math.max(prefixSum, prefixMax);
            max = Math.max(max, Math.abs(prefixMax - prefixSum));
            prefixMin =  Math.min(prefixSum, prefixMin);
        }
        return max;
    }

    public int maxAbsoluteSum0(int[] nums) {
        int n = nums.length;
        int prefixSum = 0;
        int prefixMin = 0;
        int prefixMax = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + nums[i];

            if (prefixSum > 0) {
                if (prefixMin < 0) {
                    max = Math.max(max, prefixSum - prefixMin);
                } else {
                    max = Math.max(max, prefixSum);
                }
            }
            prefixMax =  prefixSum > prefixMax ? prefixSum : prefixMax;

            if (prefixSum < 0) {
                if (prefixMax > 0) {
                    // 注意要：正数 - 负数
                    max = Math.max(max, prefixMax - prefixSum);
                } else {
                    max = Math.max(max, -prefixSum);
                }
            }
            prefixMin =  prefixSum < prefixMin ? prefixSum : prefixMin;
        }
        return max;
    }




    public static void main(String[] args) {
        int i = new Q1749MaximumAbsoluteSumOfAnySubarray().maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2});
        System.out.println(i);
    }
}
