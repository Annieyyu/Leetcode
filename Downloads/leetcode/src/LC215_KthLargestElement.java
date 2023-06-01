

public class LC215_KthLargestElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        LC215_KthLargestElement m = new  LC215_KthLargestElement();
        int result = m.findKthLargest(nums,k);
        System.out.println(result);
    }
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }
    private int findKthLargest(int[] nums, int k, int start, int end){
        if(start == end){
            return nums[start];
        }
        int pvtIndex = partition(nums, start, end);
        int rank = pvtIndex - start + 1;
        if(rank == k){
            return nums[pvtIndex];
        } else if(rank < k){
            return findKthLargest(nums, k - rank, pvtIndex + 1, end);
        } else {
            return findKthLargest(nums, k, start, pvtIndex - 1);
        }
    }
    private int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int left = start - 1;
        for(int i = start; i < end; i++){
            if(nums[i] > pivot){
                swap(nums, i, ++left);
            }
        }
        swap(nums, end, ++left);
        return left;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}