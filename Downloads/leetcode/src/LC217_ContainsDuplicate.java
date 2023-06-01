public class LC217_ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        LC217_ContainsDuplicate m = new LC217_ContainsDuplicate();
        boolean result = m.checkUnique(nums);
        System.out.print(result);

    }
    public boolean checkUnique(int[] nums) {
        try {
            if (nums == null) {
                throw new IllegalArgumentException("Input array cannot be null.");
            }

            int[] bitSet = new int[8];
            for (int c : nums) {
                int i = c / 32; // cache temp
                int j = c % 32; // matrix coordinate match
                if ((bitSet[i] & (1 << j)) != 0) {
                    return true;
                } else {
                    bitSet[i] |= 1 << j;
                }
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            // Logger.log(e); // Uncomment this line if you have a Logger class
        } catch (Exception e) {
            // Handle other exceptions if needed
        } finally {
            // Perform cleanup or other necessary actions
        }
        return false;
    }





}
