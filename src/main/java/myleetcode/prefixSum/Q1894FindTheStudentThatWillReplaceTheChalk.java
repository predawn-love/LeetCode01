package myleetcode.prefixSum;

public class Q1894FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer1(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + chalk[i - 1];
        }
        k = (int)(k % sum[n]);

        int l = 1, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (sum[mid] <= k) l = mid;
            else r = mid - 1;
        }
        return sum[r] <= k ? r : r - 1;
    }

    public int chalkReplacer2(int[] chalk, int k) {
        int n = chalk.length;
        long max = 0;
        for (int i : chalk) max += i;
        k = (int)(k % max);
        for (int i = 0; i < n; i++) {
            k -= chalk[i];
            if (k < 0) return i;
        }
        return -1; // never
    }

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long max = 0;
        for (int i : chalk) {
            max += i;
        }

        k = (int) (k % max);
        for (int i = 0; i < n; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return -1;
    }

    public int chalkReplacer0(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + chalk[i];
        }

        // 此处应加等于号
        if (prefixSum[n] <= k) {
            k = (int) (k % prefixSum[n]);
        }

        // l 从 1 开始二分。
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (prefixSum[mid] >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // 注意不能直接返回 l，要分情况而定。
        return prefixSum[l] <= k ? l : l - 1;
    }

    public static void main(String[] args) {
//        new Q1894FindTheStudentThatWillReplaceTheChalk().chalkReplacer(new int[]{5,1,5}, 22);

        System.out.println(Integer.MAX_VALUE);
    }
}
