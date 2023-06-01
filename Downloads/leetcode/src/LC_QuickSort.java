public class LC_QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,7,5,1,11,2};
        LC_QuickSort n = new LC_QuickSort();
        n.quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void quickSort(int[]nums){
        int len = nums.length;
        quickSort(nums, 0, len - 1);

    }
    private void quickSort(int[]nums, int start, int end ){
        if (start >= end) return;
        int pivotIdx = partition(nums, start, end);
        quickSort(nums, start, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, end);
    }

    private int partition(int[]nums, int start, int end) {

        int pivot = nums[end];
        int left = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) swap(nums, i, ++left);
        }
        swap(nums, end, ++left);
        return left;
    }

    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
