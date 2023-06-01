import java.util.Arrays;

public class LC45_JumpGameII {

    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,1,4};
        LC45_JumpGameII m = new LC45_JumpGameII();
        int res = m.jump(nums);
        System.out.println(res);
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if(nums.length>1 && nums[0] == 0) return -1; // cannot jump to the end;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        //bc
        dp[0] = 0; //jump from 0 to 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j <= Math.min(i + nums[i], nums.length-1); j++) {
                if(dp[j] == -1) dp[j]=dp[i] +1;
            }

        }
        return dp[nums.length - 1];
    }

}
