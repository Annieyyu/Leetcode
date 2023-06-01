import java.util.Arrays;
import java.util.List;

public class LC377_CombinationSumIV {

    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3};
        int k = 4;
        LC377_CombinationSumIV m = new LC377_CombinationSumIV();
        int result = m.combinationSum4(nums,k);
        System.out.println(result);
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        // 得到target 为0的只有一种可能就是用0
        dp[0] = 1;
        dfs(nums, target, dp);
        return dp[target];
    }

    private int dfs(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) return dp[target];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                tmp += dfs(nums, target - nums[i], dp);
            }
        }
        dp[target] = tmp;
        return tmp;
    }
}
