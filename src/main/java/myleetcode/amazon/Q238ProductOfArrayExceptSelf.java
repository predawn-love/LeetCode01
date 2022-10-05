package myleetcode.amazon;

public class Q238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int p = 1, q = 1;
        for (int i = 0; i < n; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * q;
            q *= nums[i];
        }
        return res;
    }
}
