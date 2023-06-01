public class LC317_HouseRobberII {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        LC317_HouseRobberII m = new LC317_HouseRobberII();
        int res = m.rob(nums);
        System.out.print(res);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n)); // [l, r)
    }

    private int helper(int[] nums, int l, int r) {
        // 2 states: rob / no rob
        int rob = nums[l], norob = 0;

        for (int i = l + 1; i < r; i++) {
            int rob_t = rob, norob_t = norob;

            rob = norob_t + nums[i];
            norob = Math.max(rob_t, norob_t);
        }
        return Math.max(rob, norob);
    }
}
