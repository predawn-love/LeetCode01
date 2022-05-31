package girl_friend;

import org.junit.Test;

public class Q000 {
    @Test
    public void fun() {
        int n = 40;
        int result = 1;
        int index = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t", result);
            switch (index) {
                case 0:
                case 3:
                    result = 0;
                    break;
                case 1:
                case 2:
                    result = -1;
                    break;
                case 4:
                case 5:
                    result = 1;
            }
            index++;
            if (index == 6) {
                index = 0;
            }
        }
    }

    @Test
    public void fun1() {
        int n = 40;
        int result = 1;
        int index = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%d,", result);
            if (index == 1) {
                result += result;
            }
            index++;
            if (index == 2) {
                index = 0;
            }
        }
    }

    /**
     * 1、一个大兔子能生两个小兔子
     * 2、一个小兔子三个月可以长成大兔子
     */
    @Test
    public void fun2Correct() {
        int result = 0;
        int bigRabbit = 0;
        int smallRabbit = 2;
        int rabbitOf1Month = 0;
        int rabbitOf2Month = 0;
        int months = 12;
        for (int i = 0; i < months; i++) {
            result = bigRabbit + rabbitOf1Month + rabbitOf2Month + smallRabbit;
            System.out.print(result + ",");
            // 我需要一个新的变量，这个变量用来保存上个月的小兔子和上个月的一个月兔子，防止我这个值丢了
            int smallRabbitAgo = smallRabbit;
            int rabbitOf1MonthAgo = rabbitOf1Month;

            // 这个月的大兔子：上个月的两个月大的兔子长大了，加上原本的大兔子。
            bigRabbit = rabbitOf2Month + bigRabbit;

            // 这个月的小兔子是这个月的大兔子 * 2；
            smallRabbit = bigRabbit * 2;    // 这个小兔子已经是这个月的了

            // 这个月的一个月大的兔子，是上个月的小兔子长大了
            // 计算这个月的一个月大的兔子，需要的是上个月刚出生的小兔子的数量。
            rabbitOf1Month = smallRabbitAgo;

            // 这个月的两个月大的兔子，是上个月的一个月大的兔子长大了
            rabbitOf2Month = rabbitOf1MonthAgo;
        }

        // 结果就是把现在有的所有的兔子加起来。
        result = bigRabbit + rabbitOf1Month + rabbitOf2Month + smallRabbit;
        System.out.println(result);
    }

    /**
     * 1、一个大兔子能生两个小兔子
     * 2、一个小兔子三个月可以长成大兔子
     */
    @Test
    public void fun3() {
        int result = 0;
        int a = 0;
        int b = 2;
        int c = 0;
        int d = 0;
        int months = 12;
        for (int i = 0; i < months; i++) {
            result = a + b + c + d;
            System.out.print(result + ",");
            int e = b;
            int f = c;
            int g = d;
            a = g + a;
            b = a * 2;
            c = e;
            d = f;
        }
        result = a + b + c + d;
        System.out.println(result);
    }

    /**
     * 斐波那契数列
     */
    @Test
    public void fun4() {
        int n = 5;
        int first = 0;
        int second = 1;
        for (int i = 0; i < 5; i++) {
            System.out.print(second + ",");
            int secondAgo = second;
            second = first + second;
            first = secondAgo;
        }
        System.out.print(second);
    }

    @Test
    public void fun5() {
        for (int i = 1; i < 11; i++) {
            System.out.print(calFab(i) + ",");
        }
        System.out.println(calFab(100));
    }

    public int calFab(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return calFab(n - 1) + calFab(n - 2);
    }


    public static void main(String[] args) {
        int a = 2049;
        int b = 1;
        int c = 2048;
        for (int x = 1; x < 2048; x++) {
            for (int y = 1; y < 2048; y++) {
                if (x * y == 2048) {
                    if (x + y < a) {
                        a = x + y;
                        b = x;
                        c = y;
                    }
                }
            }
        }
        System.out.println(b + "," + c);
    }
}
