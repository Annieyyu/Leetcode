public class LC171_FactorialTrailingZeros {
    public static void main(String[] args) {
        int num = 3;
        LC171_FactorialTrailingZeros  m = new LC171_FactorialTrailingZeros ();
        int result = m.trailingZeroes(num);
        System.out.print(result);
    }

    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n/5;
            n /= 5;
        }
        return res;
    }

}
