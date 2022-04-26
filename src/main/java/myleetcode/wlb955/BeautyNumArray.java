package myleetcode.wlb955;

import java.util.*;

public class BeautyNumArray {
    /**
     * 纯暴力
     */
    private List<List<Integer>> result;
    private int n;
    public int func0(int[] nums, int k) {
        result = new ArrayList<>();
        n = nums.length;
        for (int i = 0; i < n - k + 1; i++) {
            int oldNumAmount = 0;
            List<Integer> path = new ArrayList<>();
            for (int j = i; j < n; j++) {
                int curNum = nums[j];
                path.add(curNum);
                if ((curNum & 1) == 0) {
                    oldNumAmount++;
                }
                if (oldNumAmount == k) {
                    result.add(new ArrayList<>(path));
                }
                if (oldNumAmount > k) {
                    break;
                }
            }
        }
        return result.size();
    }


    /**
     * dfs+回溯+剪枝
     */
//    private List<List<Integer>> result;
//    boolean[] used;
//    private int[] nums;
//    private int n;
//    private int k;
//    public List<List<Integer>> func1(int[] nums, int k) {
//        result = new ArrayList<>();
//        n = nums.length;
//        used = new boolean[n];
//        this.nums = nums;
//        this.k = k;
//        Deque<Integer> path = new ArrayDeque<>();
//        dfs(0,0, path);
//        return result;
//    }
//
//    private void dfs(int curIndex, int oldNumAmount, Deque<Integer> path) {
//        if (oldNumAmount == k) {
//            result.add(new ArrayList<>(path));
//        }
//        for (int i = curIndex; i < n; i++) {
//            path.add(i);
//            used[i] = true;
//
//            // FIXME:
//            dfs(i + 1, 0, path);
//            used[i] = false;
//            path.remove(path.size() - 1);
//        }
//    }



//    private List<List<Integer>> result;
//    private int n;
//    public long func3(int[] nums, int k) {
//        result = new ArrayList<>();
//        n = nums.length;
//        int[] prefix = new int[n + 1];
//        for (int i = 1; i < n; i++) {
//            prefix[i] = (prefix[i - 1]) + (nums[i - 1] & 1) == 1 ? 1 : 0;
//        }
//
//        int l = 0, r = 1;
//        while (true) {
//            int oldNumCount = prefix[r] - prefix[l];
//            if (oldNumCount < k) {
//                r++;
//                continue;
//            }
//            if (oldNumCount == k) {
//
//            }
//            break;
//        }
//        return 1l;
//    }

    public long func4(int[] a, int n, int k) {
        int count = 0;

        // prefix[i] 表示以 0 为起始的所有前缀中，有 i 个奇数的前缀的数量
        int[] prefix = new int[n + 1];
        int odd = 0;
        for (int i = 0; i < n; i++) {
            prefix[odd]++;

            if ((a[i] & 1) == 1) {
                odd++;
            }

            if (odd >= k) {
                count += prefix[odd - k];
            }
        }
        System.out.println(Arrays.toString(prefix));
        return count;
    }

    public static void main(String[] args) {
        BeautyNumArray util = new BeautyNumArray();
        int[] nums = new int[]{2,3,4,5,6};
        int a = util.func0(nums, 2);
        long l = util.func4(nums, nums.length, 2);
        System.out.println(a);
        System.out.println(l);
    }
}
