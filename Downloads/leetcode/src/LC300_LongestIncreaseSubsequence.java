import java.util.ArrayList;
import java.util.List;

public class LC300_LongestIncreaseSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        LC300_LongestIncreaseSubsequence m = new LC300_LongestIncreaseSubsequence();
        int result = m.lengthOfLIS(nums);
        System.out.println(result);
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            int index = getIndex(res, num);
            if(index < res.size()){
                res.set(index, num);
            } else {
                res.add(num);
            }
        }
        return res.size();
    }
    private int getIndex(List<Integer> res, int target){
        int start = 0;
        int end = res.size() - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(res.get(mid) == target) return mid;
            else if(res.get(mid) < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}