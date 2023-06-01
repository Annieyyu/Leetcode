import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_SubsetsII {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2};
        test(nums1, "Test Case 1");
        int[] nums2 = new int[]{0};
        test(nums2, "Test Case 2");
    }

    private static void test(int[] nums, String testCase) {
        LC90_SubsetsII m = new LC90_SubsetsII();
        List<List<Integer>> result = m.subsetsWithDup(nums);
        System.out.println(testCase + ": " + result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(res, nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
