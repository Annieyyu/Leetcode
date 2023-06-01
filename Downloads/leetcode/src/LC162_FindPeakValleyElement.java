import java.util.List;

public class LC162_FindPeakValleyElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        LC162_FindPeakValleyElement m = new LC162_FindPeakValleyElement();
        int result = m.findPeakElement(nums);
        System.out.println(result);
    }
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) return -1;
        if (len == 1) return 0;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        if(nums[len-1] > nums[len-2]) return len-1;
        if(nums[0] > nums[1]) return 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] < nums[mid+1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;

    }
}