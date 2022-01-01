package OneQuestionPerDay;

public class Q390EliminationGame {


    /**
     * 1
     * 1,2
     * 2
     * 1,2,3
     * 2
     * 1,2,3,4
     * 2,4
     * 2
     * 1,2,3,4,5       [2^n ~ 2^(n+1)) -> n   n=0,1,2,3,4,5.....
     * 2,4
     * 2
     * 1,2,3,4,5,6
     * 2,4,6
     * 4
     *
     * 1,2,3,4,5,6
     * 0,2,0,4,0,6
     * 0,0,0,4,0,0
     *
     * 1,2,3,4,5,6,7
     * 2,4,6
     * 4
     * 1,2,3,4,5,6,7,8
     * 2,4,6,8
     * 2,6
     * 6
     * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17  d = 1
     * 2,4,6,8,10,12,14,16  d = 2
     * 2,6,10,14  d = 4
     * 6,14   d = 8
     * 6
     * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18
     * 2,4,6,8,10,12,14,16,18
     * 4,8,12,16
     * 8,16
     * 8
     *
     * 1、 2 的倍数-1
     * 2、 2 的2次方的倍数
     * 3、 2 的
     *
     * @param n
     * @return
     */

    /**
     * 自己写的暴力模拟，对是对了，但是时间开销和内存开销都太大。
     */
//    public int lastRemaining(int n) {
//        // flagDirection 为 true：从左往右删除， false 从右往左删除
//        boolean flagDirection = true;
//        // count 表示删除次数
//        int count = 0;
//        // 计算需要删除几次
//        for (int i = 1; i <= n; i = i * 2) {
//            count++;
//        }
//        count--;
//        // 初始化一个数组,数组内是[1,2,3,4,5,...,n]，0表示该数字已经删除
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = i + 1;
//        }
//        // 循环遍历删除次数
//        for (int i = 0; i < count; i++) {
//            boolean needToDelete = true;
//            if (flagDirection) {
//                // 从左往右删，因为从0开始遍历
//                for (int j = 0; j < n; j++) {
//                    if (nums[j] != 0) {
//                        if (needToDelete) {
//                            // 1、需要删，并且该数字没删。
//                            nums[j] = 0;
//                        }
//                        needToDelete = !needToDelete;
//                    }
//                }
//            } else {
//                // 从右往左删，从末尾开始遍历
//                for (int j = n - 1; j >= 0; j--) {
//                    if (nums[j] != 0) {
//                        if (needToDelete) {
//                            // 1、需要删，并且该数字没删。
//                            nums[j] = 0;
//                        }
//                        needToDelete = !needToDelete;
//                    }
//                }
//            }
//            flagDirection = !flagDirection;
//        }
//        // [0,0,...,answer,0,0,0,...]
//        int answer = 0;
//        for (int num : nums) {
//            if (num != 0) {
//                answer = num;
//                break;
//            }
//        }
//        return answer;
//    }


    /**
     * 官方解法，等差数列。
     */
//    public int lastRemaining(int n) {
//        int a1 = 1;
//        int cnt = n;
//        int step = 1;
//        boolean flagDirection = true;   // true表示从左往右删
//        while (cnt != 1) {
//            if (flagDirection) {
//                a1 = a1 + step;
//            } else {
//                // 从右往左删除判断总共是偶数个数字还是奇数个数字
//                if (cnt % 2 != 0) {
//                    a1 = a1 + step;
//                }
////                 等价于下面一行代码
////                a1 = (cnt % 2 == 0) ? a1 : (a1 + step);
//            }
//            flagDirection = !flagDirection;
//            step *= 2;
//            cnt /= 2;
//        }
//        return a1;
//    }

    /**
     * 思想还是等差数列，用位运算提高性能效率
     */
    public int lastRemaining(int n) {
        int a1 = 1;
        int cnt = n;
        int step = 1;
        boolean flagDirection = true;   // true表示从左往右删
        while (cnt > 1) {
            if (flagDirection) {
                a1 += step;
            } else {
                // 从右往左删除判断总共是偶数个数字还是奇数个数字,奇数则需要更新a1
                if ((cnt & 1) == 1) {
                    a1 += step;
                }
//                 等价于下面一行代码
//                a1 = (cnt % 2 == 0) ? a1 : (a1 + step);
            }
            flagDirection = !flagDirection;
            step <<= 1;
            cnt >>= 1;
        }
        return a1;
    }

    public static void main(String[] args) {
//        for (int i = 1; i < 50; i++) {
//            int res = new Q390EliminationGame().lastRemaining(i);
//            System.out.println(i + " :" + res);
//        }
        for (int i = 1; i < 200; i++) {
            int res = new Q390EliminationGame().lastRemaining(i);
            System.out.print(res + "\t");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        int n = 100000000;
        int res = new Q390EliminationGame().lastRemaining(n);
        System.out.println(n + " :" + res);
    }

//    public static void main(String[] args) {
//        int count = 0;
//        // 计算需要删除几次
//        for (int i = 1; i <= 18; i = i * 2) {
//            count++;
//        }
//        count--;
//        System.out.println(count);
//    }
}
