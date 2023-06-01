public class LC_MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,7,6,1,11,2};
        LC_MergeSort n = new LC_MergeSort();
        int[] result = n.mergeSort(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] mergeSort(int[] array) {
        //cc
        int[] helper = new int[array.length];
        mergeSort(array, 0, array.length - 1, helper);
        return array;
    }

    private void mergeSort(int[] array, int left, int right, int[] helper) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid, helper);
        mergeSort(array, mid + 1, right, helper);
        merge(array, left, right, mid, helper);
    }

    private void merge(int[] array, int left, int right, int mid, int[] helper) {
        int leftStart = left;
        int rightStart = mid + 1;
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        while (leftStart <= mid && rightStart <= right) {
            if (helper[leftStart] <= helper[rightStart]) {
                array[left++] = helper[leftStart++];
            } else {
                array[left++] = helper[rightStart++];
            }
        }
        while (leftStart <= mid) {
            array[left++] = helper[leftStart++];
        }
    }
}