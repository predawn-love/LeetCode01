package myleetcode.array;

import java.util.Arrays;

public class Q59GenerateMatrix {
//    public int[][] generateMatrix0(int n) {
//        int num = 1;
//        int[][] matrix = new int[n][n];
//        int left = 0, right = n - 1, top = 0, bottom = n - 1;
//        while (left <= right && top <= bottom) {
//            for (int column = left; column <= right; column++) {
//                matrix[top][column] = num;
//                num++;
//            }
//            for (int row = top + 1; row <= bottom; row++) {
//                matrix[row][right] = num;
//                num++;
//            }
//            if (left < right && top < bottom) {
//                for (int column = right - 1; column > left; column--) {
//                    matrix[bottom][column] = num;
//                    num++;
//                }
//                for (int row = bottom; row > top; row--) {
//                    matrix[row][left] = num;
//                    num++;
//                }
//            }
//            left++;
//            right--;
//            top++;
//            bottom--;
//        }
//        return matrix;
//    }


    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int j = right - 1; j > left; j--) {
                    matrix[bottom][j] = num++;
                }
                for (int i = bottom; i > top; i--) {
                    matrix[i][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = new Q59GenerateMatrix().generateMatrix12(4, 1);
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
    }

    public int[][] generateMatrix12(int n, int m) {
        int num = 1;
        int[][] matrix = new int[n][m];
        int left = 0, right = m - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int j = right - 1; j > left; j--) {
                    matrix[bottom][j] = num++;
                }
                for (int i = bottom; i > top; i--) {
                    matrix[i][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
