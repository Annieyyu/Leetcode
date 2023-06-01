
import java.util.HashSet;
import java.util.Set;

public class LC219_ContainDupII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        LC219_ContainDupII m = new LC219_ContainDupII();
        boolean result = m.containsNearbyDuplicate(nums,k);

        System.out.print(result);

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!set.add(nums[i])) return true;
            if (set.size() > k) set.remove(nums[i-k]);

        }
        return false;

    }
}
