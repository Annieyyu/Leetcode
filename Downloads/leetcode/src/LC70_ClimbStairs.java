
 public class LC70_ClimbStairs {

     public static void main(String[] args) {
         int x = 20;
         LC70_ClimbStairs m = new LC70_ClimbStairs();
         int result = m.climbStairs(x);
         System.out.println(result);
     }
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climbStairs(0, n, memo);
    }
    private int climbStairs(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];
        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
        return memo[i];
    }
}