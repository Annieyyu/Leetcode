public class LC96_UniqueBST {

    public static void main(String[] args) {
        LC96_UniqueBST m = new LC96_UniqueBST();
        int n = 3;

        // Find the number of unique BSTs
        int numUniqueBSTs = m.numTrees(n);

        // Print the result
        System.out.println("Number of unique BSTs: " + numUniqueBSTs);
    }

    public int numTrees(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input is not valid!");
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int num = 0; num < i; num++) {
                dp[i] += dp[num] * dp[i - num - 1];
            }
        }
        return dp[n];
    }
}
