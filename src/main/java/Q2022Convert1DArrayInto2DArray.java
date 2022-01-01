public class Q2022Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length != m * n) {
            return new int[][]{};
        }
        int index = 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        }
        return res;
    }
}
