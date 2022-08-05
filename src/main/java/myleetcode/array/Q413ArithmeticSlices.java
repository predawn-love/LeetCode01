package myleetcode.array;

public class Q413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2;) {
            int d = nums[i + 1] - nums[i];
            int j = i + 1;
            while (j + 1 < n && nums[j + 1] - nums[j] == d) {
                j++;
            }
            int len = j - i + 1;

            // a1: 长度为 len 的子数组数量； an： 长度为 3 的子数组数量
            int a1 = 1, an = len - 3 + 1;

            // 符合条件（长度大于等于3）的子数组的数量为“等差数列求和的结果”
            int cnt = (a1 + an) * an / 2;
            ans += cnt;
            i = j;
        }
        return ans;
    }
}
