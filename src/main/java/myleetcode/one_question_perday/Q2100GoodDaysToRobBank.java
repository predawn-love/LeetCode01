package myleetcode.one_question_perday;

import java.util.ArrayList;
import java.util.List;

public class Q2100GoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;

        // 1、一个数组记录当前位比前一位大还是小
        int[] g = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] == security[i - 1]) continue;
            g[i] = security[i] > security[i - 1] ? 1 : -1;
        }

        // 2、两个前缀数组分别只记录 1 的数量和 -1 的数量
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + (g[i - 1] == 1 ? 1 : 0);
            b[i] = b[i - 1] + (g[i - 1] == -1 ? 1 : 0);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = time + 1; i <= n - time; i++) {
            if (a[i] - a[i - time] == 0 && b[i + time] - b[i] == 0) {
                res.add(i - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 3, 3, 5, 6, 2};
        List<Integer> ans = new ArrayList<>();
        List<Integer> integers = new Q2100GoodDaysToRobBank().goodDaysToRobBank(ints, 2);
        System.out.println(integers);
    }
}
