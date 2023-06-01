import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LC46_Permutations m = new LC46_Permutations();
        List<List<Integer>> result = m.permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        // cc
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, path, res);
            path.remove(path.size() - 1);
        }
    }
}
