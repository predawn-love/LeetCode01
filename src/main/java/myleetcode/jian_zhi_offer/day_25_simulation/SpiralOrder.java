package myleetcode.jian_zhi_offer.day_25_simulation;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int upperBoundary = 0;
        int lowerBoundary = matrix.length - 1;
        int leftBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int curIndex = 0;
        while (true) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                res[curIndex++] = matrix[upperBoundary][i];
            }
            if (lowerBoundary < ++upperBoundary) {
                break;
            }
            for (int i = upperBoundary; i <= lowerBoundary; i++) {
                res[curIndex++] = matrix[i][rightBorder];
            }
            if (leftBorder > --rightBorder) {
                break;
            }
            for (int i = rightBorder; i >= leftBorder; i--) {
                res[curIndex++] = matrix[lowerBoundary][i];
            }
            if (upperBoundary > --lowerBoundary) {
                break;
            }
            for (int i = lowerBoundary; i >= upperBoundary; i--) {
                res[curIndex++] = matrix[i][leftBorder];
            }
            if (rightBorder < ++leftBorder) {
                break;
            }
        }
        return res;
    }
}
