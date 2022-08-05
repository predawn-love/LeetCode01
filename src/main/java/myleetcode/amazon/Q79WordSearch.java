package myleetcode.amazon;

public class Q79WordSearch {
    public static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private char[][] board;
    private int rows, cols;
    private boolean[][] visited;
    private char[] wordChars;
    private int length;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        length = word.length();
        wordChars = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        // 先考虑退出条件
        if (wordChars[begin] != board[x][y]) {
            return false;
        }
        if (begin == length - 1) {
            return true;
        }

        visited[x][y] = true;
        for (int[] dir : DIRS) {
            int nextX = dir[0] + x;
            int nextY = dir[1] + y;
            if (nextX < 0 || nextY < 0 || nextX >= rows || nextY >= cols) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            if (dfs(nextX, nextY, begin + 1)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
