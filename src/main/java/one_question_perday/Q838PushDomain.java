package one_question_perday;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q838PushDomain {
    /**
     * 思路：广度优先搜索，力的传递需要一秒，则每一秒为一层
     * 出处：宫水三叶。
     */
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;

        // 记录每个骨牌是第几次受力
        int[] g = new int[n];

        // 三元组 [第几个， 第几秒（第几层）， 受力方向]
        Deque<int[]> d = new ArrayDeque<>();

        // 第一秒的时候，所有有力施加的多米诺骨牌相关情况入队
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') continue;
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }

        // 层序遍历，先进先出就不需要维护对 size 的循环。
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();

            // time 不可能为 0，最小是 1
            int loc = info[0], time = info[1], dire = info[2];

            // ne 表示下一秒，这里的力会传递至什么地方(只有两种可能，相邻的左或右)。
            int ne = loc + dire;

            // 第一层的时候，肯定不会触发 cs[loc] == '.' √
            // 意外发现：cs[loc] == '.' 这个条件可以不写，也是对的。
            // TODO: 看不懂，为什么要写这个

            /**
             * 因为能在队里取出 说明曾经入队 曾经入队 说明当时状态不是 .
             *
             * 而最终取出的时候是 . 说明该骨牌是被修正过的
             *
             * 也就是存在从不是 . 变为 . 的过程
             *
             * 而 . 的骨牌是不能对旁边的骨牌产生影响的 因此要 continue
             */
            if (cs[loc] == '.' || (ne < 0 || ne >= n)) {
                continue;
            }
            if (g[ne] == 0) { // 首次受力

                // 这里入队是在维护 BFS，下一秒，什么位置，受了什么力
                d.addLast(new int[]{ne, time + 1, dire});

                // 无论是什么情况，肯定要维护该骨牌的受力次数
                g[ne] = time + 1;

                // 为什么这里要更新？力都传递过来了，肯定要更新呀。
                // 为什么能直接按力更新？因为首次受力才会进入这里，那就直接按方向更新。
                cs[ne] = dire == -1 ? 'L' : 'R';

                // 为什么该条件表示多次受力？而不是写作 g[ne] > 1? 因为改了就错了。
                // 左边往右倒，右边往左倒，也是两个歪着的。所以一个骨牌能立着一定是同一层两次受力。
            } else if (g[ne] == time + 1) { // 多次受力

                // 如果一个骨牌能平衡，当且仅当同一层有两次受力。（Q1：那如果相邻的骨牌一左一右？）
                // 原因：一个骨牌，在层序遍历中同一层最多只会有两次受力。
                // A1：相邻骨牌一左一右是两个歪的。（Q2：连续两个同方向倒的骨牌呢？）
                // A2(读题，认真点):就这个问题而言，我们会认为一张正在倒下的多米诺骨牌
                // 不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。（所以一张骨牌永远不会受力三次。）
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        String rl = new Q838PushDomain().pushDominoes("RL");
        System.out.println(rl);
    }
}
