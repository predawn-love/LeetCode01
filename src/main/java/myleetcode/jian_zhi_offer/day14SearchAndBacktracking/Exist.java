package myleetcode.jian_zhi_offer.day14SearchAndBacktracking;

public class Exist {
    int[][] DIRECTION = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();

        // 新建一个 board 副本，防止修改数据
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        // 逻辑处理
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(newBoard, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int curIndex) {
        if (notInArea(board, i , j) || board[i][j] != chars[curIndex]) {
            return false;
        }
        if (curIndex == chars.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = false;
        for (int[] ints : DIRECTION) {
            if (dfs(board, i + ints[0], j + ints[1], chars, curIndex + 1)) {
                res = true;
                break;
            }
        }
        board[i][j] = chars[curIndex];
        return res;
    }

    private boolean notInArea(char[][] board, int i, int j) {
        return i < 0 || i >= board.length || j < 0 || j >= board[0].length;
    }

}
