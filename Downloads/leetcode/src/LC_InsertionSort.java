public class LC_InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,7,5,1,11,2};
        LC_InsertionSort n = new LC_InsertionSort();
        n.selectSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void selectSort(int[] array) {
        if (array == null || array.length <= 1) return;

        //int minIndex;
        for (int i = 0; i < array.length - 1; i++) {    // 不需要走到最后一位
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) minIndex = j;
            }
            swap(array, i, minIndex);
        }

    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
// return;
    }
}