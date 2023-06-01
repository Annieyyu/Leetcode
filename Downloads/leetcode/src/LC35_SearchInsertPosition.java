
public class LC35_SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        LC35_SearchInsertPosition m = new LC35_SearchInsertPosition();
        int result = m.searchInsert(nums,target);
        System.out.println(result);
    }
    public int searchInsert(int[] nums, int target) {
        //cc
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}