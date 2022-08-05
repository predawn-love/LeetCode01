package myleetcode.amazon;

import java.util.*;
import java.util.stream.Collectors;
class Solution957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap();

        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }

}
public class Q957PrisonCellsAfterNDays {

    /**
     * 热心网友的优化：
     * 1、位运算，分别左移右移后取异或再取反，即为同或，然后与 01111110
     * 2、找循环
     *
     */
    public static final int BN = ((int)Math.pow(2, 7)) - 2;

    public int[] prisonAfterNDays(int[] cells, int N) {
        //将cells转换成二进制数bin
        int bin = 0;
        int dig = 1;
        for (int i = cells.length - 1; i >= 0; i--) {
            bin += cells[i] * dig;
            dig *= 2;
        }

        //计算第一次变更后的状态，记录为start
        bin = ~(bin << 1 ^ bin >> 1) & BN;
        int start = bin;

        //memo数组用于存储计算过的状态
        int[] memo = new int[256];

        memo[0] = start;

        //轮询计算下一天的状态，直到出现循环
        for (int i = 1; i < N; i++) {
            bin = ~(bin << 1 ^ bin >> 1) & BN;
            if (bin == start) {
                //发现循环后，结束遍历,从第一天变换后记为循环的第一轮，因为第0天边缘处可能为1
                bin = memo[(N - 1) % i];
                break;
            } else {
                memo[i] = bin;
            }
        }

        //将最终状态转换回数组，这里为了节省内存，没有创建新数组，而是直接拷贝回cells
        int i = cells.length - 1;
        while (bin > 0) {
            cells[i--] = bin % 2;
            bin /= 2;
        }
        while (i >= 0) {
            cells[i--] = 0;
        }
        return cells;
    }


    /**
     * 官解没懂，嘿嘿
     */
    public int[] prisonAfterNDays1(int[] cells, int n) {
        Map<Integer, Integer> seen = new HashMap<>();

        // state = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; i++) {
            if (cells[i] > 0) {
                state ^= 1 << i;
            }
        }

        // while days remaining, simulate a day
        while (n > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                n %= seen.get(state) - n;
            }
            seen.put(state, n);
            if (n >= 1) {
                n--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; i++) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    private int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6
        for (int i = 1; i <= 6; i++) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans ^= 1 << i;
            }
        }
        return ans;
    }


    public int[] prisonAfterNDays3(int[] cells, int n) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<Integer>(Arrays.stream(cells).boxed().collect(Collectors.toList())));
        cells[7] = 0;
        for (int d = 1; d <= n; d++) {
            for (int i = 1, preCell = cells[1]; i < 7; i++) {
                if (preCell == cells[i + 1]) {
                    preCell = cells[i];
                    cells[i] = 1;
                } else {
                    preCell = cells[i];
                    cells[i] = 0;
                }
            }
            if (!set.contains(Arrays.stream(cells).boxed().collect(Collectors.toList()))) {
                set.add(Arrays.stream(cells).boxed().collect(Collectors.toList()));
            } else {
                System.out.println("-----------------下----");
                System.out.println(Arrays.toString(cells));
                System.out.println("-----------------上----");
            }
            System.out.println(Arrays.toString(cells));
        }
        return cells;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 1, 1, 0, 0, 1};
        int[] ints1 = new Q957PrisonCellsAfterNDays().prisonAfterNDays(ints, 100);

        System.out.println(BN - 0x7E);
//        int[] aaa = {0, 1};
//        HashSet<List<Integer>> ss = new HashSet<>();
//        ss.add(Arrays.stream(aaa).boxed().collect(Collectors.toList()));
//        aaa[0] = 2;
//        ss.add(Arrays.stream(aaa).boxed().collect(Collectors.toList()));
//        aaa[0] = 0;
//        if (ss.contains(Arrays.stream(aaa).boxed().collect(Collectors.toList()))) {
//            System.out.println("yes");
//        } else {
//            ss.add(Arrays.stream(aaa).boxed().collect(Collectors.toList()));
//        }
//        System.out.println(",,,,,,,");
    }
}
