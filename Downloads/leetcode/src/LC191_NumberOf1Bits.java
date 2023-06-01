public class LC191_NumberOf1Bits {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        LC191_NumberOf1Bits m = new LC191_NumberOf1Bits();
        int result = m.hammingWeight(n);
        System.out.print(result);

    }

        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                if ((n >> i & 1) != 0) {
                    count++;
                }
            }
            return count;
        }

}
