

public class LC153_FindMinRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        LC153_FindMinRotatedSortedArray m = new LC153_FindMinRotatedSortedArray();
        int result = m.findMin(nums);
        System.out.println(result);
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] < nums[n - 1]) return nums[0];
        int left = 0;
        int right = n - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else left = mid;
        }

        return nums[right] < nums[left] ? nums[right] : nums[left];
    }
}