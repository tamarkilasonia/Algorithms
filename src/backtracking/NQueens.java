package backtracking;

public class NQueens {
    private static final int N = 8; // Change this for different board sizes

    // Print the board
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if a queen can be placed at board[row][col]
    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    // Solve N-Queens using backtracking
    private static boolean solveNQueens(int[][] board, int col) {
        if (col >= N) {
            printBoard(board);
            return true;
        }

        boolean success = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                success = solveNQueens(board, col + 1) || success;
                board[i][col] = 0;
            }
        }
        return success;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        if (!solveNQueens(board, 0)) {
            System.out.println("No solution exists.");
        }
    }
}
