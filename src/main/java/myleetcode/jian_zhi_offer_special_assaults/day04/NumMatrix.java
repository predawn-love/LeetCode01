package myleetcode.jian_zhi_offer_special_assault.day04;

import java.util.Arrays;

class NumMatrix {
//    int[][] prefixMatrix;
//    int[][] matrix;
//
//    public NumMatrix(int[][] matrix) {
//        if (matrix == null || matrix.length == 0) {
//            return;
//        }
//        this.matrix = matrix;
//        this.prefixMatrix = new int[matrix.length][matrix[0].length];
//        for (int i = 0; i < prefixMatrix.length; i++) {
//            prefixMatrix[i][0] = matrix[i][0];
//            for (int j = 1; j < matrix[0].length; j++) {
//                prefixMatrix[i][j] = matrix[i][j] + prefixMatrix[i][j - 1];
//            }
//        }
//    }
//
//    //  [row1, col1]
//    //             [row2, col2]
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            sum += prefixMatrix[i][col2] - prefixMatrix[i][col1] + matrix[i][col1];
//        }
//        return sum;
//    }



    private int[][] prefixMatrix;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        this.matrix = matrix;
        this.prefixMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        prefixMatrix[0][0] = matrix[0][0];

        // 初始化第 0 行和第 0 列。
        Arrays.fill(prefixMatrix[0], 0);
        for (int i = 1; i < prefixMatrix.length; i++) {
            prefixMatrix[i][0] = prefixMatrix[i - 1][0] + matrix[i - 1][0];
        }

        for (int i = 1; i < prefixMatrix.length; i++) {
            for (int j = 1; j < prefixMatrix[0].length; j++) {
                prefixMatrix[i][j] = prefixMatrix[i - 1][j] + prefixMatrix[i][j - 1]
                        - prefixMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        return;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixMatrix[row2 + 1][col2 + 1] - prefixMatrix[row2 + 1][col1]
                - prefixMatrix[row1][col2 + 1] + prefixMatrix[row1][col1];
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});

        int i = numMatrix.sumRegion(2, 1, 4, 3);
    }
}
