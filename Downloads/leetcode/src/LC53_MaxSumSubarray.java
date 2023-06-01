public class LC53_MaxSumSubarray {

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        LC53_MaxSumSubarray m = new LC53_MaxSumSubarray();
        int res = m.maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        //if (nums == null || nums.length == 0) throw new Exception();
        int len = nums.length;
        int dp = nums[0];
        int max = dp;

        for (int i = 1; i < len; i++) {   // 1 3 2 -7 100
            if (dp > 0) {
                dp += nums[i];
                if (dp > max) max = dp;
            }else {
                dp = nums[i];
            }
            // <--
        }
        return max;


    }
}
