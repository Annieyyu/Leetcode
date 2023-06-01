public class LC231_PowerOfTwo {

    public static void main(String[] args) {
        int n = 1;
        LC231_PowerOfTwo m = new LC231_PowerOfTwo();
        boolean result = m.isPowerOfTwo(n);
        System.out.print(result);

    }
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        long mask = 1;
        while( mask < n){
            mask <<= 1;
        }
        return true;
    }
}
