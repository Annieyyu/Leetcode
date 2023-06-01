
public class LC240_SearchQudratic2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{8,21,23,26,30}};
        int target = 5;
        LC240_SearchQudratic2DMatrix m = new LC240_SearchQudratic2DMatrix();
        boolean result = m.searchMatrix(matrix,target);
        System.out.print(result);

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j < cols) {
            int num = matrix[i][j];
            if (num == target) return true;
            else if (num < target) j++;
            else i--;
        }
        return false;
    }
}