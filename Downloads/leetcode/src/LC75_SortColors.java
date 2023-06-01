
public class LC75_SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        LC75_SortColors n = new LC75_SortColors();
        n.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zero = 0;
        int two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            if (nums[i] == 0) swap(nums, zero++, i);
            else if (nums[i] == 2) swap(nums, two--, i--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}