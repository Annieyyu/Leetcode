public class LC55_JumpGame {

    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,1,4};
        LC55_JumpGame m = new LC55_JumpGame();
        boolean res = m.canJump(nums);
        System.out.println(res);
    }
    public boolean canJump(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > ans) {
                return false;
            }
            ans = Math.max(ans, i + nums[i]);
        }
        return true;
    }

}
