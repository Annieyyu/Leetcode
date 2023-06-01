import java.util.Arrays;

public class LC52_NQueensII {

    public static void main(String[] args) {
        int n = 4;
        LC52_NQueensII m = new LC52_NQueensII();
        int res = m.totalNQueens(n);
        System.out.print(res);
    }
    private int res = 0;
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        char[][] ch = new char[n][n];
        for (char[] c : ch) {
            Arrays.fill(c, '.');
        }
        dfs(0, ch);
        return res;
    }

    private void dfs(int level, char[][] ch) {
        if (level == ch.length) {
            res++;
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            if (isValid(ch, level, i)) {
                ch[level][i] = 'Q';
                dfs(level + 1, ch);
                ch[level][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] ch, int row, int col) {
        int n = ch.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if((Math.abs(col - j) == Math.abs(row - i) || col == j) && ch[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

}
