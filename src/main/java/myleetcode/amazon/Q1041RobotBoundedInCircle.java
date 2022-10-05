package myleetcode.amazon;

public class Q1041RobotBoundedInCircle {
    public boolean isRobotBounded0(String instructions) {

        int dir = 0; // 方向: 0上   1右   2下   3左
        int x = 0;   // x轴坐标
        int y = 0;   // y轴坐标
        char ch;
        for(int i = 0; i < instructions.length(); i ++){
            ch = instructions.charAt(i); // 逐个读取字符
            if(ch == 'L'){
                if(dir == 0)
                    dir = 3;
                else
                    dir --;
            }
            if(ch == 'R'){
                if(dir == 3)
                    dir = 0;
                else
                    dir ++;
            }
            if(ch == 'G'){
                switch(dir){
                    case 0: y ++; break;
                    case 1: x ++; break;
                    case 2: y --; break;
                    case 3: x --; break;
                }
            }
        }

        // 情况1: 走完一轮回到原点
        if(x == 0 && y == 0)
            return true;

        // 情况2: 走完一轮,只要方向改变了(即不是直走了),最后不管走多少轮总会回到起点
        if(dir != 0)
            return true;

        return false;
    }

    public boolean isRobotBounded(String instructions) {
        // 0-向上  1-向左  2-向下  3-向右
        int dir = 0;

        // {x, y}
        int[] loc = new int[]{0, 0};
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
            } else if (c == 'R') {
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir--;
                }
            } else {
                switch (dir) {
                    case 0:
                        loc[1]++;
                        break;
                    case 1:
                        loc[0]--;
                        break;
                    case 2:
                        loc[1]--;
                        break;
                    case 3:
                        loc[0]++;
                        break;
                }
            }
        }

        // 只要方向有改变就一定会兜圈子 || 走回原点了也是在兜圈子
        if (dir != 0 || (loc[0] == 0 && loc[1] == 0)) {
            return true;
        }
        return false;
    }
}
