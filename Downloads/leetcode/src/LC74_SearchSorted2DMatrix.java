
public class LC74_SearchSorted2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        LC74_SearchSorted2DMatrix m = new LC74_SearchSorted2DMatrix();
        boolean result = m.searchMatrix(matrix,target);
        System.out.print(result);

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length ==0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int mid;
        int left = 0;
        int right = row * col - 1;
        while (left <= right){
            mid = left + (right - left) / 2;
            int i = mid / col;
            int j = mid % col;
            int num = matrix[i][j];
            if (target == num) return true;
            if (target < num){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return false;
    }
}