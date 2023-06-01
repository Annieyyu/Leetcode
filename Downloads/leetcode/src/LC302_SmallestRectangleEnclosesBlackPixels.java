
public class LC302_SmallestRectangleEnclosesBlackPixels {

    public static void main(String[] args) {
        char[][] image = new char[][]{{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        int x = 0;
        int y = 2;
        LC302_SmallestRectangleEnclosesBlackPixels m = new LC302_SmallestRectangleEnclosesBlackPixels();
        int result = m.minArea(image,x,y);
        System.out.print(result);

    }
    public int minArea(char[][] image, int x, int y) {
        int left = leftBoundary(image, x, y);
        int right = rightBoundary(image, x, y);
        int up = upperBoundary(image, x, y);
        int low = lowerBoundary(image, x, y);
        return ((right - left) + 1) * ((low - up) + 1);
    }
    private int leftBoundary(char[][] image, int x, int y){
        int start = 0;
        int end = y;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(existOneInCol(image, mid)){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    private int rightBoundary(char[][] image, int x, int y){
        int start = y;
        int end = image[0].length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(existOneInCol(image, mid)){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
    private int upperBoundary(char[][] image, int x, int y){
        int start = 0;
        int end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(existOneInRow(image, mid)){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    private int lowerBoundary(char[][] image, int x, int y){
        int start = x;
        int end = image.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(existOneInRow(image, mid)){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private boolean existOneInCol(char[][] image, int target){
        for(int i = 0; i < image.length; i++){
            if( image[i][target] == '1'){
                return true;
            }
        }
        return false;
    }
    private boolean existOneInRow(char[][] image, int target){
        for(int j = 0; j < image[0].length; j++){
            if(image[target][j] == '1'){
                return true;
            }
        }
        return false;
    }

}