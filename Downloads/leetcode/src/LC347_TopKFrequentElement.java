import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC347_TopKFrequentElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        LC347_TopKFrequentElement m = new LC347_TopKFrequentElement();
        int[] result = m.topKFrequent(nums,k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        List<Integer>[] bucket = new List[n + 1];
        for (int i = 0; i <= n; i++) bucket[i] = new ArrayList<>();
        for (int x : map.keySet()) {
            int f = map.get(x);
            bucket[f].add(x);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = n; i >= 0; i--) {
            if (bucket[i].size() > 0) {
                for (int x : bucket[i]) {
                    res[idx++] = x;
                    if (idx == k) return res;
                }
            }
        }
        return res;
    }

}
