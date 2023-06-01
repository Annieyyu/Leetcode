
public class LC81_SearchRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,0,0,1,2};
        int target = 0;
        LC81_SearchRotatedSortedArrayII m = new LC81_SearchRotatedSortedArrayII();
        boolean result = m.search(nums,target);
        System.out.println(result);
    }
    public boolean search(int[] nums, int target) {
        int start  = 0, end = nums.length - 1;

        //check each num so we will check start == end
        //We always get a sorted part and a half part
        //we can check sorted part to decide where to go next
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return true;

            //if left part is sorted
            if(nums[start] < nums[mid]){
                if(target < nums[start] || target > nums[mid]){
                    //target is in rotated part
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[start] > nums[mid]){
                //right part is sorted

                //target is in rotated part
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }
            }else{
                //duplicates, we know nums[mid] != target, so nums[start] != target
                //based on current information, we can only move left pointer to skip one cell
                //thus in the worest case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                start ++;
            }
        }

        return false;
    }
}