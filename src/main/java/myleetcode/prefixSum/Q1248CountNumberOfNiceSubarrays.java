package myleetcode.prefixSum;
class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, oddCnt = 0, res = 0;
        while (right < nums.length) {
            // 右指针先走，每遇到一个奇数则 oddCnt++。
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }

            //  若当前滑动窗口 [left, right) 中有 k 个奇数了，进入此分支统计当前滑动窗口中的优美子数组个数。
            if (oddCnt == k) {
                // 先将滑动窗口的右边界向右拓展，直到遇到下一个奇数（或出界）
                // rightEvenCnt 即为第 k 个奇数右边的偶数的个数
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                // leftEvenCnt 即为第 1 个奇数左边的偶数的个数
                int leftEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }
                // 第 1 个奇数左边的 leftEvenCnt 个偶数都可以作为优美子数组的起点
                // (因为第1个奇数左边可以1个偶数都不取，所以起点的选择有 leftEvenCnt + 1 种）
                // 第 k 个奇数右边的 rightEvenCnt 个偶数都可以作为优美子数组的终点
                // (因为第k个奇数右边可以1个偶数都不取，所以终点的选择有 rightEvenCnt + 1 种）
                // 所以该滑动窗口中，优美子数组左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)
                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);

                // 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                oddCnt--;
            }

        }

        return res;
    }

}

public class Q1248CountNumberOfNiceSubarrays {
    public int numberOfSubarrays0(int[] nums, int k) {
        int left = 0, right = 0, oddCnt = 0, res = 0;
        int n = nums.length;
        while (right < n) {
            // 右指针先走，每遇到一个奇数则 oddCnt++。
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }

            if (oddCnt != k) {
                continue;
            }

            // 先将滑动窗口的右边界向右扩展，直到遇到下一个奇数(或出界)
            // rightEvenCnt 为第 k 个奇数右边的偶数的个数
            int tmp = right;
            while (right < nums.length && ((nums[right] & 1) == 0)) {
                right++;
            }
            int rightEvenCnt = right - tmp;
            int leftEvenCnt = 0;
            while (((nums[left] & 1) == 0)) {
                leftEvenCnt++;
                left++;
            }
            res += (leftEvenCnt + 1) * (rightEvenCnt + 1);
            left++;
            oddCnt--;
        }
        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length + 1;

        // prefix[i] 从首位开始有 i 个奇数的连续子数组的个数。
        int[] prefix = new int[n];
        prefix[0] = 1;
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += (num & 1);
            prefix[sum]++;
            if (sum >= k) {
                // prefix虽然直观上看是上面注解的意思，
                // 反过来思考一下我们要找的是右指针在当前 num 时有多少个左指针可以对应
                // 目标左指针最右的位置肯定是奇数位，同时我们要找该奇数左边有多少个偶数
                // prefix的值则是某个奇数及右边有多少个连续偶数，在数值上这是相等的。
                res += prefix[sum - k];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        new Q1248CountNumberOfNiceSubarrays().numberOfSubarrays(new int[]{1,1,2,1,1}, 3);
    }
}
