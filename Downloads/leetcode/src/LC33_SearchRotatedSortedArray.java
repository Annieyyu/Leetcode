
public class LC33_SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 3;
        LC33_SearchRotatedSortedArray m = new LC33_SearchRotatedSortedArray();
        int result = m.search(nums,target);
        System.out.println(result);
    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (target == nums[left]) return left;
            if (target == nums[right]) return right;
            if (nums[left] < nums[mid]){
                if (target > nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}