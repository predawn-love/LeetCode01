package myleetcode.prefixSum;

import java.util.PriorityQueue;

public class Q1738FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixXOR = new int[m + 1][n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixXOR[i + 1][j + 1] = matrix[i][j] ^ prefixXOR[i][j + 1]
                        ^ prefixXOR[i + 1][j] ^ prefixXOR[i][j];
                if (pq.size() < k) {
                    pq.add(prefixXOR[i + 1][j + 1]);
                } else {
                    if (pq.peek() < prefixXOR[i + 1][j + 1]) {
                        pq.poll();
                        pq.add(prefixXOR[i + 1][j + 1]);
                    }
                }
            }
        }
        return pq.peek();
    }
}
