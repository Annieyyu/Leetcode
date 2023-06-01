import java.util.ArrayList;
import java.util.List;

/** [1]          row = 0
 [1, 1]       row = 1
 [1, 2, 1]    row = 2 => 3 elements
 [1, 3, 3, 1] row = 3 => 4 elements


 res.add(1)
 1. 2D board to store all pascal's triangle to rowIndex + 1
 2.
 */
public class LC119_PascalTriangleII {

    public static void main(String[] args) {;
        int rowIndex = 3;
        LC119_PascalTriangleII m = new LC119_PascalTriangleII();
        List<Integer> result = m.getRow(rowIndex);
        System.out.print(result);

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[][] matrix = new int[rowIndex + 1][rowIndex + 1];
        matrix[0][0] = 1;
        for (int row = 1; row <= rowIndex; row++) {
            matrix[row][0] = 1;
            //add nums in between
            for (int col = 1; col < rowIndex; col++) {
                matrix[row][col] = matrix[row - 1][col - 1] + matrix[row - 1][col];
            }
            matrix[row][rowIndex] = 1;
        }

        for (int i = 0; i <= rowIndex; i++) {
            res.add(matrix[rowIndex][i]);
        }
        return res;
    }
}
