
public class LC410_SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        int m = 2;
        LC410_SplitArrayLargestSum n = new LC410_SplitArrayLargestSum();
        int result = n.splitArray(nums,m);
        System.out.println(result);
    }
    public int splitArray(int[] nums, int m) {
        // find sum of all elements and the maximum element.
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxElement = Math.max(maxElement, num);
        }

	/* example:
	nums = [7, 2, 5, 10, 8], k = 2
	sum = 32, maxElement = 10

left        right
	10          32
*/
        int left = maxElement;
        int right = sum;
        int minLargestSplitSum = 0;
        while (left <= right) {
            int maxSumAllowed = left + (right - left) / 2;
            if (minSubarraysRequired(nums, maxSumAllowed) <= m) {
                right = maxSumAllowed - 1;
                minLargestSplitSum = maxSumAllowed;
            } else {
                left = maxSumAllowed + 1;
            }
        }

        return minLargestSplitSum;
    }
    private int minSubarraysRequired(int[] nums, int maxSumAllowed) {
        int currentSum = 0;
        int splitsRequired = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSumAllowed) {
                currentSum += num;
            } else {
                currentSum = num;
                splitsRequired++;
            }
        }

        return splitsRequired + 1;
    }


}