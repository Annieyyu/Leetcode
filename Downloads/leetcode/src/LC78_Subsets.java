import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LC78_Subsets m = new LC78_Subsets();
        List<List<Integer>> result = m.subsets(nums);
        System.out.println(result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        if(index ==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(res, path, nums, index+1);
        path.remove(path.size()-1);
        dfs(res, path, nums, index+1);
    }



}

