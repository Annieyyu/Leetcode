import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LC47_PermutationsII {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        LC47_PermutationsII m = new LC47_PermutationsII();
        List<List<Integer>> result = m.permuteUnique(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        List<Integer> path= new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        dfs(res, nums, path, visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] visited){
        int len=nums.length;
        if (path.size()==len){
            List<Integer> copy= new ArrayList<Integer>(path);
            res.add(copy);
            return;
        }

        for (int i=0; i<len; i++){
            if (visited[i]) continue;
            if (i>0 && nums[i]==nums[i - 1] && !visited[i-1]){
                continue;
            }
            path.add(nums[i]);
            visited[i]=true;
            dfs(res,nums, path, visited);
            path.remove(path.size()-1);
            visited[i]=false;

        }
    }
}
