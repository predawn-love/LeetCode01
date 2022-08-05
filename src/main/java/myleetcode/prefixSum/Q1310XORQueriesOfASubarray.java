package myleetcode.prefixSum;

import myleetcode.utils.ArrayUtil;

import java.util.Arrays;

public class Q1310XORQueriesOfASubarray {
    /**
     * 最优解：前缀数组异或
     */
    public int[] xorQueries0(int[] arr, int[][] queries) {
        int n = queries.length;
        int len = arr.length;
        int[] ans = new int[n];
        int[] prefixXOR = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefixXOR[l] ^ prefixXOR[r + 1];
        }
        return ans;
    }

    /**
     * 树状数组，炫个技
     */
    private int[] tree;
    private int n;

    private int lowbit(int x) {
        return x & -x;
    }

    private void add(int x, int val) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] ^= val;
        }
    }

    private int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans ^= tree[i];
        }
        return ans;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        n = arr.length;
        int len = queries.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, arr[i]);
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = query(l) ^ query(r + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = ArrayUtil.turnToBigBrackets("[[0,1],[1,2],[0,3],[3,3]]");
//        System.out.println(s);
        int[] ints = new Q1310XORQueriesOfASubarray().xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        System.out.println(Arrays.toString(ints));

    }
}
