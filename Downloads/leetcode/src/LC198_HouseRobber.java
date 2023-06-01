public class LC198_HouseRobber {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        LC198_HouseRobber m = new LC198_HouseRobber();
        int res = m.rob(nums);
        System.out.print(res);
    }

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < len ; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len-1];
    }
}
