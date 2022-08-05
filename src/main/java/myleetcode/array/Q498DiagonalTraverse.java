package myleetcode.array;

import myleetcode.utils.ArrayUtil;

import java.util.Arrays;

public class Q498DiagonalTraverse {
    /**
     * 这个是错误的
     */
    public int[] findDiagonalOrder0(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int index = 0;
        int[] ans = new int[m * n];
        boolean flag = true;
        int offset = n - m >> 1;
        for (int i = 0; i < m + n - 1; i++) {
            if (flag) {
                if (i < m) {
                    for (int x = i, y = 0; x >= 0; x--, y++) {
                        ans[index++] = mat[x][y];
                    }
                } else {
                    for (int x = m - 1, y = i - m + 1; y < n; x--, y++) {
                        ans[index++] = mat[x][y];
                    }
                }
            } else {
                if (i < m) {
                    for (int x = 0 - offset, y = i + offset; x <= i; x++, y--) {
                        ans[index++] = mat[x][y];
                    }
                } else {
                    for (int x = i - m + 1 - offset, y = n - 1 - offset; x < m; x++, y--) {
                        ans[index++] = mat[x][y];
                    }
                }
            }
            flag = !flag;
        }
        return ans;
    }


    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int cnt = m * n;
        int index = 0;
        int[] ans = new int[cnt];

        // 遍历方向使用 dir 代指（当 dir = 1 代表往右上方进行遍历，当 dir = -1 代表往左下方进行遍历）
        // 结合 dir 找到当前位置的右上方格子 (x - 1, y + 1) 或是左下方格子 (x + 1, y - 1)
        int x = 0, y = 0, dir = 1;
        while (index != cnt) {
            ans[index++] = mat[x][y];
            int nx = x, ny = y;
            if (dir == 1) {
                nx = x - 1;
                ny = y + 1;
            } else {
                nx = x + 1;
                ny = y - 1;
            }
            if (index < cnt && (nx < 0 || nx == m || ny < 0 || ny == n)) {
                if (dir == 1) {
                    nx = y + 1 < n ? x : x + 1;
                    ny = y + 1 < n ? y + 1 : y;
                } else {
                    nx = x + 1 < m ? x + 1 : x;
                    ny = x + 1 < m ? y : y + 1;
                }
                dir *= -1;
            }
            x = nx;
            y = ny;
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(ArrayUtil.turnToBigBrackets("[[6,9,7]]"));
//        new Q498DiagonalTraverse().findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        int[] diagonalOrder = new Q498DiagonalTraverse().findDiagonalOrder(new int[][]{{2, 3}});
//        int[] diagonalOrder2 = new Q498DiagonalTraverse().findDiagonalOrder(new int[][]{{3},{2}});
//        int[] diagonalOrder3 = new Q498DiagonalTraverse().findDiagonalOrder(new int[][]{{6,9,7}});
//        System.out.println(Arrays.toString(diagonalOrder));
        System.out.println(Arrays.toString(diagonalOrder));
        System.out.println((int)'Z');
        System.out.println((int)'z');
        System.out.println((int)'a');
        System.out.println((int)'A');
    }
}
