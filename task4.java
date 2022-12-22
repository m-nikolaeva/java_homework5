import java.util.Arrays;

/* На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. */

public class task4 {
    public static void main(String[] args) {
        int board = 8;
        char[][] chessBoard = new char[board][board];
        for (int i = 0; i < board; i++) {
            Arrays.fill(chessBoard[i], '+');
        }
        queen(chessBoard, 0);
    }

    private static boolean check(char[][] board, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void showRes(char[][] board) {
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
        }
        System.out.println();
    }

    private static void queen(char[][] board, int r) {
        if (r == board.length) {
            showRes(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (check(board, r, i)) {
                board[r][i] = 'Q';
                queen(board, r + 1);
                board[r][i] = '+';
            }
        }
    }
}
