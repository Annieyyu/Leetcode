import java.util.TreeSet;

public class LC220_ContainsDupIII {


    public static void main(String[] args) {
        int[] nums = new int[]{1,5,9,1,5,9};
        int indexDiff = 2;
        int valueDiff = 3;
        LC220_ContainsDupIII m = new LC220_ContainsDupIII();
        boolean result = m.containsNearbyAlmostDuplicate(nums,indexDiff,valueDiff);

        System.out.print(result);
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // c.c.
        TreeSet<Integer> bst = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - indexDiff - 1 >= 0) {
                bst.remove(nums[i - indexDiff - 1]);
            }
            int higherBound = nums[i] + valueDiff;
            int lowerBound = nums[i] - valueDiff;
            Integer val = bst.floor(higherBound);
            if (val != null && val >= lowerBound) {
                return true;
            }
            bst.add(nums[i]);
        }
        return false;
    }
}
