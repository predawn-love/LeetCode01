package myleetcode.jian_zhi_offer_special_assaults.day01;

public class Divide {
    /**
     *  二分+减法：
     *  原题解链接：https://leetcode-cn.com/problems/xoh6Oh/solution/shua-chuan-jian-zhi-offer-day01-zheng-sh-8u0s/
     */
    public int divide(int a, int b) {
        int flag = 0;

        // 目标：统一为正数或负数进行处理
        // 原因：最大的整数转为负数依然在范围内，相反如果把最小的负数转为正数就会溢出 int 范围
        // 结果：统一转成负数进行计算
        if (a > 0) {
            a = -a;
            flag ++;
        }
        if (b > 0) {
            b = -b;
            flag ++;
        }
        int res = calc(a, b);

        //  flag != 1 说明 a 和 b 同号，则res 应为正数。
        //  而此时 res == Integer.MIN_VALUE 说明输入是 -2147483648 和 -1，这种情况下答案理应为 2147483648
        //  但 int 最大值为 2147483647，所以处理溢出后应返回 2147483647。 则将 res 更新为 -2147483647。可以吻合后续代码。
        if (flag != 1 && res == Integer.MIN_VALUE) {
            res++;
        }

        // flag == 1 表明 a 和 b 不同号
        return flag == 1 ? res : -res;
    }

    private int calc(int a, int b) {
        int res = 0;
        while (a <= b) {
            int cnt = 1;
            int val = b;

            //  二分法，每次 除数 += 除数， 同时把 商计数 += 商计数。
            //  因此，当 除数 < (Integer.MIN_VALUE / 2) 时，再执行 除数 += 除数 则会发生溢出，所以要停止循环。
            //  a <= (val << 1) 则是正常的循环控制，因为是负数进行处理的，所以在 a > (val << 1) 时停止循环
            while ((val >= (Integer.MIN_VALUE >> 1)) && (a <= (val << 1))) {
                cnt += cnt;
                val += val;
            }

            // res 从零开始，每次减去 cnt，表示倍数。
            // a -= val; 比如 15 和 2， 第一次跳出会在 除数 val = -8 时跳出
            // a 会更新为 -7 依然小于 -2，还要继续进行二分
            res -= cnt;
            a -= val;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = Integer.MIN_VALUE >> 1;
        int calc = new Divide().divide(15, 2);
        System.out.println(calc);
    }
}
