import java.util.PriorityQueue;

public class LC628_MaxProductThreeNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LC628_MaxProductThreeNumbers m = new LC628_MaxProductThreeNumbers();
        int res = m.maximumProduct(nums);
        System.out.print(res);


    }

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> (n2 - n1));

        for (int n : nums){
            minHeap.offer(n);
            maxHeap.offer(n);
            if (minHeap.size() > 3) minHeap.poll();
            if (maxHeap.size() > 2) maxHeap.poll();
        }

        int max = 0;
        int rightMax = 1;

        while (!minHeap.isEmpty()){
            max = minHeap.poll();
            rightMax *= max;
        }
        int leftMax = max;
        while (!maxHeap.isEmpty()){
            leftMax *= maxHeap.poll();
        }


        return Math.max(rightMax, leftMax);
    }
}
