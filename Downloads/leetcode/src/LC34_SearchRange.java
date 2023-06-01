import java.util.List;

public class LC34_SearchRange {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        LC34_SearchRange m = new LC34_SearchRange();
        int[] result = m.searchRange(nums,target);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int[] res = new int[2];
        res[0] = findStart(nums, target);
        res[1] = findEnd(nums, target);

        return res;
    }
    public int findStart(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return (left == nums.length || nums[left] != target) ? -1 : left;

    }
    public int findEnd(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }

        return (right < 0 || nums[right] != target) ? -1 : right;
    }
}
