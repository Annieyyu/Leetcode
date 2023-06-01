public class LC136_SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        LC136_SingleNumber m = new LC136_SingleNumber();
        int result = m.singleNumber(nums);
        System.out.print(result);

    }
    public int singleNumber(int[] nums) {
        // c.c.
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
