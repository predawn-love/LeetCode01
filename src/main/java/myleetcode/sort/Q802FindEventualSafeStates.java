package myleetcode.sort;

import java.util.*;

class Solution {
    /**
     * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，
     * 最后必然在有限步内到达终点，则将该起始节点称作是安全的。
     * <p>
     * 最简单的安全点就是无路可走的终点（也即出度为 0 的节点）。
     * 而拓展到一般情况，如果一个节点所指向的点均为安全点，那么这个点也是安全点。
     * <p>
     * 也就是说：我们把出度为零的节点拿走，然后更新图，再拿走出度为零的节点，循环往复。
     * 直至没有出度为零的节点，所有拿走的节点就是答案集合。
     * <p>
     * 拓扑排序是找到图中入度为 0 的节点，以及仅由入度为 0 节点所指向的节点。
     * 而本题是找到图中出度为 0 的节点，以及仅指向出度为 0 节点的节点。
     * 刚好是相反的情况，
     * 所以，我们将题目给定的有向图变为反图（也即有向边的起点、终点互换），
     * 那么所有安全点便可以通过拓扑排序来求解了。
     * <p>
     * 求解思路：不断拿走入度为零的节点并做更新，最后一个也拿不走了，统计现所有已拿走的节点。
     * <p>
     * 根据题目对「安全节点」的定义，
     * 我们知道如果一个节点无法进入「环」的话则是安全的，否则是不安全的。
     * <p>
     * n == graph.length
     * <p>
     * 1 <= n <= 10^4
     * <p>
     * 0 <= graph[i].length <= n
     * <p>
     * 0 <= graph[i][j] <= n - 1
     * <p>
     * graph[i] is sorted in a strictly increasing order.
     * <p>
     * The graph may contain self-loops.
     * <p>
     * The number of edges in the graph will be in the range [1, 4 * 10^4].
     */
    // M = 4 * N; because: The number of edges in the graph will be in the range [1, 4 * 10^4].（题目给的边界条件）
    public static final int N = 10010;
    public static final int M = 10010 << 2;

    // 链式前向星存图
    // he 表示节点，数组大小同节点总数
    public static int[] he = new int[N];

    // 同理 e 表示边，ne 表示下一个，数组大小同边总数
    public static int[] e = new int[M];
    public static int[] ne = new int[M];
    public int idx;

    // 记录每个节点的入度，数组大小同节点数
    public int[] cnts = new int[N];

    // 添加一条由 a 指向 b 的边
    void add(int a, int b) {
        // 第 idx 条边指向 b 节点
        e[idx] = b;

        // 下一个
        //   (所谓的下一个，存的是he[a]更新前的值，
        //   即让我们后续遍历时溯游而上，是溯游而上时的下一个、反向的下一个)
        // 第 idx 条边的出发点是 a 节点
        ne[idx] = he[a];

        // a 节点目前里面是第 idx 条边
        he[a] = idx;

        // idx 自增指向下一个。
        idx++;
    }

    /**
     * @param g 记录边关系的原始数组 eg： g[1] = {2,3,4} 的话，表示节点1有分别指向2、3、4的边。
     * @return 返回安全节点的结果集
     */
    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        Arrays.fill(he, -1);

        // 存反向图，并统计入度
        for (int i = 0; i < n; i++) {
            for (int j : g[i]) {
                add(j, i);
                cnts[i]++;
            }
        }

        // BFS 求反向图拓扑排序，找到初始入度为 0 的节点,作为起始节点
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) {
                deque.add(i);
            }
        }

        // 从入度为 0 的节点开始，构建拓扑排序，使拓扑序中的节点入度归 0.
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int node = e[i];
                if (--cnts[node] == 0) {
                    deque.add(node);
                }
            }
        }

        // 遍历答案：
        // 如果某个节点出现在拓扑序列，则说明其进入过队列，现在它的入度应为0
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

public class Q802FindEventualSafeStates {
    /**
     * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，
     * 最后必然在有限步内到达终点，则将该起始节点称作是安全的。
     * <p>
     * 最简单的安全点就是无路可走的终点（也即出度为 0 的节点）。
     * 而拓展到一般情况，如果一个节点所指向的点均为安全点，那么这个点也是安全点。
     * <p>
     * 拓扑排序是找到图中入度为 0 的节点，以及仅由入度为 0 节点所指向的节点。
     * 而本题是找到图中出度为 0 的节点，以及仅指向出度为 0 节点的节点。
     * 刚好是相反的情况，
     * 所以，我们将题目给定的有向图变为反图（也即有向边的起点、终点互换），
     * 那么所有安全点便可以通过拓扑排序来求解了。
     * <p>
     * 根据题目对「安全节点」的定义，
     * 我们知道如果一个节点无法进入「环」的话则是安全的，否则是不安全的。
     * <p>
     * n == graph.length
     * <p>
     * 1 <= n <= 10^4
     * <p>
     * 0 <= graph[i].length <= n
     * <p>
     * 0 <= graph[i][j] <= n - 1
     * <p>
     * graph[i] is sorted in a strictly increasing order.
     * The graph may contain self-loops.
     * The number of edges in the graph will be in the range [1, 4 * 10^4].
     */
    // M = 4 * N; because: The number of edges in the graph will be in the range [1, 4 * 10^4].
    public static final int N = 10010;
    public static final int M = 10010 << 2;

    // 链式前向星存图
    // he 表示节点，数组大小同节点总数
    public static int[] he = new int[N];

    // 同理 e 表示边，ne 表示下一个，数组大小同边总数
    public static int[] e = new int[M];
    public static int[] ne = new int[M];
    public int idx;

    // 记录每个节点的入度，数组大小同节点数
    public int[] cnts = new int[N];

    // 添加一条由 a 指向 b 的边
    void add(int a, int b) {
        // 第 idx 条边指向 b 节点
        e[idx] = b;

        // 下一个
        //   (所谓的下一个，存的是he[a]更新前的值，
        //   即让我们后续遍历时溯游而上，是溯游而上时的下一个、反向的下一个)
        // 第 idx 条边的出发点是 a 节点
        ne[idx] = he[a];

        // a 节点目前里面是第 idx 条边
        he[a] = idx;

        // idx 自增指向下一个。
        idx++;
    }

    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        Arrays.fill(he, -1);

        // 存反向图，并统计入度
        for (int i = 0; i < n; i++) {
            for (int j : g[i]) {
                add(j, i);
                cnts[i]++;
            }
        }

        // BFS 求反向图拓扑排序，找到初始入度为 0 的节点,作为起始节点
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) {
                deque.add(i);
            }
        }

        // 从入度为 0 的节点开始，构建拓扑排序，使拓扑序中的节点入度归 0.
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int node = e[i];
                if (--cnts[node] == 0) {
                    deque.add(node);
                }
            }
        }

        // 遍历答案：
        // 如果某个节点出现在拓扑序列，则说明其进入过队列，现在它的入度应为0
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});

    }
}

class c802 {

    // 节点总数
    public static final int N = 10010;

    // 边总数
    public static final int M = 10010 << 2;

    // 链式前向星存图
    // he 表示节点，数组大小同节点总数
    public static int[] he = new int[N];

    // e 表示边，数组大小同边总数。
    public static int[] e = new int[M];

    // ne 表示下一个，数组大小同边总数
    public static int[] ne = new int[M];
    public int idx;

    // 记录每个节点的入度，数组大小同节点数
    public int[] cnts = new int[N];

    // 添加一条由 a 指向 b 的边
    private void add(int a, int b) {
        e[idx] = b;

        // 下一个
        // （所谓的下一个，存的是 he[a] 更新前的值，
        //  即让我们后续遍历时溯游而上，是溯游而上时的下一个、反向的下一个）
        // 第 idx 条边的出发点是 a 节点
        ne[idx] = he[a];

        // a 节点目前里面是第 idx 条边
        he[a] = idx;

        // idx 自增指向下一个。
        idx++;
    }

    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        Arrays.fill(he, -1);

        // 存反向图并统计入度
        for (int i = 0; i < n; i++) {
            for (int j : g[i]) {
                add(j, i);
                cnts[i]++;
            }
        }

        // 2.单独拆出入度为零的点，不断刷新图

        // 2.1，BFS 求反向图拓扑排序，找到初始入度为 0 的节点，作为起始节点。
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) {
                deque.add(i);
            }
        }

        // 2.2，从入度为 0 的节点开始，构建拓扑排序，使拓扑序中的节点入度归 0.
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int node = e[i];
                if (--cnts[node] == 0) {
                    deque.add(node);
                }
            }
        }

        // 最后统计入度为零的，构建结果集
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

