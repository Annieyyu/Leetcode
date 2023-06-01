import java.util.HashSet;
import java.util.Set;

public class LC268_MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        LC268_MissingNumber m = new LC268_MissingNumber();
        int result = m.missingNumber(nums);
        System.out.print(result);

    }
    public int missingNumber(int[] nums){
        if(nums == null || nums.length ==0) return -1;
        Set<Integer> checkMissingNum = new HashSet<Integer>();
        for(int num : nums){
            checkMissingNum.add(num);
        }
        for(int i=0; i<=nums.length; i++){
            if(!checkMissingNum.contains(i)) return i;
        }
        return -1;
    }
}
