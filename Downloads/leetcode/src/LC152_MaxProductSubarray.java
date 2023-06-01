public class LC152_MaxProductSubarray {

    public static void main(String[] args){
        int[] nums = new int[]{2,4,-2,4};
        LC152_MaxProductSubarray m = new LC152_MaxProductSubarray();
        int res = m.maxProduct(nums);
        System.out.println(res);
    }
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int result = max[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            result = Math.max(result, max[i]);
        }

        return result;
    }
}
