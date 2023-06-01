import java.util.ArrayList;
import java.util.List;

public class LC51_NQueens {

    public static void main(String[] args) {
        int n = 4; // Set the value of N
        LC51_NQueens m = new LC51_NQueens();
        List<List<String>> solutions = m.solveNQueens(n);
        for (List<String> solution : solutions) {
            System.out.println("Solution:");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(n, 0, board, res);
        return res;

    }
    private void dfs(int n, int col, char[][] board, List<List<String>> res){
        if (col == n){
            res.add(flatBoard(board));
            return;
        }
        for (int i = 0; i < n; i++){
            if (isValid(i, col, board)){
                board[i][col] = 'Q';
                dfs(n, col + 1, board, res);
                board[i][col] = '.';

            }
        }

    }
    private boolean isValid(int row, int col, char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'Q' && (i == row || Math.abs(row - i) == Math.abs(col - j))) {
                    return false;
                }
            }
        }
        return true;
    }
    private List<String> flatBoard (char[][] board){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            res.add(new String(board[i]));
        }
        return res;
    }

}
